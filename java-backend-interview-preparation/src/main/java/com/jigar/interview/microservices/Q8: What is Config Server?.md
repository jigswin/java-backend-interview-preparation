# Microservices — Q8: What is Config Server?

## Config Server kya hai?

Microservices architecture me multiple services hoti hain aur har service ki configuration hoti hai.

Example:

Order Service
Payment Service
Inventory Service

Agar har service ke andar alag configuration rakhen:

→ Manage karna difficult ho sakta hai.

Config Server ek **central place** provide karta hai jahan configuration maintain kar sakte hain.


## Without Config Server

Order Service
→ application.properties

Payment Service
→ application.properties

Inventory Service
→ application.properties


## With Config Server

             Config Server
                  |
        ┌─────────┼─────────┐
        ↓         ↓         ↓
      Order     Payment   Inventory
      Service   Service   Service


Services startup par Config Server se required configuration le sakti hain.


## Real Example

Suppose database URL change karna hai.

Without Config Server:

→ Multiple services ki configuration update karni pad sakti hai.


With Config Server:

→ Central configuration update
→ Services new configuration fetch kar sakti hain.


## Common Configuration

- Database URL
- Database username
- External service URLs
- Feature flags
- Application settings


## Git ke saath

Spring Cloud Config Server commonly configuration ko Git repository se read kar sakta hai.

Git Repository
      ↓
Config Server
      ↓
Microservices


## Important

Passwords/secrets ko plain Git configuration me rakhna avoid karna chahiye.

Production me proper secret-management solution use karna better hai.


## Interview Answer

"Spring Cloud Config Server provides centralized external configuration management for microservices. Services can retrieve their environment-specific configuration from a central server, commonly backed by a Git repository."


## Easy Memory

Config Server
→ Central Configuration


Git
→ Configuration Store


Microservice
→ Configuration fetch karta hai


Simple:

Git → Config Server → Services



*****************************
# (Real-World Example)      |
*****************************

## Problem samajh pehle

Maan le hamare E-commerce project me 3 services hain:

Order Service
Payment Service
Inventory Service


Har service ko kuch configuration chahiye:

Order Service
→ DB URL
→ Payment Service URL
→ Kafka config


Payment Service
→ DB URL
→ Payment Gateway URL


Inventory Service
→ DB URL
→ Redis config


Agar sabki configuration unke apne application.properties me rakhen:

Order Service
   ↓
application.properties

Payment Service
   ↓
application.properties

Inventory Service
   ↓
application.properties


Problem:

Agar kisi common configuration ko change karna hai,
to multiple services me jaake change karna padega.


--------------------------------------------------
## Config Server ka solution
--------------------------------------------------

Ek separate service bana dete hain:

              Git Repository
                    ↓
              Config Server
                    ↓
        ┌───────────┼───────────┐
        ↓           ↓           ↓
     Order       Payment     Inventory
     Service     Service      Service


Git repository me configuration files:

order-service.properties
payment-service.properties
inventory-service.properties


--------------------------------------------------
## Real Example
--------------------------------------------------

Maan le Payment Service ko ye chahiye:

payment-service.properties

payment.gateway.url=https://payment-provider.com

payment.timeout=5000


Ye configuration Git me store hai.

Payment Service start hoti hai:

Payment Service
      ↓
Config Server se configuration maango
      ↓
Config Server
      ↓
Git se configuration read
      ↓
Payment Service ko return
      ↓
Payment Service use karegi


--------------------------------------------------
## Environment ka real example
--------------------------------------------------

Development:

payment-service-dev.properties

payment.gateway.url=https://dev-payment.com


Production:

payment-service-prod.properties

payment.gateway.url=https://payment.com


Same Payment Service code.

Bas environment ke according configuration change.


--------------------------------------------------
## Agar Payment URL change ho jaye?
--------------------------------------------------

Old:

https://payment-old.com


New:

https://payment-new.com


Without Config Server:

→ Payment Service ki config manually change


With Config Server:

Git
 ↓
Configuration update
 ↓
Config Server
 ↓
Service updated configuration use kar sakti hai


--------------------------------------------------
## Config Server ka main benefit
--------------------------------------------------

Configuration ko:

→ Centralize
→ Externalize
→ Environment-specific

rakh sakte hain.


Code:

PaymentService.java

same rahega.

Configuration:

DEV → Dev values
TEST → Test values
PROD → Production values


--------------------------------------------------
## Important Interview Point
--------------------------------------------------

Config Server ka purpose:

"Configuration ko centrally manage karna"

Ye database/service ka replacement nahi hai.


Aur passwords/API keys ko plain Git repo me rakhna
safe approach nahi hai.

Production me secrets ke liye proper secret-management solution
use karna chahiye.


--------------------------------------------------
## Interview Answer
--------------------------------------------------

"Spring Cloud Config Server provides centralized and externalized configuration management for microservices. For example, database URLs, external service URLs and application settings can be stored centrally and different configurations can be provided for development, testing and production environments."


--------------------------------------------------
## Easy Memory
--------------------------------------------------

Without:

Service → apni config


With:

Git
 ↓
Config Server
 ↓
All Microservices


Config Server
→ "Sabki configuration ek central jagah se manage karo."