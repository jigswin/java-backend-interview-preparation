# Spring Boot — Q37: What is Spring Boot Starter Parent?

## Answer

`spring-boot-starter-parent` Maven project ke liye **default configuration aur dependency versions** provide karta hai.

Example:

<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>...</version>
</parent>


## Iska benefit kya hai?

Ye mainly:

- Dependency versions manage karta hai
- Maven configuration simplify karta hai
- Java compiler settings provide kar sakta hai
- Common plugin configuration provide karta hai


## Example

Agar hum:

spring-boot-starter-web

use kar rahe hain, to compatible dependency versions ko manually manage karne ki need kam ho jati hai.


## Important

`starter-parent` khud application functionality provide nahi karta.

Ye mainly **Maven project configuration aur dependency management** me help karta hai.


## Interview Answer

"`spring-boot-starter-parent` is a Maven parent POM provided by Spring Boot that provides default project configuration and manages compatible dependency and plugin versions."

## Easy Memory

Starter Parent
→ Maven configuration + Version Management