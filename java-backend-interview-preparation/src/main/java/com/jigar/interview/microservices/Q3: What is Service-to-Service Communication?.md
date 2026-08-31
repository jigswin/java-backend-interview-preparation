# Microservices — Q3: What is Service-to-Service Communication?

## Meaning

Microservices me ek service ko doosri service se data/action ke liye communicate karna padta hai.

Example:

Order Service
      ↓
Payment Service

Order create hone ke baad Payment Service ko call karna hai.


## 2 Main Types

### 1. Synchronous

Order Service
      ↓ REST / Feign
Payment Service
      ↓
Response
      ↓
Order Service continues

Order Service response ka wait karegi.


### 2. Asynchronous

Order Service
      ↓
Kafka
      ↓
Payment / Notification Service

Order Service ko immediate response ka wait nahi karna padta.


## Real Example

Order placed:

### Synchronous

Order Service
→ Payment Service ko REST call
→ Payment response
→ Order complete


### Asynchronous

Order Service
→ `OrderCreated` event Kafka me publish
→ Notification Service event consume
→ Email/SMS send


## Kab kya use kare?

REST / Feign
→ Jab immediate response required ho.


Kafka
→ Event-driven / background processing ke liye.


## Interview Answer

"Microservices can communicate synchronously using REST or Feign Client, where the caller waits for a response, or asynchronously using messaging systems like Kafka, where services communicate through events without requiring an immediate response."


## Easy Memory

REST / Feign
→ Request → Wait → Response


Kafka
→ Event → Continue