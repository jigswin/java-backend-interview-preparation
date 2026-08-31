Java Comparable & Comparator — Interview Preparation Notes

Concepts → examples → compareTo/compare → sorting → Java 8 → interview questions

1. Why do we need Comparable and Comparator?

Java can sort simple values, but for custom objects such as Employee it needs to know which field determines the order. An Employee may need sorting by salary, name, ID, or joining date. Comparable and Comparator provide these comparison rules.

2. Comparable — Core Concept

Comparable defines a class's natural/default ordering. The class implements Comparable<T> and provides compareTo(). Think: Comparable = “How should this object normally be sorted?”

class Employee implements Comparable<Employee> {
    int id;
    String name;
    long salary;

    @Override
    public int compareTo(Employee other) {
        return Long.compare(this.salary, other.salary);
    }
}

Here salary becomes the natural ordering, so Collections.sort(employees) can use compareTo().

3. compareTo() Return Values

a.compareTo(b)

< 0  → a comes before b
= 0  → a and b are equal for ordering
> 0  → a comes after b

For ascending numeric order use Integer.compare/Long.compare. For descending order reverse the arguments. Prefer these methods over subtraction to avoid overflow issues.

4. Complete Comparable Example

import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    long salary;

    Employee(int id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Long.compare(this.salary, other.salary);
    }

    @Override
    public String toString() {
        return name + " -> " + salary;
    }
}

List<Employee> employees = Arrays.asList(
    new Employee(101, "Jigar", 8522400),
    new Employee(102, "Rahul", 5000000),
    new Employee(103, "Amit", 9000000),
    new Employee(104, "Raj", 6000000)
);

Collections.sort(employees);

This sorts employees by salary in ascending order.

5. Comparator — Core Concept

Comparator defines custom sorting logic outside the class. It is especially useful when the same object needs multiple sorting strategies. Think: Comparator = “How do I want to sort this object for this particular situation?”

Comparator<Employee> byName =
    (e1, e2) -> e1.name.compareTo(e2.name);

employees.sort(byName);

6. Multiple Comparator Strategies

Comparator<Employee> bySalary =
    (e1, e2) -> Long.compare(e1.salary, e2.salary);

Comparator<Employee> bySalaryDesc =
    (e1, e2) -> Long.compare(e2.salary, e1.salary);

Comparator<Employee> byId =
    (e1, e2) -> Integer.compare(e1.id, e2.id);

Comparator<Employee> byName =
    (e1, e2) -> e1.name.compareTo(e2.name);

The Employee class does not need to change every time a different sort is required.

7. Comparable vs Comparator

Point

Comparable

Comparator

Purpose

Natural/default ordering

Custom sorting

Method

compareTo()

compare()

Location

Inside the class

Usually outside the class

Interface

java.lang.Comparable

java.util.Comparator

Strategies

Usually one natural order

Can have many

Example

Employee default by ID/salary

Employee by name/salary/date

8. Java 8 Comparator.comparing()

employees.sort(Comparator.comparing(Employee::getName));

employees.sort(Comparator.comparingLong(Employee::getSalary));

employees.sort(
    Comparator.comparingLong(Employee::getSalary).reversed()
);

Use getters when fields are private. comparing(), comparingInt(), and comparingLong() make sorting concise.

9. Multiple-Level Sorting

Example: salary descending, and if salary is equal, name ascending.

employees.sort(
    Comparator.comparingLong(Employee::getSalary)
              .reversed()
              .thenComparing(Employee::getName)
);

thenComparing() is a common Java 8 interview topic.

10. Comparable with TreeSet / TreeMap

TreeSet and TreeMap need ordering. They can use Comparable natural ordering or a supplied Comparator. Be careful: in a sorted collection, compareTo()/compare() returning 0 can make different objects equivalent for that collection. Add a tie-breaker when both objects must remain.

Set<Employee> employees = new TreeSet<>(
    Comparator.comparingLong(Employee::getSalary)
              .thenComparingInt(Employee::getId)
);

11. Common Mistakes

1. Avoid return (int)(salary1 - salary2); prefer Long.compare().
2. For descending order reverse the arguments.
3. A TreeSet comparator returning 0 for different business objects may cause one to be discarded.
4. compareTo()/compare() define ordering; equals() defines logical equality.
5. Comparator does not need to modify the original class.

12. Real-World Employee Example

An ERP application may need default ordering by employee ID (Comparable), while different screens need sorting by salary, name, or joining date (Comparators). Salary descending plus name ascending can be created by Comparator chaining.

13. Interview Questions

• What is Comparable?

• What is Comparator?

• Difference between Comparable and Comparator?

• What is compareTo()?

• What does compareTo() return?

• How do you sort custom objects?

• How do you sort Employee by salary?

• How do you sort salary descending?

• How do you sort by name?

• Can one class have multiple Comparator implementations?

• Why use Comparator if Comparable exists?

• What is Comparator.comparing()?

• What is thenComparing()?

• How do TreeSet and Comparator interact?

• What happens when a TreeSet comparator returns 0 for two different objects?

• Difference between compareTo(), compare(), and equals()?

• Why avoid subtraction in compare methods?

• Can Comparable be used with TreeSet?

• Can Comparator be passed to List.sort()?

• Give a real-world use case.

14. 30-Second Interview Answer

“Comparable is used to define the natural ordering of objects inside the class using compareTo(). Comparator is used to define custom or multiple sorting strategies outside the class using compare(). For example, an Employee can have salary as its natural ordering with Comparable, while Comparator can sort the same employees by name, salary descending, or joining date depending on the requirement.”

15. Quick Revision Cheat Sheet

Comparable
  → implements Comparable<T>
  → compareTo()
  → natural/default ordering

Comparator
  → Comparator<T>
  → compare()
  → custom/multiple ordering

Ascending:  Integer.compare(a,b) / Long.compare(a,b)
Descending: Integer.compare(b,a) / Long.compare(b,a)

Java 8:
Comparator.comparing(...)
Comparator.comparingInt(...)
Comparator.comparingLong(...)
.reversed()
.thenComparing(...)

