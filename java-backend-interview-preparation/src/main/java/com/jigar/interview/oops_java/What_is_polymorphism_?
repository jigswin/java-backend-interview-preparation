# Q10 — Polymorphism in Java

## 1. Polymorphism kya hota hai?

Polymorphism ka simple meaning hai:

> "One thing, many forms."

Java me same method/interface ka behavior different objects ke according different ho sakta hai.

Example:

class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

Ab:

Animal a1 = new Dog();
Animal a2 = new Cat();

a1.sound();
a2.sound();

Output:

Dog barks
Cat meows

Reference type same hai:

Animal

Lekin actual object different hai:

Dog
Cat

Isliye method ka behavior different hai.

Ye Polymorphism hai.


# 2. Polymorphism ke types

Java me mainly 2 types ke polymorphism discuss kiye jate hain:

1. Compile-time Polymorphism
2. Runtime Polymorphism


# 3. Compile-time Polymorphism

Compile-time polymorphism ko mainly:

> Method Overloading

ke through achieve karte hain.

Example:

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

Yahan method ka naam same hai:

add()

Lekin parameters different hain.

Java compiler compile time par decide kar leta hai ki kaunsa method call hoga.

Example:

Calculator calculator = new Calculator();

calculator.add(10, 20);

→ add(int, int)

calculator.add(10, 20, 30);

→ add(int, int, int)

calculator.add(10.5, 20.5);

→ add(double, double)


# 4. Runtime Polymorphism

Runtime polymorphism mainly:

> Method Overriding

ke through achieve hota hai.

Example:

class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

Ab:

Animal animal;

animal = new Dog();
animal.sound();

Output:

Dog barks


Then:

animal = new Cat();
animal.sound();

Output:

Cat meows


Yahan method call ka actual implementation runtime par decide hota hai.

Isliye:

Runtime Polymorphism
→ Method Overriding


# 5. Important Concept — Reference Type vs Object Type

Ye interview me bahut important hai.

Example:

Animal animal = new Dog();

Yahan:

Animal
→ Reference type

Dog
→ Object type / Actual object

Jab:

animal.sound();

call karte hain, overridden method actual object ke according execute hota hai.

Dog object hai:

→ Dog.sound()


# 6. Why is it called Runtime Polymorphism?

Because method implementation ka selection runtime par hota hai.

Example:

Animal animal = new Dog();

animal.sound();

Compile time par compiler dekhta hai:

Animal me sound() available hai.

Runtime par JVM dekhta hai:

Actual object = Dog

So:

Dog.sound()

execute hota hai.


# 7. Dynamic Method Dispatch

Runtime polymorphism ko Java me:

> Dynamic Method Dispatch

bhi kaha jata hai.

Example:

Animal animal = new Dog();

animal.sound();

Runtime par JVM actual object ke overridden method ko invoke karti hai.

This is called dynamic method dispatch.


# 8. Compile-time vs Runtime Polymorphism

Compile-time:

Method Overloading

Decision:
Compile time

Same method name:
Yes

Parameters:
Different

Inheritance required:
No

Example:

add(int, int)
add(int, int, int)


Runtime:

Method Overriding

Decision:
Runtime

Parent-child relationship:
Required

Method signature:
Same

Example:

Animal.sound()
Dog.sound()


# 9. Important Table

Feature:

Compile-time Polymorphism
→ Method Overloading
→ Compile time
→ Different parameters
→ Inheritance not required

Runtime Polymorphism
→ Method Overriding
→ Runtime
→ Same method signature
→ Parent-child relationship required


# 10. Real-World Example

Suppose payment system hai.

interface Payment {

    void pay();
}

class CreditCardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment using Credit Card");
    }
}

class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment using UPI");
    }
}

Ab:

Payment payment;

payment = new CreditCardPayment();
payment.pay();

Output:

Payment using Credit Card


Then:

payment = new UpiPayment();
payment.pay();

Output:

Payment using UPI


Same:

payment.pay();

Lekin behavior different.

Ye runtime polymorphism ka real-world example hai.


# 11. Polymorphism in Spring Boot

Spring Boot me polymorphism bahut common hai.

Example:

PaymentService interface:

public interface PaymentService {

    void pay();
}


Implementation:

@Service
public class UpiPaymentService implements PaymentService {

    @Override
    public void pay() {
        System.out.println("UPI Payment");
    }
}


Another implementation:

@Service
public class CardPaymentService implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Card Payment");
    }
}


Yahan:

PaymentService

ek common abstraction hai.

Different implementations:

UpiPaymentService
CardPaymentService

Same method:

pay()

Different behavior.

Ye polymorphism ka practical use hai.


# 12. Can static methods be overridden?

No.

Static methods class se belong karti hain, object se nahi.

Agar child class same static method define kare, to usko method hiding kehte hain, overriding nahi.


# 13. Can final methods be overridden?

No.

Example:

class Parent {

    final void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    // Not allowed

    void show() {
    }
}


# 14. Can private methods be overridden?

No.

Private methods child class ko directly visible/inherited nahi hote.

Therefore they cannot be overridden.


# 15. Method Overloading vs Polymorphism

Method overloading:

Same method name
+
Different parameters

Example:

void print(int value)

void print(String value)


Method overriding:

Parent and child classes
+
Same method signature

Example:

class Parent {

    void show() {
    }
}

class Child extends Parent {

    @Override
    void show() {
    }
}


# 16. Important Interview Question

Q: What is polymorphism?

A:

"Polymorphism means one interface or method name can represent different behaviors. In Java, compile-time polymorphism is achieved through method overloading, while runtime polymorphism is achieved through method overriding."


Q: What is runtime polymorphism?

A:

"Runtime polymorphism occurs when a parent reference refers to a child object and the overridden method implementation is selected at runtime."


Example:

Animal animal = new Dog();

animal.sound();


Q: What is dynamic method dispatch?

A:

"It is the mechanism where the JVM determines the overridden method implementation based on the actual object at runtime."


Q: Is method overloading runtime polymorphism?

A:

"No. Method overloading is compile-time polymorphism."


Q: Is method overriding runtime polymorphism?

A:

"Yes."


Q: Can static methods be overridden?

A:

"No. Static methods are hidden, not overridden."


# 17. Easy Memory Trick

Polymorphism
= One name → Many forms


Compile-time:

Overloading
→ Different parameters
→ Compiler decides


Runtime:

Overriding
→ Same method
→ Different implementation
→ JVM decides


Remember:

Overloading
→ Compile time

Overriding
→ Runtime


# 18. Most Important Interview Points

1. Polymorphism means one thing having many forms.
2. Java has compile-time and runtime polymorphism.
3. Method overloading gives compile-time polymorphism.
4. Method overriding gives runtime polymorphism.
5. Runtime polymorphism requires inheritance/interface relationship.
6. Parent reference can point to child object.
7. Actual object determines overridden method implementation.
8. Dynamic Method Dispatch is related to runtime polymorphism.
9. Static methods cannot be overridden.
10. Final methods cannot be overridden.
11. Private methods cannot be overridden.
12. Spring Boot commonly uses polymorphism through interfaces and multiple implementations.


# QUICK REVISION

Polymorphism
= One thing → Many forms

Compile-time Polymorphism
= Method Overloading
= Different parameters
= Compiler decides

Runtime Polymorphism
= Method Overriding
= Parent reference + Child object
= JVM decides

Example:

Animal animal = new Dog();

animal.sound();

Reference:
Animal

Actual Object:
Dog

Method executed:
Dog.sound()


ONE-LINE INTERVIEW ANSWER:

"Overloading is compile-time polymorphism, while overriding is runtime polymorphism where the JVM selects the overridden method based on the actual object."