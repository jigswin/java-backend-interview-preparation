# DOCKER Q2 — IMAGE vs CONTAINER

## Docker Image kya hai?

Image ek read-only blueprint/template hoti hai
jisme application aur required dependencies
packaged hoti hain.

Example:

Spring Boot App
+ Java Runtime
+ Dependencies
  ↓
  Docker Image


## Docker Container kya hai?

Container = Docker Image ka running instance.

Example:

Docker Image
↓
Container
↓
Spring Boot Running


## Real Example

Ek image se multiple containers
run kar sakte hain:

        Spring Boot Image
          /     |      \
         ↓      ↓       ↓
      EC2-1   EC2-2   EC2-3


## Main Difference

Image:
→ Blueprint
→ Read-only
→ Build hoti hai
→ Store/share ki ja sakti hai


Container:
→ Running instance
→ Image se create hota hai
→ Start/stop/restart kar sakte hain


## Simple Example

Image = Class

Container = Object

Jaise:

class Product { }


Product p1 = new Product();
Product p2 = new Product();


Same concept:

Image
↓
Container 1
Container 2
Container 3


## Important Commands

Image dekhna:

docker images


Container dekhna:

docker ps


Container run:

docker run image-name


## Interview Answer

"A Docker image is an immutable template containing the application and its dependencies. A container is a running instance created from that image. Multiple containers can be created from the same image."


## Easy Memory

IMAGE
→ Blueprint 📦


CONTAINER
→ Running instance ▶️


Image → Container


## 🧠 Bas ye line yaad rakh:

Image = kya run karna hai
Container = woh application abhi run ho rahi hai