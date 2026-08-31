# DOCKER Q3 — DOCKERFILE

## Dockerfile kya hai?

Dockerfile ek text file hoti hai
jisme Docker Image banane ke instructions
likhe hote hain.

Simple:

Dockerfile
↓
Docker Build
↓
Docker Image
↓
Container


## Spring Boot Example

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]


## Important Instructions

FROM
→ Base image select karta hai


WORKDIR
→ Working directory set karta hai


COPY
→ Files image me copy karta hai


EXPOSE
→ Application ke intended port ko document karta hai


ENTRYPOINT
→ Container start hone par command execute karta hai


## Build

docker build -t my-app .


Meaning:

Dockerfile
↓
Image
↓
my-app


## Run

docker run -p 8080:8080 my-app


Then:

localhost:8080
↓
Docker Container
↓
Spring Boot


## Real Example

Project:

target/app.jar

Dockerfile:

FROM Java 21
COPY app.jar
RUN/START application


Build:

docker build


Result:

Spring Boot Docker Image


## Interview Answer

"A Dockerfile is a text file containing instructions to build a Docker image. For a Spring Boot application, I can specify the Java base image, copy the JAR file, define the working directory and configure the command to start the application."


## Easy Memory

Dockerfile
→ Image banane ki recipe


Dockerfile
↓
docker build
↓
Image
↓
docker run
↓
Container


## 🧠 Important flow:

Dockerfile → Image → Container