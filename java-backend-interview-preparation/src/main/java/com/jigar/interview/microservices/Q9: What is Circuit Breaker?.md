# Microservices — Q9: What is Circuit Breaker?

## Problem

Maan le:

Order Service
      ↓
Payment Service


Payment Service DOWN ❌

Order Service continuously Payment Service ko call karti rahe:

Request
 ↓
Payment ❌
 ↓
Wait
 ↓
Timeout
 ↓
Retry
 ↓
Again Payment ❌


Aise bahut requests hone par Order Service ke threads/resources bhi consume
ho sakte hain.

Isko prevent karne ke liye Circuit Breaker use karte hain.


--------------------------------------------------
## Circuit Breaker kya karta hai?
--------------------------------------------------

Circuit Breaker temporarily failed service ko call karna stop kar deta hai.

Simple:

Payment Service DOWN
       ↓
Circuit Breaker
       ↓
Calls temporarily BLOCK
       ↓
Fallback response


--------------------------------------------------
## 3 States
--------------------------------------------------

### 1. CLOSED

Normal condition:

Order
 ↓
Circuit Breaker
 ↓
Payment ✅


Requests normally pass hoti hain.


### 2. OPEN

Payment repeatedly fail ho rahi hai:

Order
 ↓
Circuit Breaker
 ↓
Payment ❌


Failure threshold cross hone par:

Circuit → OPEN

Ab Payment Service ko calls nahi jayengi.

Instead:

Fallback


### 3. HALF_OPEN

Kuch time baad Circuit Breaker test request bhejta hai:

Circuit
 ↓
Test request
 ↓
Payment


Agar successful:

HALF_OPEN → CLOSED ✅


Agar fail:

HALF_OPEN → OPEN ❌


--------------------------------------------------
## Real-World Example
--------------------------------------------------

E-commerce:

Order Service
      ↓
Payment Service


Payment provider temporarily down.

Circuit Breaker:

Payment failures detect
        ↓
Circuit OPEN
        ↓
Payment calls stop
        ↓
Order Service fallback


Example fallback:

"Payment service temporarily unavailable.
Please try again."


Payment service recover:

OPEN
 ↓
HALF_OPEN
 ↓
Success
 ↓
CLOSED


--------------------------------------------------
## Spring Boot me
--------------------------------------------------

Modern Spring applications me commonly:

Resilience4j

use kiya jata hai.


Example:

@CircuitBreaker(
    name = "paymentService",
    fallbackMethod = "paymentFallback"
)
public PaymentResponse pay() {

    return paymentClient.pay();
}


Fallback:

public PaymentResponse paymentFallback(
        Exception ex) {

    return new PaymentResponse(
        "Payment service unavailable"
    );
}


--------------------------------------------------
## Interview Answer
--------------------------------------------------

"Circuit Breaker prevents repeated calls to a failing downstream service. When failures cross a configured threshold, the circuit opens and requests are stopped temporarily. After a wait period, it moves to half-open to test whether the service has recovered."


--------------------------------------------------
## Easy Memory
--------------------------------------------------

CLOSED
→ Normal


OPEN
→ Service failing → Calls stop


HALF_OPEN
→ Recovery check


CLOSED
→ Service recovered


Memory:

CLOSED → OPEN → HALF_OPEN → CLOSED