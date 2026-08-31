# KAFKA — Q15: Message Ordering & Idempotency

## 1. Kafka me Message Ordering

Kafka ordering ko **partition level par** guarantee karta hai.

Example:

Partition 0:

Offset 0 → Order Created
Offset 1 → Payment Done
Offset 2 → Order Shipped


Consumer in messages ko isi order me read kar sakta hai:

1 → Order Created
2 → Payment Done
3 → Order Shipped


## Important:

Kafka poore TOPIC ke liye global ordering guarantee nahi karta.

Example:

Topic:

order-events

P0:
Order A → Created
Order A → Paid

P1:
Order B → Created
Order B → Paid


P0 aur P1 ke messages ke beech global ordering
guaranteed nahi hoti.


## 2. Same Key ka use

Agar related events ko same partition me rakhna hai,
to same key use kar sakte hain.

Example:

Key = orderId


Order 101:

OrderCreated
PaymentCompleted
OrderShipped


Same key:

orderId = 101
       ↓
Same Partition


Isse us order ke events ka ordering
partition level par maintain ho sakta hai.


## 3. Real-World Example

Suppose:

OrderCreated
     ↓
PaymentCompleted
     ↓
OrderCancelled


Agar events alag partitions me chale gaye aur
consumer ko unexpected order me mil gaye,
business logic incorrect ho sakta hai.


Isliye related events ke liye appropriate key
choose karna important hai.


# 4. Idempotency kya hai?

Same message multiple times process ho,
phir bhi business operation ka final effect
duplicate nahi hona chahiye.

Example:

PaymentSuccess(P1001)


First time:

P1001 → Process
       ↓
Payment SUCCESS


Duplicate:

P1001 → Again received


Consumer:

Already processed?
      ↓
YES
      ↓
Ignore


Final:

Payment sirf ek baar apply hua.


# 5. Duplicate message kyu aa sakta hai?

Common scenario:

Consumer
   ↓
Process
   ↓
DB update SUCCESS ✅
   ↓
Offset commit FAIL ❌


Consumer restart/retry:

Same message
   ↓
Again received


Isliye duplicate handling important hai.


# 6. Idempotent Consumer kaise banaye?

### Option 1 — Unique Event ID

Event:

{
    "eventId": "E1001",
    "orderId": 101
}


Database:

processed_events

E1001


Consumer:

if event already exists
    → Ignore

else
    → Process
    → Save eventId


### Option 2 — Unique Database Constraint

Example:

payment_id UNIQUE


Agar same payment event dobara aaye:

First:
P1001 → Insert ✅


Duplicate:
P1001 → Constraint violation / already exists


Business duplicate effect prevent ho sakta hai.


## 7. Ordering + Idempotency Together

Real payment/order system:

Kafka
  ↓
Partition
  ↓
Consumer
  ↓
Idempotency Check
  ↓
Business Processing
  ↓
DB


Ordering:

Same orderId
→ Same partition


Idempotency:

Same eventId
→ Process only once


## 8. Important Trade-off

More partitions:

→ More parallelism
→ Better throughput


But:

→ Global ordering nahi milegi
→ Ordering requirements carefully design karni hongi.


Agar poore topic ka strict global order chahiye,
single partition approach use kar sakte hain,
but scalability/parallelism limited ho jayegi.


## 9. Interview Scenario

Question:

"How do you maintain ordering for order events in Kafka?"


Answer:

"I would use a meaningful key such as orderId so that events for the same order are routed to the same partition. Kafka preserves ordering within a partition, not across the entire topic."


Question:

"What if the same event is consumed twice?"


Answer:

"I would make the consumer idempotent by using a unique event ID or business transaction ID and a database constraint or processed-event record to prevent duplicate business effects."


## 10. Easy Memory

ORDERING:

Same Key
   ↓
Same Partition
   ↓
Ordered within partition


IDEMPOTENCY:

Same Event
   ↓
Check Event ID
   ↓
Already Processed?
   ├── YES → Ignore
   └── NO  → Process


## Interview Answer

"Kafka guarantees ordering within a partition. To preserve ordering for related events, we can use a consistent key such as orderId so those events are routed to the same partition. Because Kafka consumers may process a message more than once depending on the delivery and commit behavior, consumers should be designed to be idempotent using unique event IDs or business keys."