# Spring Boot — Q23: What is @Valid and Validation?

## @Valid kya hai?

`@Valid` ka use request data ko validate karne ke liye hota hai.

Example:

public class EmployeeRequest {

    @NotBlank
    private String name;

    @Min(18)
    private int age;
}


Controller:

@PostMapping
public Employee create(
        @Valid @RequestBody EmployeeRequest request) {

    return service.create(request);
}


## Common Validation Annotations

@NotNull
→ Value null nahi honi chahiye

@NotBlank
→ String null/empty/blank nahi honi chahiye

@Size
→ Length check

@Min / @Max
→ Number range check

@Email
→ Valid email format


## Flow

Client JSON
   ↓
@Valid
   ↓
Validation
   ↓
Valid → Controller continues
Invalid → Validation error


## Interview Answer

"`@Valid` is used to trigger Bean Validation on request objects. It checks constraints such as `@NotNull`, `@NotBlank`, `@Size`, and `@Email` before the request reaches the business logic."


## Easy Memory

@Valid
→ Request ko validate karo

@NotBlank
→ Empty nahi

@Email
→ Valid email

@Min
→ Minimum value