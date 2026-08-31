# KAFKA — Q14: Kafka Transactions & Exactly-Once Semantics

## 1. Problem samjho

Maan le Order Service ko:

1. Kafka me event publish karna hai
2. Multiple Kafka records ko safely process karna hai

Problem:

Kafka message publish ho gaya
      ↓
Second operation fail ❌

To system inconsistent state me ja sakta hai.


## 2. Kafka Transaction kya hai?

Kafka transaction multiple Kafka operations ko
ek atomic unit ki tarah handle kar sakta hai.

Simple:

Operation A
+
Operation B
+
Operation C

      ↓

Transaction

      ↓

ALL SUCCESS ✅

ya

ALL ABORTED ❌


## 3. Real-World Example

Suppose Order Service ko:

OrderCreated
PaymentInitiated

events publish karne hain.


Without Transaction:

OrderCreated → SUCCESS ✅

PaymentInitiated → FAIL ❌


Ab partial result ho gaya.


With Kafka Transaction:

START TRANSACTION
      ↓
OrderCreated
      ↓
PaymentInitiated
      ↓
COMMIT
      ↓
Both visible


Agar failure:

START
 ↓
OrderCreated
 ↓
PaymentInitiated ❌
 ↓
ABORT
 ↓
Transaction rolled back


## 4. Exactly-Once Semantics (EOS)

Exactly-once ka goal hai:

Same Kafka processing ka duplicate effect
avoid karna.


Example:

Input:

OrderCreated(101)


Consumer:

Read Event
   ↓
Process
   ↓
Produce another Kafka Event


Exactly-once processing flow me Kafka transactions
input offset aur output records ko atomically
coordinate kar sakte hain, when the complete design
supports Kafka's EOS model.


## 5. Important Example

Input Topic:

order-created

      ↓

Consumer

      ↓

Process

      ↓

Output Topic:

inventory-update


Transactional flow:

Read Input
    ↓
Process
    ↓
Write Output
    ↓
Commit Consumer Offset
    +
Commit Output Record


Agar transaction fail:

→ Output record visible nahi hona chahiye
according to transactional read semantics
→ Offset commit bhi transactionally handle ho sakta hai


## 6. `transactional.id`

Kafka producer transactions ke liye
transactional identity configure ki ja sakti hai.

Example concept:

transactional.id = order-service-transactional


Ye producer transaction support ka part hai.


## 7. `enable.idempotence`

Producer idempotence:

enable.idempotence=true


Iska purpose producer retries ke case me
duplicate records ka risk reduce karna hai.


Important:

Idempotence ≠ Full Exactly Once


Idempotence producer side protection hai.

Exactly-once processing broader transactional
workflow hai.


## 8. Payment Example

Suppose:

Payment Service
      ↓
Kafka Transaction
      ↓
PaymentProcessed
      ↓
Order Service


Agar transactional workflow me:

Payment event publish
+
related Kafka processing
+
offset handling


successfully commit hota hai,
to Kafka-level exactly-once processing semantics
achieve ki ja sakti hain when configured correctly.


## 9. Important Limitation

Exactly-once Kafka ke andar supported workflow ke
context me samajhna chahiye.

Agar consumer:

Kafka
  ↓
External REST API
  ↓
Bank Payment System


to Kafka transaction automatically external bank
transaction ko rollback nahi kar sakta.


Example:

Kafka transaction
      ↓
Bank API
      ↓
₹100 deducted


Uske baad Kafka transaction rollback ho gaya:

Kafka → Rollback
Bank → ₹100 already deducted


Isliye external systems ke liye:

→ Idempotency
→ Unique transaction ID
→ Business-level compensation

jaise mechanisms important hote hain.


## 10. At-Least-Once vs Exactly-Once

At-Least-Once:

Message duplicate ho sakta hai
→ Consumer idempotent hona chahiye


Exactly-Once:

Kafka-supported transactional processing me
duplicate processing effects ko prevent karne ki
stronger guarantee.


## 11. Real-World Architecture

Input Topic
     ↓
Consumer
     ↓
Transaction
     ↓
Business Processing
     ↓
Output Topic
     +
Offset Commit
     ↓
COMMIT


Failure:

Transaction
     ↓
ABORT
     ↓
Retry / Recovery


## 12. Interview Answer

"Kafka transactions allow multiple Kafka operations to be committed atomically. Kafka's exactly-once semantics can coordinate consumed offsets and produced records within a transactional processing workflow. However, Kafka transactions do not automatically make external database or third-party API operations exactly once, so external side effects still require idempotency or other consistency mechanisms."


## Easy Memory

Idempotence
→ Retry duplicate risk reduce


Transaction
→ Multiple Kafka operations together


Exactly Once
→ Kafka transactional processing workflow
   with stronger processing guarantees


External API
→ Kafka transaction alone is NOT enough