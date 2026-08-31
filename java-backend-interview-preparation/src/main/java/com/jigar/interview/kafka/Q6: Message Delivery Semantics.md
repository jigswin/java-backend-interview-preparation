# KAFKA — Q6: Message Delivery Semantics

Kafka me main 3 delivery semantics samajhne hain:

1. At Most Once
2. At Least Once
3. Exactly Once


# 1. At Most Once

Message:

→ Maximum ek baar process hoga.

Problem:

→ Message lost ho sakta hai.


Example:

Kafka
  ↓
Consumer

Consumer ne message receive kiya
  ↓
Offset commit kar diya
  ↓
Processing se pehle consumer crash ❌


Message dobara process nahi hoga.

Result:

Message Lost ❌


Use case:

Jahan occasional message loss acceptable ho.


# 2. At Least Once

Message:

→ Minimum ek baar process hoga.

Benefit:

→ Message loss avoid karne ki priority.


Problem:

→ Duplicate processing ho sakti hai.


Example:

Kafka
  ↓
Consumer
  ↓
Process Payment
  ↓
Consumer crash
  ↓
Offset commit nahi hua


Consumer restart:

Same message
  ↓
Again process


Result:

Message duplicate process ho sakta hai.


Payment example:

₹100 payment

First attempt → ₹100 deducted
Retry → ₹100 again deducted ❌


Isliye consumer ko idempotent banana important hai.


# 3. Exactly Once

Goal:

→ Message processing effectively exactly once semantics
provide kare, supported processing flow/configuration ke andar.


Example:

Order event

Kafka
  ↓
Consumer
  ↓
Process
  ↓
Commit


Duplicate processing avoid karne ke liye Kafka ke
transactional features aur end-to-end design important ho sakte hain.


# Important Comparison

At Most Once
→ No duplicate
→ Message loss possible


At Least Once
→ Message loss avoid karne ki priority
→ Duplicate possible


Exactly Once
→ Duplicate processing ko avoid karne ka stronger guarantee
→ More complex


# Real-World Payment Example

Suppose:

Payment Service
      ↓
Kafka
      ↓
Order Service


Payment event:

PaymentSuccess(orderId=101)


Consumer ko event process karna hai.


At Least Once:

Event repeat ho sakta hai.


Isliye:

if paymentAlreadyProcessed(orderId) {
    return;
}


Jaise business-level idempotency / unique constraint
duplicate effect ko prevent kar sakta hai.


# Idempotency

Idempotent operation ka matlab:

Same request multiple times execute karne par
final business result same rahe.


Example:

Payment ID = P1001


First message:

P1001 → Process → SUCCESS


Duplicate message:

P1001 → Already processed → Ignore


Final result:

Only one payment effect.


# Real-World Best Practice

Kafka me duplicate delivery ko assume karke
consumer logic ko idempotent design karna important hai.

Example:

Kafka Event
   ↓
Consumer
   ↓
Check Event/Payment ID
   ↓
Already processed?
   ├── YES → Ignore
   └── NO  → Process
             ↓
          Save status


# Easy Memory

At Most Once
→ "Loss ho sakta hai"


At Least Once
→ "Duplicate ho sakta hai"


Exactly Once
→ "Exactly-once processing semantics ka goal"


At Least Once + Idempotent Consumer
→ Very common practical approach


# Interview Answer

"Kafka supports different delivery semantics such as at-most-once, at-least-once, and exactly-once. At-most-once may lose messages, at-least-once can result in duplicates, and exactly-once provides stronger processing guarantees when the complete processing flow supports it. In real-world applications, idempotent consumers are commonly used to safely handle duplicate events."