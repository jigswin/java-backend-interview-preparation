# Spring Boot — Q50: How do you handle API errors properly?

## Problem

Agar service me exception aa jaye:

GET /employees/999

Employee nahi mila.

Direct exception return karna proper API response nahi hai.


## Best Approach

Custom Exception
        ↓
@RestControllerAdvice
        ↓
@ExceptionHandler
        ↓
Proper HTTP Response


## 1. Custom Exception

public class EmployeeNotFoundException
        extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}


## 2. Throw Exception

public Employee getEmployee(Long id) {

    return repository.findById(id)
            .orElseThrow(() ->
                new EmployeeNotFoundException(
                    "Employee not found"
                )
            );
}


## 3. Global Handler

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
        EmployeeNotFoundException.class
    )
    public ResponseEntity<String> handle(
            EmployeeNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}


## Response

HTTP 404

Employee not found


## Real-World Benefit

Instead of every controller having:

try {
   ...
} catch (...) {
   ...
}

Central handler handles errors.

→ Clean code
→ Consistent responses
→ Less duplicate code


## Interview Answer

"In Spring Boot, we can handle API errors centrally using custom exceptions, `@RestControllerAdvice` and `@ExceptionHandler`. This allows us to return consistent HTTP status codes and error responses."


## Easy Memory

Custom Exception
      ↓
Throw
      ↓
@RestControllerAdvice
      ↓
@ExceptionHandler
      ↓
Proper HTTP Response