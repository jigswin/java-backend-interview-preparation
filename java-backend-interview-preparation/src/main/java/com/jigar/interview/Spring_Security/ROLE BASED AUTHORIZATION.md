# SPRING SECURITY — ROLE BASED AUTHORIZATION

## RBAC kya hai?

RBAC = Role-Based Access Control

User ko directly permission dene ke bajay
hum user ko ek ROLE assign karte hain.

Role ke basis par decide hota hai ki
user kya kar sakta hai.


==================================================
REAL-WORLD EXAMPLE
==================================================

Users:

Jigar  → ROLE_USER
Admin  → ROLE_ADMIN
Manager → ROLE_MANAGER


Permissions:

ROLE_USER
→ Products dekh sakta hai
→ Order create kar sakta hai

ROLE_MANAGER
→ Products dekh sakta hai
→ Orders manage kar sakta hai

ROLE_ADMIN
→ Sab kuch kar sakta hai
→ Product delete kar sakta hai
→ User manage kar sakta hai


==================================================
SPRING BOOT EXAMPLE
==================================================

@GetMapping("/products")

→ authenticated users


@DeleteMapping("/products/{id}")

→ ADMIN only


Conceptually:

.requestMatchers("/products/**")
.hasAnyRole("USER", "ADMIN")

.requestMatchers("/admin/**")
.hasRole("ADMIN")


==================================================
DATABASE EXAMPLE
==================================================

users

id | username | password
---|----------|---------
1  | jigar    | hash...


roles

id | name
---|------
1  | USER
2  | ADMIN


user_roles

user_id | role_id
--------|--------
1       | USER


Jigar:

USER
↓
GET /products       ✅
DELETE /products/1  ❌


Admin:

ADMIN
↓
GET /products       ✅
DELETE /products/1  ✅


==================================================
JWT KE SAATH ROLE
==================================================

Login:

Username + Password
↓
Authentication
↓
User ka Role
↓
JWT


JWT payload concept:

{
"sub": "jigar",
"roles": ["USER"]
}


Request:

DELETE /products/101

Authorization:
Bearer JWT


        ↓
JWT Validate
↓
Role = USER
↓
Required Role = ADMIN
↓
403 Forbidden ❌


==================================================
ROLE vs AUTHORITY
==================================================

Role:

ROLE_ADMIN
ROLE_USER


Authority:

PRODUCT_READ
PRODUCT_DELETE
ORDER_CREATE


Role broad access define karta hai.

Authority more granular permission
define kar sakti hai.


Example:

ADMIN
↓
PRODUCT_READ
PRODUCT_CREATE
PRODUCT_DELETE
USER_DELETE


==================================================
@PreAuthorize
==================================================

Method level security ke liye:

@PreAuthorize("hasRole('ADMIN')")

public void deleteProduct(Long id) {
...
}


Matlab:

Sirf ADMIN ye method execute kar sakta hai.


Another example:

@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")

public void updateProduct(...) {
...
}


==================================================
REAL MICROSERVICE EXAMPLE
==================================================

              API Gateway
                   ↓
             JWT Validation
                   ↓
        ┌──────────┼──────────┐
        ↓          ↓          ↓
      User       Order      Product
     Service     Service     Service


User:

ROLE_USER

→ GET /products       ✅
→ POST /orders        ✅
→ DELETE /products    ❌


Admin:

ROLE_ADMIN

→ GET /products       ✅
→ POST /orders        ✅
→ DELETE /products    ✅


==================================================
401 vs 403 — AGAIN
==================================================

No JWT
↓
401


Valid JWT
+
Wrong Role
↓
403


Example:

USER tries ADMIN API

Authentication → ✅
Authorization  → ❌

Result:

403 Forbidden


==================================================
INTERVIEW ANSWER
==================================================

"Role-based authorization means access to resources
is controlled based on the user's assigned role. For
example, a USER may be allowed to create orders while
an ADMIN can additionally delete products or manage
users. In Spring Security, we can enforce this using
methods such as hasRole(), hasAnyRole(), or
@PreAuthorize."


==================================================
EASY MEMORY
==================================================

Authentication
→ WHO?


Role
→ WHICH CATEGORY?


Authorization
→ WHAT CAN HE DO?


USER
→ Normal operations


MANAGER
→ Management operations


ADMIN
→ Administrative operations


## 🔥 Ek important interview trap

Bhai hasRole("ADMIN") use karte waqt Spring Security internally generally ROLE_ADMIN authority convention ke saath kaam karta hai.

Isliye:

hasRole("ADMIN")
↓
ROLE_ADMIN

Aur agar directly authority check karni ho:

hasAuthority("ROLE_ADMIN")