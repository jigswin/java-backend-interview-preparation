# REDIS — Q10: RedisTemplate vs @Cacheable + Serialization

## 1. Sabse pehle Serialization kya hai?

Java Object ko aise format me convert karna
jise Redis me store/transmit kiya ja sake,
serialization kehlata hai.

Example:

Java Object:

Product
----------------
id = 101
name = Laptop
price = 50000


Serialization:

Product Object
      ↓
JSON / bytes
      ↓
Redis


Read karte waqt:

Redis
      ↓
JSON / bytes
      ↓
Java Product Object


Is reverse process ko:

DESERIALIZATION

kehte hain.


# 2. Real-World Example

Spring Boot:

Product product = new Product(
    101L,
    "Laptop",
    50000
);


Redis me directly Java object ka
memory structure store nahi hota.

Usko serialize karke store kiya jata hai.


Conceptually:

product:101

{
    "id": 101,
    "name": "Laptop",
    "price": 50000
}


# 3. Serialization kyu important hai?

Suppose:

Producer/Application
      ↓
Java Object


Redis ko data kisi serialized representation
me chahiye.


Agar serializer/deserializer configuration
match nahi karti:

Write:
Java Object → JSON


Read:
Redis JSON → incompatible Java type


To errors aa sakte hain.


Isliye:

Serializer
+
Deserializer

properly configure karna important hai.


# 4. RedisTemplate

RedisTemplate direct Redis operations
karne ke liye use kiya ja sakta hai.


Example:

redisTemplate.opsForValue()
             .set(
                 "product:101",
                 product
             );


Read:

Product product =
    (Product) redisTemplate
        .opsForValue()
        .get("product:101");


Yaha RedisTemplate ke serializers decide karte hain
ki key/value kaise represent honge.


# 5. StringRedisTemplate

Spring Data Redis me:

StringRedisTemplate


String-based Redis operations ke liye
convenient hai.


Example:

stringRedisTemplate
    .opsForValue()
    .set(
        "user:name:101",
        "Jigar"
    );


Read:

String name =
    stringRedisTemplate
        .opsForValue()
        .get("user:name:101");


Useful for:

→ String values
→ Simple keys
→ Counters
→ Tokens
→ Plain Redis commands


# 6. RedisTemplate vs StringRedisTemplate

RedisTemplate:

RedisTemplate<String, Object>


→ Objects ke saath kaam kar sakta hai
→ Serializer configuration required


StringRedisTemplate:

StringRedisTemplate


→ String based operations
→ Simple
→ String key/value use cases


# 7. `@Cacheable`

Spring Cache abstraction use karne par:

@Cacheable(
    value = "products",
    key = "#id"
)
public Product getProduct(Long id) {

    return productRepository
            .findById(id)
            .orElseThrow();
}


First request:

getProduct(101)
      ↓
Cache MISS
      ↓
Method executes
      ↓
MySQL
      ↓
Product
      ↓
Serialize
      ↓
Redis


Next request:

getProduct(101)
      ↓
Redis HIT
      ↓
Deserialize
      ↓
Product Object


Application ko manually Redis GET/SET
manage karne ki need nahi padti.


# 8. RedisTemplate Approach

Manual:

public Product getProduct(Long id) {

    String key = "product:" + id;

    Product product =
        (Product) redisTemplate
            .opsForValue()
            .get(key);

    if (product != null) {
        return product;
    }

    product =
        productRepository
            .findById(id)
            .orElseThrow();

    redisTemplate
        .opsForValue()
        .set(key, product);

    return product;
}


Yaha:

Application khud manage kar rahi hai:

→ Key
→ GET
→ Cache miss
→ DB
→ SET
→ Cache logic


# 9. Spring Cache Approach

Same use case:

@Cacheable(
    value = "products",
    key = "#id"
)
public Product getProduct(Long id) {

    return productRepository
            .findById(id)
            .orElseThrow();
}


Code bahut clean hai.


Spring Cache internally:

→ Cache lookup
→ Method execution
→ Cache put
→ Serialization
→ Cache retrieval


manage kar sakta hai.


# 10. Comparison

RedisTemplate:

Application
 ↓
RedisTemplate
 ↓
Redis


You control:

→ GET
→ SET
→ DELETE
→ TTL
→ Hash/List/Set operations
→ Custom logic


Spring Cache:

Application
 ↓
@Cacheable
 ↓
Cache Abstraction
 ↓
Redis


Framework cache behavior handle karta hai.


# 11. Kab RedisTemplate use kare?

Suppose requirement:

"Har user ke API requests count karne hain."

Example:

user:101:requests = 25


Then:

INCR


jaisi Redis-specific operation chahiye.


RedisTemplate useful.


Another example:

Leaderboard:

ZADD leaderboard


Redis Sorted Set operations chahiye.


RedisTemplate / native Redis operations
appropriate ho sakte hain.


# 12. Kab @Cacheable use kare?

Simple database caching:

Product
User
Configuration


Example:

@Cacheable("products")
public Product getProduct(Long id) {

    return repository.findById(id)
                     .orElseThrow();
}


Yaha manually Redis GET/SET likhne ki
need nahi hai.


# 13. Important Serialization Options

Common approaches:

JSON serialization


Example:

{
    "id": 101,
    "name": "Laptop"
}


Java native serialization bhi possible hai,
lekin distributed systems me JSON ya other explicit
serialization formats often easier to inspect and
interoperate with.


Interview me:

"Which serializer do you use?"


You can say:

"For application cache objects, I prefer a JSON-based serializer when interoperability and readable payloads are useful, with compatible deserialization configuration."


# 14. Serialization Problem Example

Suppose Product class:

ProductV1

{
    id,
    name,
    price
}


Later:

ProductV2

{
    id,
    name,
    price,
    category
}


Old cached data:

{
    id,
    name,
    price
}


New application ko old cached data read karna hai.


Serializer/deserializer configuration aur
backward compatibility carefully handle karni padti hai.


# 15. Cache Key Design

Good:

product:101

user:101

order:101


Bad:

101


Why?

Different services me:

101

kis entity ka hai?

Product?
User?
Order?


Namespace-based key better:

product:101
user:101
order:101


# 16. Real Microservice Example

Product Service:

Key:

product:101


Value:

{
    "id": 101,
    "name": "Laptop",
    "price": 50000
}


Flow:

Controller
    ↓
ProductService
    ↓
@Cacheable
    ↓
Redis
    ↓
Serializer
    ↓
JSON
    ↓
Redis


Read:

Redis
 ↓
JSON
 ↓
Deserializer
 ↓
Product
 ↓
Service


# 17. Interview Question

Q:

"What's the difference between RedisTemplate and @Cacheable?"


Answer:

"RedisTemplate provides programmatic control over Redis operations and is useful when I need Redis-specific data structures or custom logic. @Cacheable is part of Spring's cache abstraction and is useful for straightforward application caching because the framework handles cache lookup and population."


# 18. Another Interview Question

Q:

"How are Java objects stored in Redis?"


Answer:

"Java objects need to be serialized into a suitable representation such as JSON or bytes before being stored. When reading them back, the data is deserialized into the required Java object. The serializer and deserializer configuration must be compatible between the producer and consumer of the cached data."


# Easy Memory

RedisTemplate
→ Direct Redis control


StringRedisTemplate
→ String based Redis operations


@Cacheable
→ Automatic cache abstraction


Serialization
→ Object → JSON/bytes


Deserialization
→ JSON/bytes → Object


Good Key:

product:101


Bad Key:

101