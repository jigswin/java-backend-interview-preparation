# KAFKA — Q11: Consumer Rebalancing & Partition Assignment

## 1. Partition Assignment kya hota hai?

Kafka ko decide karna hota hai ki Consumer Group ke
kaunse consumer ko kaunsi partition process karni hai.

Example:

Topic:
order-created

Partitions:
P0
P1
P2

Consumers:

C1
C2
C3


Assignment:

P0 → C1
P1 → C2
P2 → C3


Is process ko Partition Assignment kehte hain.


## 2. Rebalancing kya hota hai?

Jab Consumer Group ke members change hote hain,
Kafka partitions ko consumers ke beech dobara distribute karta hai.

Is process ko:

REBALANCING

kehte hain.


## 3. Consumer Join Example

Initially:

Consumers:
C1
C2

Partitions:
P0
P1
P2
P3


Assignment:

C1 → P0 + P1
C2 → P2 + P3


Ab C3 group me join karta hai:

C1 → P0 + P1
C2 → P2
C3 → P3


Kafka ne partitions redistribute ki:

→ REBALANCING


## 4. Consumer Failure Example

Initially:

C1 → P0
C2 → P1
C3 → P2


C2 crash ❌


Kafka detect karta hai ki C2 available nahi hai.

Rebalancing:

C1 → P0 + P1
C3 → P2


P1 kisi remaining consumer ko assign ho gaya.


## 5. Real-World Example

E-commerce:

Topic:
order-created

Partitions:
P0 P1 P2 P3


Notification Service ke paas:

C1
C2


C1 → P0 + P1
C2 → P2 + P3


Traffic badh gaya.

Naya consumer:

C3


Kafka:

C1 → P0
C2 → P2
C3 → P1 + P3


Exact assignment strategy ke according
distribution different ho sakta hai.


## 6. Why Rebalancing?

Main reasons:

→ Consumer group me new consumer join
→ Consumer group se consumer leave
→ Consumer crash
→ Consumer restart
→ Partition count change
→ Group membership changes


## 7. Rebalancing ka benefit

→ Work automatically redistribute
→ Fault tolerance
→ Consumer scaling
→ No manual partition assignment required


## 8. Important Limitation

Agar rebalancing repeatedly hoti rahe:

Consumer
   ↓
Rebalance
   ↓
Processing pause/coordination
   ↓
Rebalance again


To unnecessary overhead aur processing disruption ho sakta hai.

Isliye stable consumers aur appropriate configuration
important hai.


## 9. Consumer Group Rule

Suppose:

Partitions = 4
Consumers = 2


Possible:

C1 → P0 + P1
C2 → P2 + P3


Consumers = 4:

C1 → P0
C2 → P1
C3 → P2
C4 → P3


Consumers = 6:

C1 → P0
C2 → P1
C3 → P2
C4 → P3
C5 → Idle
C6 → Idle


Important:

Ek consumer group me ek partition ko ek time par
ek consumer process karta hai.


## 10. Interview Scenario

Question:

"What happens if a Kafka consumer crashes?"


Answer:

"Kafka detects that the consumer has left the group and
triggers a rebalance. Its assigned partitions are
redistributed among the remaining consumers in the group.
The new consumer assignments then continue processing
from the appropriate offsets."


## 11. Easy Memory

Consumer join
      ↓
Rebalance


Consumer crash
      ↓
Rebalance


Partitions
      ↓
Redistribute
      ↓
Consumers


## Interview Answer

"Consumer rebalancing is the process of redistributing topic partitions among consumers in a consumer group when group membership or partition assignments change. It provides scalability and fault tolerance, but frequent rebalances can temporarily affect processing."


## One-Line Memory

NEW consumer / FAILED consumer
        ↓
REBALANCE
        ↓
Partitions redistribute