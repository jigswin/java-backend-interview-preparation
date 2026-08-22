# Q29 — Composition in Java

## 1. Composition kya hota hai?

Composition ek strong HAS-A relationship hai.

Simple language me:

> Jab ek class ke andar dusri class ka object hota hai aur pehli class us object ko strongly own karti hai, to usse Composition kehte hain.

Example:

Car HAS-A Engine

Car ke bina Engine object ka lifecycle bhi conceptually dependent ho sakta hai.

Java me Composition generally object ko class ke andar create/maintain karke achieve ki jaati hai.


# 2. Simple Example

class Engine {

    void start() {

        System.out.println("Engine started");
    }
}


class Car {

    private Engine engine;

    public Car() {

        engine = new Engine();
    }

    void startCar() {

        engine.start();

        System.out.println("Car started");
    }
}


public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        car.startCar();
    }
}


Output:

Engine started
Car started


Yahan:

Car
→ HAS-A
→ Engine


Ye Composition ka example hai.


# 3. Composition ka Real-World Example

Car ke andar:

Car
├── Engine
├── Battery
└── Transmission


Car ek Engine ko contain karti hai.

So:

Car HAS-A Engine

Car HAS-A Battery

Car HAS-A Transmission


Ye HAS-A relationship hai.


# 4. Composition ka Main Benefit

Composition ka main benefit:

> Code reuse + loose coupling + better maintainability.

Instead of inheritance par depend karne ke, hum required behavior ke objects ko combine kar sakte hain.


# 5. Composition vs Inheritance

Inheritance:

IS-A relationship

Example:

Dog IS-A Animal


Composition:

HAS-A relationship

Example:

Car HAS-A Engine


Example:

class Animal {
}


class Dog extends Animal {
}


Yahan:

Dog IS-A Animal


Composition:

class Engine {
}


class Car {

    private Engine engine;

}


Yahan:

Car HAS-A Engine


# 6. Simple Difference

Inheritance:

Parent-child relationship

Example:

Employee IS-A Person


Composition:

Object ownership/containment relationship

Example:

Employee HAS-A Address


# 7. Important Real-World Example

class Address {

    private String city;

    public Address(String city) {

        this.city = city;
    }

    public String getCity() {

        return city;
    }
}


class Employee {

    private String name;

    private Address address;

    public Employee(
            String name,
            Address address) {

        this.name = name;

        this.address = address;
    }

    public void display() {

        System.out.println(name);

        System.out.println(
                address.getCity()
        );
    }
}


public class Main {

    public static void main(String[] args) {

        Address address =
                new Address("Bangalore");

        Employee employee =
                new Employee(
                    "Jigar",
                    address
                );

        employee.display();
    }
}


Yahan:

Employee HAS-A Address


Employee ke paas Address object hai.


# 8. Composition me Object ka Ownership

Strong composition me containing object child object ke lifecycle ko own karta hai.

Example:

class Engine {

}


class Car {

    private Engine engine =
            new Engine();

}


Car object create hua:

Car
↓
Engine


Car ka lifecycle khatam hone par Engine ko bhi koi external reference nahi hone par GC ke liye eligible hone ka chance hota hai.


Important:

GC actual destruction immediately guarantee nahi karta.

Composition ka main point ownership/design relationship hai.


# 9. Composition ka Strong Example

class Heart {

    void beat() {

        System.out.println("Heart is beating");
    }
}


class Human {

    private Heart heart;

    public Human() {

        heart = new Heart();
    }

    void live() {

        heart.beat();

        System.out.println(
                "Human is alive"
        );
    }
}


Yahan:

Human HAS-A Heart


Heart ko Human class internally create kar rahi hai.

Ye strong ownership ka example hai.


# 10. Aggregation vs Composition

Ye interview me bahut important hai.


Aggregation:

Weak HAS-A relationship


Composition:

Strong HAS-A relationship


Example:

Department HAS-A Employee


Employee department ke bahar bhi exist kar sakta hai.

So:

Aggregation


Composition example:

House HAS-A Room


Agar House ke context me Room ko strongly own kiya gaya hai, to:

Composition


# 11. Easy Difference

Aggregation:

Child object independently exist kar sakta hai.


Composition:

Child object ka lifecycle owner ke strongly tied hota hai.


Example:

Aggregation:

Department
↓
Employee

Employee department ke bahar bhi exist kar sakta hai.


Composition:

House
↓
Room

Room house ke structure ka part hai.


# 12. Composition vs Aggregation Example

Aggregation:

class Employee {
}


class Department {

    private Employee employee;

    Department(Employee employee) {

        this.employee = employee;
    }
}


Employee object outside create hua:

Employee employee =
        new Employee();

Department department =
        new Department(employee);


Yahan Employee Department ke bahar independently exist kar sakta hai.

So:

Aggregation


Composition:

class Engine {
}


class Car {

    private Engine engine;

    Car() {

        engine = new Engine();
    }
}


Yahan Car internally Engine create kar rahi hai.

Strong ownership:

Composition


# 13. Composition kaise achieve karte hain?

Composition ke liye:

1. Ek class me dusri class ka reference declare karo.
2. Required object ko constructor/initialization ke through provide karo.
3. Strong ownership ho to object internally create/manage kar sakte ho.


Example:

class Car {

    private Engine engine;

    Car() {

        engine = new Engine();
    }
}


# 14. Composition with Constructor Injection

Composition ka matlab ye nahi ki object hamesha `new` se hi create karna zaroori hai.

Example:

class Car {

    private Engine engine;

    public Car(Engine engine) {

        this.engine = engine;
    }
}


Yahan Engine outside se provide ho raha hai.

Ye dependency injection ka common pattern bhi hai.


Spring Boot me ye approach bahut common hai.


# 15. Spring Boot me Composition

Example:

@Service
class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(
            EmployeeRepository repository) {

        this.repository = repository;
    }
}


EmployeeService:

HAS-A

EmployeeRepository


Spring dependency inject karta hai.

Ye object composition/has-a relationship ka practical example hai.


# 16. Composition ka Advantage

### 1. Code Reusability

Existing classes ke objects ko reuse kar sakte hain.


### 2. Flexibility

Required object ko change karna easier hota hai.


### 3. Maintainability

Classes ko smaller responsibilities me divide kar sakte hain.


### 4. Loose Coupling

Interfaces ke saath composition use karne par coupling reduce ho sakti hai.


### 5. Better Design

Complex system ko smaller collaborating objects me divide kar sakte hain.


# 17. Composition + Interface

Composition ko interface ke saath combine karna powerful design hai.

Example:

interface PaymentService {

    void pay();
}


class CreditCardPayment
        implements PaymentService {

    public void pay() {

        System.out.println(
                "Credit Card Payment"
        );
    }
}


class OrderService {

    private PaymentService paymentService;

    public OrderService(
            PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    public void placeOrder() {

        paymentService.pay();
    }
}


Main:

PaymentService payment =
        new CreditCardPayment();

OrderService order =
        new OrderService(payment);

order.placeOrder();


Yahan:

OrderService
HAS-A
PaymentService


Aur implementation:

CreditCardPayment


Ye flexible design hai.


# 18. Why Composition is Preferred Over Inheritance?

Interview me kabhi-kabhi question aata hai:

"Why prefer composition over inheritance?"


Answer:

> Composition provides better flexibility and usually creates less coupling than inheritance. Instead of tightly depending on a parent class, we can compose objects and change their behavior more easily.


Example:

Inheritance:

class Car extends Vehicle

Car permanently Vehicle hierarchy ka part hai.


Composition:

class Car {

    private Engine engine;
}


Car ka behavior different Engine implementations ke saath change kiya ja sakta hai.


# 19. Important Interview Question

Q: What is Composition?

Answer:

"Composition is a strong HAS-A relationship where one class contains and owns another object. It promotes code reuse, modularity and better maintainability."


Q: What is the difference between IS-A and HAS-A?

Answer:

"IS-A represents inheritance, while HAS-A represents composition or aggregation."


Q: Give a real-world example of Composition.

Answer:

"Car HAS-A Engine, or House HAS-A Room."


Q: What is the difference between Aggregation and Composition?

Answer:

"Both represent HAS-A relationships, but aggregation is a weaker relationship where the child can exist independently, while composition represents stronger ownership where the child's lifecycle is closely tied to the parent."


Q: Why is composition preferred over inheritance?

Answer:

"Composition generally provides more flexibility and lower coupling because behavior can be composed from collaborating objects rather than being tightly tied to an inheritance hierarchy."


# 20. QUICK REVISION

Inheritance:

IS-A

Dog
↓
Animal


Composition:

HAS-A

Car
↓
Engine


Aggregation:

WEAK HAS-A

Department
↓
Employee


Composition:

STRONG HAS-A

Car
↓
Engine


Easy memory trick:

IS-A
→ Inheritance


HAS-A
→ Composition/Aggregation


Strong HAS-A
→ Composition


Weak HAS-A
→ Aggregation


# 21. ONE-LINE INTERVIEW ANSWER

"Composition is a strong HAS-A relationship in which one class is built using objects of another class, providing better modularity, reuse and flexibility."