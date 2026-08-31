# AWS Q6 — VPC

## VPC kya hai?

VPC = Virtual Private Cloud

AWS ke andar hamara
private network/environment hota hai.

Isme hum decide kar sakte hain:

→ Network
→ IP ranges
→ Subnets
→ Internet access
→ Security rules


## Real Example

Soch:

AWS = ek bada city 🏙️

VPC = hamari private colony 🏠

Us colony ke andar:

EC2
RDS
Load Balancer

sab resources hain.


## Basic Architecture

Internet
↓
Load Balancer
↓
Public Subnet
↓
EC2
↓
Private Subnet
↓
RDS


## Public Subnet

Jisko internet se access ki
requirement ho sakti hai.

Example:

Load Balancer


## Private Subnet

Direct public internet access
nahi dena chahiye.

Example:

RDS


## Real Project

User:

Internet
↓
Load Balancer
↓
EC2 / Spring Boot
↓
RDS

RDS ko directly internet par expose
karna avoid karte hain.


## Security

VPC ke andar networking ko control
karne ke liye:

→ Security Groups
→ Network ACLs
→ Route Tables

jaise components use hote hain.


## Interview Answer

"VPC is a logically isolated virtual network in AWS where we deploy resources such as EC2 and RDS. It allows us to control networking, subnets, routing and access. In a typical application, the load balancer and application tier may have public access requirements, while the database is kept in private subnets."


## Easy Memory

VPC
→ Private Network

Public Subnet
→ Internet-facing resources

Private Subnet
→ Internal resources

RDS
→ Usually private

Security Group
→ Resource-level firewall