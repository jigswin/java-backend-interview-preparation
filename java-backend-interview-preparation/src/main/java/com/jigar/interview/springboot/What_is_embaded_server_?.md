# Spring Boot — Q9: What is Embedded Server?

## What is Embedded Server?

Spring Boot application ke andar web server included hota hai, isliye hume separately Tomcat install/configure karke application deploy karne ki zarurat normally nahi hoti.

Example:

spring-boot-starter-web

→ Embedded Tomcat commonly provided.


## Traditional Approach

Application
↓
WAR file
↓
Install Tomcat separately
↓
Deploy WAR


## Spring Boot

Spring Boot Application
↓
Embedded Tomcat
↓
Run application


Run:

java -jar app.jar


Application directly start ho sakti hai.


## Common Embedded Servers

- Tomcat
- Jetty
- Undertow


Spring Boot web applications me Tomcat commonly default hota hai.


## Port Change

Default:

8080


application.properties:

server.port=9090


Ab application:

localhost:9090


par run hogi.


## Why Embedded Server?

- Easy deployment
- No separate server installation
- Application self-contained hoti hai
- Microservices ke liye convenient


## Interview Answer

"An embedded server means the web server is packaged with the Spring Boot application, allowing the application to run directly without deploying it to a separately installed external server."


## Easy Memory Trick

Traditional:

App → External Tomcat


Spring Boot:

App + Tomcat → One runnable application