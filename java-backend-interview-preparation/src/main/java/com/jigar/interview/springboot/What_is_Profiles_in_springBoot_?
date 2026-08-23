# Spring Boot — Q28: What are Profiles?

## Profile kya hota hai?

Spring Profiles ka use **different environments ke liye different configuration** rakhne ke liye hota hai.

Example:

Development
→ Local database

Testing
→ Test database

Production
→ Production database


## Example

application-dev.properties

server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/dev_db


application-prod.properties

server.port=8080
spring.datasource.url=jdbc:mysql://prod-server:3306/prod_db


## Profile activate kaise kare?

application.properties:

spring.profiles.active=dev


Ab:

application-dev.properties

ki configuration use hogi.


## @Profile

Specific Bean ko particular environment me enable kar sakte hain.

@Profile("dev")
@Bean
public PaymentService paymentService() {
    return new TestPaymentService();
}


## Interview Answer

"Spring Profiles allow us to maintain different configurations and beans for different environments such as development, testing and production."

## Easy Memory

dev
→ Local configuration

test
→ Testing configuration

prod
→ Production configuration