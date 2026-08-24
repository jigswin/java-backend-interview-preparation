# Microservices — Q11: What is Load Balancing?

## Load Balancing kya hai?

Load Balancing ka matlab hai incoming requests ko
**multiple service instances ke beech distribute karna**.

## Real Example

Payment Service ke 3 instances hain:

Payment-1
Payment-2
Payment-3


100 requests aayi:

        Load Balancer
             ↓
    ┌────────┼────────┐
    ↓        ↓        ↓
Payment-1 Payment-2 Payment-3


Requests different instances par distribute hongi.


## Iski zarurat kyu?

Agar sirf ek instance ho:

1000 Requests
      ↓
Payment-1
      ↓
Overload ❌


Multiple instances:

1000 Requests
      ↓
Load Balancer
   ↓   ↓   ↓
 P1  P2  P3

→ Load distribute ✅
→ Better performance
→ High availability


## Microservices me

Eureka
→ Available service instances discover karta hai.

Load Balancer
→ Available instances me request distribute karta hai.


Example:

Order Service
      ↓
Payment Service
      ↓
Eureka
      ↓
P1 / P2 / P3
      ↓
Load Balancer selects instance


## Real-World Example

Amazon jaisi application par ek saath bahut users
products access kar rahe hain.

Product Service ke multiple instances run ho sakte hain:

Product-1
Product-2
Product-3
Product-4

Load Balancer requests distribute karega.

## Interview Answer

"Load balancing distributes incoming requests across multiple instances of a service. It improves scalability, performance and availability by preventing a single instance from handling all the traffic."

## Easy Memory

Eureka
→ Service instances KAHAN hain?

Load Balancer
→ Request KIS instance ko deni hai?

Multiple Instances
→ Better Scalability + Availability