# Java — Method Overloading vs Method Overriding

## 1. What is Method Overloading?

**Method Overloading means having multiple methods with the same name but different parameter lists in the same class.**

Simple language:

> **Same method name + different parameters = Method Overloading**

### Example

```java
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
```

Yahan teeno methods ka naam `add()` hai, but parameters different hain.

```text
add(int, int)
add(int, int, int)
add(double, double)
```

Therefore, this is **Method Overloading**.

---

## 2. Why do we use Method Overloading?

Jab same type ka kaam different inputs ke saath karna ho, tab overloading useful hai.

Example:

```java
add(10, 20);
add(10, 20, 30);
add(10.5, 20.5);
```

Instead of different names:

```text
addTwoNumbers()
addThreeNumbers()
addDoubleNumbers()
```

Hum same meaningful method name `add()` use kar sakte hain.

This improves **readability and usability**.

---

# 3. Important Rules of Method Overloading

### Rule 1 — Method name same hona chahiye

```java
add()
add()
```

---

### Rule 2 — Parameters different hone chahiye

Parameters different ho sakte hain based on:

* Number of parameters
* Type of parameters
* Order of parameters

Example:

```java
void show(int a) { }

void show(int a, int b) { }        // Different number

void show(double a) { }            // Different type

void show(String a, int b) { }

void show(int a, String b) { }     // Different order
```

---

### Rule 3 — Sirf return type change karne se overloading nahi hoti

❌ Invalid:

```java
int add(int a, int b) {
    return a + b;
}

double add(int a, int b) {
    return a + b;
}
```

Parameters exactly same hain.

Java sirf return type dekhkar decide nahi kar sakta ki kaunsa method call karna hai.

Therefore:

> **Return type alone cannot be used for method overloading.**

---

## 4. Is Overloading Compile-time or Runtime Polymorphism?

Method overloading is:

> **Compile-time Polymorphism**

Kyun?

Compiler method call ke parameters dekhkar decide karta hai ki kaunsa overloaded method call hoga.

Example:

```java
Calculator c = new Calculator();

c.add(10, 20);
```

Compiler knows:

```text
add(int, int)
```

So corresponding method select ho jata hai.

---

# 5. What is Method Overriding?

**Method Overriding occurs when a child class provides its own implementation of a method already defined in the parent class.**

Simple language:

> **Parent ka method child class apne according redefine kare = Method Overriding**

### Example

```java
class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}
```

Child:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

Yahan `Dog` ne parent class ke `sound()` method ko override kiya.

---

# 6. Why do we use Method Overriding?

Different child classes ko same method ka **different behavior** provide karna ho to overriding use karte hain.

Example:

```text
Animal
  |
  |-- Dog → Bark
  |
  |-- Cat → Meow
  |
  |-- Cow → Moo
```

Parent:

```java
void sound()
```

Child classes apne according implementation provide karengi.

---

# 7. Runtime Polymorphism

Method overriding is:

> **Runtime Polymorphism**

Example:

```java
Animal animal = new Dog();

animal.sound();
```

Output:

```text
Dog barks
```

Yahan reference type:

```text
Animal
```

hai.

But actual object:

```text
Dog
```

hai.

Runtime par decide hota hai ki `Dog` ka `sound()` execute hoga.

Therefore:

> **Method overriding provides runtime polymorphism.**

---

# 8. Important Rules of Method Overriding

## Rule 1 — Parent-child relationship required

Overriding ke liye inheritance required hai.

```java
class Parent {
    void show() {
    }
}

class Child extends Parent {
    @Override
    void show() {
    }
}
```

---

## Rule 2 — Method signature same honi chahiye

Parent:

```java
void show(int a)
```

Child:

```java
void show(int a)
```

Same method signature → overriding.

Agar parameters change kar diye:

```java
void show(int a, int b)
```

to wo overriding nahi, **overloading** ho jayega.

---

## Rule 3 — Return type

Overridden method ka return type same hona chahiye ya **covariant return type** allowed hota hai.

Simple interview level:

> **Same return type or compatible covariant return type.**

---

## Rule 4 — Access modifier ko more restrictive nahi bana sakte

Parent:

```java
class Parent {

    public void show() {
    }
}
```

Child:

```java
class Child extends Parent {

    public void show() {
    }
}
```

✅ Valid.

Lekin:

```java
class Child extends Parent {

    protected void show() {
    }
}
```

❌ Invalid.

Because `public` ko `protected` se more restrictive bana diya.

### General rule:

Child class overridden method ka access level:

> **Same or wider hona chahiye.**

---

# 9. `@Override` Annotation

Best practice:

```java
@Override
void sound() {
    System.out.println("Bark");
}
```

`@Override` compiler ko indicate karta hai ki hum parent method override kar rahe hain.

Agar accidentally method signature wrong ho gayi, compiler error de sakta hai.

Example:

```java
@Override
void sounds() {
}
```

Agar parent me `sounds()` nahi hai:

❌ Compile-time error.

So:

> **Always use `@Override` when overriding a method.**

---

# 10. Can Static Methods be Overridden?

**No.**

Static methods class-level hote hain aur override nahi hote.

They are **method hidden**, not overridden.

Example:

```java
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
```

Ye overriding nahi hai.

Ye:

> **Method Hiding**

hai.

---

# 11. Can Private Methods be Overridden?

**No.**

Private methods child class ko accessible nahi hote.

Example:

```java
class Parent {

    private void show() {
    }
}
```

Child:

```java
class Child extends Parent {

    void show() {
    }
}
```

Ye overriding nahi hai.

Child ka `show()` ek completely separate method hai.

---

# 12. Can Final Methods be Overridden?

**No.**

`final` method ko child class override nahi kar sakti.

```java
class Parent {

    final void show() {
        System.out.println("Parent");
    }
}
```

```java
class Child extends Parent {

    @Override
    void show() {
        System.out.println("Child");
    }
}
```

❌ Compile-time error.

Reason:

> `final` means the method cannot be overridden.

---

# 13. Can Constructors be Overridden?

**No.**

Constructors:

* Inherit nahi hote
* Override nahi hote

Example:

```java
class Parent {

    Parent() {
    }
}

class Child extends Parent {

    Child() {
    }
}
```

Ye constructor overriding nahi hai.

Child ka constructor alag hai.

---

# 14. Overloading vs Overriding — Main Difference

| Feature            | Overloading                            | Overriding                        |
| ------------------ | -------------------------------------- | --------------------------------- |
| Meaning            | Same method name, different parameters | Child provides new implementation |
| Inheritance        | Not required                           | Required                          |
| Parameters         | Must be different                      | Must be same                      |
| Return type        | Return type alone cannot differentiate | Same/covariant                    |
| Polymorphism       | Compile-time                           | Runtime                           |
| Class relationship | Usually same class                     | Parent-child                      |
| Access modifier    | Normal rules                           | Cannot reduce visibility          |
| `static`           | Can overload                           | Cannot override; can hide         |
| `private`          | Can overload                           | Cannot override                   |
| `final`            | Can overload                           | Cannot override                   |
| `@Override`        | Not used                               | Recommended                       |

---

# 15. Easy Real-World Example

## Overloading

Restaurant me:

```text
order(item)
order(item, quantity)
order(item, quantity, address)
```

Same action:

> `order()`

But different inputs.

That's **Overloading**.

---

## Overriding

Suppose:

```text
Payment
   |
   |-- UPI
   |-- Card
   |-- NetBanking
```

Parent:

```java
void pay()
```

UPI:

```java
void pay() {
    // UPI logic
}
```

Card:

```java
void pay() {
    // Card logic
}
```

Same method but different implementation.

That's **Overriding**.

---

# 16. Interview Question — Can we overload main()?

### Yes.

Java allows overloaded `main()` methods.

```java
public class Main {

    public static void main(String[] args) {
        System.out.println("Main method");
    }

    public static void main(int number) {
        System.out.println(number);
    }
}
```

But JVM entry point ke liye specifically:

```java
public static void main(String[] args)
```

method required hai.

So overloaded `main()` automatically JVM entry point nahi banega.

---

# 17. Interview Question — Can we override main()?

Technically `main()` is `static`, so it cannot be overridden.

It can be **hidden** in a child class.

---

# 18. Interview-Ready Answer

If interviewer asks:

### "What is the difference between method overloading and method overriding?"

Say:

> **“Method overloading means having multiple methods with the same name but different parameter lists, and it is compile-time polymorphism. Method overriding occurs when a child class provides its own implementation of a method inherited from the parent class with the same method signature, and it is runtime polymorphism. Overriding requires inheritance, while overloading does not.”**

---

# 19. Easy Memory Trick

Remember:

```text
OVERLOADING
↓
Same Class
Same Method Name
Different Parameters
Compile Time


OVERRIDING
↓
Parent → Child
Same Method Signature
Different Implementation
Runtime
```

### One-line shortcut:

> **Overloading = Same name, different input.**

> **Overriding = Same method, different implementation.**

---

# 20. Most Important Interview Traps

Remember these:

1. **Return type alone cannot overload a method.**
2. **Overloading does not require inheritance.**
3. **Overriding requires inheritance.**
4. **Static methods cannot be overridden; they are hidden.**
5. **Private methods cannot be overridden.**
6. **Final methods cannot be overridden.**
7. **Constructors cannot be overridden.**
8. **Use `@Override` annotation when overriding.**
9. **Overloading → Compile-time polymorphism.**
10. **Overriding → Runtime polymorphism.**
