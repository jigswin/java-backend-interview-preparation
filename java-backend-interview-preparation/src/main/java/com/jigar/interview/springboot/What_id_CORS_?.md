# Spring Boot — Q34: What is CORS?

## CORS kya hai?

CORS = Cross-Origin Resource Sharing

Jab ek frontend application **different origin** se backend API ko call karti hai, browser security ke liye request ko restrict kar sakta hai.

Example:

Frontend:
http://localhost:3000

Backend:
http://localhost:8080

Dono ka origin different hai.

Isliye CORS configuration ki zarurat pad sakti hai.


## Simple Example

React App
   ↓
localhost:3000
   ↓
GET /employees
   ↓
Spring Boot API
localhost:8080


Browser:

"Ye different origin hai.
Kya backend is frontend ko request karne ki permission deta hai?"


## Spring Boot me

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {

}


Isse specified origin se requests allow ki ja sakti hain.


## Real-World Example

Production:

Frontend:
https://myapp.com

Backend:
https://api.myapp.com

Agar backend CORS ke through frontend origin allow karta hai:

Frontend → Backend ✅


Agar allowed nahi hai:

Browser request ko block kar sakta hai ❌


## Important

CORS mainly **browser security mechanism** hai.

Ye authentication/authorization ka replacement nahi hai.


## Interview Answer

"CORS stands for Cross-Origin Resource Sharing. It is a browser security mechanism that controls whether a web application from one origin can access resources from another origin."


## Easy Memory

Different Origin
        ↓
Browser checks CORS
        ↓
Allowed → Request works ✅
Not allowed → Browser blocks ❌