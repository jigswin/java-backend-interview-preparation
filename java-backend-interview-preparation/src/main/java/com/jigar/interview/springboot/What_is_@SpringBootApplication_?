# @SpringBootApplication — Easy Explanation

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(
            Application.class,
            args
        );
    }
}

`@SpringBootApplication` ek shortcut annotation hai.

Ye internally 3 important annotations ko combine karta hai:

1. @Configuration
2. @EnableAutoConfiguration
3. @ComponentScan


--------------------------------------------------
1. @Configuration
--------------------------------------------------

Iska meaning:

"Ye class Spring configuration ke liye use ho sakti hai."

Example:

@Configuration
public class AppConfig {

    @Bean
    public EmployeeService employeeService() {

        return new EmployeeService();
    }
}

Yani Spring ko hum bata rahe hain ki
is class me Bean configuration ho sakti hai.


--------------------------------------------------
2. @EnableAutoConfiguration
--------------------------------------------------

Ye Spring Boot ka bahut important feature hai.

Spring Boot project me hum dependencies add karte hain.

Example:

spring-boot-starter-web

Spring Boot automatically samajh leta hai ki
hume web application banana hai.

Phir required configuration automatically setup karne ki koshish karta hai.

Example:

Tomcat
Spring MVC
JSON support
etc.

Isliye hume bahut saari configuration manually nahi karni padti.


Simple:

Dependency add karo
        ↓
Spring Boot dekhta hai
        ↓
Required configuration automatically setup


--------------------------------------------------
3. @ComponentScan
--------------------------------------------------

Iska kaam hai Spring components ko scan karna.

Example:

@Service
class EmployeeService {
}


@Repository
class EmployeeRepository {
}


@RestController
class EmployeeController {
}


@Component
class EmailService {
}


@ComponentScan in classes ko scan karke
Spring Container me Beans ke roop me register karta hai.

Normally @SpringBootApplication jis package me hai,
us package aur uske sub-packages ko scan karta hai.


--------------------------------------------------
REAL-WORLD FLOW
--------------------------------------------------

Suppose package:

com.example.employee

    Application.java

    controller/
        EmployeeController.java

    service/
        EmployeeService.java

    repository/
        EmployeeRepository.java


Application.java:

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(
            Application.class,
            args
        );
    }
}


Application start hui
        ↓
@SpringBootApplication
        ↓
@Configuration
        ↓
Configuration available

        ↓
@EnableAutoConfiguration
        ↓
Required Spring Boot configuration
automatically setup

        ↓
@ComponentScan
        ↓
Controller / Service / Repository
scan hote hain

        ↓
Spring Beans create/register karta hai

        ↓
Application ready 🚀


--------------------------------------------------
INTERVIEW ME KAISE BOLNA HAI?
--------------------------------------------------

"@SpringBootApplication is a convenience annotation that combines
@Configuration, @EnableAutoConfiguration and @ComponentScan.

@Configuration marks the class as a configuration class,
@EnableAutoConfiguration enables Spring Boot's automatic configuration,
and @ComponentScan scans and registers Spring components such as
Controller, Service and Repository."


--------------------------------------------------
EASY MEMORY TRICK
--------------------------------------------------

@SpringBootApplication
        ↓
        ├── Configuration
        │   → Configuration batao
        │
        ├── AutoConfiguration
        │   → Configuration automatically karo
        │
        └── ComponentScan
            → Components dhundo aur register karo


ONE LINE:

@SpringBootApplication
= Configuration
+ Auto Configuration
+ Component Scanning