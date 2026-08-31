# Microservices — Q10: Retry & Timeout

## 1. Timeout kya hai?

Timeout ka matlab:

> Downstream service ne specified time ke andar response nahi diya,
> to request ko wait karna band kar do.

### Real Example

Order Service
      ↓
Payment Service

Payment Service response dene me 30 seconds le rahi hai.

Humne timeout = 5 seconds rakha.

5 sec wait
    ↓
No response
    ↓
Timeout ❌
    ↓
Fallback / Error


Isse Order Service unnecessarily 30 seconds tak wait nahi karegi.


--------------------------------------------------
## 2. Retry kya hai?
--------------------------------------------------

Temporary failure hone par same request ko limited number of times
dobara try karna = Retry.

Example:

Order Service
      ↓
Payment Service

1st attempt → Failed ❌
       ↓
Retry
       ↓
2nd attempt → Failed ❌
       ↓
Retry
       ↓
3rd attempt → Success ✅


Example configuration:

maxAttempts = 3

Matlab total attempts configured value ke according limited rahenge.


--------------------------------------------------
## Real-World Example
--------------------------------------------------

Payment Service temporarily network issue ki wajah se fail hui.

Retry:

Attempt 1 → ❌
Attempt 2 → ❌
Attempt 3 → ✅

Payment successful.


Lekin agar service completely DOWN hai:

Attempt 1 → ❌
Attempt 2 → ❌
Attempt 3 → ❌
        ↓
Circuit Breaker
        ↓
Fallback


--------------------------------------------------
## Retry + Timeout + Circuit Breaker
--------------------------------------------------

Order Service
      ↓
Circuit Breaker
      ↓
Timeout
      ↓
Payment Service
      ↓
Failure?
      ↓
Retry
      ↓
Still failing?
      ↓
Circuit OPEN
      ↓
Fallback


--------------------------------------------------
## Important Interview Point
--------------------------------------------------

Retry har operation ke liye blindly use nahi karna chahiye.

Example:

Payment charge operation

Agar request actually process ho gayi thi but response timeout ho gaya,
blind retry se **duplicate payment** ka risk ho sakta hai.

Isliye retry carefully use karte hain, especially non-idempotent operations
ke liye.


--------------------------------------------------
## Interview Answer
--------------------------------------------------

"Timeout limits how long a service waits for a downstream response. Retry attempts a failed operation again for transient failures. Both should be configured carefully, and Circuit Breaker can stop repeated calls when a downstream service continues to fail."


--------------------------------------------------
## Easy Memory
--------------------------------------------------

Timeout
→ Kitni der wait karna?


Retry
→ Kitni baar dobara try karna?


Circuit Breaker
→ Kab calls completely stop karni?


Example:

Wait → Retry → Retry → Still Fail → Circuit OPEN