# AWS Q8 — AUTO SCALING

## Auto Scaling kya hai?

Traffic/load ke according
EC2 instances ko automatically
increase ya decrease karna.

Example:

Normal traffic:
2 EC2

High traffic:
4 EC2

Low traffic:
2 EC2


## Real Example

Users
↓
ALB
↓
EC2-1
EC2-2


Traffic suddenly increase:

        ↓
Auto Scaling
↓
EC2-3
EC2-4


ALB automatically healthy
instances ko traffic distribute karega.


## Scale Out

Instances increase:

2 → 4 → 6

Isko:

SCALE OUT

kehte hain.


## Scale In

Instances decrease:

6 → 4 → 2

Isko:

SCALE IN

kehte hain.


## Example

CPU > 70%
↓
Add EC2


CPU < 30%
↓
Remove EC2


Actual production policies CPU ke alawa
other metrics par bhi based ho sakti hain.


## Auto Scaling Group

ASG = Auto Scaling Group

Ye EC2 instances ka group manage karta hai.

Example:

Minimum = 2
Desired = 2
Maximum = 5


Traffic badha:

2 → 3 → 4


Traffic kam:

4 → 3 → 2


## ALB + Auto Scaling

              Users
                ↓
               ALB
             /     \
           EC2     EC2
             \     /
           Auto Scaling
                ↓
        New instances when needed


ALB:
→ Traffic distribute


Auto Scaling:
→ Instances manage


## Interview Answer

"Auto Scaling automatically adjusts the number of EC2 instances based on configured scaling policies and demand. Scale-out adds instances during high load, while scale-in removes instances when demand decreases. It is commonly used with a Load Balancer."


## Easy Memory

ALB
→ Traffic distribute


Auto Scaling
→ EC2 count manage


Scale Out
→ Instances ↑


Scale In
→ Instances ↓




## 🧠 Ek line me:

ALB = “Traffic kahan bhejna hai?”

Auto Scaling = “Kitne servers chahiye?”

Dono saath:

Users
↓
ALB
↓
EC2 EC2 EC2
↑
Auto Scaling



# VERTICAL vs HORIZONTAL SCALING

## 1. Vertical Scaling

Ek hi server ki power increase karna.

Example:

EC2
2 CPU + 4 GB RAM
↓
4 CPU + 8 GB RAM


Matlab:
Same server
+ More CPU/RAM


Easy Memory:
VERTICAL = Server ko POWERFUL banana


## 2. Horizontal Scaling

Servers ki quantity increase karna.

Example:

Before:

        EC2-1


After:

        EC2-1
        EC2-2
        EC2-3


Matlab:
More servers/instances add karna.


Easy Memory:
HORIZONTAL = Servers ki COUNT badhana


## Real Example

1000 users:

Vertical:

        ALB
         ↓
    Powerful EC2
    16 CPU / 32 GB


Horizontal:

        ALB
       /   \
    EC2-1  EC2-2
             \
             EC2-3


## Difference

Vertical:
→ Same server
→ CPU/RAM increase
→ Scaling limit hoti hai


Horizontal:
→ Multiple servers
→ Better scalability
→ High availability bhi improve ho sakti hai
→ Load Balancer ke saath commonly use hota hai


## Interview Answer

"Vertical scaling means increasing the resources of an existing server, such as CPU or RAM. Horizontal scaling means adding more server instances and distributing traffic among them using a load balancer."

## Shortcut

Vertical
= SIZE ↑

Horizontal
= NUMBER ↑


🔥 Tere AWS architecture me:

Auto Scaling → mainly Horizontal Scaling

High Traffic
↓
Auto Scaling
↓
EC2: 2 → 3 → 4
↓
ALB distributes traffic

Vertical scaling me instead:

EC2:
4 GB RAM
↓
16 GB RAM

Bas bhai SIZE vs NUMBER yaad rakh. 😎