# DOCKER Q7 — DOCKER VOLUME

## Problem

Container ke andar data store kiya:

Container
↓
Database/Data

Container delete ❌
↓
Data bhi lose ho sakta hai.


## Solution

Docker Volume

Container
↓
Volume
↓
Persistent Data


Container delete/recreate hone ke baad bhi
volume ka data survive kar sakta hai.


## Real Example

MySQL container:

MySQL Container
↓
Docker Volume
↓
Database Files


Container restart/recreate:

New MySQL Container
↓
Same Volume
↓
Old Data available ✅


## Commands

Volume create:

docker volume create mysql-data


Volume check:

docker volume ls


Container ke saath use:

docker run \
-v mysql-data:/var/lib/mysql \
mysql


## Volume kyu use karte hain?

→ Database data
→ Uploaded files
→ Persistent application data


## Real Project

MySQL:

Container
↓
mysql-data volume
↓
Persistent DB


Redis/Kafka jaise stateful containers ke
case me bhi persistence requirements ke according
volumes use kiye ja sakte hain.


## Interview Answer

"Docker containers are ephemeral by nature, so important data should not depend only on the container's writable layer. Docker volumes provide persistent storage that can survive container recreation."


## Easy Memory

Container
→ Temporary


Volume
→ Persistent Data


Container delete
❌ Container data


Volume
✅ Data survives


## 🧠 Simple real example:
MySQL Container
↓
mysql-data
↓
Database


Container delete
↓
New Container
↓
Same mysql-data
↓
Data safe ✅