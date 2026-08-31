# REDIS — Q6: TTL (TIME TO LIVE) & CACHE EXPIRATION

## 1. TTL kya hai?

TTL = Time To Live

TTL batata hai ki Redis me stored key
kitne time tak valid rahegi.

Example:

product:101
TTL = 10 minutes


10 minutes ke baad:

product:101
     ↓
EXPIRED ❌


Next request:

Redis
 ↓
MISS
 ↓
MySQL
 ↓
Fresh Data
 ↓
Redis
 ↓
New TTL


# 2. TTL ki zarurat kyu hai?

Agar cache data ko permanently store kar diya:

MySQL:
₹50,000 → ₹55,000


Redis:
₹50,000 ❌


Agar cache expire nahi hua,
to application stale data return kar sakti hai.


TTL:

Redis
 ↓
10 minutes
 ↓
Expire
 ↓
Fresh data fetch


TTL stale data ko indefinitely serve hone se
prevent karne me help karta hai.


# 3. Real-World Example

Suppose:

GET /products/101


First request:

Redis → MISS
   ↓
MySQL
   ↓
Product
   ↓
Redis SET
   ↓
TTL = 10 min


For next 10 minutes:

Redis → HIT
   ↓
Return


10 minutes complete:

Redis → Key expired


Next request:

Redis → MISS
   ↓
MySQL
   ↓
Latest Product
   ↓
Redis
   ↓
TTL again 10 min


# 4. Redis TTL Example

Conceptually:

SET product:101 "Laptop"


Expire:

EXPIRE product:101 600


600 seconds = 10 minutes


Check TTL:

TTL product:101


Possible result:

540


Meaning:

Approximately 540 seconds remaining.


# 5. Spring Boot Example

Agar Spring Cache use kar rahe ho,
TTL usually cache configuration ke through
configure kiya jata hai.


Example concept:

Product Cache
→ TTL = 10 minutes


Then:

@Cacheable("products")
public Product getProduct(Long id) {

    return productRepository
            .findById(id)
            .orElseThrow();
}


Actual TTL configuration Redis cache manager
par depend karegi.


# 6. Har Data ka Same TTL?

NO ❌


Different data ke liye different TTL ho sakta hai.


Example:

Product details
→ 10 minutes


User profile
→ 30 minutes


Configuration
→ 1 hour


OTP / temporary token
→ few minutes


Session
→ requirement dependent


TTL business requirement ke according decide karna chahiye.


# 7. TTL bahut short rakha to?

Example:

TTL = 5 seconds


Requests:

Request 1 → MISS
Request 2 → HIT
Request 3 → HIT
5 sec → EXPIRE
Request 4 → MISS
5 sec → EXPIRE


Frequent expiration:

→ Cache hit ratio decrease
→ Database load increase


# 8. TTL bahut long rakha to?

Example:

TTL = 24 hours


Data update:

MySQL → New value


Redis → Old value


Agar invalidation/update mechanism nahi hai:

Stale data long time serve ho sakta hai.


Isliye TTL balance karna important hai.


# 9. TTL + Cache Invalidation

Best practical approach often:

TTL
+
Explicit Invalidation


Example:

Product:

TTL = 30 min


Admin update:

MySQL UPDATE
     ↓
Redis DELETE


Ab stale data immediately remove ho sakta hai.

TTL fallback protection provide karta hai
agar invalidation miss ho jaye.


# 10. Cache Stampede Connection

Suppose:

1000 requests


Same key:

product:101


TTL same time expire:

       product:101
            ↓
          EXPIRE
            ↓
       1000 requests
            ↓
       Redis MISS
            ↓
       1000 DB queries ❌


Isse:

CACHE STAMPEDE


ho sakta hai.


Solutions:

→ Distributed lock
→ Request coalescing
→ Early refresh
→ TTL jitter/randomization
→ Appropriate cache strategy


# 11. TTL Jitter

Suppose 1 lakh keys:

TTL = exactly 10 minutes


Agar sab same time cache me insert hue:

10 minutes later:

Many keys expire together.


Instead:

10 min + random small variation


Example:

600 sec
615 sec
587 sec
603 sec


Isse simultaneous expiration ka risk reduce
karne me help mil sakti hai.


# 12. Important Redis TTL Commands

SET:

SET key value


Set expiration:

EXPIRE key 60


Check TTL:

TTL key


Remove expiration:

PERSIST key


Delete:

DEL key


# 13. Real Microservice Example

Product Service:

GET /products/101


Flow:

Redis
 ↓
HIT
 ↓
Return


After TTL:

Redis
 ↓
Expired
 ↓
MISS
 ↓
MySQL
 ↓
Fresh Product
 ↓
Redis
 ↓
Set TTL


Update:

PUT /products/101
 ↓
MySQL
 ↓
Redis DEL


# 14. Interview Scenario

Question:

"Why do you use TTL in Redis?"


Answer:

"We use TTL to automatically expire cached data after a configured period. It prevents stale data from remaining in the cache indefinitely and also helps control memory usage. The TTL should be selected according to how frequently the underlying data changes and how much staleness the business can tolerate."


# 15. Important Interview Question

Q:

"Is TTL alone enough for cache consistency?"


Answer:

"Not always. TTL provides eventual expiration, but if the data changes and the cache has a long TTL, stale data may still be served until expiration. For important updates, we can explicitly invalidate or update the cache after the database change, while TTL acts as an additional safety mechanism."


# Easy Memory

TTL:

"Data kitne time tak cache me rahega."


Short TTL:

Freshness ↑
Cache hit ratio ↓


Long TTL:

Cache hit ratio ↑
Staleness risk ↑


Practical:

TTL
+
Cache Invalidation


## One-Line Memory

TTL = "Cache ki expiry date"