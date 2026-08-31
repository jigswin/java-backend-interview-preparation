# Spring Boot — Q46: What is @Cacheable?

## @Cacheable kya hai?

`@Cacheable` ka use **method ke result ko cache me store** karne ke liye hota hai.

Agar same data dobara request kiya:

→ Database call avoid ho sakti hai
→ Cache se fast response milta hai


## Example

@Cacheable("employees")
public Employee getEmployee(Long id) {

    return repository.findById(id)
            .orElseThrow();
}


First request:

getEmployee(101)
        ↓
Cache me nahi hai
        ↓
Database call
        ↓
Result
        ↓
Cache me save


Second request:

getEmployee(101)
        ↓
Cache me mil gaya
        ↓
Database call nahi ❌
        ↓
Cache se result ✅


## Enable Caching

@SpringBootApplication
@EnableCaching
public class Application {

}


## Real-World Example

Suppose product API hai:

GET /products/101

Product data frequently requested hai but rarely changes.

First request:
→ DB

Next requests:
→ Cache


Isse:

- Database load kam
- Response faster
- Application performance better


## Redis ke saath

Production me Redis jaise distributed cache ko use kar sakte hain.

Application
    ↓
Redis Cache
    ↓
Database


## Interview Answer

"`@Cacheable` caches the result of a method so that subsequent calls with the same parameters can return the cached result instead of executing the method again."


## Easy Memory

First call
→ DB → Cache


Next call
→ Cache → Fast response


@Cacheable
→ "Result ko cache karo."


*cache kitne time tal store hota h and agar bich me kisine us product ko kahi se update kiya tha kya hoga ?

Bilkul bhai, ye real interview-level question hai. @Cacheable ka sabse important part hi cache expiry + cache consistency hai.

1. Cache kitne time tak store hota hai?

Fixed time nahi hota. Ye cache provider/configuration par depend karta hai.

Agar simple in-memory cache use kar rahe ho, TTL configure karna alag hota hai. Redis me bhi TTL set kar sakte ho.

Example:

Product ID = 101


DB:
Price = ₹500


Cache:
Price = ₹500
TTL = 10 minutes

10 minutes ke baad cache expire ho jayega.

Next request:

Cache expired
      ↓
DB se latest data
      ↓
Cache update
2. Agar kisi ne DB me product update kar diya to?

Yahi cache consistency problem hai.

Example:

DB:
Product price = ₹500


Cache:
Product price = ₹500

Kisi admin ne DB me update kar diya:

DB:
Product price = ₹600


Cache:
Product price = ₹500  ❌

Ab agar API cache se data return karegi, to ₹500 old data mil sakta hai jab tak cache update/expire nahi hota.

3. Isko kaise solve karte hain?

Database update ke time cache bhi update/clear kar dete hain.

Spring me:

@CachePut
→ Cache ko new value se update karo


@CacheEvict
→ Cache se old value remove karo

Example:

@CachePut("products")
public Product updateProduct(Product product) {
    return repository.save(product);
}

Ya:

@CacheEvict("products")
public void deleteProduct(Long id) {
    repository.deleteById(id);
}
Interview me ekdum short answer:

"Cache ka TTL configuration par depend karta hai. Agar database me cached data update ho jaye aur cache invalidate/update na ho, to stale data return ho sakta hai. Isliye @CachePut, @CacheEvict ya TTL ka use karke cache consistency maintain karte hain."

Ye point yaad rakhna bhai:
@Cacheable → read/cache
@CachePut → update cache
@CacheEvict → remove cache