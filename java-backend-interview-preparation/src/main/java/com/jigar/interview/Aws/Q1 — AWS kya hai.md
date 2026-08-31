# AWS Q1 — AWS BASICS

## AWS kya hai?

AWS = Amazon Web Services

Ye cloud platform hai jahan hum:
→ Servers
→ Databases
→ Storage
→ Networking
→ Monitoring
→ Security

jaise resources internet ke through use kar sakte hain.


## Real-World Example

Normally:

Java Application
↓
Apna Server
↓
Maintenance
↓
Cost


AWS me:

Java Application
↓
AWS EC2
↓
Internet
↓
Users


Hume physical server khud maintain karne ki
need nahi hoti.


## Important AWS Services

EC2
→ Virtual Server

S3
→ File/Object Storage

RDS
→ Managed Database

IAM
→ Users & Permissions

VPC
→ Private Network

Load Balancer
→ Traffic distribute karta hai

CloudWatch
→ Monitoring & Logs


## Java Developer ke perspective se

Spring Boot Application
↓
EC2
↓
Load Balancer
↓
Users

Database:

Spring Boot
↓
RDS


Files:

Spring Boot
↓
S3


Logs/Monitoring:

Application
↓
CloudWatch


## Interview Answer

"AWS is a cloud computing platform that provides services such as compute, storage, databases, networking and monitoring. For a Spring Boot application, we can use services like EC2 for compute, RDS for the database, S3 for object storage and CloudWatch for monitoring."


## Easy Memory

EC2 → Server
S3 → Storage
RDS → Database
IAM → Security/Permissions
VPC → Network
ALB → Traffic
CloudWatch → Monitoring