# DOCKER Q10 — SPRING BOOT DOCKERIZATION

## Dockerize kya karna hai?

Spring Boot application ko
Docker Image + Container me run karna.


## Flow

Spring Boot Project
↓
mvn clean package
↓
app.jar
↓
Dockerfile
↓
Docker Image
↓
Docker Container
↓
Application


## Dockerfile

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]


## Build

docker build -t product-service .


## Run

docker run -p 8080:8080 product-service


## Check

Browser/API:

localhost:8080


## Real Project

Local:

Spring Boot
↓
Docker Container


Production:

Docker Image
↓
EC2 / Kubernetes
↓
Spring Boot Container


## Interview Answer

"To Dockerize a Spring Boot application, I package it as a JAR using Maven, create a Dockerfile with a Java base image, copy the JAR into the image and define the startup command. Then I build the image using docker build and run it as a container using docker run."


## Easy Memory

Maven
↓
JAR
↓
Dockerfile
↓
Image
↓
Container
↓
Spring Boot



## 🧠 Important interview point

EXPOSE 8080 port ko public nahi karta.

Actual mapping:

docker run -p 8080:8080 product-service