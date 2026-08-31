# Spring Boot — Q44: What is Spring Boot CommandLineRunner?

## Answer

`CommandLineRunner` ek Spring Boot interface hai jo application start hone ke baad **ek baar code execute** karne ke liye use hota hai.

## Example

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) {

        System.out.println(
            "Application Started"
        );
    }
}


Application start:

Spring Boot starts
      ↓
Beans create
      ↓
CommandLineRunner.run()
      ↓
Code execute


## Real-World Use

Application start hote hi:

→ Initial data insert karna
→ Cache warm-up
→ Startup configuration
→ Testing/demo ke liye code run karna


## Example

@Component
public class DataLoader
        implements CommandLineRunner {

    private final EmployeeRepository repository;

    public DataLoader(
            EmployeeRepository repository) {

        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        if (repository.count() == 0) {

            repository.save(
                new Employee("Jigar")
            );
        }
    }
}


## Interview Answer

"`CommandLineRunner` is used to execute code once after the Spring Boot application starts and the application context is initialized."


## Easy Memory

Application Start
       ↓
CommandLineRunner
       ↓
run()
       ↓
Execute startup logic



# JUnit + Mockito — Spring Boot Project Setup

## 1. Dependency

Maven project me normally:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

Is starter ke through testing ke liye JUnit, Mockito aur other testing libraries milti hain.


--------------------------------------------------
2. Suppose hamara Service hai
--------------------------------------------------

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee getEmployee(Long id) {

        return repository.findById(id)
                .orElseThrow();
    }
}


--------------------------------------------------
3. Service ka Unit Test
--------------------------------------------------

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;


    @Test
    void shouldGetEmployee() {

        Employee employee = new Employee();

        employee.setId(101L);
        employee.setName("Jigar");


        // Mock repository ka behaviour define karna
        when(repository.findById(101L))
                .thenReturn(Optional.of(employee));


        // Actual service method call
        Employee result =
                service.getEmployee(101L);


        // Result verify
        assertEquals("Jigar", result.getName());


        // Verify repository call hua
        verify(repository).findById(101L);
    }
}


--------------------------------------------------
4. Yahan kya ho raha hai?
--------------------------------------------------

@Mock
→ Fake EmployeeRepository create karta hai


@InjectMocks
→ Mock repository ko EmployeeService me inject karta hai


when(...)
→ Mock ka behaviour define karta hai


service.getEmployee()
→ Actual method test hota hai


assertEquals(...)
→ Expected vs actual result check


verify(...)
→ Check karta hai ki repository method call hua ya nahi


--------------------------------------------------
5. Real Flow
--------------------------------------------------

Test

   ↓

EmployeeService

   ↓

Mock EmployeeRepository

   ↓

NO REAL DATABASE ❌

   ↓

Result verify ✅


--------------------------------------------------
6. Interview Answer
--------------------------------------------------

"Spring Boot projects commonly use spring-boot-starter-test for testing. JUnit is used to write and execute tests, while Mockito is used to mock dependencies. For example, while testing a Service, we can mock the Repository so that the test does not require an actual database."


--------------------------------------------------
EASY MEMORY
--------------------------------------------------

@Mock
→ Fake dependency

@InjectMocks
→ Dependency inject into class under test

when()
→ Mock ka behaviour define

verify()
→ Method call check

assertEquals()
→ Result check


JUnit
→ Test chalata hai

Mockito
→ Dependency ka fake/mock banata hai