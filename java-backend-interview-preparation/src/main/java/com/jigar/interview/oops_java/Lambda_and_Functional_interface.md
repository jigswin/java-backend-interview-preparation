# Q20 — Lambda Expression & Functional Interface in Java

## 1. Lambda Expression kya hota hai?

Lambda expression Java 8 me introduce hua tha.

Simple language:

> Lambda expression ka use functional interface ke method ko short way me implement karne ke liye hota hai.

Normal code me:

interface Calculator {

    int add(int a, int b);
}

Calculator calculator = new Calculator() {

    @Override
    public int add(int a, int b) {

        return a + b;
    }
};

System.out.println(calculator.add(10, 20));


Lambda se same code:

Calculator calculator =
        (a, b) -> a + b;

System.out.println(calculator.add(10, 20));


Output:

30


# 2. Lambda ka Syntax

Basic syntax:

(parameters) -> expression


Example:

(a, b) -> a + b


Agar multiple statements hain:

(a, b) -> {

    int result = a + b;

    return result;
}


# 3. Lambda ke Important Parts

Example:

(a, b) -> a + b

`(a, b)`
→ Parameters

`->`
→ Lambda operator

`a + b`
→ Body


# 4. Functional Interface kya hota hai?

Functional interface wo interface hai jisme exactly **one abstract method** hota hai.

Example:

@FunctionalInterface
interface Calculator {

    int add(int a, int b);
}


Ye functional interface hai because:

→ Only one abstract method hai.


# 5. @FunctionalInterface

`@FunctionalInterface` compiler ko batata hai ki interface functional interface hona chahiye.

Example:

@FunctionalInterface
interface Calculator {

    int add(int a, int b);
}


Agar hum second abstract method add kar dein:

@FunctionalInterface
interface Calculator {

    int add(int a, int b);

    int subtract(int a, int b);
}

❌ Compile-time error.

Reason:

Functional interface me exactly one abstract method hona chahiye.


# 6. Functional Interface me default/static methods?

YES.

Functional interface me:

- Exactly one abstract method
- Multiple default methods allowed
- Multiple static methods allowed

Example:

@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);

    default void display() {

        System.out.println("Calculator");
    }

    static void info() {

        System.out.println("Utility method");
    }
}

Still functional interface hai.

Because abstract methods sirf ek hai.


# 7. Lambda Example

@FunctionalInterface
interface Greeting {

    void greet(String name);
}

Greeting greeting =
        name -> System.out.println("Hello " + name);

greeting.greet("Jigar");


Output:

Hello Jigar


# 8. Lambda with Multiple Parameters

@FunctionalInterface
interface Calculator {

    int add(int a, int b);
}

Calculator calculator =
        (a, b) -> a + b;

System.out.println(
        calculator.add(10, 20)
);


# 9. Lambda with One Parameter

Parentheses optional ho sakte hain.

Example:

name -> System.out.println(name);

Equivalent:

(name) -> System.out.println(name);


# 10. Lambda with No Parameters

Example:

() -> System.out.println("Hello");


Functional interface:

@FunctionalInterface
interface Greeting {

    void greet();
}

Greeting greeting =
        () -> System.out.println("Hello");


# 11. Lambda with Multiple Statements

Example:

Calculator calculator =
        (a, b) -> {

            int result = a + b;

            return result;
        };


Important:

Curly braces use karne par return statement explicitly likhna pad sakta hai if the lambda returns a value.


# 12. Lambda ka Main Benefit

Lambda ka main benefit:

> Boilerplate code reduce karna.

Without lambda:

Calculator calculator = new Calculator() {

    @Override
    public int add(int a, int b) {

        return a + b;
    }
};


With lambda:

Calculator calculator =
        (a, b) -> a + b;


Much cleaner.


# 13. Java ke Built-in Functional Interfaces

Java me commonly used functional interfaces:

1. Predicate
2. Function
3. Consumer
4. Supplier


Ye `java.util.function` package me milte hain.


# 14. Predicate

Predicate ek input leta hai aur boolean return karta hai.

Signature conceptually:

boolean test(T t)


Example:

Predicate<Integer> isEven =
        number -> number % 2 == 0;

System.out.println(
        isEven.test(10)
);


Output:

true


Easy memory:

Predicate
→ Check condition
→ Returns boolean


# 15. Function

Function ek input leta hai aur output return karta hai.

Example:

Function<String, Integer> length =
        str -> str.length();

System.out.println(
        length.apply("Java")
);


Output:

4


Easy memory:

Function
→ Input → Output


# 16. Consumer

Consumer input leta hai but return kuch nahi karta.

Example:

Consumer<String> print =
        value -> System.out.println(value);

print.accept("Java");


Output:

Java


Easy memory:

Consumer
→ Consume input
→ No return


# 17. Supplier

Supplier input nahi leta but value provide karta hai.

Example:

Supplier<String> message =
        () -> "Hello Java";

System.out.println(
        message.get()
);


Output:

Hello Java


Easy memory:

Supplier
→ No input
→ Gives output


# 18. Easy Comparison

Predicate:

Input → Boolean


Function:

Input → Output


Consumer:

Input → Nothing


Supplier:

Nothing → Output


Memory:

Predicate
→ P = Pass/Check


Function
→ F = Transform


Consumer
→ C = Consume


Supplier
→ S = Supply


# 19. Lambda with Collections

Lambda ka common use Collections ke saath hota hai.

Example:

List<String> names =
        List.of("Jigar", "Rahul", "Amit");

names.forEach(
        name -> System.out.println(name)
);


Output:

Jigar
Rahul
Amit


# 20. Lambda with Sorting

Example:

List<Integer> numbers =
        new ArrayList<>(
            List.of(30, 10, 20)
        );

numbers.sort(
        (a, b) -> a - b
);

System.out.println(numbers);


Output:

[10, 20, 30]


Interview me ye common example hai.


# 21. Lambda + Comparator

Example:

List<String> names =
        new ArrayList<>(
            List.of("Jigar", "Amit", "Rahul")
        );

names.sort(
        (a, b) -> a.compareTo(b)
);

System.out.println(names);


Lambda yahan Comparator ke functional interface ko implement kar raha hai.


# 22. Lambda + Stream API

Example:

List<Integer> numbers =
        List.of(10, 15, 20, 25, 30);

List<Integer> evenNumbers =
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .toList();

System.out.println(evenNumbers);


Output:

[10, 20, 30]


Yahan:

`n -> n % 2 == 0`

ek lambda expression hai.


# 23. Lambda ka Real-World Use

Spring Boot/backend applications me lambda commonly use hota hai:

- Collections
- Streams
- Filtering
- Sorting
- Mapping
- Optional
- Callbacks
- Functional interfaces


Example:

List<Employee> employees =
        employeeRepository.findAll();

List<Employee> activeEmployees =
        employees.stream()
                 .filter(Employee::isActive)
                 .toList();


# 24. Method Reference

Lambda ka ek short form method reference hota hai.

Example:

names.forEach(
        name -> System.out.println(name)
);


Method reference:

names.forEach(
        System.out::println
);


Syntax:

ClassName::methodName

or

object::methodName


# 25. Lambda vs Anonymous Inner Class

Anonymous class:

Runnable task = new Runnable() {

    @Override
    public void run() {

        System.out.println("Running");
    }
};


Lambda:

Runnable task =
        () -> System.out.println("Running");


Lambda shorter and cleaner hai.


# 26. Important — Lambda sirf Functional Interface ke saath?

Yes.

Lambda expression ka target type functional interface hona chahiye.

Example:

@FunctionalInterface
interface Calculator {

    int add(int a, int b);
}

Calculator calculator =
        (a, b) -> a + b;


# 27. Kya Lambda directly abstract class ko implement kar sakta hai?

No.

Lambda ka target type functional interface hona chahiye.

Example:

abstract class Calculator {

    abstract int add(int a, int b);
}

Calculator calculator =
        (a, b) -> a + b;

❌ Not allowed.


# 28. Functional Interface Examples in Java

Common built-in interfaces:

Runnable
→ void run()

Comparator<T>
→ int compare(T o1, T o2)

Predicate<T>
→ boolean test(T t)

Function<T,R>
→ R apply(T t)

Consumer<T>
→ void accept(T t)

Supplier<T>
→ T get()


# 29. @FunctionalInterface ka benefit

Ye annotation mandatory nahi hai.

Without annotation bhi functional interface ban sakta hai:

interface Calculator {

    int add(int a, int b);
}


But:

@FunctionalInterface

use karna recommended hai because compiler ensure karta hai ki interface me exactly one abstract method rahe.


# 30. Interview-Ready Answer

Question:

"What is Lambda expression in Java?"

Answer:

"Lambda expression is a concise way to represent an implementation of a functional interface. It was introduced in Java 8 and helps reduce boilerplate code, especially when working with collections, streams and functional interfaces."


Question:

"What is a Functional Interface?"

Answer:

"A functional interface is an interface that has exactly one abstract method. It can have multiple default and static methods. It can be used as the target type of a lambda expression."


# 31. Important Interview Questions

Q: What is Lambda?

A:

"Lambda is a concise implementation of a functional interface."


Q: What is Functional Interface?

A:

"An interface with exactly one abstract method."


Q: Can functional interface have default methods?

A:

"Yes."


Q: Can functional interface have static methods?

A:

"Yes."


Q: Can functional interface have multiple abstract methods?

A:

"No."


Q: Is @FunctionalInterface mandatory?

A:

"No. It is optional, but useful because the compiler validates the interface."


Q: Can lambda implement abstract class?

A:

"No. Lambda requires a functional interface target type."


Q: What are Predicate, Function, Consumer and Supplier?

A:

"Predicate takes input and returns boolean, Function transforms input into output, Consumer accepts input without returning a result, and Supplier provides a result without taking input."


# 32. Easy Memory Trick

Lambda:

(parameters) -> body


Functional Interface:

ONE ABSTRACT METHOD


Predicate:

Input → boolean


Function:

Input → Output


Consumer:

Input → Nothing


Supplier:

Nothing → Output


# 33. Most Important Interview Points

1. Lambda was introduced in Java 8.
2. Lambda reduces boilerplate code.
3. Lambda works with functional interfaces.
4. Functional interface has exactly one abstract method.
5. Functional interface can have multiple default methods.
6. Functional interface can have multiple static methods.
7. `@FunctionalInterface` is optional.
8. Predicate returns boolean.
9. Function transforms input to output.
10. Consumer takes input and returns nothing.
11. Supplier takes no input and supplies a value.
12. Lambda is heavily used with Stream API.
13. Lambda is commonly used with Comparator.
14. Method reference is a shorter form for certain lambdas.
15. Lambda cannot directly target an abstract class.


# QUICK REVISION

Lambda:

(a, b) -> a + b


Functional Interface:

@FunctionalInterface
interface Calculator {

    int add(int a, int b);
}


Predicate:

Predicate<Integer> p =
        n -> n > 10;


Function:

Function<String, Integer> f =
        s -> s.length();


Consumer:

Consumer<String> c =
        s -> System.out.println(s);


Supplier:

Supplier<String> s =
        () -> "Java";


Memory:

Predicate
→ Check

Function
→ Transform

Consumer
→ Consume

Supplier
→ Supply


ONE-LINE INTERVIEW ANSWER:

"Lambda expressions provide a concise way to implement functional interfaces, while a functional interface is an interface containing exactly one abstract method."