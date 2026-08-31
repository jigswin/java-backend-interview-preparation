# KAFKA — Q2: Kafka Architecture

## 1. Basic Architecture

Kafka ko simple way me aise samjho:

                KAFKA CLUSTER
        ┌─────────────────────────┐
        │                         │
        │   Broker 1              │
        │   Broker 2              │
        │   Broker 3              │
        │                         │
        └─────────────────────────┘
                  ↑
                  │
              Producers
                  │
                  ↓
               Topics
                  │
                  ↓
              Consumers


## 2. Kafka Cluster

Kafka cluster = multiple Kafka brokers ka group.

Example:

Kafka Cluster
   |
   ├── Broker 1
   ├── Broker 2
   └── Broker 3


Multiple brokers ka use:

→ Scalability
→ Fault tolerance
→ High availability


## 3. Broker

Broker ek Kafka server hai.

Broker ka main kaam:

→ Messages receive karna
→ Messages store karna
→ Consumers ko messages provide karna


Example:

Producer
   ↓
Broker 1
   ↓
Topic


## 4. Topic

Topic ek logical category hai jisme related messages
store hote hain.

Example:

order-created

payment-events

inventory-events


Producer:

Order Service
     ↓
order-created topic


## 5. Partition

Topic ko multiple partitions me divide kiya ja sakta hai.

Example:

order-created topic

 ├── Partition 0
 ├── Partition 1
 └── Partition 2


Partition Kafka ka important scalability mechanism hai.


## 6. Why Partitions?

Suppose:

1 million orders/day

Sirf ek partition:

Producer
   ↓
Partition 0
   ↓
Consumer


Processing limited ho sakti hai.


Multiple partitions:

              Topic
        ┌──────┼──────┐
        ↓      ↓      ↓
       P0     P1     P2
        ↓      ↓      ↓
       C1     C2     C3


Multiple consumers parallel processing kar sakte hain.


## 7. Consumer

Consumer topic ke messages read karta hai.

Example:

Notification Service
       ↓
Consumer
       ↓
order-created topic


## 8. Consumer Group

Consumers ko group me organize kar sakte hain.

Example:

notification-group

   Consumer 1
   Consumer 2
   Consumer 3


Agar topic me 3 partitions hain:

P0 → Consumer 1
P1 → Consumer 2
P2 → Consumer 3


Isse parallel processing possible hoti hai.


## 9. Important Rule

Consumer Group ke andar:

One partition → One consumer at a time


Agar:

3 Partitions
5 Consumers


To ek time par maximum 3 consumers actively
partitions consume karenge.

2 consumers idle reh sakte hain.


Agar:

3 Partitions
2 Consumers


To consumers multiple partitions handle kar sakte hain.


## 10. Complete Real-World Flow

Customer
   ↓
Order Service
   ↓
Producer
   ↓
Kafka Cluster
   ↓
order-created Topic
   ↓
┌───────────────┐
│ P0 │ P1 │ P2  │
└───────────────┘
   ↓    ↓    ↓
 Consumers
   ↓
Notification / Inventory / Analytics


## 11. Easy Memory

Cluster
→ Brokers ka group


Broker
→ Kafka Server


Topic
→ Message category


Partition
→ Topic ka parallel unit


Producer
→ Message bhejta hai


Consumer
→ Message padhta hai


Consumer Group
→ Consumers ka group


## Interview Answer

"Kafka follows a distributed architecture where a Kafka cluster contains
multiple brokers. Data is organized into topics, and topics are divided
into partitions for scalability and parallel processing. Producers
publish messages to topics, while consumers read messages using consumer
groups."