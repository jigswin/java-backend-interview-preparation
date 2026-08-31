# REDIS Q15 — FINAL INTERVIEW SCENARIO

## Scenario

E-commerce Product Service me:

GET /products/101

Hume response fast chahiye aur
database load reduce karna hai.


## Architecture

Client
↓
Product Service
↓
Redis
↓
HIT?
├── YES → Return
│
└── NO
↓
MySQL
↓
Redis
↓
Return


## Product Update

PUT /products/101

Product Service
↓
MySQL UPDATE
↓
Redis DELETE
↓
Success


Next GET:

Redis MISS
↓
MySQL
↓
Fresh Data
↓
Redis
↓
Return


## TTL

Example:

product:101
TTL = 30 minutes


TTL automatically cache ko expire karega.


## Multiple Instances

App-1 ─┐
App-2 ─┼→ Redis
App-3 ─┘

Redis = Distributed Cache


## Redis Data Types

String
→ Simple value / JSON / Counter

Hash
→ Object fields

List
→ Ordered data

Set
→ Unique data

Sorted Set
→ Ranking / Leaderboard


## Eviction

Memory full hone par:

LRU
→ Least Recently Used

LFU
→ Least Frequently Used

noeviction
→ Automatically evict nahi karega;
new writes fail ho sakti hain


## Pub/Sub

Publisher
↓
Redis Channel
↓
Subscriber


Useful for lightweight real-time messaging.


## Persistence

RDB
→ Snapshot

AOF
→ Write operation log


# FINAL INTERVIEW ANSWER

"Redis is an in-memory data store that I can use as a distributed caching layer in a microservices application. In a cache-aside approach, the service first checks Redis and, on a cache miss, fetches data from the database and caches it with an appropriate TTL. On updates or deletes, I would invalidate or update the cache. Redis can also be used for counters, sessions, rate limiting and other low-latency use cases. For production, I would also consider eviction policies, serialization, monitoring, high availability and persistence based on the use case."


# QUICK REVISION

Redis
→ In-memory data store

Cache
→ Fast access

Cache Hit
→ Redis se data mila

Cache Miss
→ DB se data fetch

Cache-Aside
→ Application cache manage karti hai

TTL
→ Cache expiry

Invalidation
→ Old cache remove/update

Distributed Cache
→ Multiple instances → Same Redis

RedisTemplate
→ Direct Redis operations

@Cacheable
→ Automatic caching

@CachePut
→ Cache update

@CacheEvict
→ Cache delete

LRU
→ Least Recently Used

LFU
→ Least Frequently Used

Pub/Sub
→ Lightweight real-time messaging

RDB
→ Snapshot

AOF
→ Operation log