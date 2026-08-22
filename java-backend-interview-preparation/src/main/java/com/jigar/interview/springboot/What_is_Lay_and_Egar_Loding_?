# Spring Boot — Q19: Lazy vs Eager Loading

## Lazy Loading

Related data ko **jab actually required ho tab load** karta hai.

Example:

Employee
  ↓
Department

Employee fetch karne par Department automatically load nahi hoga.

Jab department access karoge:
→ tab database se load hoga.


## Eager Loading

Related data ko **main entity ke saath hi load** karta hai.

Employee fetch karo:
→ Employee + Department data load.


## Simple Difference

Lazy
→ Load when needed

Eager
→ Load immediately


## Example

@ManyToOne(fetch = FetchType.LAZY)
private Department department;


Eager:

@ManyToOne(fetch = FetchType.EAGER)
private Department department;


## Which is generally preferred?

Generally **LAZY loading** prefer karna better hota hai, especially large relationships me, because unnecessary data load nahi hota.

But actual choice use case par depend karti hai.


## Real-World Example

Suppose Employee table me 10,000 employees hain aur har employee ke saath large Department details hain.

Agar hume sirf employee name chahiye:

EAGER
→ unnecessary related data load ho sakta hai ❌

LAZY
→ department tab load hoga jab needed ho ✅


## Interview Answer

"Lazy loading loads related data only when it is accessed, while eager loading loads it along with the main entity. Lazy loading is generally preferred when related data is not always required."


## Important Interview Point

LAZY ka matlab ye nahi ki query kabhi nahi chalegi.

Meaning:

> Related data ki loading ko delay kiya jata hai until it is accessed.


## Easy Memory Trick

LAZY
→ "Baad me chahiye to load karo."


EAGER
→ "Abhi ke abhi load karo."