# KAFKA — BASIC NOTES

## 1. What is Kafka?

Apache Kafka is a distributed event streaming platform used for:

- Asynchronous communication
- Event-driven architecture
- Real-time data streaming
- Decoupling microservices


## 2. Real-World Example

E-commerce:

Order Service
      |
      | OrderCreated Event
      ↓
    Kafka
      |
      ├──→ Notification Service
      ├──→ Inventory Service
      └──→ Analytics Service


Order Service ko directly sabhi services ko call karne ki
zarurat nahi hoti.

Order Service → Producer
Kafka → Message Broker
Other Services → Consumers


## 3. Producer

Producer wo application/service hai jo Kafka me
message/event publish karta hai.

Example:

Order Service
     ↓
Producer
     ↓
Kafka Topic


## 4. Consumer

Consumer wo application/service hai jo Kafka topic se
messages read/process karta hai.

Example:

Kafka Topic
     ↓
Consumer
     ↓
Notification Service


## 5. Topic

Topic messages/events ki logical category hoti hai.

Example:

order-created
payment-success
payment-failed
inventory-updated


Producer message ko topic me publish karta hai
aur consumer topic se message consume karta hai.


## 6. Broker

Kafka Broker ek Kafka server hota hai.

Kafka cluster me multiple brokers ho sakte hain.

Example:

Kafka Cluster
 ├── Broker 1
 ├── Broker 2
 └── Broker 3


## 7. Partition

Ek Kafka topic ko multiple partitions me divide kiya
ja sakta hai.

Example:

order-created
 ├── Partition 0
 ├── Partition 1
 └── Partition 2


Partitions ka main purpose:

- Parallel processing
- Scalability
- Higher throughput


## 8. Offset

Offset ek partition ke andar message ka position/number hota hai.

Example:

Partition 0:

Offset 0 → Order 101
Offset 1 → Order 102
Offset 2 → Order 103


Consumer offset ke through track karta hai ki
kaunsa message process kiya hai.


## 9. Consumer Group

Multiple consumers ko ek group me organize kiya ja sakta hai.

Example:

Consumer Group:
notification-group

 ├── Consumer 1
 ├── Consumer 2
 └── Consumer 3


Ek partition ko ek consumer group ke andar
ek time par ek consumer process karta hai.

Isse processing parallel ho sakti hai.


## 10. Synchronous vs Kafka

REST:

Service A
   ↓
Service B
   ↓
Response

Service A response ka wait karti hai.


Kafka:

Service A
   ↓
Kafka
   ↓
Service B

Service A ko Service B ke immediate response ka
wait nahi karna padta.


## 11. Kafka ka Main Benefit

Microservices ko loosely coupled banane me help karta hai.

Example:

Order Service
    ↓
Kafka
    ↓
Notification Service

Notification Service temporarily down ho,
to event Kafka me available reh sakta hai aur
consumer recover hone ke baad process kar sakta hai
(configuration/retention ke according).


## 12. Important Kafka Components

Producer
→ Message publish karta hai

Topic
→ Messages ki category

Partition
→ Topic ka parallel unit

Offset
→ Message position

Consumer
→ Message consume karta hai

Consumer Group
→ Consumers ka logical group

Broker
→ Kafka server


## 13. Basic Flow

Producer
   ↓
Kafka Broker
   ↓
Topic
   ↓
Partition
   ↓
Consumer
   ↓
Business Logic


## Interview Answer

"Apache Kafka is a distributed event streaming platform commonly used
for asynchronous and event-driven communication between microservices.
Producers publish events to topics, and consumers read those events
from topics. Topics can have multiple partitions for scalability
and parallel processing."