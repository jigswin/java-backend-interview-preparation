# SPRING SECURITY — AUTHENTICATION, AUTHORIZATION & JWT

## Q — Spring Security me Authentication aur Authorization kaise kaam karte hain?

Spring Security application ko secure karne ke liye
Authentication aur Authorization provide karta hai.


==================================================
1. AUTHENTICATION
   ==================================================

Question:

"WHO ARE YOU?"

Matlab user ki identity verify karna.

Example:

User:
username = jigar
password = ****

        ↓

Spring Security
↓
Credentials verify
↓
Valid ✅
↓
User authenticated


Example:

POST /login

{
"username": "jigar",
"password": "123456"
}


==================================================
2. AUTHORIZATION
   ==================================================

Question:

"WHAT ARE YOU ALLOWED TO DO?"

User authenticated hone ke baad check hota hai
ki usko particular resource/action ki permission hai ya nahi.


Example:

Jigar → ROLE_USER

Admin → ROLE_ADMIN


GET /products
→ USER ✅
→ ADMIN ✅


DELETE /products/101
→ USER ❌
→ ADMIN ✅


So:

Authentication
→ User kaun hai?


Authorization
→ User kya kar sakta hai?


==================================================
3. JWT KYA HAI?
   ==================================================

JWT = JSON Web Token

Login successful hone ke baad server
client ko JWT token de sakta hai.

Example:

User
↓
POST /login
↓
Spring Security
↓
Username/Password verify
↓
JWT generate
↓
Client


JWT me commonly:

Header
Payload
Signature


Example payload concept:

{
"sub": "jigar",
"role": "USER"
}


Important:

JWT ko simply encrypted data mat samajhna.

Normally JWT payload encoded hota hai,
isliye sensitive information directly
payload me nahi rakhni chahiye.


==================================================
4. NEXT REQUEST
   ==================================================

Client protected API call karta hai:

GET /orders

Header:

Authorization: Bearer <JWT>


Flow:

Client
↓
Authorization Header
↓
Spring Security Filter
↓
JWT Validate
↓
User Identity/Authorities
↓
Authorization Check
↓
Controller
↓
Response


==================================================
5. SPRING SECURITY FILTER CHAIN
   ==================================================

Request
↓
Security Filter Chain
↓
JWT Authentication Filter
↓
JWT Validate
↓
SecurityContext
↓
Authorization
↓
Controller


SecurityContext me authenticated user ki
security information available hoti hai.


==================================================
6. REAL-WORLD E-COMMERCE EXAMPLE
   ==================================================

Login:

POST /auth/login

        ↓

Auth Service
↓
Verify username/password
↓
Generate JWT
↓
Return JWT


Client:

GET /orders

Authorization:
Bearer eyJ...


        ↓

API Gateway / Service
↓
Spring Security
↓
JWT Valid?
↓
YES
↓
ROLE_USER?
↓
YES
↓
Order Controller
↓
Return Orders


Admin API:

DELETE /products/101

        ↓
JWT Valid?
↓
YES

ROLE_ADMIN?
├── YES → Allow ✅
└── NO  → 403 Forbidden ❌


==================================================
7. 401 vs 403
   ==================================================

401 Unauthorized

Usually means:

User authenticated nahi hai
ya credentials/token valid nahi hai.


Example:

No JWT
Invalid JWT
Expired JWT


403 Forbidden

User authenticated hai,
but permission nahi hai.


Example:

USER tries:

DELETE /products/101

But API requires:

ROLE_ADMIN


Result:

403 Forbidden


Easy Memory:

401
→ "Pehle login/authenticate ho."


403
→ "Login ho, but permission nahi hai."


==================================================
8. PASSWORD STORAGE
   ==================================================

Password ko database me plain text me
store nahi karna chahiye.

❌

password = 123456


Instead:

Password
↓
BCrypt
↓
Hash
↓
Database


Spring Security me:

PasswordEncoder


Example:

PasswordEncoder
↓
BCryptPasswordEncoder


Login ke time:

Raw Password
↓
PasswordEncoder
↓
Stored Hash ke against verify


Important:

Hashing ≠ Encryption

Password ke liye generally
one-way hashing approach use hoti hai.


==================================================
9. SPRING SECURITY CONFIGURATION
   ==================================================

Conceptually:

/login
→ permitAll()


/products
→ authenticated()


/admin/**
→ hasRole("ADMIN")


Example:

requestMatchers("/login").permitAll()

requestMatchers("/admin/**")
.hasRole("ADMIN")

anyRequest()
.authenticated()


==================================================
10. JWT STATELESS AUTHENTICATION
    ==================================================

JWT based API commonly stateless rakhi ja sakti hai.

Matlab:

Server ko har request ke liye
traditional server-side login session
maintain karne ki requirement nahi hoti.

Request:

Client
↓
JWT
↓
Server verifies token


Example:

Request 1 → JWT
Request 2 → JWT
Request 3 → JWT


Server token ke basis par
authentication establish karta hai.


==================================================
11. COMPLETE FLOW
    ==================================================

                    LOGIN
                      ↓
                  Username
                  Password
                      ↓
              Spring Security
                      ↓
               Verify User
                      ↓
                Generate JWT
                      ↓
                   Client
                      ↓
              ┌──────────────┐
              │ JWT Token    │
              └──────────────┘
                      ↓
              GET /orders
                      ↓
          Authorization: Bearer JWT
                      ↓
            Security Filter Chain
                      ↓
                Validate JWT
                      ↓
             Set Authentication
                      ↓
             Check Authorities
                      ↓
                  Controller
                      ↓
                 Service
                      ↓
                Repository
                      ↓
                 Database


==================================================
12. INTERVIEW ANSWER
    ==================================================

"Spring Security provides authentication and authorization
for Spring applications. In a JWT-based setup, the user
first authenticates with username and password. After
successful authentication, the server generates a JWT.
The client sends this token in the Authorization header
for subsequent requests. Spring Security filters validate
the token and establish the authenticated user in the
SecurityContext. Authorization rules then determine
whether the user has permission to access the requested
resource."


==================================================
13. MOST IMPORTANT DIFFERENCES
    ==================================================

Authentication
→ Who are you?


Authorization
→ What can you do?


JWT
→ Token carrying claims used to represent/authenticate
the user between requests


401
→ Authentication problem


403
→ Authorization/permission problem


PasswordEncoder
→ Secure password hashing/verification


SecurityContext
→ Current authenticated user's security information


Filter Chain
→ Requests pass through security filters
before reaching controller




## 🧠 Bhai ekdum simple real-life analogy

Soch office building hai:

Authentication:
👉 Security guard ne tera ID card check kiya — "Tu Jigar hai?"

Authorization:
👉 ID check ke baad — "Jigar ko server room me jaane ki permission hai?"

JWT:
👉 Login ke baad mila digital access pass, jo tu subsequent requests me bhejta hai.

401: ID/pass hi valid nahi.
403: ID valid hai, lekin us room ki permission nahi hai.

⭐ Interview me ye flow yaad rakh:

Login → Verify → JWT → Request + JWT → Filter Chain → Validate → SecurityContext → Authorization → Controller

Ye ek question ke andar Spring Security ke kaafi important concepts cover kar deta hai.