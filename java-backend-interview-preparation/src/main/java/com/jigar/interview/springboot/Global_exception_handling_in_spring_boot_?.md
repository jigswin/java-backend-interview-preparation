# Spring Boot — Q24: What is Global Exception Handling?

## What is it?

Spring Boot me exceptions ko ek central place par handle karne ke liye:

@RestControllerAdvice
+
@ExceptionHandler

use karte hain.

## Example

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handle(
            EmployeeNotFoundException ex) {

        return ResponseEntity
                .status(404)
                .body(ex.getMessage());
    }
}

## Flow

Controller
   ↓
Service
   ↓
Exception
   ↓
GlobalExceptionHandler
   ↓
Proper HTTP Response

Example:

Employee nahi mila
→ EmployeeNotFoundException
→ 404 NOT FOUND

## Why use?

- Centralized exception handling
- Duplicate try-catch kam hota hai
- Consistent API error response

## Interview Answer

"Global exception handling allows us to handle exceptions centrally across controllers using `@RestControllerAdvice` and `@ExceptionHandler`, and return consistent HTTP responses."

## Remember

@RestControllerAdvice
→ Global handler

@ExceptionHandler
→ Specific exception handle