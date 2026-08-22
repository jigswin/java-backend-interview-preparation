# Spring Boot — Q20: JPA Relationships

JPA me entities ke beech mainly 4 types ke relationships hote hain:

1. @OneToOne
2. @OneToMany
3. @ManyToOne
4. @ManyToMany


## 1. @OneToOne

Ek record ka ek hi related record.

Example:

Employee → EmployeeProfile

@Entity
class Employee {

    @OneToOne
    private EmployeeProfile profile;
}


## 2. @OneToMany

Ek record ke multiple related records.

Example:

Department → Employees

@Entity
class Department {

    @OneToMany
    private List<Employee> employees;
}


## 3. @ManyToOne

Multiple records ek hi record se related.

Example:

Employees → Department

@Entity
class Employee {

    @ManyToOne
    private Department department;
}


Ye `@OneToMany` ka opposite side hai.


## 4. @ManyToMany

Multiple records multiple records se related.

Example:

Students ↔ Courses

Ek student multiple courses le sakta hai.

Ek course me multiple students ho sakte hain.


@Entity
class Student {

    @ManyToMany
    private List<Course> courses;
}


## Easy Example

One Employee → One Profile
→ @OneToOne

One Department → Many Employees
→ @OneToMany

Many Employees → One Department
→ @ManyToOne

Many Students ↔ Many Courses
→ @ManyToMany


## Interview Answer

"JPA provides four main relationship mappings: OneToOne, OneToMany, ManyToOne and ManyToMany. They are used to represent relationships between database entities."


## Important

Real projects me:

@OneToMany
+
@ManyToOne

combination bahut common hai.

Example:

Department
   ↓
One
   ↓
Many Employees


Employee
   ↓
Many
   ↓
One Department