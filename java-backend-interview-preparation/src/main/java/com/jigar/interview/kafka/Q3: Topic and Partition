# KAFKA — Q3: Topic and Partition

## 1. Topic kya hota hai?

Topic messages/events ki logical category hoti hai.

Example:

order-created

payment-success

inventory-updated


Producer message ko topic me bhejta hai.

Consumer topic se message read karta hai.


Example:

Order Service
      ↓
order-created Topic
      ↓
Notification Service


## 2. Partition kya hota hai?

Ek topic ko multiple partitions me divide kiya ja sakta hai.

Example:

order-created Topic

 ├── Partition 0
 ├── Partition 1
 └── Partition 2


## 3. Partitions ki zarurat kyu?

Suppose:

Daily Orders = 10 lakh


Agar:

Sirf 1 partition:

Producer
   ↓
P0
   ↓
Consumer


Processing limited ho sakti hai.


Multiple partitions:

Producer
    ↓
┌───── Topic ─────┐
│ P0 │ P1 │ P2 │
└────────────────┘
 ↓     ↓     ↓
C1    C2    C3


Ab parallel processing possible hai.


## 4. Message kis partition me jayega?

Kafka partition decide kar sakta hai:

### Without Key

Producer
    ↓
Random Partition

Order1 → P0
Order2 → P2
Order3 → P1


### With Key

Example:

CustomerId = 101

Kafka hash calculate karta hai:

hash(customerId)
      ↓
Partition


Same key ke messages same partition me ja sakte hain.


Example:

Customer 101:

Order1 → P1
Order2 → P1
Order3 → P1


## 5. Benefit of Key

Message order maintain ho sakta hai.

Example:

Order Created
Payment Done
Order Delivered

Sab same partition me rahenge.


## 6. Important Point

Ordering guarantee:

✅ Same Partition

❌ Entire Topic


Example:

P0:
Offset 0
Offset 1
Offset 2


Order maintained.


Different partitions:

P0 → Order A
P1 → Order B

Global order guarantee nahi hoti.


## 7. Offset

Partition ke andar har message ka ek unique number hota hai.

Example:

Partition 0:

Offset 0 → Order 101
Offset 1 → Order 102
Offset 2 → Order 103


Consumer offset track karta hai.


## 8. Real Project Example

Order Service:

CustomerId = 101

Producer
   ↓
order-created
   ↓
Partition 1
   ↓
Notification Consumer


Same customer ke events same partition me
rakhne se order maintain ho sakta hai.


## 9. Easy Memory

Topic
→ Message category


Partition
→ Parallel unit


Key
→ Same data same partition


Offset
→ Message number


## Interview Answer

"A Kafka topic is a logical category of messages. Topics are divided into partitions to enable scalability and parallel processing. Messages with the same key are generally routed to the same partition, which helps maintain ordering within that partition."