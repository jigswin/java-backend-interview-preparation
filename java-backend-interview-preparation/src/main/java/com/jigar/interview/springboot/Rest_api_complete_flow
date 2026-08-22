# Spring Boot — Q14: REST API ka Complete Flow

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

GET /employees/101


1. Client request bhejta hai

2. @RestController request receive karta hai

3. Controller → Service ko call karta hai

4. Service → Repository ko call karti hai

5. Repository → Database se data leti hai

6. Data wapas:

Database
↓
Repository
↓
Service
↓
Controller
↓
Client


## Code

@RestController
@RequestMapping("/employees")
class EmployeeController {

    @GetMapping("/{id}")
    public Employee getEmployee(
            @PathVariable Long id) {

        return service.getEmployee(id);
    }
}


@Service
class EmployeeService {

    public Employee getEmployee(Long id) {

        return repository.findById(id)
                .orElseThrow();
    }
}


@Repository
interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
}


## Simple Responsibility

Controller
→ Request/Response handle

Service
→ Business logic

Repository
→ Database interaction

Database
→ Data store


## Interview Answer

"In a typical Spring Boot REST API, the request first reaches the Controller, which calls the Service layer. The Service contains business logic and communicates with the Repository. The Repository interacts with the database, and the response travels back through the same layers to the client."


## Remember

Controller → Service → Repository → DB

DB → Repository → Service → Controller → Client