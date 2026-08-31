# Spring Boot — Q6: @Component, @Service, @Repository aur @Controller me difference

## 1. @Component

Generic Spring Bean ke liye use hota hai.

@Component
class EmailService {
}


## 2. @Service

Business logic wali class ke liye use hota hai.

@Service
class EmployeeService {
}


## 3. @Repository

Database/DAO layer ke liye use hota hai.

@Repository
class EmployeeRepository {
}


## 4. @Controller

Web/MVC controller ke liye use hota hai.

@Controller
class EmployeeController {
}


## 5. @RestController

REST API banane ke liye commonly use hota hai.

@RestController
class EmployeeController {
}


`@RestController` essentially:

@Controller
+
@ResponseBody

hota hai.


## Simple Architecture

Client
  ↓
@Controller / @RestController
  ↓
@Service
  ↓
@Repository
  ↓
Database


## Important Point

Ye annotations internally Spring ke component-scanning mechanism ke through Beans register karne me help karte hain.

Main difference mostly **role/purpose** ka hai.


## Interview Answer

"`@Component` is a generic Spring component, `@Service` is used for the service/business layer, `@Repository` is used for the persistence layer, and `@Controller` or `@RestController` is used for handling web requests."


## Easy Memory Trick

@Component
→ General

@Service
→ Business Logic

@Repository
→ Database

@RestController
→ API