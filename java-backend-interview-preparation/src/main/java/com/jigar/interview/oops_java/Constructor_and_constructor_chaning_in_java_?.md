# Q12 — Constructor in Java + Constructor Chaining

## 1. Constructor kya hota hai?

Constructor ek special member hota hai jo object create hone ke time automatically call hota hai.

Constructor ka main purpose object ko initialize karna hota hai.

Example:

class Employee {

    String name;
    int age;

    Employee() {
        name = "Jigar";
        age = 25;
    }
}

Main:

Employee employee = new Employee();

Jab `new Employee()` execute hota hai, constructor automatically call hota hai.


## 2. Constructor ki important properties

Constructor ke important rules:

1. Constructor ka naam class ke naam ke same hona chahiye.
2. Constructor ka koi return type nahi hota.
3. Constructor automatically call hota hai jab object create hota hai.
4. Constructor object initialization ke liye use hota hai.
5. Constructor overload ho sakta hai.
6. Constructor inherit nahi hota.
7. Constructor override nahi ho sakta.


## 3. Basic Constructor Example

class Student {

    String name;
    int age;

    Student() {

        name = "Unknown";
        age = 0;
    }
}

Main:

Student student = new Student();

System.out.println(student.name);
System.out.println(student.age);

Output:

Unknown
0


## 4. Constructor vs Method

Constructor:

- Class ke same naam ka hota hai.
- Return type nahi hota.
- Object creation par automatically call hota hai.
- Object initialization ke liye use hota hai.

Method:

- Koi bhi valid name ho sakta hai.
- Return type ho sakta hai ya `void`.
- Automatically call nahi hota.
- Specific functionality perform karta hai.


Example:

class Employee {

    Employee() {
        // Constructor
    }

    void display() {
        // Method
    }
}


## 5. Default Constructor kya hota hai?

Agar hum class me koi constructor explicitly define nahi karte, to compiler ek default no-argument constructor provide karta hai.

Example:

class Employee {

    String name;
}

Yahan humne koi constructor nahi banaya.

Compiler effectively ek no-argument constructor provide karta hai:

Employee() {
}


Important:

Agar hum khud koi constructor define kar dete hain, compiler automatically default constructor provide nahi karta.


## 6. Important Example

class Employee {

    String name;

    Employee(String name) {

        this.name = name;
    }
}

Ab:

Employee employee = new Employee("Jigar");

Ye valid hai.

Lekin:

Employee employee = new Employee();

Ye compile nahi hoga.

Reason:

Humne parameterized constructor define kar diya hai, isliye compiler automatically no-argument constructor nahi banayega.


## 7. No-Argument Constructor

Aisa constructor jisme koi parameter nahi hota.

Example:

class Employee {

    Employee() {

        System.out.println("Employee created");
    }
}

Ye no-argument constructor hai.


## 8. Parameterized Constructor

Aisa constructor jisme parameters hote hain.

Example:

class Employee {

    String name;
    int age;

    Employee(String name, int age) {

        this.name = name;
        this.age = age;
    }
}

Main:

Employee employee = new Employee("Jigar", 25);


## 9. Constructor Overloading

Ek class me multiple constructors ho sakte hain, bas unke parameter lists different hone chahiye.

Example:

class Employee {

    String name;
    int age;

    Employee() {

        this.name = "Unknown";
        this.age = 0;
    }

    Employee(String name) {

        this.name = name;
        this.age = 0;
    }

    Employee(String name, int age) {

        this.name = name;
        this.age = age;
    }
}

Ye constructor overloading hai.


## 10. Constructor Chaining kya hoti hai?

Jab ek constructor doosre constructor ko call karta hai, usko constructor chaining kehte hain.

Java me constructor chaining ke liye:

`this()`

aur

`super()`

use hote hain.


## 11. this() se Constructor Chaining

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

Main:

Employee employee = new Employee();

Flow:

Employee()
    ↓
this("Unknown", 0)
    ↓
Employee(String, int)


## 12. super() se Constructor Chaining

`super()` parent class ke constructor ko call karta hai.

Example:

class Person {

    Person() {

        System.out.println("Person constructor");
    }
}

class Employee extends Person {

    Employee() {

        super();

        System.out.println("Employee constructor");
    }
}

Main:

Employee employee = new Employee();

Output:

Person constructor
Employee constructor


Flow:

Employee()
    ↓
super()
    ↓
Person()
    ↓
Employee()


## 13. Important Rule — this() and super()

Constructor ke andar `this()` ya `super()` agar explicitly use kar rahe hain to wo first statement hona chahiye.

Correct:

Employee() {

    this("Unknown");
}

Wrong:

Employee() {

    System.out.println("Hello");

    this("Unknown");
}


Similarly:

Employee() {

    super();
}


`super()` bhi first statement hona chahiye.


## 14. Can this() and super() be used together?

Ek constructor me directly dono use nahi kar sakte.

Wrong:

Employee() {

    this("Jigar");

    super();
}

Reason:

Dono ko first statement hona required hai.


## 15. Constructor Inheritance

Constructors inherit nahi hote.

Example:

class Parent {

    Parent() {
    }
}

class Child extends Parent {
}

Child ko Parent ka constructor inherited method ki tarah nahi milta.

Instead, Child constructor ke execution ke time parent constructor call ho sakta hai through `super()`.


## 16. Constructor Overriding

Constructor override nahi ho sakta.

Reason:

Overriding parent-child method relationship ke liye hoti hai.

Constructor inherited hi nahi hota, therefore override bhi nahi ho sakta.


## 17. Real-World Example

Suppose e-commerce application me Product object create karna hai.

class Product {

    private int id;
    private String name;
    private double price;

    Product(int id, String name, double price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }
}

Main:

Product product =
        new Product(101, "Laptop", 75000);


Constructor object create hote hi:

id
name
price

ko initialize kar raha hai.


## 18. Constructor + Inheritance Example

class Animal {

    Animal() {

        System.out.println("Animal created");
    }
}

class Dog extends Animal {

    Dog() {

        System.out.println("Dog created");
    }
}

Main:

Dog dog = new Dog();

Output:

Animal created
Dog created


Reason:

Child constructor ke start me compiler generally implicit `super()` insert karta hai if no explicit constructor invocation is written.

So flow:

Dog()
 ↓
super()
 ↓
Animal()
 ↓
Dog()


## 19. Important Interview Question

Q: What is a constructor?

A:

"Constructor is a special member of a class used to initialize an object. It has the same name as the class and does not have a return type. It is automatically invoked when an object is created."


Q: Can constructor have a return type?

A:

"No. A constructor does not have a return type, not even void."


Q: Can constructors be overloaded?

A:

"Yes. A class can have multiple constructors with different parameter lists."


Q: Can constructors be overridden?

A:

"No. Constructors are not inherited, so they cannot be overridden."


Q: What is constructor chaining?

A:

"Constructor chaining means calling one constructor from another constructor. In Java, `this()` is used to call another constructor of the same class and `super()` is used to call the parent class constructor."


Q: If we create a parameterized constructor, will Java provide a default constructor?

A:

"No. Once we define any constructor, the compiler does not automatically provide the default no-argument constructor."


## 20. Easy Memory Trick

Constructor:

Same name as Class
+
No return type
+
Object creation par call
+
Object initialization


this():

Same class constructor


super():

Parent class constructor


Remember:

this()
→ My constructor

super()
→ Parent constructor


## 21. Most Important Interview Points

1. Constructor initializes objects.
2. Constructor name must match class name.
3. Constructor has no return type.
4. Constructor is automatically called during object creation.
5. Constructor can be overloaded.
6. Constructor cannot be overridden.
7. Constructor is not inherited.
8. If no constructor is defined, compiler provides a default no-argument constructor.
9. If any constructor is explicitly defined, compiler does not provide the default constructor.
10. `this()` calls another constructor of the same class.
11. `super()` calls the parent class constructor.
12. `this()` must be the first statement when used.
13. `super()` must be the first statement when used.
14. `this()` and `super()` cannot both be directly used in the same constructor.
15. Constructor chaining can happen within the same class using `this()`.
16. Constructor chaining between parent and child can happen using `super()`.


# QUICK REVISION

Constructor
= Object initialization

Same name as class
= Yes

Return type
= No

Automatically called?
= Yes, during object creation

Overloading?
= Yes

Overriding?
= No

Inherited?
= No


this()
= Same class constructor

super()
= Parent class constructor


Constructor Chaining:

Same class:
this()
    ↓
Another constructor


Parent-child:
super()
    ↓
Parent constructor


ONE-LINE INTERVIEW ANSWER:

"A constructor is a special class member used to initialize objects. It has the same name as the class, has no return type, can be overloaded but cannot be inherited or overridden."