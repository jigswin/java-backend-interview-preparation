# DOCKER Q5 — DOCKERFILE INSTRUCTIONS

## FROM

Base image define karta hai.

FROM eclipse-temurin:21-jdk


## WORKDIR

Container ke andar working directory set karta hai.

WORKDIR /app


## COPY

Host se file ko image ke andar copy karta hai.

COPY target/app.jar app.jar


## RUN

Image build hone ke time command execute karta hai.

RUN mkdir /logs


## CMD

Container start hone par default command deta hai.

CMD ["java", "-jar", "app.jar"]


## ENTRYPOINT

Container ka main executable/command define karta hai.

ENTRYPOINT ["java", "-jar", "app.jar"]


## EXPOSE

Application kis port par listen karti hai,
ye document karta hai.

EXPOSE 8080


# CMD vs ENTRYPOINT

CMD:
→ Default command
→ Override kiya ja sakta hai


ENTRYPOINT:
→ Main command/executable
→ Arguments ke saath commonly use hota hai


Spring Boot me:

ENTRYPOINT ["java", "-jar", "app.jar"]

common approach hai.


# Important Difference

RUN
→ Image BUILD time


CMD
→ Container START time


ENTRYPOINT
→ Container START time


## Complete Example

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]


## Easy Memory

FROM
→ Base Image

WORKDIR
→ Working Folder

COPY
→ File Copy

RUN
→ Build Time Command

CMD
→ Default Start Command

ENTRYPOINT
→ Main Start Command

EXPOSE
→ Port Documentation



## 🧠 Sabse important:

RUN = image banate waqt

CMD/ENTRYPOINT = container start karte waqt

Aur EXPOSE 8080 automatically port publish nahi karta — actual host mapping ke liye docker run -p 8080:8080 ... use karte hain.