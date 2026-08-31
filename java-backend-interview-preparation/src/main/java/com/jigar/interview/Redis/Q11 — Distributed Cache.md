# Redis Q11 — Distributed Cache

## Kya hota hai?

Agar hamare application ke multiple instances hain:

                    Load Balancer
                   /      |      \
                  ↓       ↓       ↓
               App-1   App-2   App-3
                  \       |       /
                   \      |      /
                      Redis
                        |
                     MySQL

Sabhi application instances same Redis
cache use karte hain.

Isko Distributed Cache kehte hain.


## Real Example

App-1 ne product:101 Redis me save kiya.

App-2 ko bhi wahi product chahiye.

App-2 → Redis → product:101

App-2 ko MySQL par dobara query karne ki
need nahi hai.


## Local Cache vs Distributed Cache

Local Cache:

App-1 → Memory
App-2 → Memory
App-3 → Memory

Har instance ka cache alag.


Distributed Cache:

App-1 ─┐
App-2 ─┼→ Redis
App-3 ─┘

Sab same cache use karte hain.


## Redis ka advantage

Multiple microservice/application instances ke
beech common cache provide kar sakta hai.

Useful for:

→ Product cache
→ User/session data
→ Rate limiting
→ Shared temporary data


## Interview Answer

"Redis can act as a distributed cache shared by multiple application instances. This ensures that different instances can access the same cached data instead of maintaining separate local caches."


## Easy Memory

Local Cache:
Instance → Own Memory

Distributed Cache:
Multiple Instances → Same Redis