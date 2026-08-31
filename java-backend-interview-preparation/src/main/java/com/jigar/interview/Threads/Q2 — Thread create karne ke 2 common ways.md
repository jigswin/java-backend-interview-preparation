# Thread Creation — Thread vs Runnable

## 1. Thread class extend karna

class EmailThread extends Thread {

    @Override
    public void run() {
        System.out.println("Sending Email");
    }
}

EmailThread t = new EmailThread();
t.start();


## 2. Runnable implement karna

class EmailTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Sending Email");
    }
}

Thread t = new Thread(new EmailTask());
t.start();


# Kaunsa better hai?

Generally:

Runnable → Better choice


Kyun?

Java me class already kisi aur class ko extend kar sakti hai.

Java multiple inheritance support nahi karta.

Example:

class EmailTask extends SomeService
              implements Runnable

Ye possible hai.

Lekin:

class EmailTask extends Thread
              extends SomeService

❌ Possible nahi.


## Real Example

Maan le:

class EmailService extends SomeBaseService
                     implements Runnable

Ab EmailService ko:

→ BaseService ka functionality bhi milega
→ Runnable ke through thread task bhi bana sakte ho


## Important Point

Runnable khud thread nahi hai.

Runnable
→ Task define karta hai


Thread
→ Us task ko execute karta hai.


Flow:

Runnable
   ↓
Task

Thread
   ↓
Task execute


## Interview Answer

"Java provides two common ways to create a thread: extending the Thread class or implementing Runnable. Runnable is generally preferred because it separates the task from the thread and allows the class to extend another class."


## Easy Memory

Thread
→ Worker


Runnable
→ Work/Task


Thread + Runnable
→ Worker executes Task