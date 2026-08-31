# AWS Q13 — AWS LAMBDA

## Lambda kya hai?

AWS Lambda = Serverless compute service.

Aap code likho,
AWS usko run karta hai.

Server ko manually manage karne ki
need nahi hoti.


## Simple Flow

Event
 ↓
Lambda
 ↓
Code Execute
 ↓
Result


## Real Example

S3 me image upload hui:

S3
 ↓
Lambda
 ↓
Image Processing


Ya:

SQS
 ↓
Lambda
 ↓
Order Processing


## Lambda vs EC2

EC2:
→ Server manage karna
→ Application continuously run ho sakti hai
→ OS/configuration manage karni hoti hai


Lambda:
→ Server management nahi
→ Function/event ke according execute
→ Short-lived/event-driven tasks ke liye useful


## Real Microservices Example

Order Service
      ↓
     SQS
      ↓
   Lambda
      ↓
Process Order


Lambda message process kar sakti hai
jab SQS me message available ho.


## Important

Lambda event-driven hoti hai.

Triggers ho sakte hain:

→ SQS
→ S3
→ API Gateway
→ EventBridge
→ CloudWatch Events / schedules


## Interview Answer

"AWS Lambda is a serverless compute service where we run code without managing servers. It is useful for event-driven and short-lived workloads. For example, Lambda can be triggered by SQS messages or an S3 upload to perform background processing."


## Easy Memory

EC2
→ Server manage karo


Lambda
→ Function run karo,
  server manage mat karo


SQS → Lambda:

SQS
 ↓
Lambda
 ↓
Process




## 🧠 Tere PHP wale example se samajh:

Jaise tu bol raha tha background process — conceptually Lambda ko event-triggered background processing ke liye use kar sakte hain.

Example:

Order Created
     ↓
    SQS
     ↓
   Lambda
     ↓
Send Notification

Bas Lambda permanent background server nahi hai; event aane par function execute hota hai.

🎯 AWS COMPLETE ✅

Ab AWS ke important interview topics:

EC2 → S3 → IAM → RDS → VPC → ALB → Auto Scaling → CloudWatch → Deployment → Microservices → SQS → Lambda