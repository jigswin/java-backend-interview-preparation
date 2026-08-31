# AWS Q7 — LOAD BALANCER

## Load Balancer kya hai?

Load Balancer incoming traffic ko
multiple servers/instances ke beech distribute karta hai.

Example:

Users
↓
Load Balancer
├──→ EC2-1
├──→ EC2-2
└──→ EC2-3


## Problem Without Load Balancer

Users
↓
EC2-1

Agar traffic bahut zyada ho:

EC2-1
↓
Overloaded ❌


Ya EC2-1 down:

Users
↓
EC2-1 ❌


## With Load Balancer

Users
↓
Load Balancer
/    |    \
EC2-1 EC2-2 EC2-3


Traffic distribute hota hai.


## ALB

ALB = Application Load Balancer

HTTP/HTTPS applications ke liye commonly use hota hai.

Example:

https://api.example.com/products

        ↓
       ALB
        ↓
Spring Boot instances


## Health Check

Load Balancer instances ki health check
kar sakta hai.

Example:

EC2-1 → Healthy ✅
EC2-2 → Healthy ✅
EC2-3 → Unhealthy ❌


Traffic:

ALB
├──→ EC2-1
└──→ EC2-2

EC2-3 ko traffic nahi bhejega.


## Real Project

E-commerce:

                Users
                  ↓
                 ALB
              /       \
             ↓         ↓
          EC2-1      EC2-2
             \         /
              ↓       ↓
              RDS MySQL


## Interview Answer

"An Application Load Balancer distributes incoming HTTP/HTTPS traffic across multiple healthy targets such as EC2 instances. It improves availability and allows us to scale the application horizontally."


## Easy Memory

ALB
→ Traffic Distributor

Health Check
→ Healthy instance ko traffic

Multiple EC2
→ High Availability + Scaling


🧠 Simple example

Agar 1000 users aa rahe hain:

1000 Users
↓
ALB
/   \
500   500
↓     ↓
EC2-1 EC2-2

Aur EC2-2 down ho gaya:

Users
↓
ALB
↓
EC2-1 ✅

ALB unhealthy instance ko traffic nahi bhejega.