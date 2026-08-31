# wait() vs notify() vs notifyAll()

## Basic Idea

Ye methods threads ko **aapas me coordinate** karne ke liye use hote hain.

Example:

Producer
→ Data banata hai

Consumer
→ Data consume karta hai


Agar data available nahi hai:

Consumer
→ wait()


Producer data create karta hai:

Producer
→ notify()


Consumer
→ Continue


## Real-World Example

Maan le ek food delivery system hai.

Kitchen = Producer
Delivery Boy = Consumer


Kitchen ne abhi food ready nahi kiya:

Delivery Boy
→ wait()


Kitchen:

Food Ready! 🍕

→ notify()


Delivery Boy
→ Food collect karta hai.


## wait()

Thread ko wait state me bhejta hai.

Important:

`wait()` object ka monitor lock release karta hai.


## notify()

Waiting threads me se **ek** waiting thread ko wake-up karta hai.


## notifyAll()

Us object par wait kar rahe **all threads** ko wake-up karta hai.


## Example

synchronized (lock) {

    while (!dataAvailable) {
        lock.wait();
    }

    // consume data
}


Producer:

synchronized (lock) {

    dataAvailable = true;

    lock.notify();
}


## Important

`wait()`, `notify()` aur `notifyAll()`

→ Object ke methods hain.

Inhe generally synchronized context/monitor ke saath use karna hota hai.


## wait() vs sleep()

wait()
→ Lock release karta hai
→ Thread coordination


sleep()
→ Lock release nahi karta
→ Time-based pause


## Interview Answer

"`wait()` puts a thread into a waiting state and releases the object's monitor. `notify()` wakes one waiting thread, while `notifyAll()` wakes all waiting threads on that monitor."


## Easy Memory

wait()
→ "Main wait karta hoon."


notify()
→ "Ek thread uth jao."


notifyAll()
→ "Sab uth jao."


Producer
→ notify

Consumer
→ wait