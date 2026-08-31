# REDIS — Q2: Redis vs MySQL / Database

## 1. Sabse pehle basic difference

MySQL/PostgreSQL:

→ Primary database
→ Permanent business data
→ Transactions
→ Complex queries
→ Relationships
→ Source of Truth


Redis:

→ In-memory data store
→ Very fast data access
→ Mostly cache / temporary data
→ Key-Value based access
→ Low latency


Simple:

MySQL = Actual Data

Redis = Fast Copy / Fast Access


# 2. Real-World Example

Suppose:

Product ID = 101

MySQL:

product
--------------------------------
id | name     | price
101| Laptop   | 50000


Ab users baar-baar:

GET /products/101


request kar rahe hain.


Without Redis:

1000 requests
      ↓
1000 MySQL queries


Database load ↑


With Redis:

First request:

API
 ↓
Redis
 ↓
MISS
 ↓
MySQL
 ↓
Product
 ↓
Redis me save
 ↓
Response


Next 999 requests:

API
 ↓
Redis
 ↓
HIT
 ↓
Response


MySQL par load considerably reduce ho sakta hai.


# 3. Redis ko Source of Truth kyu nahi banate?

Suppose:

Product price:

MySQL → ₹50,000

Redis → ₹50,000


Redis cache accidentally expire/delete ho gaya.

No major problem.

Application:

Redis
 ↓
MISS
 ↓
MySQL
 ↓
₹50,000
 ↓
Redis me again cache


Lekin agar MySQL me actual business data hi nahi
hoga aur Redis data lose ho gaya, to application
important data lose kar sakti hai.

Isliye normal caching architecture me:

MySQL = Source of Truth

Redis = Cache


# 4. Redis kab use karna chahiye?

Jab:

→ Same data repeatedly read ho raha ho
→ Data access fast chahiye
→ Database load reduce karna ho
→ Low latency required ho


Examples:

Product details
User profile
Frequently accessed configuration
Session data
Counters
Rate limiting


# 5. Redis kab use nahi karna chahiye?

Har data Redis me store karna correct nahi hai.

Example:

Complete ERP database
Huge permanent transaction history
Complex relational queries


Ye kaam:

MySQL/PostgreSQL

ke liye better suited hain.


# 6. Redis vs MySQL — Query Style

MySQL:

SELECT *
FROM product
WHERE id = 101;


Redis:

GET product:101


MySQL:

Complex SQL queries
JOIN
GROUP BY
ORDER BY


Redis:

Fast key-based access


# 7. Real Microservice Example

Product Service:

Client
  ↓
Product API
  ↓
Redis
  ↓
Cache Hit?
  ├── YES → Return
  │
  └── NO
       ↓
     MySQL
       ↓
     Product
       ↓
     Redis
       ↓
     Return


Yaha Redis ek:

CACHE LAYER

ki tarah kaam kar raha hai.


# 8. Data Update ka Problem

Suppose:

MySQL:

Product price = ₹50,000

Redis:

Product price = ₹50,000


Admin ne MySQL me price update kar diya:

MySQL:

₹55,000


Lekin Redis me abhi bhi:

₹50,000


Ab API Redis se data read karegi:

Redis
 ↓
₹50,000 ❌

Stale Data


Isi problem ko:

CACHE INVALIDATION

kehte hain.

Ye Redis ka bahut important topic hai.


# 9. Cache Invalidation ka Basic Solution

Update:

MySQL
 ↓
Update Product
 ↓
Redis cache delete/update


Example:

PUT /products/101

MySQL
 ↓
Price = ₹55,000
 ↓
Redis DEL product:101


Next GET:

Redis
 ↓
MISS
 ↓
MySQL
 ↓
₹55,000
 ↓
Redis cache
 ↓
Return


Isse stale cache avoid karne me help milti hai.


# 10. Simple Architecture

                Application
                     |
                     ↓
                   Redis
                Cache Layer
                     |
              Cache Miss
                     ↓
              MySQL Database


Read:

Redis → HIT → Return


Read:

Redis → MISS → MySQL → Redis → Return


Update:

MySQL → Update
  ↓
Redis → Invalidate/Update


# Interview Answer

"Redis is commonly used as a caching layer in front of a primary database such as MySQL or PostgreSQL. The database remains the source of truth, while Redis stores frequently accessed data for low-latency reads and to reduce database load. One important challenge is cache invalidation when the underlying database data changes."


# Easy Memory

MySQL
→ Permanent / Source of Truth


Redis
→ Fast Cache


Redis HIT
→ Return quickly


Redis MISS
→ Database se fetch


Database Update
→ Cache invalidate/update


IMPORTANT:

Redis ≠ Always Database Replacement

Redis = Use-case dependent in-memory data store