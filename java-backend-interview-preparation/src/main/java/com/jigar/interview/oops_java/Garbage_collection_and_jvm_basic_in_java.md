# Q27 — Garbage Collection + JVM Basics in Java

## 1. Garbage Collection kya hota hai?

Garbage Collection (GC) Java ka automatic memory management mechanism hai.

Simple language me:

> Jo objects ab application me use nahi ho rahe hain aur jinhe koi reachable reference nahi kar raha, unki memory ko JVM automatically reclaim kar sakti hai.

Example:

class Employee {
}

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee();

        e1 = null;
    }
}


Pehle:

e1
↓
Employee Object


Jab:

e1 = null;


Ho gaya, aur agar object ko koi aur reference nahi kar raha hai:

Employee Object
↓
No reference


Ab object:

GC ke liye eligible ho sakta hai.


IMPORTANT:

"Eligible for GC" ka matlab ye nahi hai ki object immediately delete ho jayega.

GC kab run karega, ye JVM decide karti hai.


# 2. Garbage Collector ka main purpose

Garbage Collector ka main purpose:

> Heap memory me unused/unreachable objects ki memory reclaim karna.

Isse developer ko manually object memory free karne ki zarurat nahi padti.


# 3. Java me Manual Memory Deallocation hota hai?

C/C++ ki tarah Java me normally manually memory free karne ke liye:

free()
delete

jaise keywords nahi hain.


Java automatically Garbage Collector use karta hai.


# 4. Object Garbage Collection ke liye kab Eligible hota hai?

Main condition:

> Jab object reachable nahi rehta.

Example:

Employee e1 = new Employee();

e1 = null;


Agar koi aur reference nahi hai:

Employee Object
↓
Unreachable


Object GC ke liye eligible hai.


# 5. Multiple References Example

Employee e1 = new Employee();

Employee e2 = e1;


Ab:

e1
↓
Employee Object
↑
e2


Agar:

e1 = null;


Still:

e2
↓
Employee Object


Object GC ke liye eligible nahi hai.


Agar:

e2 = null;


Ab:

Employee Object
↓
No reference


Ab object GC ke liye eligible ho sakta hai.


# 6. Object Reference ko null karna

Example:

Employee employee =
        new Employee();

employee = null;


Iska meaning:

Reference remove ho gaya.

Object automatically immediately destroy nahi hota.

Agar koi aur reference nahi hai:

→ Object becomes eligible for GC.


# 7. Garbage Collection Heap me hota hai

Java objects generally Heap me allocate hote hain.

Garbage Collector:

→ Heap ke objects ko manage karta hai.

Stack memory ke method frames ko GC normally manage nahi karta.

Method return hone par stack frame automatically remove ho jata hai.


# 8. System.gc()

Java me hum GC ko request kar sakte hain:

System.gc();


Example:

public class Main {

    public static void main(String[] args) {

        Employee employee =
                new Employee();

        employee = null;

        System.gc();
    }
}


IMPORTANT:

System.gc() guarantee nahi karta ki GC immediately run hoga.

Ye sirf JVM ko request/suggestion hai.


Interview me:

"System.gc() requests the JVM to perform garbage collection, but it does not guarantee immediate execution."


# 9. finalize() kya hota tha?

Older Java versions me:

finalize()

method ko object cleanup ke context me discuss kiya jata tha.


Important modern interview point:

> `finalize()` is deprecated and should not be used for resource management.


Modern Java me resources ko properly manage karne ke liye:

try-with-resources

use karna better hai.


Example:

try (FileInputStream input =
        new FileInputStream("data.txt")) {

    // use resource

}


Resource automatically close ho jata hai.


# 10. Garbage Collection kaise decide karta hai?

Simplified interview explanation:

GC primarily reachable/unreachable objects ko determine karta hai.

Agar object application ke GC roots se reachable nahi hai, to wo garbage collection ke liye eligible ho sakta hai.


GC roots ke examples:

- Active thread references
- Local variables/references in active stack frames
- Static references
- JNI references


Simple language:

> Agar object tak koi valid reachable reference path nahi hai, to object garbage ban sakta hai.


# 11. Garbage Collection Example

class Employee {
}

public class Main {

    public static void main(String[] args) {

        Employee e1 =
                new Employee();

        Employee e2 =
                new Employee();

        e1 = null;

        e2 = null;
    }
}


Method ke end tak:

e1
→ null

e2
→ null


Agar objects ke koi aur references nahi hain:

Dono objects GC ke liye eligible ho sakte hain.


# 12. Circular Reference

Important interview question.

Example:

class A {

    B b;
}

class B {

    A a;
}


A a = new A();

B b = new B();

a.b = b;

b.a = a;


Ab:

A → B
↑   ↓
└───┘


Suppose:

a = null;

b = null;


Objects ek dusre ko reference kar rahe hain, but application ke paas external reference nahi hai.

Modern Java GC algorithms unreachable cyclic objects ko bhi collect kar sakte hain.

Important:

> Java GC reference counting alone par depend nahi karta, isliye cyclic references necessarily memory leak nahi banate.


# 13. Memory Leak Java me ho sakta hai?

YES.

Garbage Collector hone ke baad bhi memory leak ho sakta hai.

Example:

static List<Employee> employees =
        new ArrayList<>();


Har request par:

employees.add(
    new Employee()
);


Agar list se old objects remove nahi kiye ja rahe:

static reference
↓
List
↓
Employee objects


Objects reachable hain, isliye GC unhe collect nahi karega.

Application ki memory continuously grow kar sakti hai.


# 14. JVM kya hoti hai?

JVM:

Java Virtual Machine


JVM Java bytecode ko execute karti hai.

Flow:

Java Source Code
        ↓
      javac
        ↓
Java Bytecode (.class)
        ↓
       JVM
        ↓
Machine-specific execution


Example:

Main.java

↓

javac Main.java

↓

Main.class

↓

JVM executes bytecode.


# 15. JVM ka Main Role

JVM mainly:

1. Bytecode execute karti hai
2. Memory manage karti hai
3. Garbage Collection provide karti hai
4. Class loading handle karti hai
5. Runtime environment provide karti hai
6. Security/runtime checks me role play karti hai


# 16. JDK, JRE, JVM Relationship

Simple structure:

JDK
│
├── Development Tools
│
└── JRE
    │
    ├── JVM
    └── Runtime Libraries


JDK:

Java Development Kit


JRE:

Java Runtime Environment


JVM:

Java Virtual Machine


# 17. JDK kya hota hai?

JDK developers ke liye hota hai.

Isme generally:

- JVM
- Runtime libraries
- Development tools

include hote hain.


Example tool:

javac


`javac` Java source code ko bytecode me compile karta hai.


# 18. JRE kya hota hai?

JRE ka purpose Java applications ko run karne ke liye runtime environment provide karna tha.

Conceptually:

JRE
→ JVM + Runtime Libraries


Modern Java distributions me standalone JRE packaging traditional Java 8-era setup jaisi nahi hoti, but interview conceptual relationship samajhna important hai.


# 19. JVM kya hoti hai?

JVM actual Java bytecode execution engine hai.

JVM:

.java file ko directly execute nahi karti.

Flow:

.java
↓
Compiler
↓
.class bytecode
↓
JVM
↓
Execution


# 20. JVM Platform Independent kaise banati hai?

Java ka famous concept:

"Write Once, Run Anywhere."


Example:

Java code:

Main.java


Compile:

Main.class


Same bytecode different OS par appropriate JVM ke through run ho sakta hai.


Windows
→ JVM

Linux
→ JVM

Mac
→ JVM


Bytecode same reh sakta hai.


# 21. JVM Platform Independent hai?

Important:

Java language/platform ko platform independent kaha jata hai because bytecode different platforms ki JVMs par run kar sakta hai.

Lekin:

JVM itself platform-specific implementation hoti hai.


Interview answer:

> Java bytecode is platform independent, while the JVM implementation is platform dependent.


# 22. JVM ke Important Components

Interview ke liye basic components:

1. Class Loader
2. Runtime Data Areas
3. Execution Engine
4. Native Method Interface
5. Native Method Libraries


# 23. Class Loader

Class Loader ka kaam:

> `.class` files/classes ko JVM me load karna.


Simple flow:

.class file

↓

Class Loader

↓

JVM


Class loading ke high-level phases:

1. Loading
2. Linking
3. Initialization


# 24. Execution Engine

Execution Engine bytecode ko execute karta hai.

Isme commonly concepts:

- Interpreter
- JIT Compiler


# 25. Interpreter

Interpreter bytecode ko instruction-by-instruction execute karta hai.

Simple:

Bytecode
↓
Interpreter
↓
Execution


Advantage:

Quick startup.


Disadvantage:

Repeated code ke liye slower ho sakta hai.


# 26. JIT Compiler

JIT:

Just-In-Time Compiler


Frequently executed code ko runtime par native machine code me compile karke performance improve kar sakta hai.


Simple:

Bytecode
↓
JIT
↓
Native Machine Code
↓
Fast execution


# 27. Interpreter vs JIT

Interpreter:

→ Bytecode instructions execute karta hai
→ Simple/quick startup
→ Repeated execution ke liye less efficient ho sakta hai


JIT:

→ Frequently executed code ko compile karta hai
→ Runtime performance improve kar sakta hai
→ JVM optimizations apply kar sakta hai


# 28. JVM Runtime Memory Areas

Important areas:

1. Heap
2. Stack
3. Method Area / Metaspace
4. PC Register
5. Native Method Stack


Interview ke liye sabka basic idea enough hai.


# 29. Heap

Heap:

→ Objects and arrays
→ Shared among threads
→ Garbage Collection primarily yahin object memory reclaim karta hai


Example:

Employee e =
        new Employee();


Employee object:

→ Heap


# 30. Stack

Each thread ka apna stack hota hai.

Stack contains execution frames.

Example:

main()
calculate()
print()


Har active method ka stack frame ho sakta hai.


# 31. Method Area / Metaspace

Modern HotSpot JVM me class metadata ke liye Metaspace use hota hai.

Isme class-related metadata store hota hai.

Example concepts:

- Class metadata
- Method metadata
- Runtime constant pool related information


Interview me simple answer:

> Metaspace stores JVM class metadata.


# 32. PC Register

PC:

Program Counter


Har thread ke paas ek PC register hota hai.

Ye currently execute hone wali JVM instruction ko track karne me help karta hai.


# 33. Native Method Stack

Native methods ke execution ke liye JVM native method stack use kar sakti hai.

Native method:

→ JVM ke bahar/native code implementation se related method.


# 34. Garbage Collector ka Benefit

Advantages:

1. Automatic memory management
2. Developer ko manually object memory free nahi karni padti
3. Unreachable objects ki memory reclaim hoti hai
4. Memory management safer aur easier hota hai


# 35. Garbage Collection ki Limitations

GC hone ke baad bhi:

- Memory leaks possible hain
- GC CPU resources use kar sakta hai
- GC timing developer fully control nahi kar sakta
- Large heaps ke saath GC pauses/performance considerations ho sakte hain


# 36. Interview-Ready Answer

Question:

"What is Garbage Collection in Java?"

Answer:

"Garbage Collection is Java's automatic memory management mechanism. It identifies objects that are no longer reachable and reclaims their heap memory. An object becoming unreachable makes it eligible for GC, but it does not guarantee immediate collection."


# 37. JVM Interview-Ready Answer

Question:

"What is JVM?"

Answer:

"JVM stands for Java Virtual Machine. It executes Java bytecode and provides runtime services such as memory management, class loading, garbage collection and execution through mechanisms like interpretation and JIT compilation."


# 38. Important Interview Questions

Q: What is Garbage Collection?

A:

"Automatic process of reclaiming heap memory occupied by unreachable objects."


Q: Can we force Garbage Collection?

A:

"No. We can request it using System.gc(), but JVM does not guarantee immediate GC."


Q: When does an object become eligible for GC?

A:

"When it becomes unreachable from GC roots."


Q: Does setting reference to null immediately delete the object?

A:

"No. It only removes that particular reference. The object becomes eligible for GC if no other reachable references exist."


Q: Can Java handle circular references?

A:

"Yes. Modern GC algorithms can collect unreachable cyclic object graphs."


Q: Can Java have memory leaks?

A:

"Yes. If objects remain reachable but are no longer logically needed, GC cannot reclaim them."


Q: What is StackOverflowError?

A:

"Usually caused by excessive stack usage, commonly infinite or very deep recursion."


Q: What is OutOfMemoryError?

A:

"It occurs when the JVM cannot satisfy a memory allocation request, for example when the Java heap is exhausted."


Q: What is JIT?

A:

"Just-In-Time compiler, which can compile frequently executed bytecode into native machine code at runtime for better performance."


Q: What is the role of Class Loader?

A:

"It loads class definitions into the JVM."


Q: Is JVM platform independent?

A:

"The JVM implementation is platform dependent, but Java bytecode is designed to be platform independent across compatible JVM implementations."


# 39. QUICK REVISION

Garbage Collection:

→ Automatic memory management

→ Works mainly with heap objects

→ Unreachable objects become eligible

→ Does not guarantee immediate deletion

→ System.gc() is only a request

→ Circular unreachable references can be collected

→ Memory leaks are still possible


JVM:

→ Executes bytecode

→ Class loading

→ Memory management

→ Garbage Collection

→ Execution Engine

→ JIT compilation


JDK:

→ Development kit


JRE:

→ Runtime environment concept


JVM:

→ Bytecode execution


Easy memory trick:

JDK
→ DEVELOP


JRE
→ RUN


JVM
→ EXECUTE


GC
→ CLEAN UNUSED OBJECTS


ONE-LINE INTERVIEW ANSWER:

"JVM executes Java bytecode and provides runtime services, while Garbage Collection automatically reclaims heap memory from objects that are no longer reachable."