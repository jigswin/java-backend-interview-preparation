# DOCKER Q4 — IMPORTANT DOCKER COMMANDS

## 1. Images dekhna

docker images

→ Local Docker images show karta hai.


## 2. Containers dekhna

docker ps

→ Running containers


docker ps -a

→ Running + stopped containers


## 3. Image build karna

docker build -t my-app .

→ Dockerfile se image banayega.


## 4. Container run karna

docker run my-app

→ Container start karega.


Port ke saath:

docker run -p 8080:8080 my-app


## 5. Container stop

docker stop <container-id>


## 6. Container start

docker start <container-id>


## 7. Container remove

docker rm <container-id>


## 8. Image remove

docker rmi <image-name>


## 9. Container logs

docker logs <container-id>

→ Application ke logs dekhne ke liye.


## 10. Container ke andar jana

docker exec -it <container-id> /bin/sh

→ Running container ke andar shell open.


## Real Example

Spring Boot:

docker build -t product-service .

        ↓

docker run -p 8080:8080 product-service

        ↓

localhost:8080

        ↓

Spring Boot Container


## Interview Answer

"Common Docker commands I use include docker build to create an image, docker run to start a container, docker ps to list containers, docker logs to inspect logs, docker exec to execute commands inside a running container, and docker stop/rm to manage containers."


## Easy Memory

build → Image banao

run → Container chalao

ps → Containers dekho

logs → Logs dekho

exec → Container ke andar command

stop → Container roko

rm → Container delete

rmi → Image delete



## 🧠 Practical flow yaad rakh:
Dockerfile
↓
docker build
↓
Image
↓
docker run
↓
Container
↓
docker logs