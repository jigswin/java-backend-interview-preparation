# Spring Boot — Q7: What is Auto Configuration?

## What is Auto Configuration?

Spring Boot automatically configures the application based on:

- Dependencies present in the project
- Application configuration
- Classes/Beans already available

Simple:

Dependency add karo
        ↓
Spring Boot configuration detect karta hai
        ↓
Required configuration automatically setup


## Example

Agar project me:

spring-boot-starter-web

dependency hai, Spring Boot web application ke liye required configuration automatically configure kar sakta hai, including embedded web server setup.


Isliye hume manually bahut saari configuration nahi karni padti.


## @EnableAutoConfiguration

Auto Configuration enable karne ke liye:

@EnableAutoConfiguration

use hota hai.

Aur:

@SpringBootApplication

ke andar already:

@EnableAutoConfiguration

included hai.


## Auto Configuration kaise decide hoti hai?

Spring Boot conditions check karta hai.

Example:

"Class available hai?"

"Required Bean already exist karta hai?"

"Specific property enabled hai?"

Conditions satisfy hone par corresponding auto-configuration apply hoti hai.


## Important

Auto Configuration ka matlab:

❌ Har cheez blindly automatically configure karna nahi.

✅ Conditions ke basis par suitable default configuration provide karna.


## Interview Answer

"Spring Boot Auto Configuration automatically configures the application based on the dependencies and configuration present in the project. It reduces the need for manual configuration."


## Easy Memory Trick

Dependency
↓
Spring Boot detects it
↓
Conditions check
↓
Required configuration
↓
Auto Configuration