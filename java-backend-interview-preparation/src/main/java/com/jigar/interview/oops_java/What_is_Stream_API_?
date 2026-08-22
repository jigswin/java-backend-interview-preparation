# Q21 — Stream API in Java

## 1. Stream API kya hoti hai?

Java 8 me Stream API introduce hui thi.

Simple language:

> Stream API ka use Collection ke data ko process/filter/transform karne ke liye hota hai.

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


# 2. Stream kya Collection hai?

NO.

Ye bahut important interview point hai.

`Stream` khud data store nahi karti.

Collection:

→ Data store karti hai.

Stream:

→ Data ko process karti hai.


Example:

List<Integer> numbers =
        List.of(10, 20, 30);

Stream<Integer> stream =
        numbers.stream();


# 3. Stream ka Basic Flow

Generally Stream pipeline:

SOURCE
   ↓
INTERMEDIATE OPERATION
   ↓
INTERMEDIATE OPERATION
   ↓
TERMINAL OPERATION


Example:

numbers.stream()
       .filter(n -> n % 2 == 0)
       .map(n -> n * 2)
       .toList();


Yahan:

Source:
`numbers.stream()`

Intermediate:
`filter()`
`map()`

Terminal:
`toList()`


# 4. Intermediate Operation kya hoti hai?

Intermediate operation ek new Stream return karti hai.

Common examples:

filter()
map()
sorted()
distinct()
limit()
skip()
peek()


Example:

numbers.stream()
       .filter(n -> n > 10)
       .map(n -> n * 2);


Yahan abhi final result generate nahi hua.


# 5. Terminal Operation kya hoti hai?

Terminal operation Stream pipeline ko execute/terminate karti hai aur result produce karti hai.

Examples:

toList()
collect()
forEach()
count()
reduce()
min()
max()
findFirst()
findAny()
anyMatch()
allMatch()
noneMatch()


Example:

long count =
        numbers.stream()
               .filter(n -> n > 10)
               .count();


`count()` terminal operation hai.


# 6. filter()

`filter()` condition ke basis par elements select karta hai.

Example:

List<Integer> numbers =
        List.of(10, 15, 20, 25, 30);

List<Integer> evenNumbers =
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .toList();

Output:

[10, 20, 30]


Easy:

filter()
→ Condition ke basis par data chuno.


# 7. map()

`map()` ek element ko kisi doosre form me transform karta hai.

Example:

List<Integer> numbers =
        List.of(1, 2, 3, 4);

List<Integer> squares =
        numbers.stream()
               .map(n -> n * n)
               .toList();

Output:

[1, 4, 9, 16]


Easy:

map()
→ Transform


# 8. filter() vs map()

filter():

→ Elements ko select/remove karta hai.

map():

→ Elements ko transform karta hai.


Example:

filter:

.filter(n -> n > 10)


map:

.map(n -> n * 2)


Memory:

filter
→ Kaunse elements chahiye?

map
→ Elements ko kis form me convert karna hai?


# 9. sorted()

Data ko sort karne ke liye:

Example:

List<Integer> numbers =
        List.of(30, 10, 20);

List<Integer> sorted =
        numbers.stream()
               .sorted()
               .toList();

Output:

[10, 20, 30]


Descending:

List<Integer> sorted =
        numbers.stream()
               .sorted(Comparator.reverseOrder())
               .toList();


# 10. distinct()

Duplicate values remove karta hai.

Example:

List<Integer> numbers =
        List.of(10, 20, 10, 30, 20);

List<Integer> result =
        numbers.stream()
               .distinct()
               .toList();

Output:

[10, 20, 30]


# 11. limit()

First N elements leta hai.

Example:

List<Integer> numbers =
        List.of(10, 20, 30, 40, 50);

List<Integer> result =
        numbers.stream()
               .limit(3)
               .toList();

Output:

[10, 20, 30]


# 12. skip()

Starting ke N elements skip karta hai.

Example:

List<Integer> numbers =
        List.of(10, 20, 30, 40, 50);

List<Integer> result =
        numbers.stream()
               .skip(2)
               .toList();

Output:

[30, 40, 50]


# 13. count()

Elements count karta hai.

Example:

long count =
        numbers.stream()
               .filter(n -> n > 20)
               .count();

Agar numbers:

10, 20, 30, 40

to result:

2


# 14. forEach()

Har element par action perform karta hai.

Example:

numbers.stream()
       .forEach(n ->
           System.out.println(n)
       );


Short:

numbers.forEach(
        n -> System.out.println(n)
);


# 15. collect()

Stream result ko collection ya doosri form me collect karne ke liye use hota hai.

Example:

List<Integer> result =
        numbers.stream()
               .filter(n -> n > 10)
               .collect(Collectors.toList());


Modern Java me:

.toList()

bhi use kar sakte hain.

Example:

List<Integer> result =
        numbers.stream()
               .filter(n -> n > 10)
               .toList();


# 16. reduce()

`reduce()` multiple elements ko combine karke ek result generate karta hai.

Example:

List<Integer> numbers =
        List.of(10, 20, 30, 40);

int sum =
        numbers.stream()
               .reduce(0, (a, b) -> a + b);

System.out.println(sum);

Output:

100


Easy:

reduce()
→ Many values → One value


# 17. Optional with reduce()

Without identity:

Optional<Integer> result =
        numbers.stream()
               .reduce((a, b) -> a + b);


Because stream empty bhi ho sakti hai, result `Optional` ho sakta hai.


# 18. findFirst()

First element find karta hai.

Example:

Optional<Integer> result =
        numbers.stream()
               .filter(n -> n > 20)
               .findFirst();


Agar numbers:

10, 20, 30, 40

to:

30

mil sakta hai.


# 19. findAny()

Koi bhi matching element return kar sakta hai.

Example:

Optional<Integer> result =
        numbers.stream()
               .filter(n -> n > 20)
               .findAny();


Sequential stream me often first matching element mil sakta hai, but contract arbitrary matching element allow karta hai.


# 20. anyMatch()

Check karta hai ki at least one element condition satisfy karta hai ya nahi.

Example:

boolean result =
        numbers.stream()
               .anyMatch(n -> n > 30);

Output:

true


Easy:

anyMatch
→ Koi ek match hai?


# 21. allMatch()

Check karta hai ki all elements condition satisfy karte hain ya nahi.

Example:

boolean result =
        numbers.stream()
               .allMatch(n -> n > 0);

Output:

true


Easy:

allMatch
→ Sab match hain?


# 22. noneMatch()

Check karta hai ki koi bhi element condition satisfy nahi karta.

Example:

boolean result =
        numbers.stream()
               .noneMatch(n -> n < 0);

Output:

true


Easy:

noneMatch
→ Ek bhi match nahi?


# 23. Stream Lazy kyu hoti hai?

Ye interview ka important question hai.

Intermediate operations generally lazy hoti hain.

Example:

numbers.stream()
       .filter(n -> {
           System.out.println("Filtering " + n);
           return n > 10;
       });

Yahan sirf stream pipeline banayi gayi.

Terminal operation nahi hai.

So processing generally start nahi hogi.


Agar:

numbers.stream()
       .filter(n -> n > 10)
       .toList();

Ab terminal operation hai, so pipeline execute hogi.


# 24. Stream ek baar use karne ke baad?

Stream reuse nahi kar sakte.

Example:

Stream<Integer> stream =
        numbers.stream();

stream.count();

stream.forEach(System.out::println);


Second operation par:

IllegalStateException

aa sakta hai because stream already consumed/closed.


Agar dobara process karna hai:

numbers.stream()

se new Stream create karo.


# 25. Stream Original Collection ko modify karti hai?

Normally Stream operations original collection ko automatically modify nahi karti.

Example:

List<Integer> numbers =
        new ArrayList<>(
            List.of(1, 2, 3)
        );

List<Integer> result =
        numbers.stream()
               .map(n -> n * 2)
               .toList();


`numbers` same rahega:

[1, 2, 3]

Result:

[2, 4, 6]


# 26. Real-World Employee Example

Suppose:

List<Employee> employees =
        employeeRepository.findAll();


Active employees:

List<Employee> activeEmployees =
        employees.stream()
                 .filter(Employee::isActive)
                 .toList();


Employee names:

List<String> names =
        employees.stream()
                 .map(Employee::getName)
                 .toList();


Salary greater than 50,000:

List<Employee> highSalaryEmployees =
        employees.stream()
                 .filter(e -> e.getSalary() > 50000)
                 .toList();


Ye Spring Boot/backend development me very common hai.


# 27. Multiple Operations Together

Example:

List<Integer> numbers =
        List.of(10, 15, 20, 25, 30, 35);

List<Integer> result =
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .map(n -> n * 2)
               .sorted()
               .toList();

Output:

[20, 40, 60]


Flow:

10 → filter → remove
15 → filter → remove
20 → filter → 40
25 → filter → remove
30 → filter → 60
35 → filter → remove

Final:

[20, 40, 60]


# 28. Stream vs Collection

Collection:

→ Data store karti hai.

Stream:

→ Data process karti hai.


Collection:

List<Integer> numbers =
        List.of(1, 2, 3);


Stream:

numbers.stream()
       .filter(n -> n > 1)
       .toList();


# 29. Sequential vs Parallel Stream

Normal:

numbers.stream()


Parallel:

numbers.parallelStream()


Parallel stream multiple threads ka use kar sakti hai.

Lekin:

> Parallel stream automatically faster nahi hoti.

Small/simple operations ke liye parallel stream unnecessary overhead create kar sakti hai.

Use carefully.


# 30. Interview-Ready Answer

Question:

"What is Stream API?"

Answer:

"Stream API, introduced in Java 8, provides a declarative way to process data from collections and other sources using operations such as filter, map, sorted, reduce and collect. Streams do not store data themselves."


# 31. Important Interview Questions

Q: Is Stream a Collection?

A:

"No. Stream is not a data structure for storing data; it is used to process data."


Q: Difference between filter and map?

A:

"filter selects elements based on a condition, while map transforms each element."


Q: What is intermediate operation?

A:

"An operation that returns another stream, such as filter, map and sorted."


Q: What is terminal operation?

A:

"An operation that produces a result or side effect and terminates the stream pipeline, such as collect, toList, count and forEach."


Q: Why are streams lazy?

A:

"Intermediate operations are generally evaluated only when a terminal operation triggers the pipeline."


Q: Can we reuse a stream?

A:

"No. Once a stream has been consumed or closed, it cannot be reused."


Q: Does stream modify the original collection?

A:

"Stream operations generally don't modify the source unless we explicitly perform side effects that modify it."


Q: What is reduce?

A:

"reduce combines stream elements into a single result."


Q: Difference between findFirst and findAny?

A:

"findFirst returns the first element according to encounter order when one exists, while findAny may return any matching element."


Q: What is parallel stream?

A:

"A parallel stream can process elements using multiple threads, but it should be used only when it actually benefits the workload."


# 32. Easy Memory Trick

filter
→ Select


map
→ Transform


sorted
→ Sort


distinct
→ Remove duplicates


limit
→ Take first N


skip
→ Skip first N


count
→ Count


reduce
→ Many → One


forEach
→ Perform action


collect / toList
→ Create result


anyMatch
→ At least one


allMatch
→ Everyone


noneMatch
→ Nobody


# 33. Most Important Interview Points

1. Stream API was introduced in Java 8.
2. Stream does not store data.
3. Stream processes data from a source.
4. filter() selects elements.
5. map() transforms elements.
6. sorted() sorts elements.
7. distinct() removes duplicates.
8. limit() limits elements.
9. skip() skips elements.
10. count() counts elements.
11. reduce() combines elements into one result.
12. collect()/toList() creates a result.
13. Intermediate operations are generally lazy.
14. Terminal operation triggers stream processing.
15. A stream cannot normally be reused after consumption.
16. `findFirst()` respects encounter order when applicable.
17. `findAny()` can return any matching element.
18. Parallel streams use multiple threads but are not always faster.
19. Streams generally don't modify the source collection automatically.
20. Streams are heavily used in modern Java and Spring Boot code.


# QUICK REVISION

Stream:

SOURCE
↓
INTERMEDIATE
↓
INTERMEDIATE
↓
TERMINAL


Example:

List<Integer> result =
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .map(n -> n * 2)
               .toList();


filter
→ Select


map
→ Transform


reduce
→ Many values → One


toList
→ Final List


IMPORTANT:

Stream ≠ Collection

Collection
→ Store data

Stream
→ Process data


ONE-LINE INTERVIEW ANSWER:

"Stream API provides a declarative way to process data using operations like filter, map, sorted, reduce and collect, without being a data storage structure itself."