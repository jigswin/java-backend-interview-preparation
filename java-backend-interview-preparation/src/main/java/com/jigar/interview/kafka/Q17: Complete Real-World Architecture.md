# KAFKA — Q17: Complete Real-World Architecture

## 1. Real-World E-Commerce Scenario

Suppose hamari e-commerce application hai.

Customer order place karta hai:

Customer
   ↓
Order Service
   ↓
Order Created


Ab Order Service ko multiple services ko
inform karna hai:

→ Inventory
→ Payment
→ Notification
→ Analytics


Hum synchronous REST calls se bhi kar sakte hain,
but event-driven architecture me Kafka use kar sakte hain.


## 2. Complete Flow

Customer
   ↓
Order Service
   ↓
Kafka Producer
   ↓
KafkaTemplate
   ↓
Kafka Cluster
   ↓
order-created Topic
   ↓
Partitions
   ↓
Consumer Groups


                 order-created
                       |
          ┌────────────┼────────────┐
          ↓            ↓            ↓
    inventory-group payment-group notification-group
          ↓            ↓            ↓
     Inventory       Payment      Notification
       Service        Service        Service


Analytics ke liye:

analytics-group
      ↓
Analytics Service


## 3. Producer Side

Order Service:

OrderCreatedEvent event =
    new OrderCreatedEvent(
        orderId,
        customerId,
        amount
    );


KafkaTemplate:

kafkaTemplate.send(
    "order-created",
    orderId.toString(),
    event
);


Yaha:

Topic = order-created

Key = orderId

Value = OrderCreatedEvent


## 4. Partitioning

Suppose:

Topic:
order-created

Partitions:

P0
P1
P2


Key:

orderId


Kafka key ke basis par partition choose kar sakta hai.

Example:

Order 101 → P0
Order 102 → P2
Order 103 → P1


Same order ke related events ke liye
same key use karne se same partition routing
aur partition-level ordering maintain karne me help milti hai.


## 5. Consumer Groups

Inventory:

inventory-group


Payment:

payment-group


Notification:

notification-group


Analytics:

analytics-group


Same event ko different groups independently
consume kar sakte hain.


## 6. Consumer Processing

Inventory:

@KafkaListener(
    topics = "order-created",
    groupId = "inventory-group"
)
public void consume(OrderCreatedEvent event) {

    inventoryService.reserveStock(
        event.getOrderId()
    );
}


Payment:

@KafkaListener(
    topics = "order-created",
    groupId = "payment-group"
)
public void consume(OrderCreatedEvent event) {

    paymentService.processPayment(
        event
    );
}


Notification:

@KafkaListener(
    topics = "order-created",
    groupId = "notification-group"
)
public void consume(OrderCreatedEvent event) {

    notificationService.sendOrderConfirmation(
        event
    );
}


## 7. Failure Handling

Suppose:

Inventory Service
       ↓
Processing
       ↓
Database Error ❌


Flow:

Consumer
   ↓
Error Handler
   ↓
Retry
   ↓
Retry
   ↓
Still Failed
   ↓
DLT


Example:

order-created.DLT


Failed message ko later investigate/reprocess
kiya ja sakta hai.


## 8. Consumer Lag

Suppose:

Kafka incoming:
1000 messages/minute

Consumer processing:
600 messages/minute


Then:

Consumer Lag ↑


Monitoring:

Kafka
 ↓
Consumer Group
 ↓
Lag
 ↓
Alert


Solution depends on root cause:

→ More consumers
→ Optimize code
→ Optimize DB
→ Batch processing
→ Increase partitions if appropriate


## 9. Broker Failure

Suppose:

Kafka Cluster:

Broker 1
Broker 2
Broker 3


Partition:

P0

B1 → Leader
B2 → Follower
B3 → Follower


B1 fails:

B1 ❌

Eligible in-sync replica can become
new leader.


Replication se:

→ High availability
→ Fault tolerance
→ Better durability


## 10. Duplicate Message

Suppose:

Consumer:

Read event
   ↓
DB update ✅
   ↓
Offset commit ❌
   ↓
Consumer restart
   ↓
Same event again


Solution:

Idempotent Consumer


Example:

eventId = E1001


Check:

Already processed?
     |
     ├── YES → Ignore
     |
     └── NO  → Process
                ↓
              Save ID


## 11. Ordering

Suppose:

Order 101:

OrderCreated
PaymentCompleted
OrderShipped


Key:

orderId = 101


Same key
    ↓
Same partition
    ↓
Ordering within partition


Important:

Kafka global topic ordering guarantee nahi deta.


## 12. Producer Reliability

Important settings/concepts:

acks=all

enable.idempotence=true

appropriate retries


Purpose:

→ Better delivery reliability
→ Retry handling
→ Duplicate risk reduction


## 13. Complete Architecture

                         CUSTOMER
                            |
                            ↓
                       ORDER SERVICE
                            |
                            ↓
                       KafkaTemplate
                            |
                            ↓
                     KAFKA PRODUCER
                            |
                            ↓
                    ┌───────────────┐
                    │ Kafka Cluster  │
                    │               │
                    │ Broker 1      │
                    │ Broker 2      │
                    │ Broker 3      │
                    └───────┬───────┘
                            |
                            ↓
                    order-created
                         TOPIC
                            |
                ┌───────────┼───────────┐
                ↓           ↓           ↓
              P0           P1          P2
                |           |           |
                └───────────┼───────────┘
                            |
          ┌─────────────────┼──────────────────┐
          ↓                 ↓                  ↓
    Inventory Group   Payment Group     Notification Group
          ↓                 ↓                  ↓
    Inventory Service Payment Service Notification Service


## 14. Interview Scenario

Question:

"Explain how you would use Kafka in an e-commerce
microservices architecture."


Answer:

"I would use Kafka as an event backbone between loosely coupled services. When an order is created, the Order Service publishes an OrderCreated event to a Kafka topic. Inventory, Payment, Notification and Analytics services can consume that event using separate consumer groups. I would use a meaningful key such as orderId when ordering for an order is required, configure appropriate producer reliability settings, monitor consumer lag, handle failures with retries and DLT, and make consumers idempotent to safely handle duplicate delivery."


## 15. Most Important Kafka Concepts

Producer
→ Sends events


Kafka Broker
→ Stores and serves records


Topic
→ Logical event category


Partition
→ Parallelism + ordering boundary


Consumer
→ Reads events


Consumer Group
→ Parallel processing / independent consumption


Offset
→ Consumer progress position


Replication
→ Fault tolerance


Consumer Lag
→ Consumer kitna behind hai


DLT
→ Failed messages


Idempotency
→ Duplicate business effect prevent


Serialization
→ Object → bytes/data


Deserialization
→ bytes/data → object


## 16. Final Memory Diagram

PRODUCER
   ↓
KAFKA
   ↓
TOPIC
   ↓
PARTITIONS
   ↓
CONSUMER GROUP
   ↓
CONSUMER
   ↓
BUSINESS LOGIC


Failure:

FAIL
 ↓
RETRY
 ↓
DLT


Duplicate:

DUPLICATE
 ↓
IDEMPOTENCY CHECK
 ↓
IGNORE


Broker Failure:

LEADER FAIL
 ↓
ELIGIBLE REPLICA
 ↓
NEW LEADER


Slow Consumer:

LAG ↑
 ↓
MONITOR
 ↓
OPTIMIZE / SCALE


## FINAL INTERVIEW SUMMARY

Kafka is a distributed event streaming platform used for
high-throughput, scalable and fault-tolerant event-driven
communication.

Its core concepts are:

Topic
Partition
Producer
Consumer
Consumer Group
Offset
Replication

For production systems, also understand:

→ Consumer Lag
→ Retry & DLT
→ Idempotency
→ Ordering
→ Producer reliability
→ Transactions / exactly-once semantics
→ Serialization