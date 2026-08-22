# Spring Boot — Q22: What is DTO?

## DTO kya hai?

DTO = Data Transfer Object

DTO ka use **client aur application ke beech data transfer** karne ke liye hota hai.

Simple:

Entity
→ Database ke liye

DTO
→ API request/response ke liye


## Example

Entity:

@Entity
class Employee {

    private Long id;
    private String name;
    private String password;
}


API Response me password nahi bhejna.

Isliye DTO:

class EmployeeResponse {

    private Long id;
    private String name;
}


Controller:

@GetMapping("/{id}")
public EmployeeResponse getEmployee(
        @PathVariable Long id) {

    return service.getEmployee(id);
}


## DTO kyu use karte hain?

- Sensitive data hide karne ke liye
- API response ko control karne ke liye
- Entity ko directly expose na karne ke liye
- Request aur Response ka structure alag rakhne ke liye


## Real-World Flow

Client
 ↓
DTO
 ↓
Controller
 ↓
Service
 ↓
Entity
 ↓
Repository
 ↓
Database


Database se response:

Entity
 ↓
DTO
 ↓
Client


## Interview Answer

"DTO stands for Data Transfer Object. It is used to transfer only the required data between layers or between the client and server, instead of directly exposing the database entity."


## Easy Memory Trick

Entity
→ Database


DTO
→ API Data


IMPORTANT:

Entity ko directly API response me expose karne ke bajay DTO use karna generally better practice hai.