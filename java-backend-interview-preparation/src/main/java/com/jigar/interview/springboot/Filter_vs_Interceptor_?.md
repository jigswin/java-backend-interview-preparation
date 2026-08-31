# Spring Boot — Q41: Filter vs Interceptor

## Filter kya hai?

Filter Servlet level par kaam karta hai.

Ye request ko Controller tak pahunchne se pehle process kar sakta hai.

Example:

Request
  ↓
Filter
  ↓
Controller


Common use:

→ Authentication check
→ Logging
→ Request/Response modify


## Interceptor kya hai?

Interceptor Spring MVC level par kaam karta hai.

Ye Controller ke execution se pehle/baad me logic run kar sakta hai.

Flow:

Request
  ↓
Interceptor
  ↓
Controller
  ↓
Interceptor
  ↓
Response


Common methods:

preHandle()
→ Controller se pehle

postHandle()
→ Controller ke baad

afterCompletion()
→ Request complete hone ke baad


## Main Difference

Filter
→ Servlet level

Interceptor
→ Spring MVC level


## Real Example

JWT Authentication:

Request
   ↓
Filter
   ↓
JWT validate
   ↓
Interceptor
   ↓
Controller


## Interview Answer

"Filter works at the Servlet level and can process requests before they reach Spring MVC, while an Interceptor works within Spring MVC and can execute logic before and after controller execution."


## Easy Memory

Filter
→ Servlet level

Interceptor
→ Controller/Spring MVC level