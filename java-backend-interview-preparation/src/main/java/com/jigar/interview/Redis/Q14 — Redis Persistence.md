# Redis Q14 — Redis Persistence

## Persistence kya hai?

Redis mainly RAM me data rakhta hai.

Agar Redis restart/crash ho gaya,
to data recover karne ke liye Redis
persistence options provide karta hai.


## Main Types

### 1. RDB

RDB = Snapshot

Redis fixed intervals par
data ka snapshot disk par save karta hai.

Example:

Redis
↓
Snapshot
↓
Disk


Advantage:
→ Faster recovery
→ Backup ke liye useful

Disadvantage:
→ Last snapshot ke baad ka data lose ho sakta hai.


### 2. AOF

AOF = Append Only File

Redis write operations ko log karta hai.

Example:

SET product:101 ...
SET product:102 ...


Ye operations file me record hote hain.

Restart ke baad Redis in operations ko
replay karke state recover kar sakta hai.


Advantage:
→ Better durability options

Disadvantage:
→ File larger ho sakti hai
→ More I/O


## RDB vs AOF

RDB:
→ Periodic snapshot
→ Smaller/faster recovery files
→ Some recent changes lost ho sakte hain


AOF:
→ Write operations log
→ Better durability
→ More storage/I/O


## Real-World

Agar Redis sirf cache hai:

Data lose hone par:

Redis
↓
MISS
↓
MySQL
↓
Redis

To persistence less critical ho sakti hai.


Lekin agar Redis me important state/message
store kar rahe ho:

Persistence configuration much more important hai.


## Interview Answer

"Redis provides persistence mainly through RDB snapshots and AOF logs. RDB periodically saves snapshots, while AOF records write operations. The choice depends on the durability and recovery requirements of the application."


## Easy Memory

RDB
→ Snapshot


AOF
→ Operations Log


Cache-only Redis:
→ Persistence may be less critical


Important Redis data:
→ Persistence matters



🧠 Simple yaad rakh:

RDB = Photo kheench lo 📸
AOF = Jo changes hue unki diary likho 📖