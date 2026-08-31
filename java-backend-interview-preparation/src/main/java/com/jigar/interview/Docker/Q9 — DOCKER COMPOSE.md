# DOCKER Q9 — DOCKER COMPOSE

## Docker Compose kya hai?

Docker Compose ek tool hai jisse
multiple containers ko ek saath
define aur manage kar sakte hain.

Example:

Spring Boot
MySQL
Redis
Kafka


## Without Compose

Har container manually run:

docker run ...

docker run ...

docker run ...

Problem:
→ Commands zyada
→ Configuration manage karna difficult


## With Compose

docker-compose.yml
↓
Docker Compose
↓
┌───────────────┐
│ Spring Boot   │
│ MySQL         │
│ Redis         │
│ Kafka         │
└───────────────┘


## Example

services:

app:
image: product-service
ports:
- "8080:8080"

mysql:
image: mysql:8

redis:
image: redis


## Start

docker compose up


## Stop

docker compose down


## Real Project

docker-compose.yml

Product Service
↓
MySQL

Product Service
↓
Redis


Ek command:

docker compose up

→ Required containers start.


## Important Benefit

→ Multi-container application
→ Networking automatically manage
→ Environment/configuration centralized
→ Easy local development
→ Repeatable setup


## Interview Answer

"Docker Compose is used to define and run multi-container applications using a YAML configuration file. For example, we can define a Spring Boot application, MySQL and Redis as services and start them together using docker compose up."


## Easy Memory

Dockerfile
→ One image ka recipe


Docker Compose
→ Multiple containers ka setup


docker compose up
→ Start


docker compose down
→ Stop/remove Compose resources


## 🧠 Tere practical project me:
docker-compose.yml
↓
┌──────┼──────┐
↓      ↓      ↓
App   MySQL   Redis