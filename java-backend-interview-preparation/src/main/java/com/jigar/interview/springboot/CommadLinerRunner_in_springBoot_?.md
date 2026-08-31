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