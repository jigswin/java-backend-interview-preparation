# Q26 — Wrapper Classes, Autoboxing & Unboxing in Java

## 1. Wrapper Class kya hoti hai?

Java me primitive data types ke corresponding object types ko Wrapper Classes kehte hain.

Primitive        Wrapper Class

byte      →      Byte
short     →      Short
int       →      Integer
long      →      Long
float     →      Float
double    →      Double
char      →      Character
boolean   →      Boolean


Example:

int number = 10;

Integer numberObject = 10;


Yahan:

int
→ primitive

Integer
→ Wrapper Class


# 2. Wrapper Classes ki need kyu hoti hai?

Primitive data types objects nahi hote.

Lekin Java Collections jaise:

- ArrayList
- HashSet
- HashMap

objects ke saath kaam karte hain.

Example:

ArrayList<int> numbers;

❌ Not allowed.


Instead:

ArrayList<Integer> numbers =
        new ArrayList<>();

numbers.add(10);

numbers.add(20);

numbers.add(30);

✅ Allowed.


Isliye Wrapper Classes useful hain.


# 3. Autoboxing kya hota hai?

Primitive ko automatically Wrapper Object me convert karna:

> Autoboxing


Example:

int number = 10;

Integer object = number;


Java automatically:

int
→ Integer

convert kar deta hai.


Conceptually:

Integer object =
        Integer.valueOf(number);


# 4. Simple Autoboxing Example

int a = 100;

Integer b = a;


Yahan:

a
→ int

b
→ Integer

int automatically Integer me convert hua.

Ye:

Autoboxing

hai.


# 5. Unboxing kya hota hai?

Wrapper Object ko automatically primitive me convert karna:

> Unboxing


Example:

Integer number = 100;

int value = number;


Java automatically:

Integer
→ int

convert kar deta hai.


Conceptually:

int value =
        number.intValue();


# 6. Simple Example

Integer number = 50;

int result = number;


Yahan:

Integer
→ int

Unboxing hai.


# 7. Autoboxing + Unboxing Together

Example:

Integer a = 10;

int b = a;

System.out.println(b);


First:

10

int se Integer:

Autoboxing


Then:

Integer se int:

Unboxing


# 8. Real-World Example — ArrayList

ArrayList<Integer> numbers =
        new ArrayList<>();


numbers.add(10);

numbers.add(20);

numbers.add(30);


Yahan:

numbers.add(10);


`10` primitive int hai.

Java automatically usko Integer me convert karta hai.

This is:

Autoboxing


Jab:

int value = numbers.get(0);


`get(0)` Integer return karta hai.

Java automatically Integer ko int me convert karta hai.

This is:

Unboxing


# 9. Wrapper Class me Useful Methods

Integer class me useful methods:

Integer.parseInt()

Integer.valueOf()

Integer.compare()

Integer.max()

Integer.min()


Example:

String number = "100";

int value =
        Integer.parseInt(number);


Output:

100


# 10. parseInt() vs valueOf()

Important interview question.

parseInt():

String
→ primitive int


Example:

int number =
        Integer.parseInt("100");


valueOf():

String
→ Integer object


Example:

Integer number =
        Integer.valueOf("100");


Difference:

parseInt()
→ int


valueOf()
→ Integer


# 11. Example

String value = "500";

int a =
        Integer.parseInt(value);

Integer b =
        Integer.valueOf(value);


a
→ int

b
→ Integer


# 12. Wrapper Classes are Immutable

Wrapper objects are immutable.

Example:

Integer number = 10;

number = 20;


Yahan existing Integer object ka value modify nahi hua.

Instead:

`number`

ab ek different Integer value/object ko refer kar raha hai.


Simple interview answer:

> Wrapper class objects are immutable.


# 13. Important — Integer Caching

Java commonly caches Integer objects for values from:

-128 to 127


Example:

Integer a = 100;

Integer b = 100;

System.out.println(a == b);


Output:

true


Because both can refer to the same cached Integer object.


But:

Integer a = 200;

Integer b = 200;

System.out.println(a == b);


Generally:

false


because 200 is outside the commonly guaranteed cache range.


IMPORTANT:

Don't use `==` to compare wrapper values.

Use:

equals()


Example:

Integer a = 200;

Integer b = 200;

System.out.println(a.equals(b));


Output:

true


# 14. == vs equals() with Wrapper

Example:

Integer a = 100;

Integer b = 100;


a == b

→ compares object references.


a.equals(b)

→ compares values.


Best practice:

Use:

a.equals(b)


for wrapper value comparison.


# 15. Null with Wrapper Classes

Primitive:

int number = null;

❌ Not allowed.


Wrapper:

Integer number = null;

✅ Allowed.


Because Integer is an object/reference type.


# 16. Important — Unboxing null

Example:

Integer number = null;

int value = number;


This causes:

NullPointerException


Why?

Because Java tries to unbox:

Integer
→ int


But the Integer reference is null.


Conceptually:

number.intValue();


Calling something like this on null causes:

NullPointerException


# 17. Wrapper Classes in HashMap

Example:

Map<Integer, String> employees =
        new HashMap<>();

employees.put(101, "Jigar");

employees.put(102, "Rahul");


Here:

Integer

is used as the key type.

Primitive `int` cannot be used as a generic type parameter.


# 18. Why Generics Don't Support Primitive Types?

This is invalid:

List<int> numbers;

❌


Because Java Generics work with reference types.

Correct:

List<Integer> numbers;

✅


# 19. Wrapper Classes and Generics

Example:

List<Integer> numbers =
        new ArrayList<>();


Primitive:

int

Wrapper:

Integer


Similarly:

List<Double>

List<Long>

List<Boolean>

List<Character>


# 20. Common Wrapper Classes

byte
→ Byte


short
→ Short


int
→ Integer


long
→ Long


float
→ Float


double
→ Double


char
→ Character


boolean
→ Boolean


Important:

There is no wrapper class named `Int`.

Correct:

Integer


# 21. Autoboxing Example

int number = 10;

Integer object = number;


This:

primitive → object

is:

Autoboxing


# 22. Unboxing Example

Integer object = 10;

int number = object;


This:

object → primitive

is:

Unboxing


# 23. Interview-Ready Answer

Question:

"What are Wrapper Classes in Java?"

Answer:

"Wrapper classes provide object representations for primitive data types. They are useful when an object is required, such as with Collections and Generics. Java supports automatic conversion between primitives and their wrapper objects through autoboxing and unboxing."


# 24. Important Interview Questions

Q: Why do we need Wrapper Classes?

A:

"Because Java Collections and Generics work with objects/reference types, not primitive types."


Q: What is Autoboxing?

A:

"Automatic conversion of a primitive into its corresponding wrapper object."


Q: What is Unboxing?

A:

"Automatic conversion of a wrapper object into its corresponding primitive type."


Q: Can ArrayList store int?

A:

"Not directly. We use ArrayList<Integer>."


Q: What happens if we unbox null?

A:

"It causes NullPointerException."


Q: Difference between parseInt() and valueOf()?

A:

"parseInt() returns primitive int, while valueOf() returns an Integer object."


Q: Can Wrapper Classes be null?

A:

"Yes, because they are reference types."


Q: Can int be null?

A:

"No."


Q: Are Wrapper Classes immutable?

A:

"Yes, wrapper objects are immutable."


Q: Why should we use equals() instead of == for wrapper values?

A:

"`==` compares references when both operands are objects, while equals() compares their values."


# 25. QUICK REVISION

Primitive:

int

Wrapper:

Integer


Autoboxing:

int
↓
Integer


Unboxing:

Integer
↓
int


Example:

int a = 10;

Integer b = a;

→ Autoboxing


Integer c = 20;

int d = c;

→ Unboxing


Collections:

List<Integer>

→ Correct


List<int>

→ Wrong


Null:

Integer x = null;

→ Allowed


int x = null;

→ Not allowed


Unboxing null:

Integer x = null;

int y = x;

→ NullPointerException


parseInt():

String → int


valueOf():

String → Integer


ONE-LINE INTERVIEW ANSWER:

"Wrapper classes represent primitive types as objects; autoboxing converts primitives to wrappers automatically, while unboxing converts wrappers back to primitives."