# Spring Boot — Q25: @Autowired vs Constructor Injection

## @Autowired kya hai?

`@Autowired` Spring ko batata hai ki required dependency inject karni hai.

Example:

@Service
class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
}


## Constructor Injection

Dependency constructor ke through provide hoti hai.

@Service
class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(
            EmployeeRepository repository) {

        this.repository = repository;
    }
}


## Kaunsa better hai?

Constructor Injection generally preferred hai.

Reasons:

- Dependency clearly visible hoti hai
- `final` use kar sakte hain
- Testing easy hoti hai
- Object incomplete state me create nahi hota


## Important

Agar class me **sirf ek constructor** hai, modern Spring me usually `@Autowired` lagana zaroori nahi hota.

Example:

@Service
class EmployeeService {

    private final EmployeeRepository repository;

    EmployeeService(
            EmployeeRepository repository) {

        this.repository = repository;
    }
}


## Interview Answer

"`@Autowired` is used by Spring to inject dependencies. Constructor injection is generally preferred because dependencies are explicit, fields can be final, and the class is easier to test."

## Easy Memory

Field Injection:
@Autowired
→ Easy but generally less preferred

Constructor Injection:
→ Recommended ✅