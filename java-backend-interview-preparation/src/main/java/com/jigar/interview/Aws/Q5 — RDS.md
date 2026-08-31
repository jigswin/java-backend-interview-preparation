# AWS Q5 — RDS

## RDS kya hai?

RDS = Relational Database Service

AWS ki managed relational database service hai.

Isme hum databases run kar sakte hain:

→ MySQL
→ PostgreSQL
→ Oracle
→ SQL Server


## Real Example

Local:

Spring Boot
↓
MySQL
↓
localhost


AWS:

Spring Boot
↓
AWS RDS
↓
MySQL


## RDS ka advantage

AWS database infrastructure ka
bahut saara management handle karta hai.

Example:

→ Backups
→ Patching
→ Monitoring
→ Scaling options
→ High Availability options


## Real Project

Spring Boot:

spring.datasource.url
spring.datasource.username
spring.datasource.password


Ye application RDS ke MySQL database se
connect kar sakti hai.


## EC2 vs RDS

EC2:
→ Server/application run karne ke liye


RDS:
→ Managed relational database


Example:

EC2 → Spring Boot
RDS → MySQL


## RDS vs MySQL on EC2

MySQL manually EC2 par install kar sakte ho:

EC2
↓
MySQL

Lekin:

→ DB maintenance
→ Backup
→ Patching
→ HA setup

zyada manually manage karna padega.


RDS:

EC2
↓
RDS MySQL

AWS database management ka
bahut part handle karta hai.


## Interview Answer

"Amazon RDS is a managed relational database service. We can use engines such as MySQL or PostgreSQL with our Spring Boot application. Compared with managing MySQL ourselves on an EC2 instance, RDS provides managed capabilities such as automated backups, patching and high-availability options."


## Easy Memory

EC2
→ Application Server

RDS
→ Managed Database

S3
→ File Storage

IAM
→ Access Control