# Q25 — Stack vs Heap Memory in Java

## 1. Java me Memory kya hoti hai?

Jab Java program run hota hai, JVM memory ko different areas me manage karti hai.

Interview ke liye hume mainly 2 memory areas samajhni hain:

1. Stack Memory
2. Heap Memory


# 2. Stack Memory kya hoti hai?

Stack memory ka use mainly:

- Method calls
- Local variables
- Method parameters
- References to objects

ko manage karne ke liye hota hai.

Har thread ka apna separate stack hota hai.


Example:

public class Demo {

    public static void main(String[] args) {

        int x = 10;

        int y = 20;

        int result = add(x, y);

        System.out.println(result);
    }

    static int add(int a, int b) {

        int sum = a + b;

        return sum;
    }
}


Jab main() execute hota hai:

main() ka ek stack frame create hota hai.

Usme:

x
y
result

jaise local variables manage hote hain.


Jab add() call hota hai:

add() ka ek naya stack frame create hota hai.

Usme:

a
b
sum

manage hote hain.


add() complete hone ke baad:

add() ka stack frame remove ho jata hai.


# 3. Heap Memory kya hoti hai?

Heap memory ka use mainly objects aur arrays ko store karne ke liye hota hai.

Example:

Employee employee =
        new Employee();


Yahan:

new Employee()

→ Object heap memory me create hota hai.


`employee`

→ Object ka reference hai.

Interview level par simple way:

Reference/local variable stack frame me hota hai, aur actual object heap me hota hai.


# 4. Simple Example

class Employee {

    int id;

    String name;
}


public class Main {

    public static void main(String[] args) {

        Employee employee =
                new Employee();

        employee.id = 101;

        employee.name = "Jigar";
    }
}


Conceptually:

STACK:

employee
→ Reference


HEAP:

Employee Object
→ id = 101
→ name = "Jigar"


Important:

`employee` reference stack frame ka part ho sakta hai.

Actual Employee object heap me hota hai.


# 5. Stack vs Heap

STACK:

→ Method calls ke liye
→ Local variables
→ Method parameters
→ Per-thread
→ Fast access
→ Automatically managed when stack frames return
→ Limited size


HEAP:

→ Objects
→ Arrays
→ Instance data
→ Shared across threads
→ Garbage Collector manage karta hai
→ Generally larger than stack


# 6. Real-World Example

Suppose:

public void createEmployee() {

    int id = 101;

    Employee employee =
            new Employee();

    employee.setName("Jigar");
}


Conceptually:

STACK:

id = 101

employee = reference


HEAP:

Employee object

name = "Jigar"


Jab createEmployee() complete hota hai:

Stack frame remove ho jata hai.

Agar heap object ko koi reference nahi karta, to wo object Garbage Collection ke liye eligible ho sakta hai.


# 7. Stack Frame kya hota hai?

Jab bhi method call hota hai, JVM us method ke execution ke liye stack par ek frame create karti hai.

Example:

main()
    ↓
calculate()
    ↓
print()


Stack me conceptually:

print() frame
calculate() frame
main() frame


Jab print() complete:

print() frame remove.


Phir calculate() complete:

calculate() frame remove.


Finally main() complete:

main() frame remove.


Isko LIFO principle ke through samajh sakte ho:

Last In → First Out.


# 8. StackOverflowError

Agar method calls bahut zyada ho jayein aur stack memory available na rahe, to:

StackOverflowError

aa sakta hai.


Example:

public class Demo {

    static void test() {

        test();
    }

    public static void main(String[] args) {

        test();
    }
}


Yahan:

test()
→ test()
→ test()
→ test()
→ ...

infinite recursion ho rahi hai.

Har call ek stack frame create karta hai.

Eventually stack memory full ho sakti hai.

Result:

StackOverflowError


# 9. Heap Memory Full hone par kya ho sakta hai?

Agar application continuously objects create karti rahe aur sufficient heap available na ho, to:

OutOfMemoryError: Java heap space

aa sakta hai.


Example conceptually:

List<Employee> employees =
        new ArrayList<>();

while (true) {

    employees.add(
        new Employee()
    );
}


Agar objects continuously referenced hain aur memory release nahi ho rahi, heap eventually fill ho sakta hai.


# 10. Garbage Collector ka Role

Heap memory me unused objects ko Garbage Collector identify karke memory reclaim kar sakta hai.

Example:

Employee employee =
        new Employee();

employee = null;


Ab agar us Employee object ka koi aur reference nahi hai, to object garbage collection ke liye eligible ho sakta hai.


Important:

Eligible for GC

ka matlab ye nahi hai ki object immediately delete ho jayega.

GC kab run karega, ye JVM decide karti hai.


# 11. Stack me Garbage Collection hota hai?

Normal stack frames ko Garbage Collector manage nahi karta.

Jab method complete hota hai, uska stack frame automatically remove ho jata hai.


Heap:

→ GC manages object memory reclamation.


Stack:

→ Method execution ke saath frames create/remove hote hain.


# 12. Primitive Variables

Example:

int age = 30;

double salary = 50000.0;


Method-local primitive variables typically stack frame ke local data ka part hote hain.


Lekin exact JVM implementation details ko interview me over-simplify nahi karna chahiye.

Interview ke liye:

> Local primitive variables are typically associated with the method's stack frame.


# 13. Object Reference

Example:

Employee employee =
        new Employee();


Conceptually:

STACK:

employee
↓
reference


HEAP:

Employee object


Yani:

Reference
→ Stack frame ke context me

Object
→ Heap


# 14. String Example

Example:

String name = "Jigar";


String literals String Pool me managed hote hain, jo modern JVMs me heap ka part hota hai.

Example:

String a = "Jigar";

String b = "Jigar";


Same string literal reuse ho sakta hai through the String Pool.


Important:

String Pool heap se conceptually related hai, stack nahi.


# 15. Method Parameters

Example:

static int add(int a, int b) {

    return a + b;
}


`a` aur `b` method execution ke stack frame ke context me hote hain.


# 16. Instance Variables

Example:

class Employee {

    int id;

    String name;
}


Employee employee =
        new Employee();


`id` aur `name` object ka state hain, isliye actual object ke saath heap me associated hote hain.


# 17. Stack vs Heap — Interview Table

STACK:

Purpose:
→ Method execution

Contains:
→ Local variables
→ Method parameters
→ References/local execution data

Ownership:
→ Each thread has its own stack

Management:
→ Stack frames created/removed automatically with method execution

Error:
→ StackOverflowError


HEAP:

Purpose:
→ Objects and arrays

Contains:
→ Objects
→ Instance data
→ Arrays

Ownership:
→ Shared among threads

Management:
→ Garbage Collector

Error:
→ OutOfMemoryError: Java heap space


# 18. Important Difference

Stack:

Fast and smaller.

Heap:

Generally larger and managed by Garbage Collector.


But don't say:

"Stack is always faster than heap."

Better interview answer:

> Stack allocation/access is generally efficient because it follows method-frame based management, while heap objects require dynamic memory management.


# 19. Can Stack and Heap be shared between threads?

Stack:

NO.

Each thread has its own stack.


Heap:

YES.

Heap is shared across threads.


Example:

Thread-1
→ Own Stack

Thread-2
→ Own Stack

Thread-3
→ Own Stack


All can access objects stored in:

Common Heap


# 20. Real-World Analogy

Think of a restaurant.

STACK:

Your current table/order work.

Jab waiter ek order process karta hai, uske current task ki information temporarily maintain hoti hai.

Method complete:

Task finish.


HEAP:

Restaurant ka common storage area.

Different tasks/people objects ko use kar sakte hain.

Garbage Collector:

Unused items ko clean karne wala system.


# 21. Interview-Ready Answer

Question:

"What is the difference between Stack and Heap memory in Java?"

Answer:

"Stack memory is used for method execution, local variables and method frames, and each thread has its own stack. Heap memory is used for dynamically allocated objects and arrays and is shared across threads. Heap memory is managed by the Garbage Collector, while stack frames are created and removed as methods are called and return."


# 22. Important Interview Questions

Q: Where are objects stored?

A:

"Objects are generally allocated in heap memory."


Q: Where are local variables stored?

A:

"Local variables are associated with the method's stack frame."


Q: Where is object reference stored?

A:

"For a local reference variable, the reference is typically part of the stack frame, while the referenced object is on the heap."


Q: Which memory is shared between threads?

A:

"Heap is shared. Each thread has its own stack."


Q: What happens when a method completes?

A:

"Its stack frame is removed."


Q: What causes StackOverflowError?

A:

"Usually excessive or infinite method calls, commonly due to recursion."


Q: What causes OutOfMemoryError: Java heap space?

A:

"When the JVM cannot allocate required objects in the heap."


Q: Who manages heap memory?

A:

"Garbage Collector manages automatic reclamation of eligible heap objects."


Q: Does GC immediately remove an object when it becomes unreachable?

A:

"No. The object becomes eligible for garbage collection, but actual collection happens when the JVM's GC determines it is appropriate."


# 23. QUICK REVISION

STACK:

→ Per thread

→ Method execution

→ Stack frames

→ Local variables

→ Method parameters

→ Local references

→ LIFO

→ StackOverflowError


HEAP:

→ Shared between threads

→ Objects

→ Arrays

→ Instance data

→ Garbage Collector

→ OutOfMemoryError


Easy memory trick:

STACK
→ "What is my method doing right now?"


HEAP
→ "Where are my objects stored?"


ONE-LINE INTERVIEW ANSWER:

"Stack is mainly used for thread-specific method execution and stack frames, while heap is shared memory where Java objects and arrays are generally allocated and managed by the Garbage Collector."