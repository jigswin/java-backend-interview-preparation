# Spring Boot — Q17: What is JpaRepository?

## What is JpaRepository?

`JpaRepository` Spring Data JPA ka interface hai jo database ke common CRUD operations easily provide karta hai.

Isliye hume manually SQL queries likhne ki zarurat nahi padti for basic operations.


## Example

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

}


Yahan:

Employee
→ Entity

Long
→ Primary Key ka type


## Common Methods

save(employee)
→ Insert / Update


findById(id)
→ Single record


findAll()
→ All records


deleteById(id)
→ Delete record


existsById(id)
→ Check record exists or not


## Example

Employee employee =
        new Employee();

employee.setName("Jigar");

repository.save(employee);


Employee employee =
        repository.findById(101L)
                  .orElseThrow();


List<Employee> employees =
        repository.findAll();


repository.deleteById(101L);


## Important

JpaRepository internally Spring Data JPA ke through database operations handle karta hai.

Hum mainly interface define karte hain:

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

}


Spring implementation provide karta hai.


## Interview Answer

"`JpaRepository` is a Spring Data JPA interface that provides ready-made CRUD and other database operations for an entity, reducing the need to write boilerplate data-access code."


## Easy Memory Trick

JpaRepository
→ Ready-made CRUD


save()
→ Insert/Update

findById()
→ One

findAll()
→ All

deleteById()
→ Delete