# Spring Boot — Q4: What is Dependency Injection (DI) and IoC?

## 1. IoC kya hai?

IoC = Inversion of Control

Simple language:

> Object banana aur uski dependencies manage karna Spring ke control me hota hai, developer ke direct control me nahi.

Normally:

EmployeeService service =
        new EmployeeService();

Developer khud object bana raha hai.


Spring me:

@Service
class EmployeeService {
}


Spring automatically EmployeeService ka object (Bean) create/manage karta hai.


--------------------------------------------------
2. Dependency Injection kya hai?
--------------------------------------------------

DI ka matlab:

> Ek class ko jis object/dependency ki zarurat hai, wo dependency bahar se provide karna.

Example:

@Service
class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(
            EmployeeRepository repository) {

        this.repository = repository;
    }
}


Yahan:

EmployeeService
        ↓
needs
        ↓
EmployeeRepository


Spring EmployeeRepository ka Bean
EmployeeService ke constructor me inject karta hai.


--------------------------------------------------
3. Real-World Example
--------------------------------------------------

Suppose:

EmployeeService ko
EmployeeRepository chahiye.

Without DI:

class EmployeeService {

    private EmployeeRepository repository =
            new EmployeeRepository();
}


Yahan EmployeeService khud dependency create kar raha hai.

Problem:
→ Tight coupling


With DI:

class EmployeeService {

    private final EmployeeRepository repository;

    EmployeeService(
            EmployeeRepository repository) {

        this.repository = repository;
    }
}


Dependency bahar se mil rahi hai.

→ Loose coupling
→ Easy testing
→ Easy replacement


--------------------------------------------------
4. Constructor Injection
--------------------------------------------------

Spring Boot me constructor injection generally preferred hai.

Example:

@Service
class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(
            EmployeeRepository repository) {

        this.repository = repository;
    }
}


Spring automatically repository inject karega.


--------------------------------------------------
5. DI ke Types
--------------------------------------------------

Mainly:

1. Constructor Injection
2. Setter Injection
3. Field Injection


Constructor Injection
→ Recommended


Setter Injection
→ Optional dependencies ke cases me useful


Field Injection
→ @Autowired directly field par

Generally constructor injection ko prefer kiya jata hai.


--------------------------------------------------
6. IoC vs DI
--------------------------------------------------

IoC:

→ Big concept
→ Control Spring ke paas


DI:

→ IoC achieve karne ka common mechanism
→ Dependencies provide/inject karna


Easy:

IoC = Control kis ke paas hai?

DI = Dependency kaise provide hogi?


--------------------------------------------------
INTERVIEW ANSWER
--------------------------------------------------

"Dependency Injection is a design technique where an object's dependencies are provided from outside instead of the object creating them itself. In Spring, the IoC container manages beans and injects their dependencies. Constructor injection is generally preferred because it makes dependencies explicit and improves testability."


--------------------------------------------------
EASY MEMORY TRICK
--------------------------------------------------

IoC
→ Spring controls object creation


DI
→ Spring provides required dependency


Example:

EmployeeService
        ↓
needs
EmployeeRepository
        ↓
Spring injects it