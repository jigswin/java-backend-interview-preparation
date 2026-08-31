# Q13 — static Keyword in Java

## 1. static kya hota hai?

`static` keyword ka use kisi member ko object ke bajay class ke saath associate karne ke liye hota hai.

Simple language:

Normal member:
→ Object ke saath belong karta hai.

static member:
→ Class ke saath belong karta hai.

Example:

class Employee {

    static String company = "TYASuite";

    String name;
}

Yahan:

company
→ static → Class level

name
→ non-static → Object level


## 2. static Variable

Agar variable `static` hai, to uski single copy class ke level par hoti hai.

Example:

class Employee {

    int id;
    String name;

    static String company = "ABC";
}

Main:

Employee e1 = new Employee();
Employee e2 = new Employee();

e1.id = 101;
e1.name = "Jigar";

e2.id = 102;
e2.name = "Rahul";

System.out.println(e1.company);
System.out.println(e2.company);

Output:

ABC
ABC

Dono objects same static `company` ko share karte hain.


## 3. Why static variable?

Jab koi value sabhi objects ke liye common ho, tab static variable useful hota hai.

Example:

class Employee {

    int id;
    String name;

    static String company = "TYASuite";
}

Agar 1000 employees hain aur company same hai, to har object ke andar company ki separate copy rakhne ki zarurat nahi.

Ek class-level value sufficient hai.


## 4. static Method

`static` method class se belong karta hai.

Isliye usko object create kiye bina call kar sakte hain.

Example:

class Calculator {

    static int add(int a, int b) {

        return a + b;
    }
}

Main:

int result = Calculator.add(10, 20);

System.out.println(result);

Output:

30

Yahan object create karne ki zarurat nahi hai.


## 5. Static Method ko object se bhi call kar sakte hain?

Java technically allow kar sakta hai:

Calculator calculator = new Calculator();

calculator.add(10, 20);

Lekin ye recommended nahi hai.

Better:

Calculator.add(10, 20);

Because `add()` static hai aur class se belong karta hai.


## 6. Important Rule — Static Method directly instance variable access nahi kar sakta

Example:

class Employee {

    String name = "Jigar";

    static void display() {

        System.out.println(name);
    }
}

Ye compile-time error dega.

Reason:

`name` instance variable hai.

Static method ke paas kisi specific object ka reference nahi hota.

Correct:

class Employee {

    String name = "Jigar";

    static void display(Employee employee) {

        System.out.println(employee.name);
    }
}


## 7. Static Method directly static variable access kar sakta hai

Example:

class Employee {

    static String company = "TYASuite";

    static void displayCompany() {

        System.out.println(company);
    }
}

Ye valid hai.

Because:

static method
→ static variable

Dono class level par hain.


## 8. Can static method access instance members?

Directly:

NO.

But object/reference ke through:

YES.

Example:

class Employee {

    String name;

    static void display(Employee employee) {

        System.out.println(employee.name);
    }
}

Yahan object/reference ke through instance variable access ho raha hai.


## 9. Static Method me `this` kyu nahi use kar sakte?

Example:

class Employee {

    String name;

    static void display() {

        System.out.println(this.name);
    }
}

Compile-time error.

Reason:

`this` current object ko refer karta hai.

Static method kisi particular object se associated nahi hota.

So:

static method
→ No direct `this`


## 10. static Method me `super` kyu nahi use kar sakte?

`super` parent class ke current object context ko refer karta hai.

Static method object-specific nahi hota.

Therefore:

static method
→ `super` directly use nahi kar sakte.


## 11. static Block

Static block class load hone ke time execute hota hai.

Example:

class Test {

    static {
        System.out.println("Static block executed");
    }

    public static void main(String[] args) {

        System.out.println("Main method executed");
    }
}

Output generally:

Static block executed
Main method executed

Static block class initialization ke time execute hota hai.


## 12. Multiple Static Blocks

Ek class me multiple static blocks ho sakte hain.

Example:

class Test {

    static {

        System.out.println("Static Block 1");
    }

    static {

        System.out.println("Static Block 2");
    }

    public static void main(String[] args) {

        System.out.println("Main");
    }
}

Output:

Static Block 1
Static Block 2
Main

Static blocks generally top-to-bottom order me execute hote hain.


## 13. static Variable Example — Counter

Static variable ka common interview example:

class Employee {

    static int count = 0;

    Employee() {

        count++;
    }
}

Main:

Employee e1 = new Employee();
Employee e2 = new Employee();
Employee e3 = new Employee();

System.out.println(Employee.count);

Output:

3

Reason:

`count` static hai, so all objects same variable share karte hain.


## 14. static vs Instance Variable

Instance variable:

class Employee {

    int id;
}

Har object ki separate copy hoti hai.

Example:

Employee e1 = new Employee();
Employee e2 = new Employee();

e1.id = 10;
e2.id = 20;

e1.id → 10
e2.id → 20


Static variable:

class Employee {

    static String company = "ABC";
}

All objects same class-level variable share karte hain.


## 15. Static Variable vs Instance Variable

Static:

→ Class level
→ One shared copy per class
→ Object-specific nahi
→ Class name se access kar sakte hain

Instance:

→ Object level
→ Har object ki separate copy
→ Object-specific
→ Object/reference ke through access


## 16. Can we override static methods?

No.

Static methods overriding nahi hoti.

Agar child class same signature ka static method define karti hai, usko:

> Method Hiding

kehte hain.


Example:

class Parent {

    static void show() {

        System.out.println("Parent");
    }
}

class Child extends Parent {

    static void show() {

        System.out.println("Child");
    }
}

Ye overriding nahi hai.

Ye method hiding hai.


## 17. Important Example of Static Method Hiding

Parent parent = new Child();

parent.show();

Output:

Parent

Reason:

Static method ka resolution reference type/class ke according hota hai, runtime object ke according nahi.

This is different from runtime polymorphism.


## 18. Can a constructor be static?

No.

Constructor ko static nahi bana sakte.

Reason:

Constructor ka purpose object initialize karna hai, while static members class level par belong karte hain.


## 19. Can a class be static?

Top-level class ko directly static nahi bana sakte.

Example:

static class Employee {
}

Invalid for a top-level class.

Lekin nested class ko static bana sakte hain.

Example:

class Outer {

    static class Inner {

    }
}

Ye valid hai.


## 20. Real-World Example

Suppose e-commerce application me order count track karna hai.

class Order {

    private static int totalOrders = 0;

    public Order() {

        totalOrders++;
    }

    public static int getTotalOrders() {

        return totalOrders;
    }
}

Main:

new Order();
new Order();
new Order();

System.out.println(Order.getTotalOrders());

Output:

3

Yahan totalOrders sabhi Order objects ke liye common hai.


## 21. static in Spring Boot

Spring Boot me static ka use normal dependency injection ke replacement ke roop me nahi karna chahiye.

Spring beans normally object instances ke roop me manage hote hain.

Example:

@Service
public class PaymentService {

    public void processPayment() {
    }
}

Spring is service ka object/bean manage karta hai.

Normally hum:

@Autowired
private PaymentService paymentService;

ya constructor injection use karte hain.

Static methods/fields ko dependency injection ke saath mix karna generally avoid karna better hai.


## 22. Interview-Ready Answer

Question:

"What is static in Java?"

Answer:

"`static` is a keyword used to make a member belong to the class rather than to individual objects. A static variable is shared among objects of the class, and a static method can be called using the class name without creating an object. A static method cannot directly access instance members because it does not have a specific object context."


## 23. Important Interview Follow-up Questions

Q: What is a static variable?

A:

"A static variable belongs to the class and is shared among all instances of that class."


Q: What is a static method?

A:

"A static method belongs to the class and can be called using the class name without creating an object."


Q: Can static method access instance variables directly?

A:

"No, because a static method does not have a specific object context."


Q: Can static method access static variables?

A:

"Yes."


Q: Can we use `this` inside static method?

A:

"No, because `this` refers to the current object and static methods are class-level."


Q: Can we override static methods?

A:

"No. Static methods are hidden, not overridden."


Q: Can constructor be static?

A:

"No."


Q: What is static block?

A:

"A static block is executed during class initialization and is commonly used for static initialization logic."


# 24. Easy Memory Trick

static
= Class level


static variable
= Shared data


static method
= Class-level method


static block
= Runs during class initialization


Instance variable
= Object-specific


Remember:

Object → Instance

Class → Static


# 25. Most Important Interview Points

1. `static` means class-level association.
2. Static variable is shared among instances.
3. Static method can be called using class name.
4. Static method does not need an object to be invoked.
5. Static method cannot directly access instance variables.
6. Static method can directly access static variables.
7. `this` cannot be used directly in static context.
8. `super` cannot be used directly in static context.
9. Static methods cannot be overridden.
10. Same static method in child class is called method hiding.
11. Constructor cannot be static.
12. Static blocks execute during class initialization.
13. Multiple static blocks execute in order.
14. Static members should generally be accessed using the class name.
15. Static is different from object-level instance members.


# QUICK REVISION

static
= Class level

static variable
= Shared among objects

static method
= Call using ClassName.method()

static block
= Executes during class initialization

Instance variable
= Separate copy for each object

Static method:
❌ Cannot directly access instance variable
✅ Can directly access static variable
❌ Cannot use this directly
❌ Cannot use super directly

Static method overriding:
❌ Not possible
→ Method hiding

Constructor static:
❌ Not allowed


ONE-LINE INTERVIEW ANSWER:

"`static` makes a member belong to the class rather than individual objects, so static members can generally be accessed without creating an object."