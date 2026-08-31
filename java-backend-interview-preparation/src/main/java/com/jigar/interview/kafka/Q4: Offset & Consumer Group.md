# KAFKA — Q4: Offset & Consumer Group

## 1. Offset kya hota hai?

Offset ek partition ke andar message ka
unique sequential position/number hota hai.

Example:

Partition 0

Offset 0 → Order 101
Offset 1 → Order 102
Offset 2 → Order 103
Offset 3 → Order 104


Kafka consumer offset ke through track karta hai
ki usne kitne messages process kiye hain.


## 2. Real-World Example

Suppose Notification Service ne:

Offset 0 → Processed ✅
Offset 1 → Processed ✅
Offset 2 → Processed ✅
Offset 3 → Processing...


Agar consumer crash ho gaya,

Kafka ko pata hota hai consumer ka committed
offset kaha tak tha.

Consumer restart hone ke baad appropriate offset
se processing continue kar sakta hai,
consumer configuration/commit behavior ke according.


## 3. Offset Delete nahi karta

Important:

Offset ka matlab message delete karna nahi hai.

Kafka messages ko topic ki configured
retention policy ke according store karta hai.

Consumer ka offset alag cheez hai.


## 4. Consumer Group kya hota hai?

Consumer Group multiple consumers ka logical group hota hai
jo milkar topic consume karte hain.

Example:

notification-group

 ├── Consumer 1
 ├── Consumer 2
 └── Consumer 3


## 5. Partition + Consumer Group

Suppose:

Topic = order-created

Partitions = 3

Consumers = 3


P0 → Consumer 1
P1 → Consumer 2
P2 → Consumer 3


Teeno parallel processing kar sakte hain.


## 6. Agar Consumers zyada ho?

3 Partitions
5 Consumers

P0 → C1
P1 → C2
P2 → C3
       C4 → Idle
       C5 → Idle


Ek consumer group me ek partition ko
ek time par ek consumer hi consume karta hai.


## 7. Agar Consumers kam ho?

3 Partitions
2 Consumers


C1 → P0 + P1
C2 → P2


Ek consumer multiple partitions handle kar sakta hai.


## 8. Multiple Consumer Groups

Ye bahut important hai.

Suppose:

Topic:
order-created

Consumer Group 1:
notification-group

Consumer Group 2:
analytics-group


Flow:

                  order-created
                       ↓
              ┌────────┴────────┐
              ↓                 ↓
     notification-group   analytics-group
              ↓                 ↓
        Email/Notification   Analytics


Dono groups same event ko independently consume
kar sakte hain.


## 9. Real-World Example

Order Service:

OrderCreated Event
        ↓
       Kafka
        ↓
order-created
        ↓
 ┌───────────────┬────────────────┐
 ↓               ↓                ↓
Notification    Inventory       Analytics
 Group           Group            Group


Notification group:
→ Email send


Inventory group:
→ Stock update


Analytics group:
→ Data analysis


Same event multiple business purposes ke liye
use ho sakta hai.


## 10. Consumer Group ka main benefit

→ Parallel processing
→ Scalability
→ Multiple independent consumers
→ Fault tolerance / rebalancing support


## 11. Rebalancing

Agar consumer group me:

C1
C2
C3


Aur C2 crash ho gaya,

Kafka partitions ko remaining consumers ke
beech redistribute kar sakta hai.

Is process ko:

REBALANCING

kehte hain.


Example:

Before:

P0 → C1
P1 → C2
P2 → C3


C2 crashed:


After:

P0 → C1
P1 → C1
P2 → C3


Exact assignment Kafka ke group coordination
aur assignment strategy par depend karta hai.


## Easy Memory

Offset
→ Partition ke andar message position


Consumer Group
→ Consumers ka logical group


Partition
→ Work unit


Consumer Group + Partitions
→ Parallel processing


Multiple Groups
→ Same event ko multiple business systems consume kar sakte hain.


## Interview Answer

"An offset identifies a message's position within a Kafka partition. Consumers use offsets to track their progress. A consumer group is a group of consumers that collaboratively consumes partitions of a topic, allowing parallel processing and scalability. Kafka can rebalance partition assignments when group membership changes."