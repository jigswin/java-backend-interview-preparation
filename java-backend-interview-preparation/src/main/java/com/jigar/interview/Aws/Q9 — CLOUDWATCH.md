# AWS Q9 — CLOUDWATCH

## CloudWatch kya hai?

CloudWatch = AWS monitoring service.

Isse hum AWS resources aur applications ko
monitor kar sakte hain.

Monitor:

→ CPU
→ Memory (application/agent based)
→ Network
→ Errors
→ Logs
→ Requests
→ Alerts


## Real Example

EC2 par Spring Boot application running hai.

CloudWatch:

EC2
↓
CloudWatch
↓
CPU = 85%
↓
Alarm
↓
Action/Notification


## Logs

Spring Boot application ke logs ko bhi
CloudWatch me centralize kiya ja sakta hai
(appropriate agent/setup ke through).

Example:

ERROR Payment failed
ERROR Database connection failed


## Metrics vs Logs

Metrics:
→ Numerical data

Example:
CPU = 80%


Logs:
→ Detailed application/system messages

Example:
"Payment API failed"


## Alarm

Example:

CPU > 80%
↓
CloudWatch Alarm
↓
Notification / Scaling action


## Real Project

Users
↓
ALB
↓
EC2
↓
Spring Boot
↓
CloudWatch

CloudWatch se:

→ CPU monitor
→ Application logs
→ Errors
→ Alarms


## Interview Answer

"Amazon CloudWatch is used for monitoring AWS resources and applications. It provides metrics, logs and alarms. For example, we can monitor EC2 CPU utilization and create an alarm when it crosses a threshold."


## Easy Memory

CloudWatch
→ Monitoring


Metrics
→ Numbers


Logs
→ Detailed messages


Alarm
→ Threshold cross hone par alert/action



🧠 Simple yaad rakh:

EC2 = Server
CloudWatch = Server ka CCTV 📹

Aur jo humne abhi padha:

Users
↓
ALB
↓
EC2
↓
Spring Boot
↓
CloudWatch