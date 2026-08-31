# What is Race Condition?

Race Condition tab hoti hai jab **multiple threads same shared data ko
concurrently access/modify karte hain** aur final result execution timing
par depend karne lagta hai.

## Real-World Example

Bank account:

Balance = ₹1000

Do threads same time withdrawal kar rahe hain:

Thread 1 → Withdraw ₹700
Thread 2 → Withdraw ₹700


Dono balance read karte hain:

Thread 1 → ₹1000
Thread 2 → ₹1000


Dono ko lagta hai:

"₹700 available hai." 😅


Thread 1:
1000 - 700 = 300


Thread 2:
1000 - 700 = 300


Final:

Balance = ₹300 ❌

Lekin actual me ₹1400 withdraw karne ki koshish hui thi.


## Why?

`check → calculate → update`

Ye multiple steps hain.

Do threads in steps ko overlap kar sakte hain.


## Solution

`synchronized`

public synchronized void withdraw(int amount) {

    if (balance >= amount) {
        balance -= amount;
    }
}


Ab:

Thread 1
   ↓
Lock
   ↓
Check + Withdraw
   ↓
Unlock

Thread 2
   ↓
Lock ka wait
   ↓
Latest balance check
   ↓
Withdraw / Reject


## Another Real Example

Suppose:

int count = 0;

Thread 1 → count++
Thread 2 → count++

Expected:

count = 2


But dono same old value read kar sakte hain:

Thread 1 → read 0
Thread 2 → read 0

Thread 1 → 1
Thread 2 → 1

Final:

count = 1 ❌


## Interview Answer

"A race condition occurs when multiple threads concurrently access shared mutable data and the result depends on the timing or ordering of their execution. Synchronization mechanisms can be used to prevent it."


## Easy Memory

Multiple Threads
      ↓
Shared Data
      ↓
Concurrent Modification
      ↓
Race Condition ❌

Solution:
→ synchronized
→ Atomic classes
→ Locks
→ Other thread-safe mechanisms