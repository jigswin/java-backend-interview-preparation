# Microservices — Q14: Database per Service

## Kya hai?

Database per Service ka matlab:

> Har microservice apne data ka ownership rakhti hai
> aur ideally apna separate database/schema use karti hai.

## Real Example

E-commerce:

Order Service
    ↓
Order DB

Payment Service
    ↓
Payment DB

Inventory Service
    ↓
Inventory DB


## ❌ Common Database Approach

Order Service ──┐
Payment Service ─┼──→ One Common DB
Inventory Service ─┘


Problem:

Agar Payment Service directly Order ke tables access kare:

→ Tight coupling
→ Services independent nahi rahengi
→ Schema change ka impact multiple services par padega.


## ✅ Database per Service

Order Service
    ↓
Order DB

Payment Service
    ↓
Payment DB

Inventory Service
    ↓
Inventory DB


Har service apne data ki owner hai.


## Real Example

Order Service:

Order DB
→ orders
→ order_items


Payment Service:

Payment DB
→ payments
→ transactions


Inventory Service:

Inventory DB
→ products_stock
→ warehouses


Payment Service ko Order DB ki table directly access nahi karni chahiye.


## Agar Order ko Payment ka status chahiye?

Direct Payment DB query ❌

Instead:

Order Service
      ↓
Payment Service
      ↓
API / Event
      ↓
Payment Status


## Benefit

- Loose coupling
- Independent deployment
- Independent scaling
- Data ownership clear
- Different databases use kar sakte hain


Example:

Order → MySQL
Payment → PostgreSQL
Inventory → MongoDB

Ye possible hai.


## Important Interview Point

"Database per service" ka matlab necessarily **har service ke liye separate physical database server** compulsory nahi hai.

Separate database/schema aur strict ownership bhi architecture ke according use ki ja sakti hai.


## Interview Answer

"Database per Service means each microservice owns and manages its own data store. Other services should not directly access its database; they communicate through APIs or events."


## Easy Memory

Service
   ↓
Own Data
   ↓
Own DB/Schema

❌ Service A → Service B DB direct access

✅ Service A → API/Event → Service B