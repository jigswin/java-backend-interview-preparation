# REDIS — Q4: CACHING

## 1. Caching kya hoti hai?

Caching ka matlab:

Frequently accessed data ko
fast storage me temporarily rakhna.

Purpose:

→ Response time reduce karna
→ Database load reduce karna
→ Application performance improve karna


Simple:

Database
→ Slow/expensive access


Cache
→ Fast access


# 2. Real-World Example

Suppose:

GET /products/101


Product Service:

Client
  ↓
API
  ↓
Redis
  ↓
Product available?
  ↓
YES
  ↓
Return Product


Isko:

CACHE HIT

kehte hain.


# 3. Cache Miss

Agar Redis me product available nahi hai:

Client
  ↓
API
  ↓
Redis
  ↓
NOT FOUND
  ↓
CACHE MISS
  ↓
MySQL
  ↓
Product
  ↓
Redis me store
  ↓
Return


Example:

First request:

GET /products/101

Redis → MISS ❌

MySQL → Product found ✅

Redis → Product save

Response → User


Second request:

GET /products/101

Redis → HIT ✅

Response → User


MySQL ko second request par query karne ki
need nahi padi.


# 4. Cache Hit vs Cache Miss

CACHE HIT:

Application
    ↓
Redis
    ↓
Data Found
    ↓
Return


CACHE MISS:

Application
    ↓
Redis
    ↓
Data NOT Found
    ↓
Database
    ↓
Data
    ↓
Redis
    ↓
Return


# 5. Real-World Performance

Without Cache:

1000 requests
      ↓
1000 DB queries


With Cache:

First request
      ↓
DB


Remaining requests
      ↓
Redis


Result:

→ DB load reduce
→ Faster response


Actual performance improvement depends on
data size, network, workload and infrastructure.


# 6. Cache-Aside Pattern

Ye sabse commonly used caching pattern hai.

Flow:

Application
     ↓
Check Redis
     ↓
   HIT?
  /    \
YES     NO
 |       |
Return   DB
         |
         ↓
       Redis
         |
         ↓
       Return


Isme application khud cache ko manage karti hai.

Isko:

CACHE-ASIDE

ya

LAZY CACHING

bhi kaha jata hai.


# 7. Read Operation

Example:

GET /products/101


Step 1:

Redis se check.


Step 2:

Agar mil gaya:

→ Return


Step 3:

Agar nahi mila:

→ MySQL se fetch


Step 4:

Redis me save


Step 5:

Response return


# 8. Update Operation

Suppose:

Product price:

₹50,000


Redis:

product:101
→ ₹50,000


Admin update karta hai:

₹55,000


Agar sirf DB update kiya:

MySQL → ₹55,000
Redis → ₹50,000 ❌


Next API:

Redis
 ↓
₹50,000 ❌

Stale Data


Isliye update ke time cache ko
invalidate/update karna important hai.


# 9. Common Cache Update Strategy

Option 1:

Update DB
   ↓
Delete Redis Cache


Next read:

Redis MISS
   ↓
DB
   ↓
Latest data
   ↓
Redis


Option 2:

Update DB
   ↓
Update Redis


Dono approaches use ho sakti hain.

Most common practical approach:

DB update
+
Cache invalidation


# 10. Cache kya store kare?

Good candidates:

→ Frequently read data
→ Data that changes less frequently
→ Expensive DB queries
→ Product details
→ User profile
→ Configuration


Bad candidate:

Aisa data jo:

→ Har second change hota hai
→ Rarely read hota hai
→ Huge amount me cache karna expensive ho
→ Strong real-time consistency require karta ho


# 11. Cache TTL

Cache ko forever store karna risky ho sakta hai.

Example:

product:101

TTL = 10 minutes


10 minutes ke baad:

Redis
 ↓
Key Expired


Next request:

Redis MISS
 ↓
DB
 ↓
Latest data
 ↓
Redis


TTL ka detailed topic next questions me karenge.


# 12. Cache Stampede — Basic Idea

Suppose:

Product cache expire ho gaya.

Aur ek hi time par:

1000 requests


Sabko:

Redis MISS


Sab simultaneously:

MySQL
   ↓
1000 queries


Database par sudden load aa sakta hai.


Is problem ko:

CACHE STAMPEDE

kehte hain.


Isko prevent karne ke liye techniques use ki ja sakti hain:

→ Locking
→ Request coalescing
→ Early refresh
→ Appropriate TTL strategy


# 13. Redis Cache Architecture

                 Client
                    ↓
                 API
                    ↓
                  Redis
                    ↓
                Cache Hit?
                 /      \
               YES       NO
                ↓         ↓
             Return      MySQL
                           ↓
                         Data
                           ↓
                         Redis
                           ↓
                         Return


# 14. Real Microservice Example

Product Service:

GET /products/{id}


Service logic:

1. Redis check
2. Cache Hit → return
3. Cache Miss → DB query
4. Save result in Redis
5. Return


Update:

PUT /products/{id}


1. Update DB
2. Invalidate/update Redis


Delete:

DELETE /products/{id}


1. Delete from DB
2. Delete Redis key


# 15. Interview Answer

"Redis is commonly used as a caching layer to reduce database load and improve response time. In a cache-aside approach, the application first checks Redis. On a cache hit, it returns the cached data. On a cache miss, it fetches the data from the database, stores it in Redis and returns it. When the underlying data changes, the cache should be updated or invalidated to avoid stale data."


# Easy Memory

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
Invalidate / Update Cache


DELETE:

DB
 ↓
Delete Cache


IMPORTANT:

Cache
→ Speed


Database
→ Source of Truth