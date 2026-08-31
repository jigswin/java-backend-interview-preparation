# Microservices — Q16: What is Saga Pattern?

## Saga Pattern kya hai?

Saga Pattern ka use **distributed transaction ko manage** karne ke liye hota hai.

Jab ek business operation multiple microservices me execute hota hai,
to Saga us operation ko **multiple local transactions** me divide karta hai.

Agar beech me koi step fail ho jaye,
to pehle successful steps ke liye **compensating actions** perform kiye jate hain.


## Real-World Example

E-commerce Order:

Order Service
     ↓
Payment Service
     ↓
Inventory Service


### Step 1

Order Service:

Order Created ✅


### Step 2

Payment Service:

Payment Successful ✅


### Step 3

Inventory Service:

Stock Update ❌


Ab problem:

Order create ho gaya
Payment bhi ho gaya
Stock update nahi hua


Saga:

Inventory failed
      ↓
Payment Refund
      ↓
Order Cancel


Ye "rollback" nahi hai.

Ye **compensating transaction** hai.


## Flow

Create Order
    ↓
Payment
    ↓
Reserve Inventory
    ↓
Success ✅


Agar Inventory fail:

Inventory ❌
    ↓
Refund Payment
    ↓
Cancel Order


## Saga ke 2 Common Approaches

### 1. Choreography

Services events ke through communicate karti hain.

Order Service
   ↓ Event
Payment Service
   ↓ Event
Inventory Service


Central controller nahi hota.

Kafka jaise message broker ke saath commonly use kiya ja sakta hai.


### 2. Orchestration

Ek central Saga Orchestrator decide karta hai
ki next service ko kya karna hai.

        Saga Orchestrator
        /       |       \
       ↓        ↓        ↓
    Order    Payment  Inventory


Orchestrator:

"Order create karo"

→ "Payment karo"

→ "Inventory reserve karo"

Agar Inventory fail:

→ "Payment refund karo"

→ "Order cancel karo"


## Choreography vs Orchestration

Choreography
→ No central coordinator
→ Events


Orchestration
→ Central coordinator
→ Commands


## Interview Answer

"Saga Pattern manages distributed transactions by breaking them into a sequence of local transactions across services. If a step fails, compensating transactions are executed to undo the business effects of previously completed steps."


## Very Important

Saga ka rollback:

❌ Database-level rollback nahi

✅ Business-level compensation


Example:

Payment successful
→ Inventory failed

Rollback nahi:

"Payment DB ko rollback karo"

Instead:

"Payment ka REFUND karo"


## Easy Memory

Order
 ↓
Payment
 ↓
Inventory ❌
 ↓
Refund Payment
 ↓
Cancel Order

Saga
→ Local Transactions + Compensating Actions