package com.jigar.interview.comparable_and_comparator;

import javax.swing.plaf.SpinnerUI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*

 Comparable
→ compareTo()
→ class ke andar
→ natural/default ordering
→ generally one sorting strategy
-> string k case me compareTo inside bhi
-> baki k case me compare

Comparator
→ custom comparison
→ class ke bahar bhi define kar sakte hain
→ multiple sorting strategies
→ thenComparing() se multi-level sorting

 */

public class Employee implements Comparable<Employee>{

    int id;
    String name;
    long salary;

    Employee(int id, String name, long salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public long getSalary()
    {
        return salary;
    }

    public String getName()
    {
        return name;
    }

    // Acending order salry
    //    @Override
    //    public int compareTo(Employee other)
    //    {
    //        return Long.compare(this.salary, other.salary);
    //    }

    // Descending order salary
    // @Override
    // public int compareTo(Employee other)
    // {
    //   return Long.compare(other.salary, this.salary);
    // }

    // Ascending by name
    //    @Override
    //    public int compareTo(Employee other)
    //    {
    //        return this.name.compareTo(other.name);
    //    }

    // Descending order by name
    @Override
    public int compareTo(Employee other)
    {
        return other.name.compareTo(this.name);
    }

}

class EmployeeSalarySort {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Jigar", 13000000),
                new Employee(102, "Amit", 9000000),
                new Employee(103, "Bamit", 9000000),
                new Employee(104, "Raj", 6000000),
                new Employee(105, "Raj", 6000000)
        );

        // comparable ka example
        // Collections.sort(employees);


        //  comparator ka example

        // 1.
        //  Comparator<Employee> salaryComparator = Comparator.comparingLong(Employee :: getSalary).reversed();
        //  employees.sort(salaryComparator);

        // 2.
        // employees.sort(Comparator.comparingLong(Employee::getSalary).reversed());

        // 3. direct field access with lambda
        // employees.sort(Comparator.comparing(e -> e.name));

        // 4. get method access with lambda asc
        // employees.sort(Comparator.comparing(e -> e.getSalary()));

        // 5. get method access with lambda desc
        // employees.sort(Comparator.comparingLong((Employee e) -> e.getSalary()).reversed());

        // multi sort
        // 1.
        // employees.sort(Comparator.comparingLong(Employee :: getSalary).thenComparing(Employee::getName).reversed());

        // 2.
        employees.sort(Comparator.comparingLong(Employee::getSalary).reversed().thenComparing(Employee::getName).thenComparing(e->e.id));

        for (Employee e : employees) {
            System.out.println(e.id + " : " + e.name + " -> " + e.salary);
        }
    }
}

