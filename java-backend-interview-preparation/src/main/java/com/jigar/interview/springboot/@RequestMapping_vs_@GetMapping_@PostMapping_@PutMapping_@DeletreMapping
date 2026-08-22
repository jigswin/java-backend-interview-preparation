# Spring Boot — Q11: @RequestMapping vs @GetMapping / @PostMapping

## @RequestMapping kya hai?

`@RequestMapping` ka use URL ko controller/method ke saath map karne ke liye hota hai.

Example:

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @RequestMapping("/all")
    public String getEmployees() {

        return "All Employees";
    }
}


URL:

/employees/all


--------------------------------------------------
@GetMapping / @PostMapping etc.
--------------------------------------------------

Ye specific HTTP methods ke liye shortcut annotations hain.

@GetMapping
→ GET request

@PostMapping
→ POST request

@PutMapping
→ PUT request

@DeleteMapping
→ DELETE request


Example:

@GetMapping("/{id}")
public Employee getEmployee(
        @PathVariable Long id) {

    return service.getEmployee(id);
}


@PostMapping
public Employee createEmployee(
        @RequestBody Employee employee) {

    return service.createEmployee(employee);
}


--------------------------------------------------
@RequestMapping vs @GetMapping
--------------------------------------------------

@RequestMapping:

→ General mapping
→ HTTP method specify kar sakte ho


@GetMapping:

→ Specifically GET


@PostMapping:

→ Specifically POST


--------------------------------------------------
Real API Example
--------------------------------------------------

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(
            @PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Employee create(
            @RequestBody Employee employee) {
        return service.create(employee);
    }

    @PutMapping("/{id}")
    public Employee update(
            @PathVariable Long id,
            @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {
        service.delete(id);
    }
}


--------------------------------------------------
INTERVIEW ANSWER
--------------------------------------------------

"`@RequestMapping` is used to map HTTP requests to controller classes or methods. `@GetMapping`, `@PostMapping`, `@PutMapping` and `@DeleteMapping` are specialized shortcuts for specific HTTP methods."


EASY MEMORY:

GET
→ @GetMapping
→ Read


POST
→ @PostMapping
→ Create


PUT
→ @PutMapping
→ Update


DELETE
→ @DeleteMapping
→ Delete