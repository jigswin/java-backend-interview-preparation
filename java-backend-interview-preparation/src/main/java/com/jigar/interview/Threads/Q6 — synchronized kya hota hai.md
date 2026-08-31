# What is synchronized?

`synchronized` ka use **multiple threads ke beech shared data ko safely access**
karne ke liye hota hai.

## Real Example

Maan le bank account me:

Balance = ₹10,000

Do threads same time withdrawal kar rahe hain:

Thread 1 → ₹7,000
Thread 2 → ₹7,000


Agar dono same time balance read karein:

Thread 1 → Balance = 10,000
Thread 2 → Balance = 10,000

Dono withdrawal allow kar sakte hain ❌

Result:
→ Incorrect balance


## synchronized ka use

public synchronized void withdraw(int amount) {

    if (balance >= amount) {
        balance -= amount;
    }
}


Ab:

Thread 1
   ↓
Lock acquire
   ↓
Withdraw
   ↓
Lock release

Thread 2
   ↓
Wait for lock
   ↓
Withdraw


Ek time par synchronized method ko
same object ke through **sirf ek thread** execute karega.


## Is problem ko kya kehte hain?

Race Condition

→ Multiple threads same shared data ko concurrently access karte hain
aur unexpected/incorrect result aa sakta hai.


`synchronized` race condition ko avoid karne me help karta hai.


## synchronized ka benefit

→ Thread safety
→ Shared data protect
→ Race condition prevent karne me help


## Important

`synchronized` performance ko affect kar sakta hai kyunki
multiple threads ko lock ke liye wait karna pad sakta hai.


## Interview Answer

"`synchronized` is used to control concurrent access to shared resources. It allows only one thread at a time to execute the synchronized section for the same monitor, helping prevent race conditions."


## Easy Memory

Multiple Threads
      ↓
Shared Data
      ↓
Race Condition ❌

synchronized
      ↓
One thread at a time
      ↓
Thread Safe ✅