# Spring Boot — Q47: @CachePut vs @CacheEvict

## @CachePut

`@CachePut` method ko execute karta hai aur uska latest result cache me update karta hai.

Example:

@CachePut(value = "products", key = "#product.id")
public Product updateProduct(Product product) {

    return repository.save(product);
}


Flow:

Update DB
   ↓
Method execute
   ↓
Latest Product
   ↓
Cache update ✅


## @CacheEvict

`@CacheEvict` cache se existing data remove karta hai.

Example:

@CacheEvict(value = "products", key = "#id")
public void deleteProduct(Long id) {

    repository.deleteById(id);
}


Flow:

Delete DB
   ↓
Cache se product remove
   ↓
Cache consistent ✅


## @Cacheable vs @CachePut vs @CacheEvict

@Cacheable
→ Cache me hai?
→ Yes → Cache se return
→ No → Method execute + cache


@CachePut
→ Method ALWAYS execute
→ Result cache me update


@CacheEvict
→ Cache se data remove


## Real Example

Product price:

DB = ₹500
Cache = ₹500


Admin price update karta hai:

DB = ₹600

@CachePut
→ Cache = ₹600 ✅


Product delete:

DB → Deleted

@CacheEvict
→ Cache → Removed ✅


## Interview Answer

"`@Cacheable` avoids method execution when a cached value exists, `@CachePut` always executes the method and updates the cache with the result, while `@CacheEvict` removes entries from the cache."


## Easy Memory

@Cacheable
→ READ from cache


@CachePut
→ UPDATE cache


@CacheEvict
→ DELETE from cache