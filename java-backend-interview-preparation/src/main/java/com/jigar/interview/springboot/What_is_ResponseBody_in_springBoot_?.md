# Spring Boot — Q36: What is @ResponseEntity?

## Answer

`ResponseEntity` ka use API se **response body + HTTP status code + headers** control karne ke liye hota hai.

## Example

@GetMapping("/{id}")
public ResponseEntity<Employee> getEmployee(
        @PathVariable Long id) {

    Employee employee = service.getEmployee(id);

    return ResponseEntity.ok(employee);
}

Yahan:

Response body
→ employee

Status
→ 200 OK


## Not Found Example

if (employee == null) {

    return ResponseEntity
            .notFound()
            .build();
}

→ 404 Not Found


## Why use ResponseEntity?

Normal:

return employee;

→ Body mil jayegi, but status/headers par direct control kam hota hai.

ResponseEntity:

return ResponseEntity
        .status(201)
        .body(employee);

→ Status + Body dono control kar sakte hain.


## Common Methods

ResponseEntity.ok()
→ 200 OK

ResponseEntity.status(201)
→ 201 Created

ResponseEntity.badRequest()
→ 400 Bad Request

ResponseEntity.notFound()
→ 404 Not Found


## Interview Answer

"`ResponseEntity` is used to control the complete HTTP response, including the response body, HTTP status code and headers."

## Easy Memory

ResponseEntity
→ Body + Status + Headers