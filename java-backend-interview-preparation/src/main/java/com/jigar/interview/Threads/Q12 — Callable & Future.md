# Callable & Future

## Problem with Runnable

Runnable ka `run()` method koi result return nahi karta.

Example:

Runnable task = () -> {
    // calculation
};

Isse hum directly result nahi le sakte.


## Callable

`Callable` ek task ko represent karta hai jo:

→ Result return kar sakta hai
→ Exception throw kar sakta hai

Example:

Callable<Integer> task = () -> {

    return 10 + 20;
};


## Future

`Future` asynchronous task ka **future result** represent karta hai.

Example:

ExecutorService executor =
    Executors.newFixedThreadPool(2);


Callable<Integer> task = () -> {

    return 10 + 20;
};


Future<Integer> future =
    executor.submit(task);


Integer result = future.get();


System.out.println(result);

Output:

30


## Flow

Main Thread
    ↓
submit(Callable)
    ↓
ExecutorService
    ↓
Worker Thread
    ↓
Calculation
    ↓
Result
    ↓
Future
    ↓
future.get()
    ↓
Main Thread gets result


## Real-World Example

Maan le Order Service ko ek external service se
customer ka credit score calculate karwana hai.

Main Thread:

"Credit score calculate karo."

Worker Thread:
→ Calculation karta hai


Future:
→ Result baad me milega.


CreditScore = future.get();


## Important Point

`future.get()` **wait/block** kar sakta hai agar task abhi complete nahi hua.

Example:

Worker task → 5 seconds

Main thread:
future.get()

→ Result aane tak wait karega.


## Runnable vs Callable

Runnable
→ No return value
→ `run()`


Callable
→ Result return kar sakta hai
→ `call()`


Runnable
→ Checked exception directly throw nahi kar sakta


Callable
→ Exception throw kar sakta hai


## Interview Answer

"`Callable` represents a task that can return a result and throw an exception, while `Future` represents the result of an asynchronous computation. A Future can be used to retrieve the result using `get()`."


## Easy Memory

Runnable
→ Work karo


Callable
→ Work karo + Result do


Future
→ Result baad me milega


Flow:

Callable
   ↓
ExecutorService
   ↓
Future
   ↓
get()
   ↓
Result