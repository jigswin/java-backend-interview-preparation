# Spring Boot — Q21: What is Cascade in JPA?

## What is Cascade?

Cascade ka matlab:

> Parent entity par operation perform karne par related child entity par bhi automatically same operation apply karna.

## Example

Department
   ↓
Employees

Agar:

Department save karo
→ Employees bhi save ho sakte hain.

@Entity
class Department {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees;
}


## Common Cascade Types

PERSIST
→ Parent persist → Child persist


MERGE
→ Parent merge → Child merge


REMOVE
→ Parent delete → Child delete


ALL
→ Above cascade operations


## Example

Department department = new Department();

Employee employee = new Employee();

department.setEmployees(
    List.of(employee)
);

repository.save(department);


Agar `CascadeType.PERSIST` / appropriate cascade configured hai:

Department
↓
Employee

dono persist ho sakte hain.


## CascadeType.ALL

CascadeType.ALL ka matlab:

PERSIST
+ MERGE
+ REMOVE
+ etc.


## Important Interview Point

Cascade aur orphanRemoval same nahi hain.

Cascade:
→ Parent operation ka effect child par


orphanRemoval:
→ Parent se child relationship remove hone par child ko database se delete kar sakta hai.


## Interview Answer

"Cascade in JPA allows operations performed on a parent entity to be propagated to its related child entities."


## Easy Memory Trick

Parent operation
        ↓
Cascade
        ↓
Child operation


Example:

Parent SAVE
→ Child SAVE

Parent DELETE
→ Child DELETE