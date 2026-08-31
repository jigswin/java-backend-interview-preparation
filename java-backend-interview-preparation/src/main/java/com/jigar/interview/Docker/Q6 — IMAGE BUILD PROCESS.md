# DOCKER Q6 — IMAGE BUILD PROCESS

## Image kaise banti hai?

Simple flow:

Dockerfile
↓
docker build
↓
Docker Image
↓
docker run
↓
Container


## Spring Boot Example

Project:

target/app.jar

Dockerfile:

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]


## Step 1 — Build JAR

mvn clean package


Output:

target/app.jar


## Step 2 — Build Docker Image

docker build -t product-service .


Meaning:

-t
→ Image ka name/tag


.
→ Current directory me Dockerfile


Result:

product-service:latest


## Step 3 — Check Image

docker images


## Step 4 — Run Container

docker run -p 8080:8080 product-service


## Flow

Spring Boot
↓
JAR
↓
Dockerfile
↓
docker build
↓
Docker Image
↓
docker run
↓
Container
↓
Application


## Interview Answer

"First I package the Spring Boot application as a JAR using Maven. Then Docker uses the Dockerfile to build an image with docker build. Finally, I create and run a container from that image using docker run."


## Easy Memory

mvn package
→ JAR

docker build
→ Image

docker run
→ Container


## 🧠 Real command flow
mvn clean package


docker build -t product-service .


docker run -p 8080:8080 product-service

Bas bhai JAR → Image → Container yaad rakh. 🔥