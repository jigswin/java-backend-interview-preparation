# KAFKA — Q5: Replication & Fault Tolerance

## 1. Replication kya hoti hai?

Kafka partition ke data ki multiple copies
different brokers par rakh sakta hai.

In copies ko:

REPLICAS

kehte hain.


Example:

Kafka Cluster

Broker 1
Broker 2
Broker 3


Topic: order-created

Partition 0

Broker 1 → Replica
Broker 2 → Replica
Broker 3 → Replica


Agar ek broker fail ho jaye,
to doosri replica available ho sakti hai.


## 2. Replication Factor

Replication Factor batata hai ki ek partition ki
kitni replicas maintain hongi.

Example:

Replication Factor = 3


Partition 0:

Replica 1
Replica 2
Replica 3


Matlab partition ke data ki 3 copies.


## 3. Leader & Follower

Kafka partition ki replicas me:

1 Leader
Multiple Followers


Example:

Partition 0

Broker 1 → Leader
Broker 2 → Follower
Broker 3 → Follower


Producer normally partition ke leader ke through
data write karta hai.

Consumers bhi partition leader se data read karte hain
in standard Kafka behavior.


## 4. Leader ka role

Leader:

→ Writes handle karta hai
→ Reads serve karta hai


Followers:

→ Leader ke data ko replicate karte hain.


Example:

Producer
   ↓
Leader
   ↓
Followers


## 5. Broker Failure

Suppose:

Broker 1 = Leader

Broker 1 DOWN ❌


Kafka available follower replicas me se
ek ko new leader elect kar sakta hai,
provided it is eligible/in-sync according to Kafka's
replication rules.


Example:

Before:

B1 → Leader
B2 → Follower
B3 → Follower


B1 DOWN ❌


After:

B2 → New Leader
B3 → Follower


Application continue kar sakti hai,
assuming the cluster has sufficient healthy replicas.


## 6. ISR — In-Sync Replicas

ISR = In-Sync Replicas

Ye wo replicas hain jo leader ke data ke
saath sufficiently synchronized hain.


Example:

Partition 0:

Leader → B1
ISR → B1, B2, B3


Agar B3 bahut behind ho:

ISR → B1, B2


Kafka leader election aur durability behavior me
ISR important hota hai.


## 7. Real-World Example

E-commerce:

OrderCreated events important hain.

Agar sirf ek broker par data ho:

Broker 1
   ↓
Order events

Broker crash
   ↓
Data unavailable ❌


Replication:

           Kafka Cluster

      B1        B2        B3
      ↓         ↓         ↓
     P0        P0        P0
   Replica   Replica   Replica


B1 fail:

      B1 ❌

      B2        B3
      ↓         ↓
    Replica   Replica


Data availability improve hoti hai.


## 8. Replication ka benefit

→ Fault tolerance
→ High availability
→ Better durability
→ Broker failure se protection


## 9. Important Difference

Partition:

→ Data ko divide karta hai
→ Scalability / parallel processing


Replication:

→ Data ki copies maintain karta hai
→ Fault tolerance / availability


Example:

10 partitions
+
Replication Factor 3


→ 10 logical partitions
→ Each partition has 3 replicas


## 10. Interview Answer

"Kafka provides fault tolerance through partition replication. Each partition can have multiple replicas distributed across brokers. One replica acts as the leader and followers replicate the leader's data. If the leader fails, Kafka can elect an eligible in-sync replica as the new leader."


## Easy Memory

Partition
→ Divide data


Replication
→ Copy data


Leader
→ Main replica


Follower
→ Copy/replica


ISR
→ In-sync replicas


Leader fails
→ Eligible follower can become leader