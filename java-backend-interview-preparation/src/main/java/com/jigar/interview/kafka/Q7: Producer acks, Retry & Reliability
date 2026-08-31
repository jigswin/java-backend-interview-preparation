# KAFKA — Q7: Producer acks, Retry & Reliability

## 1. `acks` kya hai?

`acks` ka matlab hai:

Producer ko Kafka se kitna acknowledgement chahiye
before considering the send successful.


Main options:

acks=0
acks=1
acks=all


# 2. acks=0

Producer Kafka ke acknowledgement ka wait nahi karta.

Producer
   ↓
Kafka
   ↓
No ACK wait


Benefit:
→ Very fast


Risk:
→ Message delivery guarantee weak
→ Message loss possible


Use case:

Jahan data loss acceptable ho.


# 3. acks=1

Producer partition ke leader se acknowledgement ka
wait karta hai.

Producer
   ↓
Leader
   ↓
ACK
   ↓
Producer


Leader ne record accept kar liya to producer ko ACK mil sakta hai.

Risk:

Leader failure / replication timing ke according
stronger durability ke liye acks=all preferred ho sakta hai.


# 4. acks=all

Producer ko ISR (In-Sync Replicas) based stronger
acknowledgement milta hai.

Producer
   ↓
Leader
   ↓
ISR replicas
   ↓
ACK
   ↓
Producer


Ye stronger durability provide karta hai.


## Production Example

Payment event:

PaymentSuccess
      ↓
Kafka Producer


Payment event important hai.

Hum generally stronger durability chahenge.

Example configuration:

acks=all


# 5. Retry kya hota hai?

Suppose producer ne Kafka ko message bheja:

Producer
   ↓
Kafka

Temporary network problem ❌


Producer retry kar sakta hai.

Producer
   ↓
Retry
   ↓
Kafka


Kafka producer configuration me retries/retry-related
settings available hoti hain.


# 6. Idempotent Producer

Retries ki wajah se duplicate records ka risk ho sakta hai.

Kafka producer idempotence support karta hai.

Example:

Producer
   ↓
OrderCreated


Network issue
   ↓
Retry


Idempotent producer duplicate write ke risk ko reduce karta hai
within Kafka's supported producer semantics.


Common configuration:

enable.idempotence=true


# 7. Important Configuration

Example:

spring.kafka.producer.acks=all

spring.kafka.producer.retries=3

spring.kafka.producer.properties.enable.idempotence=true


Exact configuration production requirements ke according
tune ki jati hai.


# 8. Real-World Example

Order Service:

Order Created
      ↓
Kafka Producer
      ↓
acks=all
      ↓
Kafka
      ↓
Replication
      ↓
ACK
      ↓
Producer


Agar temporary failure ho:

Producer
      ↓
Retry
      ↓
Kafka


Isse important events ki reliability improve hoti hai.


# 9. Important Difference

Producer reliability:

→ acks
→ retries
→ idempotence


Consumer reliability:

→ Offset management
→ At-least-once processing
→ Idempotent consumer


## 10. Interview Answer

"`acks` controls the level of acknowledgement a Kafka producer requires from the broker. `acks=0` provides no acknowledgement, `acks=1` waits for the leader, and `acks=all` provides stronger durability based on the in-sync replicas. Producer retries help recover from transient failures, and idempotence can prevent duplicate records caused by retries."


## Easy Memory

acks=0
→ No ACK
→ Fast
→ Risky


acks=1
→ Leader ACK


acks=all
→ Stronger durability


Retry
→ Temporary failure ke baad resend


Idempotent Producer
→ Retry ke duplicate risk ko reduce karta hai