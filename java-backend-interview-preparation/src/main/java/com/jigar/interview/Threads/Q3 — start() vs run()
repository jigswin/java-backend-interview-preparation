# start() vs run()

## start()

start() call karne par **new thread create hota hai**.

Thread t = new Thread(() -> {
    System.out.println("Task running");
});

t.start();


Flow:

main thread
    ↓
t.start()
    ↓
New Thread
    ↓
run()
    ↓
Task execute


## run()

run() ko directly call karoge to **new thread create nahi hota**.

t.run();


Flow:

main thread
    ↓
t.run()
    ↓
Same main thread me execute


## Real Example

Maan le:

Thread t = new Thread(() -> {
    System.out.println(
        Thread.currentThread().getName()
    );
});


t.start();

Output:
Thread-0

→ New thread.


t.run();

Output:
main

→ Main thread hi execute kar raha hai.


## Interview Answer

"`start()` creates a new thread and internally invokes `run()`, whereas calling `run()` directly is just a normal method call and executes in the current thread."


## Easy Memory

start()
→ NEW THREAD ✅

run()
→ NORMAL METHOD CALL ❌