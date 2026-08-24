# Threads Q13 — Atomic Classes & Concurrent Collections

## 1. Atomic Classes kya hain?

Atomic classes aise operations provide karti hain jo
**thread-safe aur atomic** hote hain.

Example:

AtomicInteger count =
    new AtomicInteger(0);


Thread 1:
count.incrementAndGet();


Thread 2:
count.incrementAndGet();


Final value correctly maintain ho sakti hai.


## Problem with normal int

int count = 0;

count++;


`count++` actually multiple steps involve karta hai:

READ
 ↓
ADD
 ↓
WRITE


Multiple threads ke saath race condition ho sakti hai.


## AtomicInteger

AtomicInteger ka:

incrementAndGet()

operation atomic hota hai.

Example:

AtomicInteger count =
    new AtomicInteger(0);

count.incrementAndGet();


## Real-World Example

Website par:

Total requests = 0


100 threads simultaneously request process kar rahe hain.

AtomicInteger:

AtomicInteger requests =
    new AtomicInteger(0);


requests.incrementAndGet();


Thread-safe counter maintain karne ke liye useful.


# 2. Concurrent Collections

Normal collections har situation me thread-safe nahi hoti.

Example:

HashMap
→ Thread-safe nahi ❌


Multithreaded environment me:

ConcurrentHashMap
→ Thread-safe map ✅


## Real Example

Multiple threads user activity update kar rahe hain:

ConcurrentHashMap<String, Integer> activity =
    new ConcurrentHashMap<>();


activity.merge(
    "Jigar",
    1,
    Integer::sum
);


Multiple threads safely map access kar sakte hain.


## Common Concurrent Collections

ConcurrentHashMap
→ Thread-safe Map


CopyOnWriteArrayList
→ Thread-safe List


BlockingQueue
→ Producer/Consumer scenarios


## Atomic vs synchronized

AtomicInteger:

→ Simple atomic operations ke liye useful


synchronized:

→ Multiple statements / larger critical section
ko protect karne ke liye useful


## Interview Answer

"Atomic classes such as AtomicInteger provide thread-safe atomic operations without using traditional synchronization for simple cases. Concurrent collections such as ConcurrentHashMap are designed for safe concurrent access by multiple threads."


## Easy Memory

AtomicInteger
→ Thread-safe counter


ConcurrentHashMap
→ Thread-safe Map


synchronized
→ Critical section protect


Example:

count++
→ Race condition possible


AtomicInteger.incrementAndGet()
→ Atomic operation ✅