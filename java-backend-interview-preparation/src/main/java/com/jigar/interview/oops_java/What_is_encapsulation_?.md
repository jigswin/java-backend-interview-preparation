# Q8 — Encapsulation in Java

## 1. Encapsulation kya hota hai?

Encapsulation ka simple meaning hai:

> Data (variables) aur us data par kaam karne wale methods ko ek single unit/class ke andar bind karna aur data ko direct external access se protect karna.

Simple language:

Data ko directly access karne ke bajay usko class ke andar private rakho aur controlled access ke liye getter/setter ya methods provide karo.

Easy example:

class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }
}

Yahan:

balance
→ private hai

deposit()
→ balance ko controlled way me modify kar raha hai

getBalance()
→ balance ko read karne ka controlled way de raha hai


## 2. Encapsulation kyu use karte hain?

Encapsulation ka main purpose hai:

1. Data hiding
2. Data ko unauthorized access se protect karna
3. Controlled access provide karna
4. Validation apply karna
5. Code ko maintainable banana
6. Internal implementation ko hide karna


## 3. Without Encapsulation

Suppose:

class BankAccount {

    public double balance;
}

Ab koi bhi directly balance change kar sakta hai:

BankAccount account = new BankAccount();

account.balance = -50000;

System.out.println(account.balance);

Problem:

Bank account ka balance negative nahi hona chahiye, lekin `public` hone ki wajah se koi bhi directly invalid value set kar sakta hai.


## 4. With Encapsulation

Hum balance ko private kar denge:

class BankAccount {

    private double balance;

    public void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

Ab:

BankAccount account = new BankAccount();

account.deposit(5000);

System.out.println(account.getBalance());

Output:

5000.0

Ab koi directly:

account.balance = -5000;

nahi kar sakta.

Because balance private hai.


## 5. Encapsulation kaise achieve karte hain?

Generally encapsulation achieve karne ke liye:

1. Instance variables ko `private` rakho.
2. Required access ke liye `public` methods provide karo.
3. Validation/business rules methods ke andar rakho.

Example:

class Employee {

    private int id;
    private String name;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }
}


## 6. Getter aur Setter kya hote hain?

Getter:

> Variable ki value read karne ke liye use hota hai.

Example:

public String getName() {
    return name;
}


Setter:

> Variable ki value modify/update karne ke liye use hota hai.

Example:

public void setName(String name) {
    this.name = name;
}


Usage:

Employee employee = new Employee();

employee.setName("Jigar");

System.out.println(employee.getName());


## 7. Kya har private variable ke liye getter/setter banana zaroori hai?

NO.

Ye bahut important interview point hai.

Encapsulation ka matlab simply:

> "Har private variable ke liye getter aur setter banana"

nahi hai.

Agar kisi field ko externally modify nahi karna hai, to setter provide karne ki zarurat nahi hai.

Example:

class Employee {

    private final int employeeId;

    public Employee(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}

Yahan employeeId ko read kar sakte hain, lekin update nahi kar sakte.

No setter.


## 8. Real-World Example — Bank Account

Bank account me:

private double balance;

Hum directly balance change nahi karna chahte.

Instead:

public void deposit(double amount) {

    if (amount > 0) {
        balance += amount;
    }
}

public void withdraw(double amount) {

    if (amount > 0 && amount <= balance) {
        balance -= amount;
    }
}

Ab business rules class ke andar control ho rahe hain.

Example:

BankAccount account = new BankAccount();

account.deposit(10000);

account.withdraw(3000);

System.out.println(account.getBalance());

Output:

7000.0


## 9. Encapsulation vs Data Hiding

Dono related hain, but exactly same nahi hain.

Data Hiding:

> Internal data ko direct external access se hide karna.

Example:

private double balance;


Encapsulation:

> Data aur methods ko ek class me bind karna aur controlled access provide karna.

So:

Encapsulation
→ Bigger concept

Data Hiding
→ Encapsulation ka important benefit/part


## 10. Encapsulation ke Benefits

### 1. Data Protection

Private variables ko direct access nahi kar sakte.

### 2. Validation

Invalid data ko prevent kar sakte hain.

Example:

if (salary >= 0) {
    this.salary = salary;
}

### 3. Maintainability

Internal implementation change karne par external code par minimum impact hota hai.

### 4. Controlled Access

Hum decide kar sakte hain:

- Read only
- Write only
- Read + Write

### 5. Loose Coupling

External classes ko internal implementation ke details par depend nahi karna padta.


## 11. Read-Only Property

Agar getter hai but setter nahi:

class Employee {

    private final int id;

    public Employee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

External code:

employee.getId();

Allowed.

But:

employee.setId(10);

Possible nahi hai because setter hi nahi hai.

So:

Getter only
→ Read-only


## 12. Write-Only Property

Agar setter hai but getter nahi:

class PasswordManager {

    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
}

External code password set kar sakta hai but directly read nahi kar sakta.

Real applications me sensitive information ke liye controlled access useful ho sakta hai.


## 13. Is private keyword alone enough for Encapsulation?

Interview me best answer:

> Private fields data hiding provide karte hain, but complete encapsulation ka goal data aur behavior ko class ke andar encapsulate karna aur controlled access dena hai.

So sirf:

private int age;

likh dene se concept ka pura benefit nahi milta.

Class ko meaningful methods ke through controlled behavior expose karna better design hai.


## 14. Spring Boot me Encapsulation

Spring Boot application me common structure:

Controller
    ↓
Service
    ↓
Repository
    ↓
Database

Example:

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow();
    }
}

Yahan service ki internal implementation external controller se hidden hai.

Controller ko sirf:

employeeService.getEmployee(id);

call karna hai.

Usko database access ka internal implementation nahi pata.


## 15. Encapsulation vs Abstraction

Ye interviewer ka common follow-up hai.

Encapsulation:

> Data + methods ko class ke andar bind karta hai aur data ko controlled access deta hai.

Abstraction:

> Unnecessary implementation details hide karta hai aur required functionality expose karta hai.


Easy difference:

Encapsulation
→ HOW data is protected/accessed

Abstraction
→ WHAT functionality is exposed


Example:

BankAccount:

Encapsulation:
private balance;

Abstraction:
withdraw() method user ko functionality deta hai, lekin internally balance kaise update ho raha hai wo hide karta hai.


## 16. Interview-Ready Answer

Question:
"What is encapsulation in Java?"

Answer:

"Encapsulation is the process of bundling data and the methods that operate on that data into a single class and restricting direct access to the internal state. In Java, we commonly achieve it by making fields private and providing controlled access through methods such as getters, setters, or business methods. It helps with data protection, validation, maintainability, and controlled access."


## 17. Interview Follow-up Questions

Q: How do you achieve encapsulation in Java?

A:

"By keeping fields private and providing controlled access through public methods such as getters, setters, or specific business methods."


Q: Is getter and setter mandatory for encapsulation?

A:

"No. Getter and setter are not mandatory. We should expose only the operations that are actually required."


Q: What is data hiding?

A:

"Data hiding means preventing direct external access to internal data, commonly using private fields."


Q: Difference between encapsulation and abstraction?

A:

"Encapsulation focuses on bundling data and behavior and controlling access to internal state, whereas abstraction focuses on hiding unnecessary implementation details and exposing only required functionality."


Q: Can encapsulation be achieved without getters and setters?

A:

"Yes. We can expose controlled business methods instead of getters and setters."


Example:

class BankAccount {

    private double balance;

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

Yahan getters/setters ke bina bhi encapsulation achieve ho rahi hai.


## 18. Easy Memory Trick

Encapsulation:

DATA
+
BEHAVIOR
↓
CLASS
↓
PRIVATE DATA
↓
CONTROLLED ACCESS


One-line trick:

"Data ko andar rakho aur controlled methods ke through access do."


## 19. Most Important Interview Points

1. Encapsulation means bundling data and behavior together.
2. Private fields are commonly used for data hiding.
3. Controlled access can be provided through getters, setters, or business methods.
4. Getter/setter mandatory nahi hain.
5. Validation setter ya business method ke andar apply kar sakte hain.
6. Read-only property ke liye getter without setter use kar sakte hain.
7. Write-only behavior ke liye setter/business method without getter possible hai.
8. Encapsulation improves data protection and maintainability.
9. Data hiding and encapsulation are related but not exactly identical.
10. Abstraction and encapsulation are different concepts.
11. Encapsulation focuses on controlling access to internal state.
12. Abstraction focuses on hiding unnecessary implementation details.


# QUICK REVISION

Encapsulation
= Data + Methods → Single Class

Private field
= Direct external access blocked

Getter
= Read

Setter
= Update

Business method
= Controlled operation + Validation

Getter/Setter
= Not mandatory

Main benefit
= Data protection + Controlled access + Maintainability