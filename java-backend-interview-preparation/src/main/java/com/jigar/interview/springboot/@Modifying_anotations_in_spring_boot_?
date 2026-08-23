# @Modifying Annotation

## @Modifying kya hai?

`@Modifying` ka use Spring Data JPA me **INSERT, UPDATE, DELETE** jaise modifying queries ke saath hota hai.

Ye batata hai:

"Ye @Query database ka data modify karegi, sirf SELECT nahi karegi."


## Example

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    @Modifying
    @Query("UPDATE Employee e SET e.salary = :salary WHERE e.id = :id")
    int updateSalary(
            @Param("id") Long id,
            @Param("salary") double salary);
}


## DELETE Example

@Modifying
@Query("DELETE FROM Employee e WHERE e.id = :id")
int deleteEmployee(@Param("id") Long id);


## @Transactional kyu chahiye?

Modifying query ko transaction ke andar execute karna hota hai.

Usually:

@Modifying
@Transactional
@Query("UPDATE Employee e SET e.salary = :salary WHERE e.id = :id")
int updateSalary(
        @Param("id") Long id,
        @Param("salary") double salary);


Ya `@Transactional` service layer par bhi rakh sakte hain.


## Important

Normal SELECT query:

@Query("SELECT e FROM Employee e WHERE e.id = :id")

→ `@Modifying` ki need nahi.


UPDATE / DELETE:

@Modifying
@Query(...)

→ `@Modifying` required.


## Interview Answer

"`@Modifying` is used with Spring Data JPA `@Query` methods when the query performs modifying operations such as UPDATE or DELETE instead of SELECT."

## Easy Memory

SELECT
→ @Query


UPDATE / DELETE
→ @Modifying + @Query


Transaction
→ @Transactional