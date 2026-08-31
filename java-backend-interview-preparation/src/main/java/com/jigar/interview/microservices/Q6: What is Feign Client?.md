# Microservices — Q6: What is Feign Client?

## Feign Client kya hai?

Feign Client ka use ek microservice se **dusri microservice ko REST API call** karne ke liye hota hai.

Simple:

Order Service
      ↓ Feign
Payment Service


## Without Feign

Manually HTTP request banana pad sakta hai:

→ URL
→ HTTP method
→ Headers
→ Request
→ Response handling

Code lengthy ho sakta hai.


## With Feign

Interface define karo:

@FeignClient(name = "payment-service")
public interface PaymentClient {

    @GetMapping("/payments/{id}")
    Payment getPayment(
        @PathVariable Long id
    );
}


Ab Service me:

Payment payment =
    paymentClient.getPayment(101L);


Bas.

Feign internally REST call handle karta hai.


## Eureka ke saath

@FeignClient(name = "payment-service")

Yahan service name important hai.

Flow:

Order Service
    ↓
Feign Client
    ↓
Eureka
    ↓
Payment Service instance
    ↓
Response


Order Service ko Payment Service ka
hard-coded IP maintain nahi karna padta.


## Real Example

Order Service ko payment status chahiye:

Order Service
      ↓
paymentClient.getPayment(101)
      ↓
Eureka se Payment Service
      ↓
Payment Service
      ↓
Payment Status
      ↓
Order Service


## Feign ka Benefit

- Less boilerplate code
- REST calls easy
- Service name se communication
- Eureka ke saath easily integrate
- Readable code


## Interview Answer

"Feign Client is a declarative HTTP client used for communication between microservices. Instead of manually writing HTTP client code, we define an interface with annotations, and Feign handles the REST communication."


## Easy Memory

REST call manually
→ More code ❌

Feign
→ Interface + annotations
→ REST call automatically handle ✅


Eureka
→ Service kaha hai?


Feign
→ Service ko call kaise karna hai?