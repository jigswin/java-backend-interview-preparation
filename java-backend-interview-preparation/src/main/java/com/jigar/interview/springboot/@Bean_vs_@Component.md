# Spring Boot — Q26: @Bean vs @Component

## @Component

`@Component` class ke upar lagate hain, aur Spring us class ka Bean automatically create karta hai.

@Component
class EmailService {
}


## @Bean

`@Bean` method ke upar lagate hain, aur method jo object return karta hai usko Spring Bean bana deta hai.

@Configuration
class AppConfig {

    @Bean
    public EmailService emailService() {

        return new EmailService();
    }
}


## Main Difference

@Component
→ Class par lagta hai
→ Component scanning se Bean banta hai

@Bean
→ Method par lagta hai
→ Method ka returned object Bean banta hai


## Kab @Bean use karenge?

Jab:

- Third-party class ho
- Class ko modify nahi kar sakte
- Custom configuration chahiye


## Interview Answer

"`@Component` is used to automatically register a class as a Spring Bean through component scanning, while `@Bean` is used on a method to explicitly register the object returned by that method as a Spring Bean."

## Easy Memory

@Component
→ "Ye class Bean hai."

@Bean
→ "Is method se jo object milega, wo Bean hai."