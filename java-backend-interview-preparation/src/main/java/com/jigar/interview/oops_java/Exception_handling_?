# Q7 — Exception Handling in Java

## 1. What is an Exception?

Exception ek unexpected situation hai jo program ke normal flow ko interrupt karti hai.

Example:

int a = 10;
int b = 0;

int result = a / b;

Yahan `10 / 0` possible nahi hai, isliye Java `ArithmeticException` throw karega.

Simple language:

Exception = Program run hote time aane wali problem jo normal execution ko disturb karti hai.


## 2. Why do we need Exception Handling?

Agar exception handle nahi karenge, to program terminate ho sakta hai.

Example:

int a = 10;
int b = 0;

System.out.println(a / b);

System.out.println("Program completed");

Output:

Exception in thread "main" java.lang.ArithmeticException: / by zero

"Program completed" execute nahi hoga.

Agar exception handle kar dein:

try {
    int result = 10 / 0;
    System.out.println(result);
}
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}

System.out.println("Program completed");

Output:

Cannot divide by zero
Program completed

So exception handling ka main purpose hai:

> Exception ko handle karke program ke normal flow ko maintain karna.


# 3. Main Keywords of Exception Handling

Java me mainly ye keywords use hote hain:

1. try
2. catch
3. finally
4. throw
5. throws


# 4. try

`try` block ke andar wo code likhte hain jahan exception aane ka possibility ho.

Example:

try {
    int result = 10 / 0;
}


# 5. catch

`catch` block exception ko handle karta hai.

Example:

try {
    int result = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}

Output:

Cannot divide by zero


# 6. finally

`finally` block generally cleanup ke liye use hota hai.

Example:

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


Important:

finally normally execute hota hai chahe exception aaye ya na aaye.


# 7. Complete try-catch-finally Example

try {
    int a = 10;
    int b = 0;

    int result = a / b;

    System.out.println(result);
}
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
finally {
    System.out.println("Cleanup completed");
}

Output:

Cannot divide by zero
Cleanup completed


# 8. What is throw?

`throw` ka use manually exception throw karne ke liye hota hai.

Example:

public void checkAge(int age) {

    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18 or above");
    }

    System.out.println("Eligible");
}


Calling:

checkAge(15);

Output:

Exception in thread "main" java.lang.IllegalArgumentException:
Age must be 18 or above


Simple:

throw
→ Exception manually throw karna.


# 9. What is throws?

`throws` method declaration me use hota hai.

Ye indicate karta hai ki method kuch checked exceptions throw kar sakta hai.

Example:

public void readFile() throws IOException {

    FileReader file = new FileReader("data.txt");

}


Calling method ko exception handle ya further declare karna padega.

Simple:

throws
→ Method declare karta hai ki ye exception propagate kar sakta hai.


# 10. throw vs throws

throw:

- Exception manually throw karta hai.
- Method ke andar use hota hai.
- Ek specific exception object throw karte hain.

Example:

throw new IllegalArgumentException("Invalid age");


throws:

- Method declaration me use hota hai.
- Batata hai ki method kaunsi exception throw/propagate kar sakta hai.

Example:

public void readFile() throws IOException {
}


Easy trick:

throw
→ Throw the exception

throws
→ Declares the exception


# 11. Checked Exception

Checked exceptions ko compiler compile-time par check karta hai.

Example:

IOException
SQLException
FileNotFoundException

Example:

public void readFile() throws IOException {

    FileReader file = new FileReader("data.txt");

}

Yahan compiler require karega ki exception handle karo ya `throws` se declare karo.


# 12. Unchecked Exception

Unchecked exceptions runtime par occur hoti hain.

Ye generally `RuntimeException` ke subclasses hoti hain.

Examples:

ArithmeticException
NullPointerException
ArrayIndexOutOfBoundsException
IllegalArgumentException

Example:

int a = 10;
int b = 0;

System.out.println(a / b);

Runtime par:

ArithmeticException


# 13. Checked vs Unchecked Exception

Checked Exception:

- Compile-time checking
- Compiler handling/propagation require karta hai
- Example: IOException, SQLException

Unchecked Exception:

- Runtime par occur hoti hai
- RuntimeException ke subclasses
- Example: NullPointerException, ArithmeticException


# 14. Exception Hierarchy

Basic hierarchy:

Throwable
    |
    |--- Error
    |
    |--- Exception
          |
          |--- RuntimeException


Important:

Error aur Exception same nahi hain.

Error generally serious JVM/system-level problems ko represent karta hai.

Examples:

OutOfMemoryError
StackOverflowError


Exception generally application-level problems ko represent karti hai jo handle ki ja sakti hain.


# 15. Multiple catch Blocks

Ek try ke saath multiple catch blocks ho sakte hain.

Example:

try {

    int[] numbers = {10, 20, 30};

    System.out.println(numbers[5]);

}
catch (ArithmeticException e) {

    System.out.println("Arithmetic problem");

}
catch (ArrayIndexOutOfBoundsException e) {

    System.out.println("Invalid array index");

}
catch (Exception e) {

    System.out.println("Some other exception");

}


Important:

Specific exception pehle aur generic exception baad me.

Correct:

catch (ArithmeticException e) {
}
catch (Exception e) {
}


Wrong:

catch (Exception e) {
}
catch (ArithmeticException e) {
}

Because `Exception` parent hai aur wo already ArithmeticException ko cover kar lega.


# 16. try-catch with Multiple Exceptions

Modern Java me multiple exception types ko ek catch me handle kar sakte hain.

Example:

try {

    // code

}
catch (ArithmeticException | NullPointerException e) {

    System.out.println("Exception occurred");

}


Isko multi-catch kehte hain.


# 17. Custom Exception

Hum apni custom exception bhi create kar sakte hain.

Example:

class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}


Use:

public void checkAge(int age) throws InvalidAgeException {

    if (age < 18) {
        throw new InvalidAgeException("Age must be 18 or above");
    }

    System.out.println("Eligible");
}


Calling:

try {

    checkAge(15);

}
catch (InvalidAgeException e) {

    System.out.println(e.getMessage());

}


Output:

Age must be 18 or above


# 18. Real-World Example

Suppose banking application me payment process ho raha hai.

try {

    processPayment();

}
catch (PaymentException e) {

    System.out.println("Payment failed");

}
finally {

    closeConnection();

}


Flow:

Payment process
      ↓
Exception?
   /       \
 Yes       No
 ↓          ↓
catch      continue
   \        /
    finally
       ↓
 cleanup


# 19. Spring Boot me Exception Handling

Spring Boot applications me commonly:

@ControllerAdvice
@ExceptionHandler

use kiya jata hai.

Example:

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(
            ResourceNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}


Isse application ke exceptions ko centralized way me handle kar sakte hain.


# 20. Interview-Ready Answer

Question:
"What is exception handling in Java?"

Answer:

"Exception handling is a mechanism in Java used to handle runtime problems and maintain the normal flow of the application. Java provides try, catch, finally, throw and throws keywords for exception handling. We can use try-catch to handle exceptions, finally for cleanup, throw to explicitly throw an exception, and throws to declare exceptions at the method level."


# 21. Interview Follow-up Questions

Q: Difference between throw and throws?

A:
throw manually exception throw karta hai, while throws method declaration me exception declare karta hai.


Q: Difference between checked and unchecked exception?

A:
Checked exceptions are checked by compiler and generally must be handled or declared. Unchecked exceptions occur at runtime and are subclasses of RuntimeException.


Q: Can we have try without catch?

A:
Yes, try can be followed by finally without catch.

Example:

try {
    // code
}
finally {
    // cleanup
}


Q: Can we have catch without try?

A:
No.

catch must be associated with a try block.


Q: Can we have multiple catch blocks?

A:
Yes.


Q: Can finally be skipped?

A:
Normally finally executes, but situations like JVM termination using System.exit() can prevent it from executing.


# 22. Easy Memory Trick

try
→ Risky code

catch
→ Handle exception

finally
→ Cleanup

throw
→ Manually throw exception

throws
→ Declare/propagate exception


# 23. Most Important Interview Points

1. Exception disrupts normal program flow.
2. try contains risky code.
3. catch handles exception.
4. finally is generally used for cleanup.
5. throw manually throws an exception.
6. throws declares exceptions at method level.
7. Checked exceptions are checked by compiler.
8. Unchecked exceptions are RuntimeException subclasses.
9. Multiple catch blocks are allowed.
10. Specific catch should come before generic catch.
11. Custom exceptions can be created.
12. Spring Boot commonly uses @ExceptionHandler and @RestControllerAdvice for centralized exception handling.
13. Error and Exception are different.
14. RuntimeException is an unchecked exception.
15. finally normally executes whether exception occurs or not.
16. System.exit() can terminate JVM before finally executes.


# QUICK REVISION

try
= Risky code

catch
= Handle exception

finally
= Cleanup

throw
= Manually throw exception

throws
= Declare exception

Checked
= Compiler checks

Unchecked
= RuntimeException / runtime checking