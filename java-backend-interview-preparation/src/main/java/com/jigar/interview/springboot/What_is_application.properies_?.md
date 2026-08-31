# Spring Boot — Q27: application.properties kya hota hai?

## Answer

`application.properties` file me hum application ki configuration define karte hain.

Example:

server.port=9090

spring.datasource.url=jdbc:mysql://localhost:3306/employee_db

spring.datasource.username=root

spring.datasource.password=root


## Common Uses

- Server port
- Database configuration
- Logging
- JPA/Hibernate settings
- Custom application properties


## Example

server.port=9090

Isse application default 8080 ke instead:

9090

port par run hogi.


## application.yml

Same configuration YAML format me bhi likh sakte hain:

server:
  port: 9090


## Interview Answer

"`application.properties` is used to store Spring Boot application configuration such as server settings, database configuration, JPA settings and custom properties."

## Easy Memory

application.properties
→ Application ki configuration

Example:

server.port
DB URL
DB username/password
JPA settings