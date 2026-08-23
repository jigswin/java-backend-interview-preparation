# Spring Boot — Q32: Spring Boot Security & JWT kya hai?

## Spring Security kya hai?

Spring Security application ko secure karne ke liye use hota hai.

Mainly:

- Authentication
- Authorization

handle karta hai.


## Authentication

"User kaun hai?"

Example:

Username + Password
        ↓
Login
        ↓
User verify


## Authorization

"User ko kya access allowed hai?"

Example:

ADMIN
→ Delete employee ✅

USER
→ Delete employee ❌


## JWT kya hai?

JWT = JSON Web Token

Login successful hone ke baad server client ko token deta hai.

Flow:

Client
  ↓
POST /login
  ↓
Username + Password
  ↓
Server verifies
  ↓
JWT Token
  ↓
Client stores token


Next request:

GET /employees

Authorization:
Bearer <JWT>

        ↓

Server JWT validate karta hai
        ↓
Valid → Request allowed ✅
Invalid → 401 Unauthorized ❌


## JWT me commonly 3 parts hote hain

Header
+
Payload
+
Signature


## Important

JWT ko password ka replacement mat samjho.

JWT ek **signed token** hai jo client ki identity/claims ko represent karta hai.

Sensitive information JWT payload me plain text me nahi rakhni chahiye.


## Interview Answer

"Spring Security is used for authentication and authorization. JWT is commonly used for stateless authentication, where the server issues a signed token after successful login and the client sends that token with subsequent requests."


## Easy Memory

Authentication
→ WHO are you?


Authorization
→ WHAT can you access?


JWT
→ Login ke baad milne wala signed token


Flow:

Login
 ↓
JWT
 ↓
Request + JWT
 ↓
Validate
 ↓
Allow / Reject