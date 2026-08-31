# Spring Boot — Q8: What are Starter Dependencies?

## What are Starter Dependencies?

Spring Boot Starters are predefined dependency bundles that provide the commonly required libraries for a particular type of application.

Simple:

Ek-ek dependency manually add karne ke bajay,
Spring Boot starter me related dependencies ka group mil jata hai.


## Example

For REST API:

spring-boot-starter-web


Isse web application ke liye commonly required dependencies mil jaati hain, such as:

- Spring MVC
- Embedded Tomcat
- JSON support


## Common Starters

spring-boot-starter-web
→ REST API / Web application


spring-boot-starter-data-jpa
→ JPA + Hibernate + database access


spring-boot-starter-security
→ Spring Security


spring-boot-starter-test
→ Testing


## Why use Starters?

- Dependency management easy
- Required libraries ek saath milti hain
- Compatible versions manage karna easier
- Configuration/development faster


## Interview Answer

"Spring Boot Starter Dependencies are convenient dependency descriptors that group commonly used libraries for a specific functionality, reducing manual dependency configuration."


## Easy Memory Trick

Starter
→ Related dependencies ka ready-made bundle


Example:

starter-web
→ Web/API


starter-data-jpa
→ JPA/Database


starter-security
→ Security