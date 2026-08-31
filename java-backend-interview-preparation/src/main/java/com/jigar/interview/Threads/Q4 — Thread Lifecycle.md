# Thread Lifecycle

Java thread ki main states:

NEW
 ↓
RUNNABLE
 ↓
RUNNING
 ↓
WAITING / TIMED_WAITING / BLOCKED
 ↓
TERMINATED


## 1. NEW

Thread object create hua hai,
but start nahi kiya.

Thread t = new Thread();

→ NEW


## 2. RUNNABLE

`t.start()` call karne ke baad thread
execution ke liye ready hai.

t.start();

→ RUNNABLE


## 3. RUNNING

CPU thread ko execution ke liye select karta hai.

→ run() execute ho raha hai.


## 4. WAITING

Thread kisi doosre thread ke action ka wait kar raha hai.

Example:

wait()


## 5. TIMED_WAITING

Specific time tak wait.

Example:

Thread.sleep(5000);

→ 5 seconds wait.


## 6. BLOCKED

Thread kisi lock ko acquire karne ka wait kar raha hai.

Example:

Thread A ke paas lock hai.

Thread B
→ Same lock chahiye
→ BLOCKED


## 7. TERMINATED

run() complete ho gaya.

Thread ka execution finish.


## Real Example

Order processing thread:

NEW
 ↓
start()
 ↓
RUNNABLE
 ↓
RUNNING
 ↓
sleep(5 sec)
 ↓
TIMED_WAITING
 ↓
RUNNING
 ↓
Task complete
 ↓
TERMINATED


## Interview Answer

"A Java thread can move through states such as NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING and TERMINATED depending on its execution and synchronization conditions."


## Easy Memory

NEW
→ Created

RUNNABLE
→ Ready

RUNNING
→ Executing

WAITING
→ Waiting

BLOCKED
→ Lock ka wait

TERMINATED
→ Finished