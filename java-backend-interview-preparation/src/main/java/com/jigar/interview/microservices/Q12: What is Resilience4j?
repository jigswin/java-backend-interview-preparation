# Microservices — Q12: What is Resilience4j?

## Resilience4j kya hai?

Resilience4j ek lightweight fault-tolerance library hai jo
microservices ko failures handle karne me help karti hai.

Common features:

→ Circuit Breaker
→ Retry
→ Rate Limiter
→ Time Limiter
→ Bulkhead


## Real Example

Order Service
      ↓
Payment Service

Payment Service DOWN ❌


Resilience4j:

Order
 ↓
Circuit Breaker
 ↓
Payment ❌
 ↓
Fallback


## Spring Boot Example

@CircuitBreaker(
    name = "paymentService",
    fallbackMethod = "paymentFallback"
)
public PaymentResponse makePayment() {

    return paymentClient.pay();
}


Fallback:

public PaymentResponse paymentFallback(
        Exception ex) {

    return new PaymentResponse(
        "Payment service temporarily unavailable"
    );
}


## Retry Example

@Retry(name = "paymentService")
public PaymentResponse makePayment() {

    return paymentClient.pay();
}


Temporary failure:

Attempt 1 ❌
   ↓
Attempt 2 ❌
   ↓
Attempt 3 ✅


## TimeLimiter

Agar service bahut time le rahi hai:

Payment Service
      ↓
5 seconds
      ↓
No response
      ↓
Timeout


## Main Features

CircuitBreaker
→ Repeated failures par calls stop


Retry
→ Failed request ko retry


RateLimiter
→ Requests ki limit


TimeLimiter
→ Maximum wait time


Bulkhead
→ Resources isolate karta hai


## Interview Answer

"Resilience4j is a fault-tolerance library commonly used with Spring Boot microservices. It provides mechanisms such as Circuit Breaker, Retry, Rate Limiter, Time Limiter and Bulkhead to make distributed systems more resilient."


## Easy Memory

Resilience4j
→ Service failure handle karne ka toolkit

Circuit Breaker
→ Calls stop

Retry
→ Again try

TimeLimiter
→ Wait limit

RateLimiter
→ Request limit

Bulkhead
→ Resource isolation