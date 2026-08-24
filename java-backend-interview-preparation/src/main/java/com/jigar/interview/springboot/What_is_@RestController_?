# Spring Boot — Q10: What is @RestController?

## What is @RestController?

`@RestController` ka use Spring Boot me **REST APIs banane ke liye** hota hai.

Ye basically:

@Controller
+
@ResponseBody

ka combination hai.


## Example

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public String getEmployees() {
        return "Employee List";
    }
}


Request:

GET /employees


Response:

Employee List


## @Controller vs @RestController

@Controller
→ Mainly MVC/Web pages ke liye


@RestController
→ REST APIs ke liye


`@RestController` me returned value directly HTTP response body me jaati hai.


## Real Example

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/{id}")
    public Employee getEmployee(
            @PathVariable Long id) {

        return employeeService
                .getEmployee(id);
    }
}


Client:

GET /employees/101


Controller:

→ Request receive karta hai

→ Service ko call karta hai

→ Employee object return karta hai

→ Spring usko JSON response me convert kar sakta hai.


## Interview Answer

"`@RestController` is used to create RESTful web controllers in Spring. It combines `@Controller` and `@ResponseBody`, so the return value of controller methods is written directly to the HTTP response body."


## Easy Memory Trick

@Controller
→ View/Page


@RestController
→ REST API / JSON