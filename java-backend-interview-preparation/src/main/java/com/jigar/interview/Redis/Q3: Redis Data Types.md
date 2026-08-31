# REDIS — Q3: Redis Data Types

Redis sirf simple key-value String store nahi hai.

Redis multiple data structures provide karta hai:

1. String
2. Hash
3. List
4. Set
5. Sorted Set (ZSet)
6. Streams
7. Bitmaps / Bitfields
8. HyperLogLog


Hum interview ke liye pehle 5 ko strongly samjhenge.


# 1. STRING

Sabse basic Redis data type.

Example:

Key:
user:name:101

Value:
Jigar


Redis:

SET user:name:101 "Jigar"

GET user:name:101


Result:

Jigar


## Real-world use:

→ Simple cache
→ Token
→ Counter
→ Configuration
→ JSON string


Example:

product:101

{
    "id": 101,
    "name": "Laptop",
    "price": 50000
}


String ke andar JSON bhi store kar sakte hain.


## Counter Example

SET product:view:101 100

INCR product:view:101


Result:

101


Useful for:

→ Page views
→ Likes
→ Request count


# 2. HASH

Hash ek object ke multiple fields ko
ek Redis key ke andar store karne ke liye useful hai.


Example:

user:101

name → Jigar
email → jigar@example.com
city → Bangalore


Redis concept:

HSET user:101 name "Jigar"
HSET user:101 email "jigar@example.com"
HSET user:101 city "Bangalore"


Get:

HGET user:101 name


Result:

Jigar


## Real-world use:

User profile
Product details
Configuration object


Example:

product:101

name → Laptop
price → 50000
stock → 25


# 3. LIST

List ordered collection hoti hai.

Example:

notifications:user:101


Items:

Notification 1
Notification 2
Notification 3


Commands:

LPUSH notifications:user:101 "Order Created"

LPUSH notifications:user:101 "Payment Successful"


List useful hai:

→ Queue-like use cases
→ Recent items
→ Activity feed
→ Notifications


Example:

Latest 10 activities

LPUSH activity:user:101 "Login"
LPUSH activity:user:101 "Order Created"

LRANGE activity:user:101 0 9


# 4. SET

Set unordered collection hai
jisme duplicate values automatically allowed nahi hoti.


Example:

user:101:roles

ADMIN
USER


Agar:

USER
USER


dobara add karoge,
duplicate store nahi hoga.


Useful for:

→ Unique values
→ Tags
→ Roles
→ Membership
→ Unique users/items


Example:

SADD user:101:roles "USER"
SADD user:101:roles "ADMIN"


Check:

SISMEMBER user:101:roles "ADMIN"


Result:

1 / true


# 5. SORTED SET (ZSET)

Sorted Set me:

Member + Score

store hota hai.

Example:

Leaderboard:

Jigar → 100
Rahul → 90
Amit → 80


Redis:

ZADD leaderboard 100 Jigar
ZADD leaderboard 90 Rahul
ZADD leaderboard 80 Amit


Score ke according sorted result
nikal sakte hain.


## Real-world use:

→ Gaming leaderboard
→ Ranking
→ Priority-based data
→ Score-based sorting


# 6. STREAMS

Redis Streams event/message stream ke liye
use ho sakte hain.

Concept:

Producer
   ↓
Redis Stream
   ↓
Consumer


Useful for:

→ Event streaming
→ Activity logs
→ Message processing


Lekin hamare architecture me event streaming ke liye
Kafka bhi available hai, jisko hum already cover kar chuke hain.


# 7. Quick Comparison

STRING

Key → Value

Example:
product:101 → JSON


HASH

Key → Fields

Example:
user:101 → name, email, city


LIST

Ordered values

Example:
notifications


SET

Unique values

Example:
roles/tags


SORTED SET

Value + Score

Example:
leaderboard


STREAM

Append-style event stream

Example:
events


# 8. Real-World E-Commerce Example

Redis:

product:101
→ Product JSON / cached data

user:101
→ User profile Hash

notifications:101
→ List of notifications

user:101:roles
→ Set of roles

product:views:101
→ String counter

sales:leaderboard
→ Sorted Set


# 9. Interview Question

Q:

"What Redis data types have you used?"


Answer:

"I have mainly used Redis Strings and Hashes for caching and structured data. Strings are useful for simple values, JSON or counters, while Hashes are useful for storing multiple fields under a single key. Redis also provides Lists for ordered collections, Sets for unique values, Sorted Sets for score-based ranking, and Streams for stream-like processing."


# Easy Memory

STRING
→ Simple value / JSON / Counter


HASH
→ Object fields


LIST
→ Ordered collection


SET
→ Unique values


ZSET
→ Score + Ranking


STREAM
→ Events / Stream