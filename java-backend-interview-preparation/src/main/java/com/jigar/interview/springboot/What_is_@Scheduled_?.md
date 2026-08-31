# Spring Boot — Q49: What is @Scheduled?

## @Scheduled kya hai?

`@Scheduled` ka use kisi method ko **fixed time ya interval par automatically execute** karne ke liye hota hai.

## Enable Scheduling

@SpringBootApplication
@EnableScheduling
public class Application {

}


## Example

@Scheduled(fixedRate = 60000)
public void checkOrders() {

    System.out.println("Checking orders...");
}


fixedRate = 60000
→ Har 60 seconds me method run.


## Common Options

fixedRate
→ Previous execution ke start se fixed interval


fixedDelay
→ Previous execution complete hone ke baad wait


cron
→ Specific time/schedule


## Cron Example

@Scheduled(cron = "0 0 2 * * *")
public void dailyJob() {

    // 2 AM par run
}


## Real-World Example

E-commerce application:

Har 10 minutes:

→ Pending orders check
→ Expired orders process
→ Temporary data cleanup


Ya daily:

→ Reports generate
→ Database cleanup
→ Reminder emails


## Important

`@Scheduled` methods generally no-argument hone chahiye.

## Interview Answer

"`@Scheduled` is used to execute a method automatically at a configured interval or according to a cron expression. Scheduling is enabled using `@EnableScheduling`."


## Easy Memory

@EnableScheduling
→ Scheduling ON


@Scheduled
→ Automatic execution


fixedRate
→ Fixed interval


fixedDelay
→ Previous execution ke baad delay


cron
→ Specific schedule