# KAFKA — Q13: Dead Letter Topic (DLT) & Error Handling

## 1. Problem kya hai?

Maan le:

Order Service
      ↓
Kafka
      ↓
Inventory Service


Kafka message:

OrderCreated(orderId=101)


Inventory Consumer process kar raha hai:

Read Message
     ↓
Update Inventory
     ↓
ERROR ❌


Ab question:

"Is failed message ka kya karein?"


## 2. Retry

Sabse pehle consumer message ko retry kar sakta hai.

Example:

Attempt 1 → FAIL ❌
Attempt 2 → FAIL ❌
Attempt 3 → FAIL ❌


Agar temporary problem hai:

Database temporarily down
External API temporarily unavailable
Network issue


to retry se problem solve ho sakti hai.


## 3. DLT kya hai?

DLT = Dead Letter Topic

Agar message repeatedly fail ho raha hai,
to us message ko ek separate Kafka topic me
send kar sakte hain.

Example:

Main Topic:

order-created


Processing:

order-created
      ↓
Consumer
      ↓
FAIL
      ↓
Retry
      ↓
FAIL
      ↓
Retry
      ↓
FAIL
      ↓
DLT


Dead Letter Topic:

order-created.DLT


## 4. Real-World Example

Suppose:

OrderCreated:

orderId = 101


Inventory Service:

Stock update karne ki koshish
       ↓
Database constraint error
       ↓
Retry
       ↓
Again fail
       ↓
DLT


Ab original consumer continuously
same bad message ko process karke
poori processing block nahi karega,
depending on the configured error-handling strategy.


## 5. DLT me kya store kar sakte hain?

Failed message ke saath useful metadata bhi
available/forward kiya ja sakta hai, depending on setup:

→ Original message
→ Topic
→ Partition
→ Offset
→ Exception/error information
→ Headers


Isse debugging easier hoti hai.


## 6. DLT ka benefit

→ Failed messages isolate
→ Main processing flow protect
→ Debugging easy
→ Manual reprocessing possible
→ Production failures handle karna easier


## 7. Real Production Flow

                Kafka
                  ↓
          order-created
                  ↓
              Consumer
                  ↓
             Processing
                  ↓
             ┌────┴────┐
             ↓         ↓
          Success     Failure
             ↓         ↓
           Done      Retry
                         ↓
                    Retry Limit
                         ↓
                        DLT
                         ↓
                  Investigation
                         ↓
                  Fix + Reprocess


## 8. Spring Kafka Concept

Spring Kafka me error handling ke liye
error handlers aur Dead Letter Publishing
mechanisms available hain.

Conceptually:

@KafkaListener(
    topics = "order-created"
)
public void consume(OrderCreatedEvent event) {

    // process event
}


Agar processing fail ho:

Consumer
   ↓
Error Handler
   ↓
Retry
   ↓
DLT


Spring Kafka me `DefaultErrorHandler`
aur `DeadLetterPublishingRecoverer`
jaise components commonly use kiye ja sakte hain.


## 9. Important Point

Har error ke liye immediately DLT nahi bhejna chahiye.

### Temporary error:

Database down
Network issue

→ Retry useful


### Permanent error:

Invalid data
Invalid business state
Malformed event


→ Retry repeatedly karna useful nahi ho sakta
→ DLT better


## 10. DLT vs Retry

Retry:

"Thoda time baad fir try karo."


DLT:

"Repeatedly fail ho raha hai,
ab ise side me rakho aur investigate karo."


## 11. Real Interview Scenario

Question:

"What will you do if Kafka consumer keeps failing for a particular message?"


Answer:

"First I would distinguish between transient and permanent failures. For transient failures I would use controlled retries. If the message continues to fail after the retry limit, I would route it to a Dead Letter Topic along with useful error metadata. This prevents a bad message from continuously blocking normal processing and allows later investigation or reprocessing."


## 12. Easy Memory

Message
  ↓
Process
  ↓
Success → DONE ✅

Failure
  ↓
Retry
  ↓
Success → DONE ✅

Failure
  ↓
Retry Limit
  ↓
DLT
  ↓
Investigate / Reprocess


## Interview Answer

"A Dead Letter Topic is used to store messages that cannot be successfully processed after the configured retry/error-handling policy. It isolates failed messages from the normal processing flow and allows them to be investigated and potentially reprocessed later."


## Easy Memory

Retry
→ Try again


DLT
→ Failed message ko side me rakho