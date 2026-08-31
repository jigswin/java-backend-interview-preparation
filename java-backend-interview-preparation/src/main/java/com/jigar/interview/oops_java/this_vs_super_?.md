# Q11 — this vs super in Java

## 1. What is this?

`this` ek keyword hai jo current object ko refer karta hai.

Simple language:

this
→ Current class ke object ko refer karta hai.

Example:

class Employee {

    String name;

    Employee(String name) {
        this.name = name;
    }
}

Yahan:

this.name
→ Class ka instance variable

name
→ Constructor ka local parameter

Agar `this` nahi lagayenge:

Employee(String name) {
    name = name;
}

To dono `name` parameter ko refer karenge aur instance variable update nahi hoga.

Isliye:

this.name = name;

ka meaning hai:

Current object's name = Constructor parameter name


# 2. this ka main use

`this` ke important uses:

1. Current object ko refer karna
2. Instance variable aur local variable ke same name ka conflict solve karna
3. Current class constructor ko call karna
4. Current object ko method ke argument ke roop me pass karna
5. Current object return karna


# 3. this for Instance Variable

Example:

class Student {

    private String name;

    Student(String name) {

        this.name = name;
    }
}

Yahan:

this.name
→ Instance variable

name
→ Constructor parameter


# 4. this() — Current Class Constructor Call

`this()` ka use same class ke another constructor ko call karne ke liye hota hai.

Example:

class Employee {

    String name;
    int age;

    Employee() {

        this("Unknown", 0);
    }

    Employee(String name, int age) {

        this.name = name;
        this.age = age;
    }
}

Ab:

Employee e = new Employee();

Default constructor call hoga.

Then:

this("Unknown", 0);

same class ke parameterized constructor ko call karega.


Important:

`this()` constructor ke andar first statement hona chahiye.

Correct:

Employee() {
    this("Unknown", 0);
}

Wrong:

Employee() {

    System.out.println("Hello");

    this("Unknown", 0);
}

Ye compile-time error dega.


# 5. What is super?

`super` parent class ke members ko refer karne ke liye use hota hai.

Simple:

super
→ Parent class ko refer karta hai.


# 6. super for Parent Variable

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


# 7. super for Parent Method

Child class parent method ko override kar sakti hai.

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

        super.sound();
    }
}

Main:

Dog dog = new Dog();

dog.sound();

Output:

Dog barks
Animal sound


Yahan:

super.sound();

Parent class ka sound() method call kar raha hai.


# 8. super() — Parent Constructor Call

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

`super()` constructor ke first statement ke roop me hona chahiye.


# 9. this vs super

this:

→ Current class/object ko refer karta hai.

super:

→ Parent class ko refer karta hai.


this.variable:

→ Current class ka variable


super.variable:

→ Parent class ka variable


this.method():

→ Current class ka method


super.method():

→ Parent class ka method


this():

→ Current class ka constructor


super():

→ Parent class ka constructor


# 10. Important Difference Table

Feature:

this
→ Current object/class context

super
→ Parent class context

this.variable
→ Current class variable

super.variable
→ Parent class variable

this.method()
→ Current class method

super.method()
→ Parent class method

this()
→ Current class constructor

super()
→ Parent class constructor


# 11. Real-World Example

class Employee {

    String company = "ABC";

    Employee() {

        System.out.println("Employee constructor");
    }
}

class Manager extends Employee {

    String company = "XYZ";

    Manager() {

        super();

        System.out.println("Manager constructor");
    }

    void display() {

        System.out.println(this.company);
        System.out.println(super.company);
    }
}

Main:

Manager manager = new Manager();

manager.display();

Output:

XYZ
ABC

Explanation:

this.company
→ Manager ka company

super.company
→ Employee ka company


# 12. Constructor Chaining

`this()` aur `super()` dono constructor chaining me use ho sakte hain.

Example:

class Parent {

    Parent() {

        System.out.println("Parent");
    }
}

class Child extends Parent {

    Child() {

        this(10);

        System.out.println("Child default");
    }

    Child(int value) {

        super();

        System.out.println("Child parameterized");
    }
}

Main:

new Child();

Output:

Parent
Child parameterized
Child default


Flow:

new Child()
    ↓
Child()
    ↓
this(10)
    ↓
Child(int)
    ↓
super()
    ↓
Parent()
    ↓
Child(int)
    ↓
Child()


# 13. Important Rule — this() and super() Together?

Ek constructor ke first statement ke roop me `this()` ya `super()` me se sirf ek use kar sakte hain.

Wrong:

Child() {

    this(10);
    super();
}

Ye allowed nahi hai.

Reason:

Dono constructor invocation statements hain aur first statement hona required hai.


# 14. Can we use this in static method?

No.

Example:

class Test {

    int value = 10;

    static void show() {

        System.out.println(this.value);
    }
}

Ye compile-time error dega.

Reason:

`this` current object ko refer karta hai.

Static method class-level hota hai aur uske paas specific object reference nahi hota.


# 15. Can we use super in static method?

Normally no.

`super` parent class ke current object context ko refer karta hai, while static method object-specific nahi hota.

So `super` cannot be used directly inside a static context.


# 16. Can this and super be used together?

Yes, but not as both constructor calls.

Example:

class Parent {

    String value = "Parent";
}

class Child extends Parent {

    String value = "Child";

    void display() {

        System.out.println(this.value);
        System.out.println(super.value);
    }
}

Output:

Child
Parent

Yahan dono use ho rahe hain:

this.value
super.value


# 17. Interview-Ready Answer

Question:

"What is the difference between this and super?"

Answer:

"`this` refers to the current object or current class context, while `super` refers to the immediate parent class.

We use `this` to access current class fields and methods and to call another constructor of the same class using `this()`.

We use `super` to access parent class fields and methods and to call the parent constructor using `super()`."


# 18. Important Interview Follow-up Questions

Q: What is this?

A:

"`this` is a reference to the current object."


Q: What is super?

A:

"`super` is used to refer to the immediate parent class."


Q: Difference between this() and super()?

A:

"`this()` calls another constructor of the same class, while `super()` calls the constructor of the immediate parent class."


Q: Can this() and super() be used together in the same constructor?

A:

"No. Both must be the first statement of the constructor, so they cannot both be used in the same constructor."


Q: Can this be used in static method?

A:

"No, because this refers to the current object and static methods do not have a specific object context."


Q: Can super access private parent variables?

A:

"No. Private members are not directly accessible from the child class."


# 19. Easy Memory Trick

this
→ ME / Current Class

super
→ PARENT


this.variable
→ My variable

super.variable
→ Parent variable


this.method()
→ My method

super.method()
→ Parent method


this()
→ My constructor

super()
→ Parent constructor


# 20. Most Important Interview Points

1. `this` refers to the current object.
2. `super` refers to the immediate parent class.
3. `this.variable` accesses current class variable.
4. `super.variable` accesses parent class variable.
5. `this.method()` calls current class method.
6. `super.method()` calls parent class method.
7. `this()` calls another constructor of the same class.
8. `super()` calls the parent class constructor.
9. `this()` must be the first statement in a constructor.
10. `super()` must be the first statement in a constructor.
11. `this()` and `super()` cannot both be first statements in the same constructor.
12. `this` cannot be used directly in a static context.
13. `super` cannot be used directly in a static context.
14. `super` refers to the immediate parent class.
15. Private parent members cannot be directly accessed using `super`.


# QUICK REVISION

this
= Current Object

super
= Parent Class


this.variable
= Current class variable

super.variable
= Parent class variable


this.method()
= Current class method

super.method()
= Parent class method


this()
= Same class constructor

super()
= Parent class constructor


ONE-LINE MEMORY:

"this = myself, super = my parent."