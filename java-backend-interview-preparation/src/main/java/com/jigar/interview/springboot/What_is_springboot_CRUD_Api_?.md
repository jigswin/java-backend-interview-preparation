# Spring Boot — Q33: What is Spring Boot CRUD API?

## CRUD

CRUD means:

C → Create
R → Read
U → Update
D → Delete


## Typical API

POST /employees
→ Create


GET /employees
→ Get all


GET /employees/101
→ Get by ID


PUT /employees/101
→ Update


DELETE /employees/101
→ Delete


## Layer Flow

Client
 ↓
Controller
 ↓
Service
 ↓
Repository
 ↓
Database


## Example

@PostMapping
public Employee create(
        @RequestBody Employee employee) {

    return service.create(employee);
}


@GetMapping("/{id}")
public Employee getById(
        @PathVariable Long id) {

    return service.getById(id);
}


@DeleteMapping("/{id}")
public void delete(
        @PathVariable Long id) {

    service.delete(id);
}


## Real-World Example

E-commerce application:

POST /products
→ New product create

GET /products
→ Products list

PUT /products/101
→ Product update

DELETE /products/101
→ Product delete


## Interview Answer

"CRUD APIs provide Create, Read, Update and Delete operations on resources. In Spring Boot, the Controller handles requests, the Service contains business logic, and the Repository interacts with the database."


## Easy Memory

POST
→ CREATE

GET
→ READ

PUT
→ UPDATE

DELETE
→ DELETE