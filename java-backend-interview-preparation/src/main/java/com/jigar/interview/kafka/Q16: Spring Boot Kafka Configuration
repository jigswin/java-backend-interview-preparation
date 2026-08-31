# KAFKA — Q16: Spring Boot Kafka Configuration

## 1. Spring Boot me Kafka ka basic flow

Producer:

Spring Boot
    ↓
KafkaTemplate
    ↓
Kafka Producer
    ↓
Kafka Topic


Consumer:

Kafka Topic
    ↓
Kafka Consumer
    ↓
@KafkaListener
    ↓
Spring Boot Service


## 2. Dependency

Maven me Spring Kafka dependency add karte hain:

<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>


Spring Boot version ke according dependency version
normally Spring Boot dependency management handle kar sakta hai.


## 3. application.properties

Basic configuration:

spring.kafka.bootstrap-servers=localhost:9092

spring.kafka.consumer.group-id=order-group

spring.kafka.consumer.auto-offset-reset=earliest

spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer

spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer

spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer

spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer


## 4. bootstrap-servers

Example:

spring.kafka.bootstrap-servers=localhost:9092


Iska meaning:

Spring Boot ko Kafka broker ka address kaha milega.


Production me multiple brokers configure kiye ja sakte hain:

broker1:9092,broker2:9092,broker3:9092


## 5. Producer — KafkaTemplate

Spring Kafka me messages send karne ke liye:

KafkaTemplate


Example:

@Service
public class OrderProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderProducer(
        KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(OrderCreatedEvent event) {

        kafkaTemplate.send(
            "order-created",
            event.getOrderId().toString(),
            event
        );
    }
}


Flow:

OrderCreatedEvent
      ↓
KafkaTemplate
      ↓
Serializer
      ↓
Kafka


## 6. `@KafkaListener`

Consumer side par:

@KafkaListener


Example:

@KafkaListener(
    topics = "order-created",
    groupId = "inventory-group"
)
public void consume(OrderCreatedEvent event) {

    System.out.println(
        "Order: " + event.getOrderId()
    );
}


Meaning:

"Is method ko Kafka topic ke messages consume karne hain."


## 7. Topic

Example:

"order-created"


Producer:

kafkaTemplate.send(
    "order-created",
    event
);


Consumer:

@KafkaListener(
    topics = "order-created"
)


Same topic.


## 8. Consumer Group

Example:

@KafkaListener(
    topics = "order-created",
    groupId = "inventory-group"
)


Another service:

@KafkaListener(
    topics = "order-created",
    groupId = "notification-group"
)


Result:

              order-created
                    ↓
          ┌─────────┴─────────┐
          ↓                   ↓
 inventory-group      notification-group
          ↓                   ↓
   Inventory Service   Notification Service


Different consumer groups same event
independently consume kar sakte hain.


## 9. `@KafkaListener` ka Real Example

OrderCreated event:

{
    "orderId": 101,
    "customerId": 50,
    "amount": 1500
}


Inventory Service:

@KafkaListener(
    topics = "order-created",
    groupId = "inventory-group"
)
public void consume(OrderCreatedEvent event) {

    inventoryService.reserveStock(
        event.getOrderId()
    );
}


Notification Service:

@KafkaListener(
    topics = "order-created",
    groupId = "notification-group"
)
public void consume(OrderCreatedEvent event) {

    notificationService.sendEmail(
        event.getOrderId()
    );
}


Same Kafka event:

→ Inventory update
→ Email notification


## 10. JSON Serialization

Producer:

Java Object
    ↓
JsonSerializer
    ↓
Kafka


Consumer:

Kafka
    ↓
JsonDeserializer
    ↓
Java Object


Example:

OrderCreatedEvent


Consumer method directly object receive kar sakta hai:

public void consume(OrderCreatedEvent event)


## 11. Key ka use

Producer:

kafkaTemplate.send(
    "order-created",
    event.getOrderId().toString(),
    event
);


Yaha:

Key = orderId


Same order ke events ko consistent key use karke
same partition me route karne me help mil sakti hai.


## 12. `acks`

Important producer configuration:

spring.kafka.producer.acks=all


Meaning:

Producer stronger acknowledgement/durability
ke liye broker response ka wait karega.


## 13. Idempotent Producer

Example:

spring.kafka.producer.properties.enable.idempotence=true


Retries ke case me duplicate records ka risk
reduce karne me help karta hai.


## 14. Consumer Offset

Basic configuration:

spring.kafka.consumer.enable-auto-commit=false


Agar application manual/controlled acknowledgement
use karna chahti hai to offset management explicitly
configure kiya ja sakta hai.


Spring Kafka me acknowledgement modes aur
container configuration available hain.


## 15. Error Handling

Consumer:

@KafkaListener
      ↓
Processing
      ↓
Exception ❌
      ↓
Error Handler
      ↓
Retry
      ↓
DLT


Spring Kafka me commonly:

DefaultErrorHandler

aur

DeadLetterPublishingRecoverer


jaise components use kiye ja sakte hain.


## 16. Complete Spring Boot Flow

                 ORDER SERVICE
                      |
                      ↓
             KafkaTemplate
                      |
                      ↓
                 Producer
                      |
                      ↓
                Kafka Topic
              "order-created"
                      |
          ┌───────────┴───────────┐
          ↓                       ↓
 INVENTORY SERVICE       NOTIFICATION SERVICE
          ↓                       ↓
   @KafkaListener           @KafkaListener
          ↓                       ↓
    Update Stock             Send Email


## 17. Important Annotations / Classes

KafkaTemplate
→ Message publish karne ke liye


@KafkaListener
→ Message consume karne ke liye


DefaultErrorHandler
→ Consumer error handling


DeadLetterPublishingRecoverer
→ Failed messages ko DLT par publish karne me help


JsonSerializer
→ Object → JSON/bytes


JsonDeserializer
→ JSON/bytes → Object


## Interview Answer

"In Spring Boot, we commonly use KafkaTemplate to publish messages and @KafkaListener to consume messages. Producer and consumer serializers/deserializers are configured according to the message type, such as String or JSON. Consumer groups are used to scale consumers and independently consume events, while Spring Kafka also provides error-handling and dead-letter mechanisms for failed messages."


## Easy Memory

PRODUCER:

Service
 ↓
KafkaTemplate
 ↓
Serializer
 ↓
Kafka


CONSUMER:

Kafka
 ↓
Deserializer
 ↓
@KafkaListener
 ↓
Service


ERROR:

Listener
 ↓
Error Handler
 ↓
Retry
 ↓
DLT