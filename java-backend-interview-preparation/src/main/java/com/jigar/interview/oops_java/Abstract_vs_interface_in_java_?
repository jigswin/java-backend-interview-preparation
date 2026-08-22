# Q22 — Interface vs Abstract Class in Java

## 1. Interface kya hota hai?

Interface ek contract/blueprint hota hai jo define karta hai ki class ko kya functionality provide karni chahiye.

Example:

interface Payment {

    void pay();
}

class UpiPayment implements Payment {

    @Override
    public void pay() {

        System.out.println("Payment using UPI");
    }
}

class CardPayment implements Payment {

    @Override
    public void pay() {

        System.out.println("Payment using Card");
    }
}


Yahan:

Payment
→ Interface

UpiPayment
→ Implementation

CardPayment
→ Implementation


Simple meaning:

Interface batata hai:

"WHAT to do"

Implementation class batati hai:

"HOW to do it"


--------------------------------------------------

## 2. Abstract Class kya hoti hai?

Abstract class ek partially implemented class ho sakti hai.

Isme:

- Abstract methods ho sakte hain
- Concrete methods ho sakte hain
- Variables ho sakte hain
- Constructors ho sakte hain

Example:

abstract class Vehicle {

    abstract void start();

    void stop() {

        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car started");
    }
}


Yahan:

start()
→ Abstract method

stop()
→ Concrete method


--------------------------------------------------

## 3. Main Difference

Interface:

→ Mainly contract define karta hai.

Abstract class:

→ Contract + common implementation dono provide kar sakti hai.


--------------------------------------------------

## 4. Interface Example

interface Payment {

    void pay();
}


class UpiPayment implements Payment {

    @Override
    public void pay() {

        System.out.println("UPI Payment");
    }
}


class CardPayment implements Payment {

    @Override
    public void pay() {

        System.out.println("Card Payment");
    }
}


Yahan Payment sirf contract define kar raha hai.


--------------------------------------------------

## 5. Abstract Class Example

abstract class Payment {

    abstract void pay();

    void generateReceipt() {

        System.out.println("Receipt generated");
    }
}


class UpiPayment extends Payment {

    @Override
    void pay() {

        System.out.println("UPI Payment");
    }
}


Yahan common functionality:

generateReceipt()

already abstract class me available hai.


--------------------------------------------------

## 6. Interface me Methods

Modern Java interface me:

- Abstract methods
- default methods
- static methods
- private methods

ho sakte hain.

Example:

interface Payment {

    void pay();

    default void receipt() {

        System.out.println("Receipt generated");
    }

    static void info() {

        System.out.println("Payment interface");
    }
}


Important:

Interface ke abstract method ko implementing class ko implement karna hota hai, unless class itself abstract ho.


--------------------------------------------------

## 7. Abstract Class me Methods

Abstract class me:

- Abstract methods
- Concrete methods

dono ho sakte hain.

Example:

abstract class Vehicle {

    abstract void start();

    void stop() {

        System.out.println("Stop");
    }
}


--------------------------------------------------

## 8. Interface me Variables

Interface ke fields implicitly:

public static final

hote hain.

Example:

interface Payment {

    int MAX_LIMIT = 100000;
}


Conceptually:

public static final int MAX_LIMIT = 100000;


Isliye:

MAX_LIMIT = 200000;

❌ Not allowed.


--------------------------------------------------

## 9. Abstract Class me Variables

Abstract class me normal variables ho sakte hain.

Example:

abstract class Employee {

    int id;

    String name;

    final String company = "ABC";
}


Yahan fields ko normal tarike se declare kar sakte hain.


--------------------------------------------------

## 10. Multiple Inheritance

Java class ke through multiple inheritance support nahi karta.

Example:

class C extends A, B {

}

❌ Not allowed.


Lekin interface ke through multiple inheritance of type achieve kar sakte hain.

Example:

interface A {

    void methodA();
}

interface B {

    void methodB();
}

class C implements A, B {

    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }
}


✅ Allowed.


--------------------------------------------------

## 11. Abstract Class Multiple Extend kar sakte hain?

NO.

Example:

class Car extends Vehicle, Machine {

}

❌ Not allowed.


Ek class sirf ek class extend kar sakti hai.


--------------------------------------------------

## 12. Class Multiple Interfaces Implement kar sakti hai?

YES.

Example:

class Car implements Vehicle, Machine {

}


✅ Allowed.


--------------------------------------------------

## 13. Constructor in Interface

Interface ka constructor nahi hota.

Example:

interface Payment {

    Payment() {
    }
}


❌ Invalid.


Reason:

Interface ka object directly create nahi kar sakte.


--------------------------------------------------

## 14. Constructor in Abstract Class

Abstract class constructor rakh sakti hai.

Example:

abstract class Vehicle {

    Vehicle() {

        System.out.println("Vehicle constructor");
    }
}


class Car extends Vehicle {

    Car() {

        System.out.println("Car constructor");
    }
}


Car object create karne par:

Vehicle constructor
Car constructor


execute hoga.


--------------------------------------------------

## 15. Can we create object of Interface?

Directly NO.

Example:

Payment payment = new Payment();

❌ Invalid.


But interface reference bana sakte hain:

Payment payment =
        new UpiPayment();

✅ Allowed.


Important:

Reference type:

Payment

Actual object:

UpiPayment


--------------------------------------------------

## 16. Can we create object of Abstract Class?

Directly NO.

Example:

Vehicle vehicle =
        new Vehicle();

❌ Invalid.


But reference bana sakte hain:

Vehicle vehicle =
        new Car();

✅ Allowed.


--------------------------------------------------

## 17. Abstract Class me Abstract Method compulsory hai?

Nahi.

Ye important correction hai.

Abstract class me abstract method hona compulsory nahi hai.

Example:

abstract class Vehicle {

    void start() {

        System.out.println("Start");
    }
}


Ye valid hai.


Lekin:

Agar class me koi abstract method hai, to class ko abstract declare karna compulsory hai.


Example:

abstract class Vehicle {

    abstract void start();
}


--------------------------------------------------

## 18. Interface me Abstract Method compulsory hai?

Modern Java me interface me abstract method hona technically compulsory nahi hai because interface can contain only default/static/private methods.

Example:

interface Vehicle {

    default void start() {

        System.out.println("Start");
    }
}


Ye valid hai.


Lekin interview me traditional explanation:

> Interface is primarily used to define a contract and historically consisted mainly of abstract methods.


--------------------------------------------------

## 19. Interface vs Abstract Class — Table

Interface:

→ Contract / capability

→ Class `implements` interface

→ Multiple interfaces implement kar sakte hain

→ Instance constructor nahi hota

→ Fields are implicitly public static final

→ Abstract/default/static/private methods possible

→ Object directly create nahi kar sakte


Abstract Class:

→ Partial abstraction + common implementation

→ Class `extends` abstract class

→ Only one class extend kar sakte hain

→ Constructor ho sakta hai

→ Instance variables ho sakte hain

→ Abstract + concrete methods dono ho sakte hain

→ Object directly create nahi kar sakte


--------------------------------------------------

## 20. Real-World Example — Interface

Suppose application me different payment methods hain:

UPI
Card
Net Banking

Sabka common behavior:

pay()


To interface useful hai.

interface Payment {

    void pay();
}


class UpiPayment implements Payment {

    @Override
    public void pay() {

        System.out.println("Pay using UPI");
    }
}


class CardPayment implements Payment {

    @Override
    public void pay() {

        System.out.println("Pay using Card");
    }
}


Yahan interface ek common contract provide kar raha hai.


--------------------------------------------------

## 21. Real-World Example — Abstract Class

Suppose different vehicles hain:

Car
Bike
Truck

Sabke paas common:

start()
stop()
fuel()

Ho sakta hai kuch implementation common ho aur kuch specific.

abstract class Vehicle {

    String brand;

    Vehicle(String brand) {

        this.brand = brand;
    }

    abstract void start();

    void stop() {

        System.out.println("Vehicle stopped");
    }
}


class Car extends Vehicle {

    Car(String brand) {

        super(brand);
    }

    @Override
    void start() {

        System.out.println("Car started");
    }
}


Yahan abstract class common state + common behavior + abstract behavior provide kar rahi hai.


--------------------------------------------------

## 22. Spring Boot me Interface ka Real Use

Spring Boot me interfaces bahut commonly use hote hain.

Example:

public interface EmployeeService {

    Employee getEmployee(Long id);

    Employee createEmployee(Employee employee);
}


Implementation:

@Service
public class EmployeeServiceImpl
        implements EmployeeService {

    @Override
    public Employee getEmployee(Long id) {

        // business logic
        return null;
    }

    @Override
    public Employee createEmployee(
            Employee employee) {

        // business logic
        return null;
    }
}


Yahan:

EmployeeService
→ Contract

EmployeeServiceImpl
→ Implementation


--------------------------------------------------

## 23. Why Interface in Spring Boot?

Interface use karne ke benefits:

1. Loose coupling
2. Easy testing
3. Multiple implementations possible
4. Dependency Injection ke saath useful
5. Code maintainability better


Example:

EmployeeService service;


Controller ko implementation ki details pata nahi hain.

Controller sirf interface ke contract par depend karta hai.


--------------------------------------------------

## 24. Interface vs Abstract Class — Kab Use Kare?

Interface use karo jab:

> Different/unrelated classes ko same capability/contract dena ho.

Example:

interface Flyable {

    void fly();
}


Bird implements Flyable

Airplane implements Flyable


Bird aur Airplane unrelated classes hain, but dono fly kar sakte hain.


Abstract class use karo jab:

> Closely related classes ke beech common state aur common behavior share karna ho.


Example:

abstract class Animal {

    String name;

    void eat() {

        System.out.println("Eating");
    }

    abstract void sound();
}


Dog extends Animal

Cat extends Animal


--------------------------------------------------

## 25. Interview-Ready Answer

Question:

"What is the difference between interface and abstract class?"

Answer:

"An interface is mainly used to define a contract or capability, while an abstract class is useful when we want to provide partial implementation and share common state or behavior. A class can implement multiple interfaces but can extend only one class."


--------------------------------------------------

## 26. Very Important Interview Questions

Q: Can a class implement multiple interfaces?

A:

"Yes."


Q: Can a class extend multiple classes?

A:

"No. Java does not support multiple class inheritance."


Q: Can abstract class have constructor?

A:

"Yes."


Q: Can interface have constructor?

A:

"No."


Q: Can we create object of abstract class?

A:

"No, but we can create a reference of the abstract type pointing to a concrete subclass object."


Q: Can interface have variables?

A:

"Yes. Interface fields are implicitly public, static and final."


Q: Can abstract class have concrete methods?

A:

"Yes."


Q: Can abstract class have zero abstract methods?

A:

"Yes."


Q: Can interface have default methods?

A:

"Yes."


Q: Why use interface in Spring Boot?

A:

"Interfaces help define contracts, support loose coupling, allow multiple implementations and work well with dependency injection."


# QUICK REVISION

Interface
→ Contract / Capability

Abstract Class
→ Partial implementation


Interface:

class A implements B

Multiple interfaces:
class A implements B, C


Abstract class:

class A extends B

Only one class can be extended.


Interface:
→ No constructor

Abstract class:
→ Constructor allowed


Interface fields:
→ public static final


Abstract class:
→ Normal instance/static/final fields possible


Interface:
→ Multiple implementation possible


Abstract class:
→ Common state + common behavior


ONE-LINE INTERVIEW ANSWER:

"Use an interface when you want to define a contract or capability, especially when multiple unrelated classes may implement it; use an abstract class when closely related classes need shared state or common implementation."