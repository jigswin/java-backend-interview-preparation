# REDIS — Q7: CACHE INVALIDATION STRATEGIES

## 1. Cache Invalidation kya hai?

Cache invalidation ka matlab:

Jab database me data change/delete ho,
to Redis ke old/stale data ko
remove ya update karna.

Example:

MySQL:
Product 101 = ₹50,000

Redis:
Product 101 = ₹50,000


Admin price update karta hai:

MySQL:
₹55,000


Redis:
₹50,000 ❌

Ye stale data hai.


Solution:

MySQL UPDATE
     ↓
Redis INVALIDATE / UPDATE


# 2. Strategy 1 — Delete Cache

Sabse simple aur commonly used approach.

Flow:

UPDATE /products/101
        ↓
Update MySQL
        ↓
DELETE Redis key
        ↓
Success


Example:

MySQL:
₹50,000 → ₹55,000


Redis:

DEL product:101


Next GET:

Redis → MISS
     ↓
MySQL
     ↓
₹55,000
     ↓
Redis
     ↓
Cache


## Advantage:

→ Simple
→ Less stale-data risk
→ Next read automatically fresh data load karega


## Disadvantage:

Next request ko DB hit karna padega.


# 3. Strategy 2 — Update Cache

Database update ke baad
Redis ko bhi immediately update kar do.


Flow:

UPDATE
 ↓
MySQL → ₹55,000
 ↓
Redis → ₹55,000


Next GET:

Redis HIT
 ↓
₹55,000


## Advantage:

→ Next request bhi fast
→ Cache miss avoid


## Disadvantage:

→ DB aur Redis update ke beech
  consistency problem aa sakti hai
→ Cache update fail ho sakta hai


# 4. Strategy 3 — TTL

Cache ko automatically expire hone do.

Example:

TTL = 10 minutes


MySQL:

₹55,000


Redis:

₹50,000


10 minutes ke baad:

Redis → EXPIRE


Next GET:

Redis MISS
 ↓
MySQL
 ↓
₹55,000


## Problem:

10 minutes tak stale data serve ho sakta hai.


Isliye important/ frequently changing data ke liye
TTL alone sufficient nahi hota.


# 5. Strategy 4 — Delete + TTL

Practical approach:

Redis cache:

TTL = 30 min


Update:

MySQL UPDATE
     ↓
Redis DELETE


Agar kisi reason se invalidation miss ho gaya:

TTL eventually cache expire kar dega.


Isliye:

Explicit Invalidation
+
TTL


strong combination ho sakta hai.


# 6. Real-World Example

E-commerce:

Product:

id = 101
price = ₹50,000


Redis:

product:101
→ ₹50,000


Admin:

PUT /products/101

New price:

₹55,000


Recommended flow:

Product Service
       ↓
Update MySQL
       ↓
SUCCESS
       ↓
DEL product:101
       ↓
Response


Next user:

GET /products/101

Redis
 ↓
MISS
 ↓
MySQL
 ↓
₹55,000
 ↓
Redis
 ↓
Return


# 7. Important Question

Q:

"Should you update Redis first or database first?"


Common approach:

Database first
      ↓
Cache invalidation/update


Why?

Database is generally the
source of truth.


Example:

MySQL UPDATE
     ↓
SUCCESS
     ↓
Redis DELETE


If DB update fails:

MySQL ❌
 ↓
Don't invalidate/update cache