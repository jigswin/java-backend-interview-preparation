# What is Deadlock?

Deadlock tab hota hai jab **do ya zyada threads ek-dusre ke lock ka wait
karte rehte hain aur koi bhi aage execute nahi kar pata.**

## Real-Life Example

Soch:

Person A ke paas:
→ Pen ✏️

Person B ke paas:
→ Paper 📄


A:
"Paper chahiye."

B:
"Pen chahiye."

Dono wait kar rahe hain:

A → B ke resource ka wait
B → A ke resource ka wait

→ Deadlock 😄


## Java Example

Object lock1 = new Object();
Object lock2 = new Object();


Thread 1:

synchronized (lock1) {

    synchronized (lock2) {

        // work
    }
}


Thread 2:

synchronized (lock2) {

    synchronized (lock1) {

        // work
    }
}


### Flow

Thread 1
→ lock1 acquire ✅
→ lock2 ka wait


Thread 2
→ lock2 acquire ✅
→ lock1 ka wait


Ab:

Thread 1 → Thread 2 ka lock wait
Thread 2 → Thread 1 ka lock wait


❌ DEADLOCK


## How to Prevent?

### 1. Same lock order maintain karo

Har jagah:

lock1
 ↓
lock2


Aisa nahi:

Thread 1:
lock1 → lock2

Thread 2:
lock2 → lock1


### 2. Lock timeout use karo

Java me `tryLock()` with timeout useful ho sakta hai.


### 3. Unnecessary nested locks avoid karo

Jitne kam locks,
→ utna deadlock risk kam.


## Interview Answer

"Deadlock occurs when two or more threads are blocked indefinitely because each thread is waiting for a lock held by another thread. It can be prevented by maintaining a consistent lock ordering, minimizing nested locks, or using timed lock acquisition."


## Easy Memory

Thread 1
→ Lock A
→ Waiting for B


Thread 2
→ Lock B
→ Waiting for A


A waits for B
B waits for A

= DEADLOCK 🔒