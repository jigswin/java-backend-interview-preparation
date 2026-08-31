# REDIS — Q5: CACHE-ASIDE PATTERN

## 1. Cache-Aside Pattern kya hai?

Cache-Aside me application khud decide karti hai:

→ Cache se data kab read karna hai
→ Database se data kab lena hai
→ Cache me data kab store karna hai
→ Cache kab delete/update karna hai

Isliye ise:

CACHE-ASIDE

kehte hain.


# 2. READ FLOW

Suppose:

GET /products/101


Application
     ↓
Check Redis
     ↓
  Data exists?
    /     \
  YES      NO
   ↓        ↓
Return    MySQL
            ↓
          Product
            ↓
          Redis
            ↓
          Return


## Step-by-Step

### Step 1

Application Redis me check karegi:

GET product:101


### Step 2 — Cache HIT

Agar data mil gaya:

Redis
 ↓
Product
 ↓
Return


Database query nahi hogi.


### Step 3 — Cache MISS

Agar Redis me data nahi mila:

Redis
 ↓
MISS
 ↓
MySQL


### Step 4

MySQL se data fetch:

Product #101


### Step 5

Application data Redis me store karegi:

SET product:101 <product-data>


### Step 6

User ko response:


MySQL
 ↓
Application
 ↓
User


# 3. Real-World Example

Product Service:

public Product getProduct(Long id) {

    // 1. Check Redis

    Product product =
        redis.get("product:" + id);

    if (product != null) {

        return product;
    }

    // 2. Cache miss

    product =
        productRepository.findById(id);


    // 3. Save in Redis

    redis.set(
        "product:" + id,
        product
    );


    // 4. Return

    return product;
}


Actual implementation Redis client/library
ke according different ho sakti hai.


# 4. UPDATE FLOW

Suppose:

PUT /products/101


Admin:

Price:
₹50,000 → ₹55,000


Flow:

Request
  ↓
Application
  ↓
MySQL UPDATE
  ↓
SUCCESS
  ↓
Redis INVALIDATE
  ↓
Response


Example:

DB:

₹55,000


Redis:

DELETE product:101


Next GET:

Redis MISS
 ↓
MySQL
 ↓
₹55,000
 ↓
Redis
 ↓
Return


# 5. DELETE FLOW

Suppose:

DELETE /products/101


Flow:

Application
    ↓
Delete MySQL
    ↓
Delete Redis
    ↓
Response


Important:

Agar DB se delete kar diya
but Redis key delete nahi ki:

Redis me old product reh sakta hai.


Next GET:

Redis
 ↓
Old Product ❌


Isliye cache consistency maintain karna important hai.


# 6. Why Cache-Aside?

Advantages:

→ Simple
→ Application control
→ Database remains source of truth
→ Only requested data cache hota hai
→ Cache failure ke case me DB se recover kar sakte hain


# 7. Disadvantages

→ Application ko cache logic manage karna padta hai
→ Cache invalidation difficult
→ Stale data ka risk
→ Cache miss par extra DB request
→ Cache stampede possible


# 8. Redis Down ho gaya to?

Important interview scenario:

Application
    ↓
Redis ❌


Application ko ideally gracefully handle karna chahiye.

Example:

Redis unavailable
      ↓
Fallback to DB
      ↓
Return data


But production design me:

→ Timeout
→ Circuit breaker
→ Monitoring
→ Appropriate fallback

jaise mechanisms use kiye ja sakte hain.


# 9. Cache-Aside vs Write-Through

CACHE-ASIDE:

Application
    ↓
DB
    +
Cache managed separately


Application cache ko explicitly
read/write/invalidate karti hai.


WRITE-THROUGH:

Application
    ↓
Cache
    ↓
Database


Cache write operation ke through
underlying database bhi update ho sakta hai,
depending on the implementation.


Abhi hum mainly:

CACHE-ASIDE

use karenge.


# 10. Real Microservice Example

Product Service:

GET /products/101


Flow:

Product Service
      ↓
Redis
      ↓
HIT?
 ┌────┴────┐
YES        NO
 ↓          ↓
Return     MySQL
            ↓
          Redis
            ↓
          Return


Update:

PUT /products/101
      ↓
MySQL UPDATE
      ↓
Redis DELETE


Delete:

DELETE /products/101
      ↓
MySQL DELETE
      ↓
Redis DELETE


# 11. Important Race Condition

Suppose simultaneously:

Request A:
Update Product


Request B:
Get Product


Possible timing:

A → DB update
B → Redis read old value
A → Redis invalidate


Depending on exact timing,
temporary stale data serve ho sakta hai.


Distributed systems me cache consistency
carefully design karni padti hai.


# 12. Interview Scenario

Question:

"Explain cache-aside pattern with an example."


Answer:

"In the cache-aside pattern, the application first checks the cache for a requested object. If the data is present, it returns it directly. If there is a cache miss, the application reads the data from the database, stores it in the cache and returns it. For updates or deletes, the application typically updates the database and then invalidates or updates the corresponding cache entry."


# 13. Easy Memory

READ:

Redis
 ↓
HIT → Return


MISS:

Redis
 ↓
DB
 ↓
Redis
 ↓
Return


UPDATE:

DB
 ↓
Redis invalidate/update


DELETE:

DB
 ↓
Redis delete


## One-Line Memory

CACHE-ASIDE =

"Application cache ko khud manage karti hai."