# AWS Q10 — SPRING BOOT DEPLOYMENT

## Basic Flow

Developer
↓
Spring Boot Code
↓
Maven Build
↓
JAR File
↓
EC2
↓
Java Install
↓
Run JAR
↓
Application


## Step 1 — Build

Maven:

mvn clean package


Output:

target/app.jar


## Step 2 — EC2

EC2 instance launch karo.

Usme:

→ Linux
→ Java
→ Required packages


## Step 3 — JAR Upload

Local:

app.jar

EC2 server par upload.


## Step 4 — Run

EC2:

java -jar app.jar


Spring Boot:

8080 port par run.


## Step 5 — Security Group

Required port allow:

8080 → Spring Boot


Production me usually:

Internet
↓
ALB
↓
EC2

Direct 8080 public expose karna avoid
kiya ja sakta hai.


## Step 6 — Database

Application:

EC2
↓
RDS MySQL


## Step 7 — File Storage

Application:

EC2
↓
S3


## Complete Architecture

              Users
                ↓
               ALB
                ↓
        ┌───────┴───────┐
        ↓               ↓
      EC2-1           EC2-2
Spring Boot     Spring Boot
│               │
└───────┬───────┘
↓
RDS MySQL

             +
             S3

             +
          CloudWatch


## Interview Answer

"To deploy a Spring Boot application, I can build the application as a JAR using Maven, launch an EC2 instance, install the required Java version, upload the JAR and run it using java -jar. For production, I would place an Application Load Balancer in front of multiple EC2 instances, use RDS for the database, S3 for object storage and CloudWatch for monitoring."


## Easy Memory

Maven
↓
JAR
↓
EC2
↓
Java
↓
Spring Boot

Production:

ALB
↓
EC2 × N
↓
RDS

Files → S3
Logs → CloudWatch





## 🧠 Bhai ab ek important point:

Abhi humne manual EC2 deployment samjha.

Aage Docker/Kubernetes me:

Spring Boot
↓
Docker Image
↓
Container
↓
Kubernetes
↓
AWS