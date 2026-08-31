# REDIS — Q9: REDIS IN SPRING BOOT

## 1. Spring Boot me Redis use karne ke liye kya chahiye?

Basic flow:

Spring Boot
    ↓
Spring Data Redis
    ↓
Redis Client
    ↓
Redis Server


Spring Boot application Redis ke saath
communicate karne ke liye Spring Data Redis
use kar sakti hai.


# 2. Dependency

Maven:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>


Isse Spring Boot me Redis integration ke required
support classes mil jate hain.


# 3. Redis Server

Local development me:

Redis Server
→ localhost:6379


Default Redis port:

6379


Architecture:

Spring Boot
     |
     | localhost:6379
     ↓
   Redis


Production me Redis usually separate server,
managed service, cluster etc. par ho sakta hai.


# 4. application.properties

Basic:

spring.data.redis.host=localhost

spring.data.redis.port=6379


Meaning:

Host:
→ Redis kaha running hai


Port:
→ Redis kis port par listen kar raha hai


Production example concept:

spring.data.redis.host=redis-server

spring.data.redis.port=6379


# 5. RedisTemplate

Spring Data Redis ka important class:

RedisTemplate


Iska use Redis ke saath programmatically
data read/write karne ke liye kiya ja sakta hai.


Example:

@Autowired
private RedisTemplate<String, Object> redisTemplate;


Then:

redisTemplate.opsForValue()
             .set("product:101", product);


Read:

Object product =
    redisTemplate.opsForValue()
                .get("product:101");


Concept:

RedisTemplate
      ↓
Redis Commands


# 6. `opsForValue()`

String/value operations ke liye:

redisTemplate.opsForValue()


Example:

set:

redisTemplate.opsForValue()
             .set("name", "Jigar");


get:

redisTemplate.opsForValue()
             .get("name");


Conceptually:

SET name Jigar

GET name


# 7. Hash Operations

Redis Hash ke liye:

redisTemplate.opsForHash()


Example:

redisTemplate.opsForHash()
             .put(
                 "user:101",
                 "name",
                 "Jigar"
             );


Concept:

user:101
   |
   ├── name → Jigar
   ├── city → Bangalore
   └── role → USER


# 8. List Operations

Redis List:

redisTemplate.opsForList()


Example:

redisTemplate.opsForList()
             .rightPush(
                 "notifications:101",
                 "Order Created"
             );


Useful for ordered collections /
queue-like use cases.


# 9. Set Operations

Redis Set:

redisTemplate.opsForSet()


Example:

redisTemplate.opsForSet()
             .add(
                 "user:101:roles",
                 "ADMIN"
             );


Duplicate values automatically
allowed nahi hoti.


# 10. Sorted Set

Redis Sorted Set:

redisTemplate.opsForZSet()


Example:

redisTemplate.opsForZSet()
             .add(
                 "leaderboard",
                 "Jigar",
                 100
             );


Concept:

Jigar → 100


# 11. TTL with RedisTemplate

Example:

redisTemplate.opsForValue()
             .set(
                 "product:101",
                 product,
                 Duration.ofMinutes(10)
             );


Meaning:

product:101
     ↓
Stored
     ↓
TTL = 10 minutes
     ↓
Expired


# 12. Cache Approach in Spring Boot

There are generally two approaches:

### Approach 1

Direct RedisTemplate


Application
    ↓
RedisTemplate
    ↓
Redis


You explicitly manage:

→ GET
→ SET
→ DELETE
→ TTL


### Approach 2

Spring Cache abstraction


Application
    ↓
@Cacheable
@CacheEvict
@CachePut
    ↓
Cache Manager
    ↓
Redis


Second approach business code ko
clean rakhne me useful hota hai.


# 13. `@EnableCaching`

Spring Cache abstraction enable karne ke liye
commonly:

@EnableCaching


Example:

@SpringBootApplication
@EnableCaching
public class ProductApplication {

}


# 14. `@Cacheable`

Example:

@Cacheable(
    value = "products",
    key = "#id"
)
public Product getProduct(Long id) {

    return productRepository
            .findById(id)
            .orElseThrow();
}


Flow:

First request:

getProduct(101)
      ↓
Cache MISS
      ↓
Method execute
      ↓
MySQL
      ↓
Result
      ↓
Cache


Second request:

getProduct(101)
      ↓
Cache HIT
      ↓
Cached Result


# 15. `@CacheEvict`

Update/delete ke time:

@CacheEvict(
    value = "products",
    key = "#id"
)


Example:

@CacheEvict(
    value = "products",
    key = "#id"
)
public void deleteProduct(Long id) {

    productRepository.deleteById(id);
}


Flow:

DB DELETE
   +
Cache DELETE


# 16. `@CachePut`

Example:

@CachePut(
    value = "products",
    key = "#product.id"
)
public Product updateProduct(Product product) {

    return productRepository.save(product);
}


Meaning:

Method execute hoga
+
Returned product cache me put/update hoga.


Difference:

@Cacheable
→ Cache hit par method skip ho sakta hai


@CachePut
→ Method always execute hota hai
→ Result cache update karta hai


# 17. Complete Product Service

Example:

@Service
public class ProductService {

    @Cacheable(
        value = "products",
        key = "#id"
    )
    public Product getProduct(Long id) {

        return productRepository
                .findById(id)
                .orElseThrow();
    }


    @CachePut(
        value = "products",
        key = "#product.id"
    )
    public Product updateProduct(Product product) {

        return productRepository.save(product);
    }


    @CacheEvict(
        value = "products",
        key = "#id"
    )
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }
}


# 18. Complete Flow

GET:

Controller
    ↓
Service
    ↓
@Cacheable
    ↓
Redis
    ↓
HIT?
 ├── YES → Return
 └── NO
      ↓
    MySQL
      ↓
    Cache
      ↓
    Return


UPDATE:

Controller
    ↓
Service
    ↓
MySQL UPDATE
    ↓
@CachePut
    ↓
Redis UPDATE


DELETE:

Controller
    ↓
Service
    ↓
MySQL DELETE
    ↓
@CacheEvict
    ↓
Redis DELETE


# 19. Important Interview Question

Q:

"How have you integrated Redis with Spring Boot?"


Answer:

"I can integrate Redis using Spring Data Redis. For direct Redis operations, RedisTemplate can be used. For application-level caching, I can enable Spring Cache and use annotations such as @Cacheable, @CachePut and @CacheEvict with a Redis cache manager. TTL and serialization are also configured according to the application's requirements."


# 20. RedisTemplate vs Spring Cache

RedisTemplate:

→ Low-level/programmatic control
→ Direct Redis operations
→ Data structures
→ Custom Redis logic


Spring Cache:

→ Higher-level abstraction
→ Easy caching
→ Less boilerplate
→ `@Cacheable`, `@CacheEvict`, `@CachePut`


Simple:

RedisTemplate
→ "Redis ke saath directly kaam karo"


Spring Cache
→ "Mujhe caching manage karni hai"


# Easy Memory

DEPENDENCY:

spring-boot-starter-data-redis


CONFIG:

host
port


DIRECT:

RedisTemplate


CACHE:

@EnableCaching

@Cacheable
@CachePut
@CacheEvict


READ:

@Cacheable


UPDATE:

@CachePut


DELETE:

@CacheEvict