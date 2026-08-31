# Spring Boot — Q16: What is @Entity, @Id and @GeneratedValue?

## @Entity

`@Entity` batata hai ki ye Java class database table ke saath map hogi.

@Entity
class Employee {

}


## @Id

`@Id` batata hai ki kaunsa field entity ki Primary Key hai.

@Entity
class Employee {

    @Id
    private Long id;

}


## @GeneratedValue

`@GeneratedValue` ka use primary key ki value automatically generate karne ke liye hota hai.

@Entity
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}


Database:

employee
----------------
id     | name
----------------
1      | Jigar
2      | Rahul


Yahan:

@Entity
→ Employee table/entity


@Id
→ id is Primary Key


@GeneratedValue
→ id automatically generate


## GenerationType.IDENTITY

Commonly database ke auto-increment mechanism ko use karta hai.

Example:

First employee
→ id = 1

Second employee
→ id = 2


## Interview Answer

"`@Entity` marks a class as a JPA entity, `@Id` identifies its primary-key field, and `@GeneratedValue` specifies that the primary-key value should be generated automatically."


## Easy Memory Trick

@Entity
→ Table


@Id
→ Primary Key


@GeneratedValue
→ Auto-generated ID