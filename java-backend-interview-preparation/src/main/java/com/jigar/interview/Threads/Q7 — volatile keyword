# What is volatile?

`volatile` ensure karta hai ki ek thread ke dwara variable me kiya gaya
latest change **dusre threads ko visible** ho.

## Real Example

Maan le:

volatile boolean running = true;


Thread 1:

while (running) {
    // work
}


Thread 2:

running = false;


Thread 2 ne `running = false` kar diya.

`volatile` ki wajah se Thread 1 ko latest value visible hogi
aur loop stop ho sakta hai.


## Problem Without volatile

CPU/JVM optimization ki wajah se ek thread ko variable ki
latest value immediately visible na ho sakti hai.

`volatile`
→ visibility guarantee


## volatile vs synchronized

volatile
→ Visibility


synchronized
→ Mutual exclusion + visibility


Example:

volatile int count;

Multiple threads agar:

count++;

kar rahe hain, to `volatile` alone enough nahi hai.

Kyunki `count++` ek single atomic operation nahi hai.


## Easy Example

volatile boolean shutdown = false;


Thread 1
→ Application ka kaam


Thread 2
→ shutdown = true


volatile
→ Thread 1 ko updated value visible.


## Interview Answer

"`volatile` ensures visibility of changes to a variable across threads. However, it does not provide mutual exclusion and does not make compound operations like `count++` atomic."


## Easy Memory

volatile
→ "Latest value dikhao" 👀


synchronized
→ "Ek time par ek thread" 🔒