# Redis Q13 — Redis Pub/Sub

## Pub/Sub kya hai?

Pub/Sub = Publisher / Subscriber

Ek service message publish karti hai,
aur interested services us message ko receive karti hain.


## Flow

Publisher
↓
Redis Channel
↓
Subscribers


## Real-World Example

Notification:

Order Service
↓
Publish
↓
"order-notification"
↓
Notification Service
↓
Send Email


## Important

Publisher ko subscriber ke baare me
directly pata hona zaroori nahi.

Publisher:

"order-created event publish kar diya."

Subscriber:

"Main order-created messages sun raha hoon."


## Redis Pub/Sub vs Kafka

Redis Pub/Sub:

→ Simple messaging
→ Very fast
→ Messages generally persistent nahi hote
→ Active subscribers ko message milta hai


Kafka:

→ Durable event streaming
→ Messages persist hote hain
→ Replay possible
→ Consumer groups
→ Large-scale event processing


## Real Example

Redis Pub/Sub:

Live notification
Real-time updates
Simple application events


Kafka:

Order events
Payment events
Inventory events
Event-driven microservices


## Interview Answer

"Redis Pub/Sub allows publishers to send messages to channels and subscribers to receive them. It is useful for lightweight real-time messaging, but unlike Kafka, traditional Redis Pub/Sub does not provide durable message storage or replay."


## Easy Memory

Publisher
↓
Channel
↓
Subscriber


Redis Pub/Sub
→ Real-time messaging


Kafka
→ Durable event streaming


🧠 One-line difference

Redis Pub/Sub = “Abhi jo online hai usko message bhejo.”

Kafka = “Message store karo, consumer baad me bhi process/replay kar sakta hai.”