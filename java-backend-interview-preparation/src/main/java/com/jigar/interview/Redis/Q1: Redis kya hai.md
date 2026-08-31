# REDIS — Q1: Redis kya hai?

## 1. Redis kya hai?

Redis ek in-memory data store hai.

Redis ka data primarily memory (RAM) me rakha jata hai,
isliye data access bahut fast hota hai.

Redis commonly use hota hai:

→ Caching
→ Session storage
→ Temporary data
→ Counters
→ Rate limiting
→ Pub/Sub
→ Distributed locking
→ Fast lookups


## 2. Simple Example

Normally:

Application
    ↓
MySQL
    ↓
Query
    ↓
Result


Agar same data baar-baar request ho raha hai:

Application
    ↓
Redis
    ↓
Data available?
    ↓
YES → Return immediately


Agar Redis me data nahi hai:

Application
    ↓
Redis
    ↓
Cache Miss
    ↓
MySQL
    ↓
Data
    ↓
Redis me store
    ↓
Return


## 3. Real-World Example

Suppose e-commerce application me:

GET /products/101


Without Redis:

User
 ↓
API
 ↓
MySQL
 ↓
Product


Agar 10,000 users same product request kare:

10,000 requests
       ↓
MySQL


Database par unnecessary load aa sakta hai.


Redis ke saath:

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
Redis
 ↓
User


Next requests:

API
 ↓
Redis
 ↓
HIT
 ↓
User


MySQL ko baar-baar query nahi karni padegi.


## 4. Redis In-Memory kyu fast hai?

Traditional database ka data disk/storage se
read ho sakta hai.

Redis frequently accessed data ko memory me
store karta hai.

RAM access generally much faster hota hai
than disk-based access.


Isliye Redis low-latency use cases me useful hai.


## 5. Redis ko Database ka Replacement samajhna?

Usually NO.

MySQL/PostgreSQL:

→ Permanent business data
→ Transactions
→ Relational queries
→ Source of truth


Redis:

→ Fast temporary/access layer
→ Cache
→ Session
→ Counters
→ Other specialized use cases


Example:

Product:

MySQL
→ Actual product record


Redis
→ Frequently accessed product ka cached copy


## 6. Cache Hit

Redis me data mil gaya:

Request
 ↓
Redis
 ↓
FOUND
 ↓
Cache HIT
 ↓
Return


## 7. Cache Miss

Redis me data nahi mila:

Request
 ↓
Redis
 ↓
NOT FOUND
 ↓
Cache MISS
 ↓
MySQL
 ↓
Data
 ↓
Redis
 ↓
Return


## 8. Real Microservices Example

Product Service:

GET /products/101


Flow:

Client
 ↓
API
 ↓
Product Service
 ↓
Redis
 ↓
HIT?
 ├── YES → Return Product
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


## 9. Redis ka Important Characteristic

Redis:

→ In-memory
→ Key-Value based
→ Very fast
→ Distributed use cases support karta hai
→ Multiple data structures support karta hai
→ Persistence options bhi provide karta hai


## 10. Redis Example

Key:

product:101


Value:

{
    "id": 101,
    "name": "Laptop",
    "price": 50000
}


Redis conceptually:

product:101
     ↓
Product Data


Application:

GET product:101


→ Data mil gaya → Cache Hit


## 11. Redis kaha use karenge?

### Caching

Product details
User profile
Configuration


### Session

Logged-in user session


### Counter

Page views
Likes
API request count


### Rate Limiting

Example:

User maximum 100 API requests/minute.


### Distributed Lock

Multiple application instances ko
same resource simultaneously modify karne
se prevent karna.


## 12. Interview Answer

"Redis is an in-memory key-value data store commonly used for low-latency use cases such as caching, session storage, counters, rate limiting and distributed coordination. In a typical application, Redis can act as a fast cache in front of a relational database, reducing database load and improving response time."


## Easy Memory

MySQL
→ Permanent business data


Redis
→ Fast access layer


Cache Hit
→ Data Redis me mil gaya


Cache Miss
→ Redis me nahi mila → Database se fetch


Redis
→ RAM
→ Fast
→ Key-Value