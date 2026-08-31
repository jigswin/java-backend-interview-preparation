# Spring Boot — Q31: JPA Query Methods vs @Query

## Query Method kya hai?

Spring Data JPA method ke naam se automatically query generate kar sakta hai.

Example:

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(double salary);
}


findByDepartment("IT")
→ WHERE department = 'IT'


findBySalaryGreaterThan(50000)
→ WHERE salary > 50000


## @Query kya hai?

Jab complex/custom query likhni ho, tab `@Query` use kar sakte hain.

@Query("SELECT e FROM Employee e WHERE e.salary > :salary")
List<Employee> findHighSalaryEmployees(
        @Param("salary") double salary);


## Difference

Query Method
→ Simple queries
→ Method name se query generate


@Query
→ Complex/custom queries
→ Query manually define karte hain


## Interview Answer

"Spring Data JPA can derive queries from repository method names for simple requirements. For complex or custom queries, we can use the `@Query` annotation."

## Easy Memory

Simple query
→ Query Method

Complex/custom query
→ @Query