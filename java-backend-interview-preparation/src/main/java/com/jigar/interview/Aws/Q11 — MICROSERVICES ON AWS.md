# AWS Q11 — MICROSERVICES ON AWS

## Basic Architecture

                    Users
                      ↓
               Load Balancer
                      ↓
                API Gateway
                      ↓
        ┌─────────────┼─────────────┐
        ↓             ↓             ↓
Product Service   Order Service   User Service
EC2              EC2             EC2
↓             ↓             ↓
Redis          Redis          Redis
↓             ↓             ↓
Product DB     Order DB       User DB
RDS            RDS            RDS


## AWS Services

EC2
→ Microservices run karne ke liye

ALB
→ Traffic distribute

API Gateway
→ APIs ka entry point

RDS
→ Relational databases

S3
→ Files/images

Redis
→ Cache

CloudWatch
→ Monitoring

IAM
→ Permissions


## Real Example

User:

POST /orders

        ↓
API Gateway
↓
Order Service
↓
Order DB (RDS)
↓
Kafka
↓
Inventory Service
↓
Notification Service


## Important

Har microservice ideally:

Own Service
+
Own Database
+
Own Cache


Example:

Order Service
→ Order DB

Product Service
→ Product DB


## Interview Answer

"In AWS, microservices can be deployed as independent services using compute platforms such as EC2 or containers. An API Gateway can act as the external entry point, while a load balancer distributes traffic across healthy instances. Each service can have its own database, Redis can provide caching, S3 can handle object storage, and CloudWatch can be used for monitoring."


## Easy Memory

API Gateway
→ Entry Point

ALB
→ Traffic Distribution

EC2
→ Compute

RDS
→ Database

Redis
→ Cache

S3
→ Files

CloudWatch
→ Monitoring

IAM
→ Security


🧠 Interview me agar architecture banane bole:
USERS
↓
API GATEWAY
↓
┌───────┼───────┐
↓       ↓       ↓
Product  Order    User
↓       ↓       ↓
DB      DB      DB

Aur Kafka/Redis ko requirements ke according services ke beech add kar sakte hain.