# Spring Boot — Q42: What is AOP?

## AOP kya hai?

AOP = Aspect-Oriented Programming

AOP ka use **common/cross-cutting logic** ko business logic se separate rakhne ke liye hota hai.

## Common Examples

- Logging
- Security
- Transaction Management
- Performance Monitoring
- Auditing


## Problem Without AOP

Har method me manually logging:

public void createEmployee() {

    System.out.println("Method started");

    // business logic

    System.out.println("Method completed");
}


Multiple methods me same code repeat hoga.


## AOP ke saath

@Aspect
class LoggingAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void log() {
        System.out.println("Method called");
    }
}


Ab service methods ke around logging centrally handle ho sakti hai.


## Important Terms

Aspect
→ Cross-cutting logic


Advice
→ Kab aur kya logic execute karna hai


Join Point
→ Execution ka point, e.g. method execution


Pointcut
→ Kin methods par Advice apply karni hai


## Interview Answer

"AOP is used to separate cross-cutting concerns such as logging, security and transaction management from the core business logic. It allows us to apply common behavior to multiple methods without duplicating code."


## Easy Memory

AOP
→ Common logic ko separate karo

Example:

Business Logic
+
Logging
+
Security
+
Transaction

AOP
→ In common concerns ko separately manage karne me help karta hai.