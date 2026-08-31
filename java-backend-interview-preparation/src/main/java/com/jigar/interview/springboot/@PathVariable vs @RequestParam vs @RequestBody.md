# Spring Boot — Q12: @PathVariable vs @RequestParam vs @RequestBody

## 1. @PathVariable

URL ke andar jo value hoti hai usko read karne ke liye use hota hai.

Example:

GET /employees/101

@GetMapping("/employees/{id}")
public Employee getEmployee(
        @PathVariable Long id) {

    return service.getEmployee(id);
}

Yahan:

{id}
→ PathVariable

id = 101


## 2. @RequestParam

URL ke query parameter se value lene ke liye use hota hai.

Example:

GET /employees?department=IT

@GetMapping("/employees")
public List<Employee> getEmployees(
        @RequestParam String department) {

    return service.getByDepartment(department);
}

Yahan:

department=IT
→ RequestParam


## 3. @RequestBody

Request ke body se JSON data lene ke liye use hota hai.

Example:

POST /employees

JSON:

{
    "name": "Jigar",
    "salary": 50000
}


@PostMapping("/employees")
public Employee createEmployee(
        @RequestBody Employee employee) {

    return service.createEmployee(employee);
}

Yahan JSON:

→ Employee object me convert hota hai.


# Simple Difference

@PathVariable
→ URL path se data

Example:
`/employees/101`


@RequestParam
→ Query parameter se data

Example:
`/employees?department=IT`


@RequestBody
→ Request body se data

Example:
`{"name":"Jigar"}`


# Interview Answer

"`@PathVariable` is used to extract values from the URL path, `@RequestParam` is used to extract query parameters, and `@RequestBody` is used to read data from the HTTP request body, commonly as JSON."


# Easy Memory Trick

PathVariable
→ `/employees/101`

RequestParam
→ `/employees?id=101`

RequestBody
→ JSON body