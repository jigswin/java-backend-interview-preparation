# Q23 — Access Modifiers in Java

## 1. Access Modifier kya hota hai?

Access modifiers Java me decide karte hain ki kisi class, variable, method ya constructor ko kaha se access kiya ja sakta hai.

Java me 4 main access levels hain:

1. public
2. protected
3. default
4. private


# 2. public

public ka meaning:

> Is member ko kisi bhi class/package se access kiya ja sakta hai.

Example:

public class Employee {

    public String name = "Jigar";

    public void display() {

        System.out.println(name);
    }
}


Dusri class:

Employee employee = new Employee();

System.out.println(employee.name);

employee.display();

Output:

Jigar


# 3. private

private ka meaning:

> Sirf same class ke andar access kiya ja sakta hai.

Example:

class Employee {

    private double salary;

    private void calculateSalary() {

        System.out.println("Calculating salary");
    }
}


Dusri class:

Employee employee = new Employee();

employee.salary;

❌ Not allowed.

employee.calculateSalary();

❌ Not allowed.


# 4. private ka Real-World Use

private encapsulation achieve karne ke liye bahut important hai.

Example:

class Employee {

    private double salary;

    public double getSalary() {

        return salary;
    }

    public void setSalary(double salary) {

        if (salary > 0) {

            this.salary = salary;
        }
    }
}


Ab outside class directly salary modify nahi kar sakti:

employee.salary = -5000;

❌ Not allowed.

Instead:

employee.setSalary(50000);

✅ Allowed.


# 5. default Access Modifier

Agar hum koi access modifier nahi likhte, to member ka access level default/package-private hota hai.

Example:

class Employee {

    String name;

    void display() {

        System.out.println(name);
    }
}


Yahan:

name
→ default

display()
→ default


Default members:

> Sirf same package ke andar directly accessible hote hain.


# 6. protected

protected member accessible hota hai:

1. Same package ke andar
2. Different package me subclass ke through

Example:

class Employee {

    protected double salary;
}


Same package:

Employee employee = new Employee();

System.out.println(employee.salary);

✅ Allowed.


Different package me subclass:

class Manager extends Employee {

    void display() {

        System.out.println(salary);
    }
}

✅ Allowed.


Important:

Different package me protected member ko subclass/inheritance context ke through access karna hota hai.


# 7. Easy Memory Trick

private
→ Same class


default
→ Same package


protected
→ Same package + subclass


public
→ Everywhere


Yaad rakho:

private
→ CLASS

default
→ PACKAGE

protected
→ PACKAGE + CHILD

public
→ EVERYWHERE


# 8. Access Modifier Table

Modifier       Same Class   Same Package   Subclass   Other Package

public             YES          YES           YES          YES

protected          YES          YES           YES*         NO*

default            YES          YES           YES**        NO

private            YES          NO            NO           NO


* Protected member different package me subclass/inheritance context ke through accessible hota hai.

** Same package me subclass already package access ke through member access kar sakti hai.


# 9. Top-Level Class ke Access Modifiers

Top-level class ke liye:

public
default

allowed hain.

Example:

public class Employee {
}


or:

class Employee {
}


Lekin:

private class Employee {
}

❌ Not allowed.


protected class Employee {
}

❌ Not allowed.


Reason:

Top-level class ko private/protected declare nahi kar sakte.


# 10. Inner/Nested Class

Nested class ko private/protected bhi bana sakte hain.

Example:

class Outer {

    private class Inner {

    }

    protected class Test {

    }
}


Ye valid hai.


# 11. Constructor ke saath Access Modifiers

Constructor ko bhi access modifier de sakte hain.

Example:

public class Employee {

    public Employee() {

    }
}


Dusri class object create kar sakti hai:

Employee employee =
        new Employee();

✅ Allowed.


# 12. private Constructor

Constructor ko private bhi bana sakte hain.

Example:

class Utility {

    private Utility() {

    }

    public static void print() {

        System.out.println("Utility method");
    }
}


Ab:

Utility utility =
        new Utility();

❌ Not allowed.


But:

Utility.print();

✅ Allowed.


Private constructor ka common use:

- Utility classes
- Singleton pattern
- Controlled object creation


# 13. private Method

Private method sirf same class me access ho sakta hai.

Example:

class Employee {

    public void calculate() {

        validate();
    }

    private void validate() {

        System.out.println("Validation");
    }
}


Outside class:

employee.validate();

❌ Not allowed.


# 14. Can private method be overridden?

NO.

Example:

class Parent {

    private void display() {

        System.out.println("Parent");
    }
}


class Child extends Parent {

    void display() {

        System.out.println("Child");
    }
}


Ye overriding nahi hai.

Child ka display() ek separate method hai because parent ka private method subclass ko directly accessible/inherited nahi hota.


# 15. Can public method be overridden?

YES.

Example:

class Parent {

    public void display() {

        System.out.println("Parent");
    }
}


class Child extends Parent {

    @Override
    public void display() {

        System.out.println("Child");
    }
}


Allowed.


# 16. Can protected method be overridden?

YES.

Example:

class Parent {

    protected void display() {

        System.out.println("Parent");
    }
}


class Child extends Parent {

    @Override
    protected void display() {

        System.out.println("Child");
    }
}


Allowed.


# 17. Can default method be overridden?

YES.

Example:

class Parent {

    void display() {

        System.out.println("Parent");
    }
}


class Child extends Parent {

    @Override
    void display() {

        System.out.println("Child");
    }
}


Same package context me valid hai.


# 18. Important — Overriding me Access Reduce nahi kar sakte

Parent:

public void display()


Child:

protected void display()


❌ Not allowed.


Reason:

Child ka overriding method parent method se more restrictive access nahi de sakta.


Example:

Parent:

protected void display()


Child:

public void display()


✅ Allowed.


Parent:

default void display()


Child:

protected void display()


✅ Allowed.


Parent:

protected void display()


Child:

private void display()


❌ Not allowed.


Rule:

> Overriding method ka access same ya wider ho sakta hai, narrower nahi.


# 19. Access Modifier + Encapsulation

Access modifiers encapsulation implement karne me help karte hain.

Example:

class BankAccount {

    private double balance;

    public double getBalance() {

        return balance;
    }

    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;
        }
    }
}


Outside:

account.balance = -10000;

❌ Not allowed.


Instead:

account.deposit(5000);

✅ Allowed.


Yahan:

private
→ Data ko protect kar raha hai.

public methods
→ Controlled access de rahe hain.


# 20. Spring Boot Real-World Example

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(
            EmployeeRepository repository) {

        this.repository = repository;
    }

    public Employee getEmployee(Long id) {

        return findEmployee(id);
    }

    private Employee findEmployee(Long id) {

        return repository.findById(id)
                .orElseThrow();
    }
}


Yahan:

repository
→ private

getEmployee()
→ public

findEmployee()
→ private


Controller ko sirf required public method expose kiya gaya hai.

Internal implementation ko private rakha gaya hai.


# 21. Interview-Ready Answer

Question:

"What are access modifiers in Java?"

Answer:

"Java provides four access levels: public, protected, default and private. Public members can be accessed from anywhere, protected members can be accessed within the same package and through subclass access, default members are accessible within the same package, and private members are accessible only within the same class."


# 22. Important Interview Questions

Q: How many access modifiers/access levels are there in Java?

A:

"Four: public, protected, default/package-private and private."


Q: Which is the most restrictive?

A:

"private."


Q: Which provides the widest access?

A:

"public."


Q: What is default access?

A:

"When no access modifier is specified, the member has package-private/default access and can be accessed within the same package."


Q: Can private members be accessed from a child class?

A:

"Not directly. Private members are accessible only within the declaring class."


Q: Can private method be overridden?

A:

"No, because private methods are not inherited by the subclass."


Q: Can protected member be accessed from another package?

A:

"Yes, through a subclass/inheritance context, subject to Java's protected access rules."


Q: Can top-level class be private?

A:

"No."


Q: Can constructor be private?

A:

"Yes."


Q: Can access level be reduced while overriding?

A:

"No. An overriding method cannot have more restrictive access than the parent method."


# 23. QUICK REVISION

public
→ Everywhere


protected
→ Same package + subclass access


default
→ Same package


private
→ Same class


Memory:

private
→ CLASS

default
→ PACKAGE

protected
→ PACKAGE + CHILD

public
→ EVERYWHERE


# 24. Most Important Interview Points

1. Java has four access levels.
2. private is the most restrictive.
3. public provides the widest access.
4. default means package-private.
5. protected allows same-package access and subclass access.
6. Top-level classes can be public or default.
7. Constructor can be private.
8. Private methods cannot be overridden.
9. Overriding cannot reduce visibility.
10. Access modifiers help achieve encapsulation.
11. Private fields + public methods are commonly used for controlled access.
12. Spring Boot classes commonly use private fields and public service methods.


ONE-LINE INTERVIEW ANSWER:

"Access modifiers control the visibility of classes and their members. Java provides public, protected, default and private access levels, from widest to most restrictive."