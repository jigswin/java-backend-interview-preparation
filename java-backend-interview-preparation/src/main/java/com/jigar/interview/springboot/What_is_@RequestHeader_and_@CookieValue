# Spring Boot — Q35: What is @RequestHeader and @CookieValue?

## @RequestHeader

HTTP request ke header se value read karne ke liye use hota hai.

Example:

GET /employees

Authorization: Bearer abc123


@GetMapping("/employees")
public String getEmployees(
        @RequestHeader("Authorization") String token) {

    return token;
}


Yahan:

Authorization
→ Request Header

abc123
→ Header ki value


## @CookieValue

HTTP Cookie se value read karne ke liye use hota hai.

Example:

Cookie:

sessionId=abc123


@GetMapping("/profile")
public String profile(
        @CookieValue("sessionId") String sessionId) {

    return sessionId;
}


## Difference

@RequestHeader
→ HTTP Header se data


@CookieValue
→ Cookie se data


## Real-World Example

JWT authentication me:

Authorization: Bearer <token>

→ `@RequestHeader` se token read kiya ja sakta hai.


Session-based application me:

sessionId=xyz123

→ `@CookieValue` se session ID read ki ja sakti hai.


## Interview Answer

"`@RequestHeader` is used to read values from HTTP request headers, while `@CookieValue` is used to read values from cookies."

## Easy Memory

Header
→ @RequestHeader

Cookie
→ @CookieValue