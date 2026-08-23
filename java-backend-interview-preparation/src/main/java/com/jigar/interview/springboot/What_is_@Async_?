# Spring Boot — Q48: What is @Async?

## @Async kya hai?

`@Async` ka use kisi method ko **asynchronously execute** karne ke liye hota hai.

Simple:

Normal:

Request
  ↓
Method
  ↓
Complete
  ↓
Response


@Async:

Request
  ↓
Method starts
  ↓
Background thread
  ↓
Main request continue


## Enable Async

@SpringBootApplication
@EnableAsync
public class Application {

}


## Example

@Service
public class NotificationService {

    @Async
    public void sendEmail(String email) {

        // Email sending logic
    }
}


Controller:

@PostMapping("/orders")
public String createOrder() {

    orderService.createOrder();

    notificationService.sendEmail(
        "jigar@gmail.com"
    );

    return "Order Created";
}


Email sending slow ho sakta hai, lekin request ko unnecessarily wait nahi karna padega.


## Real-World Example

E-commerce:

Order placed
    ↓
Order save
    ↓
Email notification
    ↓
SMS notification


Email/SMS ko async kar sakte hain.

Main order operation ko unnecessary wait nahi karna padega.


## Important Point

`@Async` use karne ke liye:

@EnableAsync

required hota hai.


Aur generally async method ko **Spring-managed bean** me rakhna chahiye.

Same class ke andar ek method se doosre `@Async` method ko directly call karoge, to Spring proxy bypass ho sakta hai aur async behavior expected tarike se nahi chalega.


## Interview Answer

"`@Async` allows a method to execute asynchronously on a separate thread, so the caller does not have to wait for that method to complete."


## Easy Memory

Normal:
→ Wait


@Async:
→ Background execution
→ Caller can continue