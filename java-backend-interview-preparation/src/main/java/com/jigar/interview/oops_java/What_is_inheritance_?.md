# Q9 — Inheritance in Java

## 1. Inheritance kya hota hai?

Inheritance ka matlab hai:

> Ek class doosri class ke properties aur methods ko inherit/reuse kar sakti hai.

Java me inheritance ke liye `extends` keyword use hota hai.

Simple example:

class Animal {

    String name;

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog is barking");
    }
}

Yahan:

Animal = Parent / Superclass
Dog    = Child / Subclass

Dog ko Animal ka `name` aur `eat()` mil jayega.


## 2. Inheritance kyu use karte hain?

Inheritance ke main benefits:

1. Code reusability
2. Common functionality ko parent class me rakhna
3. Duplicate code reduce karna
4. Method overriding support karna
5. IS-A relationship represent karna
6. Polymorphism achieve karne me help karna


## 3. Basic Example

class Vehicle {

    void start() {
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle {

    void drive() {
        System.out.println("Car is driving");
    }
}

Main:

public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        car.start();
        car.drive();
    }
}

Output:

Vehicle started
Car is driving

`start()` Car class me define nahi hai, but Car ne Vehicle ko extend kiya hai, isliye Car us method ko use kar sakti hai.


## 4. Parent Class and Child Class

Example:

class Animal {
}

class Dog extends Animal {
}

Animal = Parent class / Superclass / Base class

Dog = Child class / Subclass / Derived class

Relationship:

Dog IS-A Animal

Ye IS-A relationship inheritance ko represent karti hai.


## 5. Types of Inheritance

Java me commonly inheritance ke ye types discuss kiye jate hain:

1. Single Inheritance
2. Multilevel Inheritance
3. Hierarchical Inheritance
4. Multiple Inheritance
5. Hybrid Inheritance


## 6. Single Inheritance

Ek child class ek parent class ko extend karti hai.

Example:

class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking");
    }
}

Structure:

Animal
   ↓
Dog


## 7. Multilevel Inheritance

Ek class doosri class ko extend kare aur third class second class ko extend kare.

Example:

class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking");
    }
}

class Puppy extends Dog {

    void play() {
        System.out.println("Playing");
    }
}

Structure:

Animal
   ↓
Dog
   ↓
Puppy

Puppy ko Animal aur Dog dono ke inherited members mil sakte hain.


## 8. Hierarchical Inheritance

Ek parent class ke multiple child classes ho.

Example:

class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking");
    }
}

class Cat extends Animal {

    void meow() {
        System.out.println("Meowing");
    }
}

Structure:

        Animal
        /    \
       /      \
     Dog      Cat


## 9. Multiple Inheritance

Multiple inheritance ka matlab:

> Ek class multiple parent classes ko directly inherit kare.

Example concept:

class A {
}

class B {
}

class C extends A, B {
}

Java classes ke through ye allowed nahi hai.

Ye compile-time error dega.

Reason:

> Java multiple inheritance with classes ko avoid karta hai mainly ambiguity/diamond problem ki wajah se.


## 10. Diamond Problem

Suppose:

        A
       / \
      B   C
       \ /
        D

A me same method hai:

class A {

    void show() {
        System.out.println("A");
    }
}

B aur C dono A se inherit karte hain aur dono `show()` ko override kar dete hain.

Ab D agar B aur C dono ko extend kare, to:

D d = new D();

d.show();

Question:

B ka `show()` chalega ya C ka?

Ye ambiguity create karega.

Isi type ki ambiguity ko diamond problem kehte hain.

Java classes ke through multiple inheritance ko allow nahi karta.


## 11. Can Java achieve multiple inheritance?

Yes, Java multiple inheritance of type/behavior ko interfaces ke through support karta hai.

Example:

interface A {

    void show();
}

interface B {

    void show();
}

class C implements A, B {

    @Override
    public void show() {
        System.out.println("C implementation");
    }
}

Yahan C multiple interfaces implement kar raha hai.

So:

Java class:
→ Multiple classes extend nahi kar sakti

Java class:
→ Multiple interfaces implement kar sakti hai


## 12. Hybrid Inheritance

Hybrid inheritance = multiple types of inheritance ka combination.

Java classes ke through arbitrary hybrid inheritance support nahi karta because multiple inheritance of classes allowed nahi hai.

Lekin interfaces ke combination se complex inheritance structures design kiye ja sakte hain.


## 13. Important Rule — Java Multiple Classes Extend nahi kar sakti

Ye invalid hai:

class C extends A, B {
}

Correct:

class C extends A implements B {
}

Agar B interface hai.

Example:

class C extends A implements B, C {
}

Yahan ek class extend aur multiple interfaces implement kar sakti hai.


## 14. What is Method Overriding in Inheritance?

Child class parent ke method ko apne according implement kar sakti hai.

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

Ab:

Animal animal = new Dog();

animal.sound();

Output:

Dog barks

Ye runtime polymorphism ka example bhi hai.


## 15. What is `super` in Inheritance?

`super` parent class ke members ko refer karne ke liye use hota hai.

Example:

class Animal {

    String name = "Animal";
}

class Dog extends Animal {

    String name = "Dog";

    void display() {

        System.out.println(name);
        System.out.println(super.name);
    }
}

Output:

Dog
Animal

`name`
→ Current class ka variable

`super.name`
→ Parent class ka variable


## 16. `super()` Constructor

`super()` parent class ke constructor ko call karta hai.

Example:

class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {

    Dog() {

        super();

        System.out.println("Dog constructor");
    }
}

Output:

Animal constructor
Dog constructor


Important:

Agar child constructor me explicitly `super()` nahi likhte, to compiler generally parent ka no-argument constructor call karne ke liye implicit `super()` insert karta hai, provided such constructor is accessible.


## 17. Important Interview Question

Q: Does Java support inheritance?

A:

"Yes. Java supports inheritance using the `extends` keyword for classes and `implements` for interfaces."


Q: Can a class extend multiple classes?

A:

"No. Java does not support multiple inheritance through classes."


Q: Can a class implement multiple interfaces?

A:

"Yes. A class can implement multiple interfaces."


Q: Why doesn't Java support multiple inheritance through classes?

A:

"Mainly to avoid ambiguity such as the diamond problem and to keep class inheritance simpler."


Q: What is IS-A relationship?

A:

"IS-A relationship represents inheritance. For example, Dog IS-A Animal."


Q: What is HAS-A relationship?

A:

"HAS-A represents composition/association, where one object contains or uses another object."

Example:

class Car {

    Engine engine;
}

Car HAS-A Engine.


## 18. Inheritance vs Composition

This is an important 3–5 years interview question.

Inheritance:

class Dog extends Animal

Means:

Dog IS-A Animal

Composition:

class Car {

    private Engine engine;
}

Means:

Car HAS-A Engine

General rule:

IS-A
→ Inheritance

HAS-A
→ Composition


## 19. Real-World Example

Suppose e-commerce application me:

class User {

    String name;

    void login() {
        System.out.println("User logged in");
    }
}

class Admin extends User {

    void manageUsers() {
        System.out.println("Managing users");
    }
}

class Customer extends User {

    void placeOrder() {
        System.out.println("Order placed");
    }
}

Structure:

              User
             /    \
            /      \
        Admin     Customer

Common functionality:

login()

Parent class me rakhi.

Admin-specific:

manageUsers()

Customer-specific:

placeOrder()

Isse code duplication reduce hota hai.


## 20. Interview-Ready Answer

Question:

"What is inheritance in Java?"

Answer:

"Inheritance is an OOP concept where a child class acquires properties and behavior from a parent class. In Java, class inheritance is achieved using the `extends` keyword. It promotes code reuse and supports method overriding and runtime polymorphism. Java supports single, multilevel and hierarchical inheritance through classes, but it does not support multiple inheritance through classes. Multiple interfaces can be implemented by a class."


## 21. Easy Memory Trick

Inheritance:

Parent
   ↓
Child

Child gets/reuses parent behavior.

IS-A
→ Inheritance

HAS-A
→ Composition


Remember:

Single:
A → B

Multilevel:
A → B → C

Hierarchical:
    A
   / \
  B   C

Multiple classes:
A + B → C
❌ Not allowed

Multiple interfaces:
A + B → C
✅ Allowed


## 22. Most Important Interview Points

1. Inheritance provides code reusability.
2. `extends` is used for class inheritance.
3. `implements` is used for implementing interfaces.
4. Parent class = Superclass/Base class.
5. Child class = Subclass/Derived class.
6. IS-A relationship represents inheritance.
7. Java supports single inheritance.
8. Java supports multilevel inheritance.
9. Java supports hierarchical inheritance.
10. Java does not support multiple inheritance through classes.
11. Java supports multiple interfaces.
12. Multiple class inheritance is avoided mainly because of ambiguity/diamond problem.
13. Child class can override parent methods.
14. `super` is used to access parent members.
15. `super()` calls the parent constructor.
16. Composition represents HAS-A relationship.
17. Inheritance represents IS-A relationship.


# QUICK REVISION

Inheritance
= Child gets/reuses Parent properties and behavior

Keyword:
extends

Parent:
Superclass

Child:
Subclass

IS-A:
Inheritance

HAS-A:
Composition

Single:
A → B

Multilevel:
A → B → C

Hierarchical:
A → B
A → C

Multiple classes:
❌ Not supported

Multiple interfaces:
✅ Supported

super:
→ Parent class member/constructor access