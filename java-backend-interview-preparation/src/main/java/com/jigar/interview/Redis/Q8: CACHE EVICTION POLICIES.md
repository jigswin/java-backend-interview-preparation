# REDIS — Q8: CACHE EVICTION POLICIES

## 1. Eviction kya hota hai?

Redis memory limited hoti hai.

Suppose:

maxmemory = 1 GB

Aur Redis me data continuously add ho raha hai.

Eventually:

Redis Memory
     ↓
1 GB FULL
     ↓
New data aa raha hai


Ab Redis ko decide karna padega:

"Konsa old/existing data remove karu?"


Is process ko:

CACHE EVICTION

kehte hain.


# 2. Eviction Policy kya hoti hai?

Eviction Policy = Redis ka rule

ki memory full hone par
kaunsi keys remove karni hain.


Example:

Redis:

product:101
product:102
product:103
product:104


Memory full.


Policy decide karegi:

→ Random key?
→ Least recently used?
→ Least frequently used?
→ Sirf TTL wali keys?


# 3. Important Policies

Interview ke liye ye policies important hain:

1. noeviction
2. allkeys-lru
3. volatile-lru
4. allkeys-lfu
5. volatile-lfu
6. allkeys-random
7. volatile-random
8. volatile-ttl


# 4. `noeviction`

Redis automatically existing keys
evict nahi karega.


Memory full:

New write
   ↓
❌ Error


Example:

SET product:105 ...


Memory available nahi:

→ Command fail ho sakta hai.


Useful when:

Data loss through eviction acceptable nahi hai.


# 5. `allkeys-lru`

LRU:

Least Recently Used


Redis dekhega:

"Kaunsi key sabse recently use nahi hui?"


Example:

product:101 → recently used
product:102 → recently used
product:103 → long time se use nahi hua


Memory full:

product:103
      ↓
Evict


`allkeys` ka meaning:

TTL ho ya na ho,
all keys eviction candidates ho sakti hain.


# 6. `volatile-lru`

Isme sirf un keys me se eviction hota hai
jin par TTL/expiration set hai.


Example:

product:101 → TTL
product:102 → TTL
product:103 → NO TTL


Memory full:


Candidate:

101
102


103 ko eviction candidate nahi banaya jayega.


# 7. `allkeys-lfu`

LFU:

Least Frequently Used


Redis dekhega:

"Kaunsi key sabse kam baar access hui?"


Example:

product:101 → 1000 accesses
product:102 → 500 accesses
product:103 → 2 accesses


Memory full:

product:103
      ↓
Evict


`allkeys`:

TTL hona necessary nahi.


# 8. `volatile-lfu`

Sirf TTL wali keys me se:

Least Frequently Used

key remove karne ki koshish hoti hai.


Example:

product:101 → TTL → 1000 accesses
product:102 → TTL → 10 accesses
product:103 → no TTL


Eviction candidate:

product:102


# 9. `allkeys-random`

Memory full:

Redis random key select karke
evict kar sakta hai.


Example:

product:101
product:102
product:103


Random:

product:102 → Remove


LRU/LFU jaisi usage information
consider nahi hoti.


# 10. `volatile-random`

Sirf TTL wali keys me se
random key eviction candidate hoti hai.


Example:

101 → TTL
102 → TTL
103 → No TTL


Random:

101 / 102


# 11. `volatile-ttl`

Sirf TTL wali keys consider hoti hain.

Redis expiration time ko consider karta hai.


Conceptually:

Key A → expires sooner
Key B → expires later


Earlier-expiring keys eviction ke liye
better candidates ho sakti hain.


# 12. LRU vs LFU

Ye interview me bahut common hai.


LRU:

Least Recently Used


Question:

"Last time kab use hua tha?"


Example:

A → accessed 1 min ago
B → accessed 1 day ago


B likely LRU candidate.


LFU:

Least Frequently Used


Question:

"Kitni baar use hua?"


Example:

A → 1000 times
B → 2 times


B likely LFU candidate.


# 13. Real-World Example

E-commerce:

Redis cache:

product:101 → very popular
product:102 → popular
product:103 → rarely accessed
product:104 → rarely accessed


Memory full.


Agar:

allkeys-lru


use kar rahe ho:

Recently least-used keys
eviction candidates ban sakti hain.


Agar:

allkeys-lfu


use kar rahe ho:

Rarely accessed keys
eviction candidates ban sakti hain.


# 14. Cache vs Important Data

Important point:

Eviction policy ka decision business requirement
ke according hona chahiye.


Agar Redis sirf cache hai:

→ Eviction acceptable ho sakta hai.


Agar Redis me critical data hai:

→ Blind eviction dangerous ho sakta hai.


Example:

Cache:

Product details
→ Eviction okay


Critical business state:

Payment transaction state
→ Automatically evict karna carefully evaluate karna hoga.


# 15. `maxmemory`

Redis ko maximum memory limit configure
ki ja sakti hai.


Concept:

maxmemory 1gb


Jab Redis configured memory limit reach karta hai,
configured eviction policy apply ho sakti hai.


# 16. Real Architecture

Application
    ↓
Redis
    ↓
Memory
    ↓
FULL
    ↓
Eviction Policy
    ↓
Choose Key
    ↓
Remove
    ↓
New Data


# 17. Interview Question

Q:

"What is LRU?"


Answer:

"LRU stands for Least Recently Used. Under an LRU eviction policy, keys that have been least recently accessed are preferred as eviction candidates when Redis needs to free memory."


Q:

"LRU vs LFU?"


Answer:

"LRU focuses on how recently a key was accessed, while LFU focuses on how frequently a key is accessed."


# 18. Interview Scenario

Question:

"Your Redis cache is full. What happens?"


Answer:

"It depends on the configured maxmemory and eviction policy. If an eviction policy is configured, Redis can evict eligible keys according to that policy. With noeviction, new writes can fail once the memory limit is reached."


# 19. Easy Memory

LRU
→ Least Recently Used


LFU
→ Least Frequently Used


ALLKEYS
→ All keys can be candidates


VOLATILE
→ Only keys with expiration/TTL


RANDOM
→ Random key


NOEVICTION
→ Don't remove keys
→ New writes can fail


## Most Important:

allkeys-lru
→ Common cache-oriented choice


allkeys-lfu
→ Useful when frequency matters


noeviction
→ No automatic eviction