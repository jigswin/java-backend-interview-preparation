# AWS Q12 — SQS

## SQS kya hai?

SQS = Simple Queue Service

Ye AWS ki managed message queue service hai.

Simple:

Producer → Queue → Consumer


## Real Example

Order Service ko order process karna hai.

Order Service
↓
SQS Queue
↓
Inventory Service


Order Service message queue me daal deta hai
aur consumer baad me process kar sakta hai.


## Benefit

Producer aur Consumer directly tightly coupled
nahi hote.

Agar Inventory Service temporarily down hai:

Order Service
↓
SQS
↓
Message Queue me wait karega


Consumer recover hone ke baad message process kar sakta hai.


## Real E-commerce Example

Order Created
↓
SQS
↓
Inventory Service
↓
Stock Update

Same concept notification/payment jaise
asynchronous workflows me bhi use ho sakta hai.


## SQS vs Kafka

SQS:
→ AWS managed queue
→ Simple async messaging
→ Consumer processing ke liye useful
→ AWS ecosystem ke saath easy integration


Kafka:
→ Distributed event streaming platform
→ Events persist hote hain
→ Replay possible
→ High-throughput event streaming
→ Consumer groups


Simple:

SQS
→ "Kaam queue me daalo, consumer process kare."


Kafka
→ "Events ko stream/store karo, consumers process/replay kar sakte hain."


## Interview Answer

"Amazon SQS is a managed message queuing service used for asynchronous communication between components or microservices. It helps decouple producers and consumers and can buffer messages when the consumer is temporarily unavailable."


## Easy Memory

Producer
↓
SQS
↓
Consumer


SQS
→ Queue


Kafka
→ Event Streaming



## 🧠 Real project me:
Order Service
↓
SQS
↓
Inventory Service


     ↓
Notification Service

Important: SQS aur Kafka same cheez nahi hain, although dono asynchronous communication ke use cases me aa sakte hain.