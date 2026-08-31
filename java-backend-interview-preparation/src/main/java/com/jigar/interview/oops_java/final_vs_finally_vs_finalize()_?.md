# Q6 — final, finally, and finalize() in Java

## 1. Simple Explanation

Java me `final`, `finally`, aur `finalize()` teen alag concepts hain.

Naam similar hai, lekin kaam completely different hai.

Easy trick:

final
→ Restriction lagata hai

finally
→ Exception handling me block ko execute karne ke liye

finalize()
→ Old Java me Garbage Collector se related method tha; modern Java me deprecated hai aur use nahi karna chahiye.


# 2. What is final?

`final` ek keyword hai.

Iska use variable, method aur class ke saath kiya ja sakta hai.

## A. final variable

Agar variable ko `final` bana diya, to uski value dobara assign nahi kar sakte.

Example:

final int MAX = 100;

MAX = 200;   // Compile-time error

So:

final variable
→ Value cannot be reassigned


## B. final method

Agar method ko `final` bana diya, to child class us method ko override nahi kar sakti.

Example:

class Parent {

    final void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    // Compile-time error
    // Cannot override final method

    void show() {
        System.out.println("Child");
    }
}


Important:

final method
→ Cannot be overridden


## C. final class

Agar class ko `final` bana diya, to us class ko extend nahi kar sakte.

Example:

final class Vehicle {

}

class Car extends Vehicle {

    // Compile-time error
}


Important:

final class
→ Cannot be inherited


# 3. What is finally?

`finally` exception handling ka block hai.

Usually `try-catch` ke saath use hota hai.

Example:

try {
    System.out.println("Inside try");
}
catch (Exception e) {
    System.out.println("Exception occurred");
}
finally {
    System.out.println("Finally executed");
}

Output:

Inside try
Finally executed


`finally` ka main purpose hai:

> Important cleanup code ko execute karna.

Examples:

- Closing resources
- Closing connections
- Cleanup operations
- Releasing resources


# 4. Example with Exception

try {
    int result = 10 / 0;
    System.out.println(result);
}
catch (ArithmeticException e) {
    System.out.println("Exception occurred");
}
finally {
    System.out.println("Cleanup code");
}

Output:

Exception occurred
Cleanup code


Exception aane ke baad catch execute hua aur uske baad finally execute hua.


# 5. What if Exception nahi aaye?

try {
    int result = 10 / 2;
    System.out.println(result);
}
catch (Exception e) {
    System.out.println("Exception occurred");
}
finally {
    System.out.println("Finally executed");
}

Output:

5
Finally executed


So normally:

try
↓
catch (if exception)
↓
finally


# 6. What is finalize()?

`finalize()` Java ke old mechanism se related method tha jo Garbage Collector se related cleanup ke liye use kiya jata tha.

Conceptually:

Object becomes eligible for Garbage Collection
↓
Garbage Collector
↓
finalize() may be invoked in old Java behavior


Lekin important:

> `finalize()` deprecated hai aur modern Java applications me use nahi karna chahiye.

Isliye interview me ye point zaroor mention karna.


# 7. final vs finally vs finalize()

| Feature | final | finally | finalize() |
|---|---|---|---|
| Type | Keyword | Block | Method |
| Purpose | Restriction | Exception cleanup | Old GC-related mechanism |
| Used with | Variable, Method, Class | try/catch | Object |
| Override? | final method cannot be overridden | Not applicable | Old method mechanism |
| Modern usage | Yes | Yes | Avoid / deprecated |


# 8. Real-World Example

Suppose banking application me:

final:

final double INTEREST_RATE = 7.5;

Interest rate ko accidentally reassign nahi karna.

finally:

try {
    processPayment();
}
catch (Exception e) {
    handleError(e);
}
finally {
    closeConnection();
}

Payment successful ho ya exception aaye, cleanup karna hai.

finalize():

Old Java applications me object cleanup ke context me use hota tha, but modern Java me is approach ko avoid karna chahiye.


# 9. Important Interview Question

Q: Can we make a variable final?

Yes.

final int age = 25;


Q: Can we make a method final?

Yes.

final void display() {
}


Q: Can we make a class final?

Yes.

final class Employee {
}


Q: Can final method be overridden?

No.


Q: Can final class be extended?

No.


Q: Can finally exist without catch?

Yes.

Example:

try {
    System.out.println("Hello");
}
finally {
    System.out.println("Cleanup");
}

`try` ke saath `finally` directly use kar sakte hain.


# 10. Important Exception Case

Normally finally execute hota hai.

Lekin kuch exceptional situations me finally execute nahi ho sakta.

For example:

System.exit(0);

Example:

try {
    System.out.println("Try");
    System.exit(0);
}
finally {
    System.out.println("Finally");
}

Generally output:

Try

`System.exit(0)` JVM ko terminate kar deta hai.


# 11. Interview-Ready Answer

Question:
"What is the difference between final, finally and finalize()?"

Answer:

"`final` is a keyword used to restrict modification. A final variable cannot be reassigned, a final method cannot be overridden, and a final class cannot be extended.

`finally` is a block used with exception handling, generally for cleanup code that should execute after try/catch.

`finalize()` was an old Garbage Collection-related method, but it is deprecated in modern Java and should not be used for resource cleanup."


# 12. Easy Memory Trick

final
→ Restriction

finally
→ Exception cleanup

finalize()
→ Old GC-related mechanism


One-line trick:

final = Cannot change

finally = Cleanup after try/catch

finalize() = Old GC mechanism


# 13. Most Important Interview Points

1. `final` is a keyword.
2. `finally` is an exception-handling block.
3. `finalize()` is a method.
4. final variable cannot be reassigned.
5. final method cannot be overridden.
6. final class cannot be extended.
7. finally is generally used for cleanup.
8. finally can be used without catch.
9. finalize() is deprecated and should not be used for resource cleanup.
10. `System.exit()` can prevent finally from executing.


# QUICK REVISION

final variable
→ Cannot reassign

final method
→ Cannot override

final class
→ Cannot extend

finally
→ Cleanup block in exception handling

finalize()
→ Old GC-related method
→ Deprecated
→ Avoid using it