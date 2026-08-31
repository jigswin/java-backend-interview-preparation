# DOCKER Q8 — DOCKER NETWORK

## Docker Network kya hai?

Docker Network containers ko
aapas me communicate karne ki facility deta hai.

Example:

Spring Boot
↓
MySQL

Dono alag containers me hain,
phir bhi network ke through communicate kar sakte hain.


## Real Example

E-commerce:

Product Service
↓
MySQL

Order Service
↓
MySQL

Redis
↑
|
Services


## Important

Same Docker network ke containers
ek-dusre ko container/service name se
access kar sakte hain.


Example:

Spring Boot
↓
mysql:3306


Yaha `mysql` container/service ka name hai.


## Create Network

docker network create app-network


## Run Containers

docker run --network app-network --name mysql mysql

docker run --network app-network --name product-service product-service


Ab:

product-service
↓
mysql:3306


## Common Network Types

bridge
→ Normal/default container networking


host
→ Host ka network directly use karta hai


none
→ Network connectivity disabled


## Docker Compose

Docker Compose me common network
automatically create/use kiya ja sakta hai.

Example:

product-service
order-service
mysql
redis

Sab same application network me
communicate kar sakte hain.


## Interview Answer

"Docker networking allows containers to communicate with each other and with external systems. In a user-defined bridge network, containers can communicate using container or service names, which is especially useful for multi-container applications."


## Easy Memory

Docker Network
→ Container communication


product-service
↓
mysql:3306


Same Network
→ Service name se communication



## 🧠 Real project:
app-network
┌──────────┼──────────┐
↓          ↓          ↓
Product    Order     Redis
↓         ↓
MySQL     MySQL