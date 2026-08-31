# Java — Q1: What is Thread?

## Thread kya hai?

Thread ek **smallest unit of execution** hai jo program ke andar independently
kaam kar sakta hai.

Simple:

Application
   ↓
Process
   ↓
Multiple Threads


## Real-World Example

E-commerce application:

Main Thread
→ User request handle

Thread 1
→ Payment

Thread 2
→ Email

Thread 3
→ Notification


Multiple tasks concurrently execute ho sakte hain.


## Process vs Thread

Process
→ Running application

Thread
→ Process ke andar execution ka unit


Example:

Chrome = Process

Chrome ke andar multiple tasks
→ Multiple threads


## Java me Thread create karna

### 1. Thread class extend

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Running...");
    }
}

MyThread t = new MyThread();

t.start();


### 2. Runnable implement

class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Running...");
    }
}

Thread t = new Thread(new MyTask());

t.start();


## Important: start() vs run()

start()

→ New thread create karta hai
→ run() ko new thread me execute karta hai


run()

→ Normal method ki tarah current thread me execute hota hai.


## Interview Answer

"A thread is the smallest unit of execution within a process. Java supports multithreading, allowing multiple tasks to execute concurrently within the same application."


## Easy Memory

Process
→ Application

Thread
→ Application ke andar execution unit

start()
→ New thread

run()
→ Normal method call



# Thread — Real-World Example

Maan le hamari e-commerce application hai.

Customer ne order place kiya.

Order ke baad 3 kaam karne hain:

1. Order save
2. Email send
3. Notification send


### Without Multithreading

Main Thread
    ↓
Save Order
    ↓
Send Email
    ↓
Send Notification
    ↓
Response


Problem:

Email service slow hai → 5 sec

To user ko unnecessarily wait karna padega.


### With Multiple Threads

Main Thread
    ↓
Save Order
    ↓
    ├── Thread 1 → Send Email
    └── Thread 2 → Send Notification

Main request ka required work continue kar sakta hai.

Ye especially background/independent tasks ke liye useful hai.


# Java Example

class EmailTask implements Runnable {

    @Override
    public void run() {

        System.out.println(
            "Sending Email..."
        );
    }
}


class NotificationTask implements Runnable {

    @Override
    public void run() {

        System.out.println(
            "Sending Notification..."
        );
    }
}


public class Main {

    public static void main(String[] args) {

        Thread emailThread =
            new Thread(new EmailTask());

        Thread notificationThread =
            new Thread(new NotificationTask());

        emailThread.start();
        notificationThread.start();
    }
}


### Flow

main()
  ↓
Email Thread ─────→ Email
       \
        \
Notification Thread → Notification


Dono tasks independently execute ho sakte hain.


# Important Point

"Multithreading" ka matlab ye nahi ki har situation me tasks
exactly same time par execute honge.

Actual execution CPU scheduling par depend karta hai.

Isliye interview me better word hai:

→ Concurrent execution


# Real Example yaad rakh

Order Service

Main Thread
→ Order save

Background Thread
→ Email

Background Thread
→ Notification

**Independent tasks ko parallel/concurrent handle karne ke liye
multiple threads useful hote hain.**