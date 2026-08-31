# AWS Q2 — EC2

## EC2 kya hai?

EC2 = Elastic Compute Cloud

Simple words:

EC2 = AWS ka virtual server.

Jaise hum apne laptop/server par
Spring Boot application run karte hain,

waise hi AWS EC2 par application run
kar sakte hain.


## Real Example

Local:

Your Laptop
↓
Java 21
↓
Spring Boot
↓
localhost:8080


AWS:

EC2 Server
↓
Java 21
↓
Spring Boot
↓
Public IP / Domain
↓
Users


## EC2 me kya hota hai?

EC2 instance basically ek virtual machine hai.

Isme:

→ CPU
→ RAM
→ Disk
→ Operating System
→ Network

available hota hai.


## Spring Boot Deployment

Basic flow:

Code
↓
Build JAR
↓
Upload to EC2
↓
Install Java
↓
Run JAR
↓
Application


Example:

java -jar app.jar


Application:

http://server-ip:8080


## Security Group

EC2 ke saath Security Group
firewall ki tarah kaam karta hai.

Example:

Port 22
→ SSH

Port 8080
→ Spring Boot

Port 80
→ HTTP

Port 443
→ HTTPS


Only required ports ko allow karna chahiye.


## EC2 vs Physical Server

Physical Server:

→ Hardware khud manage
→ Maintenance
→ Scaling difficult


EC2:

→ Virtual server
→ AWS infrastructure manage karta hai
→ Instance size change kar sakte ho
→ Instances create/delete kar sakte ho


## "Elastic" ka meaning

Requirement badhne par
resources/instances ko scale kar sakte hain.

Example:

Normal traffic:

2 EC2 instances


High traffic:

5 EC2 instances


Ye scaling Auto Scaling ke through
automate bhi ho sakti hai.


## Interview Answer

"EC2 is a virtual compute server provided by AWS. We can launch an EC2 instance with a required operating system and resources, install Java and deploy our Spring Boot JAR on it. Security Groups control the inbound and outbound network access."


## Easy Memory

EC2
→ AWS Virtual Server


Security Group
→ Firewall


22
→ SSH


8080
→ Spring Boot


80
→ HTTP


443
→ HTTPS