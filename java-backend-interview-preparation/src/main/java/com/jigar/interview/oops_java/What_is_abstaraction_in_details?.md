# Java Abstraction — Complete Interview Notes

## 1. What is Abstraction?

**Abstraction means hiding implementation details and exposing only the essential functionality to the user.**

Simple language:

> **WHAT to do → Show**
> **HOW to do → Hide**

### Real-world example

ATM me user ko:

* Withdraw
* Deposit
* Check Balance

ka option dikhta hai.

Lekin internally:

* PIN verification
* Account validation
* Bank server communication
* Transaction processing

kaise ho raha hai, ye user se hidden hai.

This is **Abstraction**.

---

# 2. How to achieve Abstraction in Java?

Java me abstraction mainly 2 ways se achieve kar sakte hain:

1. **Abstract Class**
2. **Interface**

---

# 3. Abstract Class

Abstract class wo class hoti hai jise `abstract` keyword ke saath declare kiya jata hai.

Example:

```java
abstract class Payment {

    abstract void pay();

    void paymentSuccess() {
        System.out.println("Payment successful");
    }
}
```

Yahan `Payment` ek abstract class hai.

Isme:

* Abstract method bhi hai
* Concrete/normal method bhi hai

---

# 4. Important Rules of Abstract Class

### Rule 1: `abstract` keyword use karna hota hai

```java
abstract class Payment {
}
```

---

### Rule 2: Abstract class ko directly instantiate nahi kar sakte

❌ Invalid:

```java
Payment p = new Payment();
```

Because abstract class ka direct object create nahi kar sakte.

---

### Rule 3: Abstract class me abstract method ho sakta hai

```java
abstract class Payment {

    abstract void pay();
}
```

Abstract method ke paas body nahi hoti.

```java
abstract void pay();
```

---

### Rule 4: Abstract class me concrete methods bhi ho sakte hain

```java
abstract class Payment {

    abstract void pay();

    void paymentSuccess() {
        System.out.println("Payment successful");
    }
}
```

So abstract class can contain:

```text
Abstract methods
+
Concrete methods
+
Variables
+
Constructors
```

---

# 5. Important Point — Kya Abstract Class me at least one Abstract Method hona compulsory hai?

### Important interview point:

**NO.**

Ye common misconception hai.

An abstract class **abstract methods ke bina bhi exist kar sakti hai.**

Example:

```java
abstract class Payment {

    void pay() {
        System.out.println("Payment");
    }
}
```

Ye completely valid Java code hai.

Lekin agar class ke andar abstract method hai, to class ko `abstract` declare karna compulsory hai.

Example:

```java
abstract class Payment {

    abstract void pay();
}
```

Yahan `Payment` ko abstract hona hi padega.

### Interview me bolna:

> **“An abstract class does not necessarily need to contain an abstract method. However, if a class contains at least one abstract method, the class must be declared abstract.”**

🔥 Ye important interview trap hai.

---

# 6. Abstract Method

Abstract method wo method hota hai:

* `abstract` keyword ke saath declared hota hai
* Uski body nahi hoti
* Child class ko normally usko implement/override karna padta hai

Example:

```java
abstract class Payment {

    abstract void pay();
}
```

Yahan:

```java
abstract void pay();
```

abstract method hai.

---

# 7. Child Class Abstract Method ko Implement karti hai

Example:

```java
abstract class Payment {

    abstract void pay();
}
```

Child class:

```java
class UpiPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Payment through UPI");
    }
}
```

Object:

```java
Payment payment = new UpiPayment();

payment.pay();
```

Output:

```text
Payment through UPI
```

---

# 8. Agar Child Class Abstract Method Implement nahi kare?

Agar child class abstract method implement nahi karti, to child class ko bhi `abstract` declare karna padega.

Example:

```java
abstract class Payment {

    abstract void pay();
}
```

```java
abstract class UpiPayment extends Payment {

    // pay() not implemented
}
```

Ye valid hai because `UpiPayment` bhi abstract hai.

Lekin:

```java
class UpiPayment extends Payment {

    // pay() not implemented
}
```

❌ Compile-time error.

---

# 9. Abstract Class Constructor

Abstract class ka constructor ho sakta hai.

Example:

```java
abstract class Payment {

    Payment() {
        System.out.println("Payment constructor");
    }

    abstract void pay();
}
```

Child class:

```java
class UpiPayment extends Payment {

    UpiPayment() {
        System.out.println("UPI constructor");
    }

    @Override
    void pay() {
        System.out.println("UPI Payment");
    }
}
```

Object:

```java
Payment p = new UpiPayment();
```

Output conceptually:

```text
Payment constructor
UPI constructor
```

### Important:

Abstract class ka direct object nahi bana sakte, but uska constructor child object create hone par call ho sakta hai.

---

# 10. Abstract Class me Variables

Abstract class me normal variables ho sakte hain.

```java
abstract class Employee {

    String name;
    int salary;

    abstract void work();
}
```

Child class:

```java
class Developer extends Employee {

    @Override
    void work() {
        System.out.println("Writing code");
    }
}
```

---

# 11. Abstract Class ka Real-world Example

```java
abstract class Payment {

    abstract void pay();

    void generateReceipt() {
        System.out.println("Receipt generated");
    }
}
```

UPI:

```java
class UpiPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Processing UPI payment");
    }
}
```

Card:

```java
class CardPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Processing Card payment");
    }
}
```

Use:

```java
Payment payment = new UpiPayment();

payment.pay();
payment.generateReceipt();
```

Here:

* `pay()` → implementation child class provides
* `generateReceipt()` → common implementation provided by parent

This is why abstract classes are useful when we want **common state/behavior + abstraction**.

---

# 12. Interface

Interface is another way of achieving abstraction.

Example:

```java
interface Payment {

    void pay();
}
```

Implementation:

```java
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment through UPI");
    }
}
```

Use:

```java
Payment payment = new UpiPayment();

payment.pay();
```

Interface mainly defines a **contract**.

Meaning:

> “Jo bhi class `Payment` implement karegi, usko `pay()` provide karna padega.”

---

# 13. Interface Rules

### Rule 1: Class interface ko `implements` keyword se implement karti hai

```java
class UpiPayment implements Payment {
}
```

---

### Rule 2: Interface ka direct object nahi bana sakte

❌

```java
Payment p = new Payment();
```

---

### Rule 3: Interface ke abstract methods ko implementing class ko implement karna hota hai

```java
interface Payment {

    void pay();
}
```

```java
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("UPI payment");
    }
}
```

---

### Rule 4: Ek class multiple interfaces implement kar sakti hai

```java
interface Payment {
    void pay();
}

interface Refund {
    void refund();
}

class UpiPayment implements Payment, Refund {

    @Override
    public void pay() {
        System.out.println("Payment");
    }

    @Override
    public void refund() {
        System.out.println("Refund");
    }
}
```

This is one major advantage of interfaces.

---

# 14. Interface Variables

Interface ke fields by default:

```text
public static final
```

hote hain.

Example:

```java
interface Payment {

    int MAX_LIMIT = 100000;
}
```

Conceptually compiler treats it as:

```java
public static final int MAX_LIMIT = 100000;
```

So interface variables are constants.

---

# 15. Interface Methods in Modern Java

Java 8 ke baad interface me:

### Abstract methods

```java
interface Payment {

    void pay();
}
```

### Default methods

```java
interface Payment {

    default void receipt() {
        System.out.println("Receipt");
    }
}
```

### Static methods

```java
interface Payment {

    static void validate() {
        System.out.println("Validation");
    }
}
```

Java 9 se interface me private methods bhi allowed hain.

---

# 16. 100% / Complete Abstraction — Important Interview Point

Traditional Java interview answer:

> **“Interface can be used to achieve 100% abstraction.”**

Because traditionally interface primarily contained method declarations without implementations.

However, modern Java me interfaces can contain:

* `default` methods
* `static` methods
* private methods

with implementations.

Therefore, technically:

> **It is an oversimplification to say that a modern Java interface always provides 100% abstraction.**

Interview me safe answer:

> **“Traditionally, interfaces were considered a way to achieve complete abstraction because they defined method contracts without implementation. Since Java 8, interfaces can also contain default and static methods with implementations, so the 100% abstraction statement is mainly a traditional interview concept.”**

---

# 17. Abstract Class vs Interface

| Feature              | Abstract Class                        | Interface                                 |
| -------------------- | ------------------------------------- | ----------------------------------------- |
| Keyword              | `abstract class`                      | `interface`                               |
| Inheritance keyword  | `extends`                             | `implements`                              |
| Abstract methods     | Yes                                   | Yes                                       |
| Concrete methods     | Yes                                   | Yes, e.g. default/static                  |
| Variables            | Instance/static variables allowed     | Fields are `public static final`          |
| Constructor          | Yes                                   | No                                        |
| Direct object        | No                                    | No                                        |
| Multiple inheritance | A class can extend only one class     | A class can implement multiple interfaces |
| Main purpose         | Common state + behavior + abstraction | Contract/capability                       |
| Can have state       | Yes                                   | No instance state                         |
| Typical use          | Closely related classes               | Common contract across different classes  |

---

# 18. When to Use Abstract Class?

Use abstract class when:

* Classes are closely related
* You want common variables/state
* You want common implementation
* You also want some methods to be abstract

Example:

```text
Employee
   |
   |-- Developer
   |-- Tester
   |-- Manager
```

Common things:

```text
name
salary
employeeId
login()
logout()
```

Different behavior:

```text
Developer → writeCode()
Tester    → testApplication()
Manager   → manageTeam()
```

Abstract class can be useful here.

---

# 19. When to Use Interface?

Use interface when you mainly want to define a **contract/capability**.

Example:

```java
interface Payment {
    void pay();
}
```

Different classes can implement it:

```text
Payment
   |
   |-- UpiPayment
   |-- CardPayment
   |-- NetBankingPayment
```

Even unrelated classes can implement the same interface if they support the same capability.

Also, a class can implement multiple interfaces.

---

# 20. Abstraction vs Encapsulation

This is a very common interview question.

### Abstraction

> **Hides implementation details.**

Focus:

```text
WHAT to do?
```

Example:

```java
payment.pay();
```

---

### Encapsulation

> **Controls access to data by bundling data and methods together and using access modifiers.**

Focus:

```text
HOW to protect data?
```

Example:

```java
private double balance;

public double getBalance() {
    return balance;
}
```

### Easy trick:

```text
Abstraction   → Hide implementation
Encapsulation → Protect data
```

---

# 21. Abstraction + Polymorphism Together

In real Java/Spring applications, abstraction and polymorphism are often used together.

Example:

```java
interface PaymentService {

    void processPayment();
}
```

Implementations:

```java
class UpiPaymentService implements PaymentService {

    @Override
    public void processPayment() {
        System.out.println("UPI payment");
    }
}
```

```java
class CardPaymentService implements PaymentService {

    @Override
    public void processPayment() {
        System.out.println("Card payment");
    }
}
```

Caller:

```java
PaymentService service = new UpiPaymentService();

service.processPayment();
```

The caller depends on the **interface**, not the concrete implementation.

This is very common in Spring Boot applications because Spring can inject an implementation through dependency injection.

---

# 22. Important Interview Questions

### Q1. What is abstraction?

> Abstraction means hiding implementation details and exposing only essential functionality.

### Q2. How can we achieve abstraction in Java?

> Using abstract classes and interfaces.

### Q3. Can we create an object of an abstract class?

> No, we cannot directly instantiate an abstract class.

### Q4. Can abstract class have a constructor?

> Yes.

### Q5. Can abstract class have concrete methods?

> Yes.

### Q6. Can abstract class exist without an abstract method?

> Yes.

### Q7. If a class has an abstract method, what must be done?

> The class must be declared abstract.

### Q8. What happens if child class doesn't implement abstract methods?

> The child class must also be declared abstract.

### Q9. Can interface have method implementation?

> Yes. Modern Java interfaces can have default and static methods with implementations, and private methods from Java 9.

### Q10. Can interface have constructor?

> No.

### Q11. Can a class implement multiple interfaces?

> Yes.

### Q12. Can a class extend multiple classes?

> No. Java does not support multiple class inheritance.

### Q13. Abstract class vs interface?

> Abstract class is useful when we need common state and behavior along with abstraction, while interface is mainly useful for defining a contract/capability and allows multiple interfaces to be implemented.

---

# 23. Super Important Interview Trap

### Question:

**“Does abstract class need at least one abstract method?”**

Answer:

> **No. An abstract class can have zero abstract methods. However, if a class contains even one abstract method, the class must be declared abstract.**

Example:

```java
abstract class Test {

    void show() {
        System.out.println("Hello");
    }
}
```

✅ Valid.

---

# 24. Super Important Interview Trap #2

### Question:

**“Can an abstract method be private?”**

Answer:

> **No. An abstract method cannot be private because the child class must be able to override it, while a private method is not accessible to the child class.**

❌

```java
abstract class Test {

    private abstract void show();
}
```

---

# 25. Super Important Interview Trap #3

### Question:

**“Can an abstract method be static?”**

Answer:

> **No. Abstract methods are meant to be overridden by child classes, while static methods belong to the class and are not overridden.**

❌

```java
abstract static void show();
```

---

# 26. Super Important Interview Trap #4

### Question:

**“Can an abstract class be final?”**

Answer:

> **No. A final class cannot be inherited, while an abstract class is designed to be inherited and implemented/extended.**

❌

```java
final abstract class Test {
}
```

These concepts conflict with each other.

---

# 27. Final Memory Trick

```text
ABSTRACTION
    ↓
Hide HOW
Show WHAT
    ↓
-------------------------
|                       |
Abstract Class       Interface
|                       |
Common state/        Contract/
behavior +          capability
abstraction
```

### Abstract Class:

```text
abstract class
    ↓
Can have abstract methods
Can have concrete methods
Can have variables
Can have constructor
Cannot create direct object
```

### Interface:

```text
interface
    ↓
Contract
Class implements it
Multiple interfaces possible
No constructor
Fields are public static final
Modern Java → default/static/private methods possible
```

### Most important 5 lines to remember:

```text
1. Abstraction = hide implementation, expose functionality.

2. Abstract class can contain abstract + concrete methods.

3. Abstract class does NOT require at least one abstract method.

4. If a class has an abstract method, the class must be abstract.

5. Interface is mainly used to define a contract, and a class can implement multiple interfaces.
```
