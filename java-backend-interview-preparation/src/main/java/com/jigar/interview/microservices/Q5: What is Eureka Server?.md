# Microservices — Q5: What is Eureka Server?

## Eureka Server kya hai?

Eureka Server ek **Service Discovery Server** hai.

Ye registered microservices ki information maintain karta hai:

→ Service name
→ Host/IP
→ Port
→ Available instances


## Real Example

Hamare paas:

Order Service
Payment Service
Inventory Service


Sab Eureka me register:

Order Service
      ↓
     Eureka
      ↑
Payment Service


Inventory Service
      ↑
     Eureka


## Order → Payment Call

Order Service ko Payment ka IP nahi pata.

Order Service:

"Payment Service kaha hai?"


Eureka:

"Payment Service ke ye instances available hain."

Payment-1
Payment-2


Order Service
      ↓
Payment Service


## Eureka Architecture

                Eureka Server
                     |
          ┌──────────┼──────────┐
          ↓          ↓          ↓
       Order      Payment    Inventory
       Service     Service     Service


## Important Terms

### Eureka Server

→ Service registry maintain karta hai.


### Eureka Client

→ Service Eureka ke saath register/discover karne ke liye use hota hai.


Example:

Order Service
→ Eureka Client


Payment Service
→ Eureka Client


## Real-World Benefit

Suppose Payment Service:

Instance 1 → :8082
Instance 2 → :8083
Instance 3 → :8084


Eureka in sabko track kar sakta hai.

Agar ek instance down ho:

Payment-1 ❌

Available:

Payment-2 ✅
Payment-3 ✅


Client available instance use kar sakta hai.


## Interview Answer

"Eureka Server is a service registry used for service discovery in Spring Cloud. Microservices register themselves with Eureka, and other services can discover available instances through it."


## Easy Memory

Eureka Server
→ Registry


Service
→ Register


Client
→ Discover