
### 🧠 Bhai interview me ye **3 annotations** pakke kar:

| Annotation | Kaam |
|---|---|
| `@Cacheable` | Cache me data nahi hai to method/DB call, result cache |
| `@CacheEvict` | Cache entry delete/invalidate |
| `@CachePut` | Method execute + returned result cache update |

### 🔥 Real-world flow

```text id="redis07-flow"
GET
 ↓
@Cacheable
 ↓
Redis HIT?
 ├── YES → Return
 └── NO → DB → Redis → Return


UPDATE
 ↓
DB UPDATE
 ↓
@CacheEvict
 ↓
Redis DELETE


DELETE
 ↓
DB DELETE
 ↓
@CacheEvict
 ↓
Redis DELETE