# Spring Boot — Q5: What is a Spring Bean?

## 1. Bean kya hota hai?

Spring Bean ek aisa Java object hai jisko **Spring IoC Container create aur manage karta hai**.

Simple:

Normal object:
→ Developer creates using `new`

Spring Bean:
→ Spring creates/manages


## 2. Example

@Service
public class EmployeeService {

}


Yahan `EmployeeService` ka object Spring automatically create karega.

Ye object:

→ Spring Bean


## 3. Bean kaise create hota hai?

Common ways:

### @Component

@Component
public class EmailService {

}


### @Service

@Service
public class EmployeeService {

}


### @Repository

@Repository
public class EmployeeRepository {

}


### @Controller / @RestController

@RestController
public class EmployeeController {

}


In annotations ke through Spring class ko detect karke Bean bana sakta hai.


## 4. @Bean

Hum manually bhi Bean define kar sakte hain:

@Configuration
public class AppConfig {

    @Bean
    public PaymentService paymentService() {

        return new PaymentService();
    }
}


Yahan `paymentService()` jo object return karta hai,
Spring us object ko Bean ke roop me manage karega.


## 5. Real-World Flow

@Service
EmployeeService
        ↓
@ComponentScan
        ↓
Spring detects class
        ↓
Spring creates Bean
        ↓
IoC Container me store/manage
        ↓
Dusri class me inject ho sakta hai


## 6. Interview Answer

"Spring Bean is an object that is created, configured and managed by the Spring IoC container."


## Remember

`@Component`, `@Service`, `@Repository`, `@Controller`

→ Spring Bean create karne ke common ways


`@Bean`

→ Configuration class ke andar manually Bean define karne ka way.


### One-line:

**Spring Bean = Object managed by Spring IoC Container.**