# Microservices — Q15: What is Distributed Transaction?

## Simple Meaning

Jab ek business operation ke liye **multiple microservices/databases**
me changes karne padte hain, to usse distributed transaction kehte hain.

## Real Example

E-commerce me Order place karna:

Order Service
→ Order create

Payment Service
→ Payment deduct

Inventory Service
→ Stock reduce


Flow:

Order DB
   ↓
Payment DB
   ↓
Inventory DB


Ab problem:

Order ✅
Payment ✅
Inventory ❌


Ab system inconsistent ho sakta hai.

Order create ho gaya,
payment bhi ho gaya,
but stock reduce nahi hua.


## Monolith me

Usually ek database transaction:

BEGIN
 ↓
Order
 ↓
Payment
 ↓
Inventory
 ↓
COMMIT

Agar kuch fail:

ROLLBACK

Sab changes rollback ho sakte hain.


## Microservices me

Order DB
Payment DB
Inventory DB

Alag databases hain.

Ek simple `@Transactional` normally
in sab independent databases ko automatically
single atomic transaction nahi bana deta.


## Is Problem ko kaise solve kare?

Microservices me commonly:

### Saga Pattern

Use karte hain.

Example:

Order Created
    ↓
Payment Successful
    ↓
Inventory Failed ❌
    ↓
Compensating Action
    ↓
Payment Refund
    ↓
Order Cancel


Isse distributed operation ko business level par
consistent rakha ja sakta hai.


## Distributed Transaction ke Challenges

- Multiple databases
- Network failures
- Partial failures
- Data consistency
- Rollback difficult


## Important

Distributed transaction ka goal:

> Multiple services ke beech ek business operation ko
> consistent rakhna.


## Interview Answer

"A distributed transaction is a business transaction that involves multiple services or databases. Since each microservice usually owns its own database, maintaining consistency across them is challenging. Patterns such as Saga are commonly used to manage these distributed transactions."


## Easy Memory

One DB
→ @Transactional
→ Rollback relatively easy


Multiple Services + DBs
→ Distributed Transaction
→ Saga / Compensating Actions


Example:

Order ✅
Payment ✅
Inventory ❌

→ Refund Payment
→ Cancel Order