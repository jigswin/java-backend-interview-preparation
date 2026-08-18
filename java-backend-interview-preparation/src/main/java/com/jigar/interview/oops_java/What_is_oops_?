WHAT IS OOPS ?

1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction

1) ====> Encapsulation
-> my lang : Wrapping an attributes and methods in single unit and access data using access modifiers.

->professional :  Encapsulation means wrapping data and related methods together in a class and restricting direct access to the
data using access modifiers.


class Employee {

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }
}

-> Yahan salary private hai, directly access nahi kar sakte.

private data
    ↓
getter/setter
    ↓
controlled access



============================================================

2) =====> Inheritance

-> Inheritance allows a child class to reuse properties and behavior of a parent class using mechanisms such as extends.
-> extends keyword use hota h

class Employee {
    void work() {
        System.out.println("Working");
    }
}

class Developer extends Employee {
    void writeCode() {
        System.out.println("Writing code");
    }
}

-> Developer ko Employee ka work() mil jayega.
Employee
   ↑
Developer


* super keword use :=>> ye child class se parent class ka name fucntion or constructor call karne k liye hota h

super.variable    → Parent ka variable
super.method()    → Parent ka method
super()           → Parent ka constructor

============================================================

3) =====> Polymorphism

-> Polymorphism allows the same interface or method name to represent different behaviors. In Java,
method overloading is compile-time polymorphism and method overriding is runtime polymorphism.

Compile-time  → Method Overloading
Runtime       → Method Overriding


1) Method overloading (compile time) : Same method name, different parameters in same class

class A {
    void calculate(int a, int b) { }
    void calculate(int a, int b, int c) {}
 }


2) Method Overriding (runtime): same method name , same parameters in different class
-> using @Override keyword

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}


===============================================================

4) ======> Abstraction

-> my lang : Unnecessary implementation details hide karna aur sirf required functionality expose karna.

-> Abstraction means hiding implementation details and exposing only the essential functionality to the user.
-> implements keyword use hota h

interface Payment {
    void pay();
}

-> User ko sirf pay() ka concept pata hai. Internally payment kaise process ho raha hai, wo hide ho sakta hai.

class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment through UPI");
    }
}


=================================================================

Encapsulation → Data ko protect karo 🔒

Inheritance   → Code reuse karo ♻️

Polymorphism  → Same thing, different behavior 🔄

Abstraction   → Implementation hide karo 🎭

