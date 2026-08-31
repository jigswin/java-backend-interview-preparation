# Microservices — Q7: What is API Gateway?

## API Gateway kya hai?

API Gateway client aur multiple microservices ke beech **single entry point** ki tarah kaam karta hai.

Without Gateway:

Client
 ├──→ User Service
 ├──→ Order Service
 ├──→ Payment Service
 └──→ Product Service


With Gateway:

Client
   ↓
API Gateway
   ↓
 ├── User Service
 ├── Order Service
 ├── Payment Service
 └── Product Service


## Real Example

E-commerce application:

Client request:

GET /api/orders/101

Client directly Order Service ko call nahi karega.

Request:

Client
  ↓
API Gateway
  ↓
Order Service


## Gateway kya-kya kar sakta hai?

### 1. Routing

/api/orders/**

→ Order Service


/api/products/**

→ Product Service


### 2. Authentication

JWT token check kar sakta hai.

Client
 ↓
Gateway
 ↓
JWT valid? ✅
 ↓
Service


### 3. Rate Limiting

Ek client bahut zyada requests bhej raha hai:

→ Requests limit kar sakte hain.


### 4. Logging / Monitoring

Requests ko centrally log/monitor kar sakte hain.


## Gateway + Eureka

Gateway ko services ke hard-coded IPs maintain karne ki zarurat nahi hoti.

Flow:

Client
 ↓
API Gateway
 ↓
Eureka
 ↓
Required Service
 ↓
Response


## Real-World Example

Suppose:

Product Service → :8081
Order Service   → :8082
Payment Service  → :8083

Client ko ye ports yaad rakhne ki zarurat nahi.

Client:

api.myapp.com/products
api.myapp.com/orders
api.myapp.com/payments

Gateway internally correct service ko route karta hai.


## Important

API Gateway **business logic ka main place nahi hona chahiye**.

Business logic respective service me hona chahiye.


## Interview Answer

"API Gateway acts as a single entry point for clients in a microservices architecture. It handles concerns such as routing, authentication, rate limiting and monitoring, and forwards requests to the appropriate microservice."


## Easy Memory

API Gateway
→ Single Entry Point

Routing
→ Request kaha bhejni hai?

Security
→ Request allowed hai?

Eureka
→ Service kaha available hai?