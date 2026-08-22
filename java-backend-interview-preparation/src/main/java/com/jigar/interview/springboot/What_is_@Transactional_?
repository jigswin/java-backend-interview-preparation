# Spring Boot — Q18: What is @Transactional?

## What is @Transactional?

`@Transactional` ka use database operations ko **ek transaction ke andar execute** karne ke liye hota hai.

Simple:

> Ya to saare operations successfully complete honge, ya failure hone par changes rollback ho jayenge.


## Example

@Transactional
public void placeOrder() {

    saveOrder();

    updateInventory();

    savePayment();
}


Agar:

saveOrder()
    ↓
updateInventory()
    ↓
savePayment() ❌


To transaction rollback ho sakta hai, yani pehle ke database changes bhi undo ho sakte hain.


## Real-World Example

Order place karte waqt:

1. Order save
2. Inventory reduce
3. Payment record save

Agar payment save fail ho gaya:

❌ Order save rehna nahi chahiye
❌ Inventory reduce nahi rehna chahiye

Transaction rollback karke database ko consistent state me rakha ja sakta hai.


## Important

`@Transactional` commonly **Service layer** par use karte hain.

@Service
public class OrderService {

    @Transactional
    public void placeOrder() {

        // multiple DB operations
    }
}


## Interview Answer

"`@Transactional` defines a transaction boundary around database operations. If the transaction completes successfully, changes are committed; if a qualifying failure occurs, the transaction can be rolled back."


## Easy Memory Trick

@Transactional

START
 ↓
Multiple DB operations
 ↓
Success → COMMIT ✅
Failure → ROLLBACK 🔄


## Important Interview Point

By default, Spring's transaction rollback behavior is primarily for unchecked exceptions (`RuntimeException` and `Error`).

Checked exceptions ke liye rollback behavior configure karna pad sakta hai.

Example:

@Transactional(
    rollbackFor = Exception.class
)
public void process() throws Exception {

}