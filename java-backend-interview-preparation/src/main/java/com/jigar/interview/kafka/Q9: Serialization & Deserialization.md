# KAFKA — Q9: Serialization & Deserialization

## 1. Serialization kya hai?

Java Object ko aise format me convert karna jise Kafka
store/transmit kar sake:

Java Object
    ↓
Serialization
    ↓
Bytes / JSON / Avro etc.
    ↓
Kafka


Example:

OrderCreatedEvent

{
    orderId: 101,
    userId: 50,
    amount: 1500
}


Object → JSON/bytes

Ye Serialization hai.


## 2. Deserialization kya hai?

Kafka se message receive hone ke baad us data ko
wapas Java Object me convert karna:

Kafka
   ↓
JSON / Bytes
   ↓
Deserialization
   ↓
Java Object


Example:

Kafka Message
     ↓
OrderCreatedEvent object


## 3. Real-World Example

Order Service:

OrderCreatedEvent event =
    new OrderCreatedEvent(
        101L,
        50L,
        1500
    );


Producer:

Java Object
     ↓
Serializer
     ↓
JSON
     ↓
Kafka Topic


Consumer:

Kafka Topic
     ↓
JSON
     ↓
Deserializer
     ↓
OrderCreatedEvent
     ↓
Business Logic


## 4. String Example

Agar hum simple String bhej rahe hain:

String message = "Order Created";


Producer:

String
 ↓
StringSerializer
 ↓
Kafka


Consumer:

Kafka
 ↓
StringDeserializer
 ↓
String


Simple hai.


## 5. JSON Example

Real project me:

OrderCreatedEvent

{
    "orderId": 101,
    "userId": 50,
    "amount": 1500
}


Producer:

Java Object
 ↓
JSON Serializer
 ↓
Kafka


Consumer:

Kafka
 ↓
JSON Deserializer
 ↓
Java Object


Ye microservices me much more useful hai.


## 6. Kafka me Message actually kya store hota hai?

Kafka internally records ko bytes ke form me
store/transmit karta hai.

Serializer:

Object
 ↓
Bytes


Deserializer:

Bytes
 ↓
Object


Isliye Producer aur Consumer ki serialization/
deserialization configuration compatible honi chahiye.


## 7. Spring Boot Example

Producer configuration concept:

Key:

StringSerializer

Value:

JSON Serializer


Consumer:

Key:

StringDeserializer

Value:

JSON Deserializer


Conceptually:

Producer
  Key   → String
  Value → JSON


Consumer
  Key   → String
  Value → JSON


## 8. Real Microservices Example

Order Service:

OrderCreatedEvent

    ↓
JSON Serialization

    ↓

Kafka

    ↓

JSON Deserialization

    ↓

Inventory Service

    ↓

OrderCreatedEvent


Inventory Service ko Order Service ki
internal Java class directly nahi milti.

Usse serialized event milta hai aur wo usse
apne expected event structure me deserialize karta hai.


## 9. Important Point — Schema

Suppose initial event:

{
    "orderId": 101,
    "amount": 1500
}


Baad me:

{
    "orderId": 101,
    "amount": 1500,
    "customerId": 50
}


Event structure change karte waqt backward/forward
compatibility ka dhyan rakhna important hai.


Large event-driven systems me:

→ Avro
→ Protobuf
→ JSON Schema

jaise schema-based approaches use kiye ja sakte hain.


## 10. Serialization vs Deserialization

Serialization:

Java Object
    ↓
JSON / Bytes

Producer side


Deserialization:

JSON / Bytes
    ↓
Java Object

Consumer side


## Interview Answer

"Serialization converts an object or data into a format that can be transmitted and stored by Kafka, while deserialization converts the received data back into an application object. In Spring Kafka, serializers and deserializers are configured for keys and values, commonly using String or JSON."


## Easy Memory

Producer:

Object
 ↓
Serialize
 ↓
Kafka


Consumer:

Kafka
 ↓
Deserialize
 ↓
Object


Serialize
→ Object → Data


Deserialize
→ Data → Object