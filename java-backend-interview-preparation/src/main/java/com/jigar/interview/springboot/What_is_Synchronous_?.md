# What is Synchronous?

Synchronous ka matlab:

> Caller request bhejta hai aur response aane tak wait karta hai.

## Simple Flow

Service A
   ↓ request
Service B
   ↓
Process
   ↓
Response
   ↓
Service A continues


## Real Example

Order Service → Payment Service

Order Service:
"Payment karo."

Payment Service:
→ Payment process karta hai
→ Response deta hai

Jab tak Payment Service response nahi deta,
Order Service wait karegi.

## Example

Order Service
      ↓
POST /payment
      ↓
Payment Service
      ↓
Payment successful
      ↓
Response
      ↓
Order Service continues


## Synchronous vs Asynchronous

Synchronous
→ Wait for response

Asynchronous
→ Request bhejo, wait zaroori nahi


## Real-Life Example

Synchronous:
→ Phone call 📞
→ Dusra person answer karega tab baat hogi.

Asynchronous:
→ WhatsApp message 📱
→ Message bhejo, reply ka wait nahi karna.


## Interview Answer

"Synchronous communication means the caller sends a request and waits for the response before continuing its execution."


## Easy Memory

SYNC
→ Send → WAIT → Response


ASYNC
→ Send → Continue