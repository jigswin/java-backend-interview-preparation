# Q19 — Immutable Class in Java

## 1. Immutable Class kya hoti hai?

Immutable class wo class hoti hai jiska object create hone ke baad uski state change nahi ki ja sakti.

Simple language:

> Object ek baar create ho gaya → uske fields ki value change nahi hogi.

Example:

String s = "Java";

String immutable hai.

Agar:

s = "Spring";

To purana `"Java"` object modify nahi hua.

`"Spring"` ek alag String object hai aur reference `s` ab usko point kar raha hai.


# 2. Immutable Class ka Real-World Example

Java ka most famous example:

String

Other examples:

Integer
Long
Double
Boolean
BigInteger
BigDecimal

Ye classes immutable design follow karti hain.


# 3. Immutable Class kaise banate hain?

Interview me ye bahut important hai.

Immutable class banane ke common rules:

1. Class ko `final` karo.
2. Fields ko `private` karo.
3. Fields ko `final` karo.
4. Fields ko constructor ke through initialize karo.
5. Setter methods provide mat karo.
6. Mutable objects ke liye defensive copy use karo.
7. Getter me mutable object ka direct reference return mat karo.


# 4. Basic Immutable Class

Example:

final class Employee {

    private final int id;
    private final String name;

    public Employee(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }
}


Main:

Employee employee =
        new Employee(101, "Jigar");

System.out.println(employee.getId());
System.out.println(employee.getName());


Ab:

employee.setName("Rahul");

❌ Possible nahi hai because setter hi nahi hai.


# 5. Why class final?

Class ko `final` karne ka purpose:

> Koi child class inherit karke behavior/state ko change na kar sake.

Example:

final class Employee {
}

class Manager extends Employee {
}

❌ Not allowed.


# 6. Why fields private?

Fields ko `private` rakhte hain taaki outside code directly modify na kar sake.

Example:

private final String name;


Outside:

employee.name = "Rahul";

❌ Not allowed.


# 7. Why fields final?

`final` ensure karta hai ki field ko initialization ke baad reassign nahi kar sakte.

Example:

private final String name;

Constructor:

this.name = name;

Later:

this.name = "Rahul";

❌ Not allowed.


# 8. Why no Setter?

Agar setter provide kar diya:

public void setName(String name) {

    this.name = name;
}

To object ki state change ho sakti hai.

Isliye immutable class me setters generally nahi hote.


# 9. Important — Mutable Field Problem

Suppose immutable class me List hai.

Example:

final class Employee {

    private final List<String> skills;

    public Employee(List<String> skills) {

        this.skills = skills;
    }

    public List<String> getSkills() {

        return skills;
    }
}

Ye actually fully immutable nahi hai.

Why?

Because external code list ko modify kar sakta hai.


# 10. Problem Example

List<String> skills =
        new ArrayList<>();

skills.add("Java");

Employee employee =
        new Employee(skills);


Now:

skills.add("Spring Boot");

Employee ke andar ki list bhi change ho jayegi.

Because same List object ka reference store hua hai.


# 11. Defensive Copy

Is problem ko solve karne ke liye defensive copy use kar sakte hain.

Example:

final class Employee {

    private final List<String> skills;

    public Employee(List<String> skills) {

        this.skills =
            new ArrayList<>(skills);
    }

    public List<String> getSkills() {

        return List.copyOf(skills);
    }
}


Ab outside list change kare:

skills.add("Spring Boot");

Employee ki internal list change nahi hogi.


# 12. Why Getter me Defensive Copy?

Agar hum directly:

return skills;

kar dein,

to caller internal mutable List ka reference le lega.

Then:

employee.getSkills().add("Kafka");

internal state modify kar sakta hai.

Isliye:

return List.copyOf(skills);

ya suitable unmodifiable/defensive representation use karte hain.


# 13. Java 10+ Example

Modern Java me:

List.copyOf()

use karke unmodifiable copy create kar sakte hain.

Example:

this.skills = List.copyOf(skills);

Aur getter:

public List<String> getSkills() {

    return skills;
}

Because `List.copyOf()` unmodifiable list return karta hai.


# 14. Complete Immutable Class Example

import java.util.List;

public final class Employee {

    private final int id;

    private final String name;

    private final List<String> skills;


    public Employee(
            int id,
            String name,
            List<String> skills) {

        this.id = id;
        this.name = name;
        this.skills = List.copyOf(skills);
    }


    public int getId() {

        return id;
    }


    public String getName() {

        return name;
    }


    public List<String> getSkills() {

        return skills;
    }
}


Main:

List<String> skills =
        List.of("Java", "Spring Boot");

Employee employee =
        new Employee(
            101,
            "Jigar",
            skills
        );

System.out.println(employee.getName());
System.out.println(employee.getSkills());


# 15. Is Employee Object Immutable?

Yes, assuming the referenced field types themselves don't expose mutable state that can be changed externally.

Fields:

id
→ final

name
→ String is immutable

skills
→ unmodifiable copy

Class:
→ final

No setters.

So state cannot be changed after construction.


# 16. Immutable vs final

Ye dono same nahi hain.

`final`:

→ Variable ko reassign nahi kar sakte.


Immutable object:

→ Object ki state change nahi ho sakti.


Example:

final List<String> list =
        new ArrayList<>();

list.add("Java");

Ye allowed hai.

Why?

`list` reference final hai.

But List object mutable hai.

So:

final reference
≠
immutable object


# 17. Immutable Class vs String

String:

→ final class
→ private internal state
→ immutable
→ no setters
→ operations return new String objects


Example:

String s1 = "Java";

String s2 = s1.concat(" Spring");

System.out.println(s1);

Output:

Java

System.out.println(s2);

Output:

Java Spring

Original `s1` change nahi hua.


# 18. Advantages of Immutable Classes

Immutable classes ke major benefits:

1. Thread-safe sharing
2. Easy to reason about
3. No accidental state changes
4. Safe as HashMap/HashSet keys
5. Useful for caching
6. Better security in many contexts
7. Easier debugging


# 19. Immutable Objects and Thread Safety

Immutable objects ko multiple threads safely share karna easy hota hai because their state cannot change.

Example:

String message = "Hello";

Multiple threads isko read kar sakte hain without worrying about one thread modifying the String object.


# 20. Immutable Object as HashMap Key

Example:

Map<String, String> map =
        new HashMap<>();

map.put("employee101", "Jigar");


String immutable hai, isliye key ka hash-related state change nahi hota.

Agar mutable object ko key banaya aur uski equality/hash-related state change kar di, to HashMap lookup problems aa sakti hain.


# 21. Real-World Example

Suppose Employee ka:

employeeId
joiningDate
name

object creation ke baad change nahi hona chahiye.

Then immutable design useful hai.

Example:

public final class Employee {

    private final long employeeId;
    private final String name;

    public Employee(
            long employeeId,
            String name) {

        this.employeeId = employeeId;
        this.name = name;
    }

    public long getEmployeeId() {

        return employeeId;
    }

    public String getName() {

        return name;
    }
}


Ab Employee object ko safely share karna easy hai.


# 22. Interview-Ready Answer

Question:

"What is an immutable class and how do you create one?"

Answer:

"An immutable class is a class whose object state cannot be changed after creation. To design one, we typically make the class final, keep fields private and final, initialize them through the constructor, avoid setters, and use defensive copies for mutable fields such as List or Date."


# 23. Important Interview Questions

Q: What is immutable class?

A:

"An immutable class is a class whose object state cannot be changed after the object is created."


Q: How do you create immutable class?

A:

"Make the class final, fields private and final, initialize through constructor, don't provide setters, and use defensive copies for mutable fields."


Q: Is final object same as immutable object?

A:

"No. final prevents reference reassignment, while immutability means the object's state cannot change."


Q: Why is String immutable?

A:

"String's immutability provides benefits such as security, string pooling, thread-safe sharing and stable hashing."


Q: Why use defensive copy?

A:

"To prevent external code from modifying an internal mutable object."


Q: Can immutable class contain mutable fields?

A:

"Yes, but we need to protect those fields using defensive copies or immutable/unmodifiable representations."


Q: Why immutable objects are useful in multithreading?

A:

"Because their state cannot change, multiple threads can safely share them without synchronization for state mutation."


# 24. Easy Memory Trick

Immutable class:

FINAL CLASS
+
PRIVATE FIELDS
+
FINAL FIELDS
+
CONSTRUCTOR
+
NO SETTERS
+
DEFENSIVE COPY


Remember:

No one can change the object after creation.


# 25. Most Important Interview Points

1. Immutable object state cannot change after creation.
2. String is a famous immutable class.
3. Immutable class is commonly made final.
4. Fields should generally be private and final.
5. Initialize fields through constructor.
6. Avoid setters.
7. Mutable fields need defensive copies.
8. Getter should not expose internal mutable state directly.
9. final reference does not mean object is immutable.
10. Immutable objects are easy to share between threads.
11. Immutable objects are useful as HashMap keys.
12. Immutability makes code easier to reason about.


# QUICK REVISION

Immutable
= State cannot change after creation


How to create:

1. final class
2. private fields
3. final fields
4. Constructor initialization
5. No setters
6. Defensive copy for mutable fields


final:

Reference/value cannot be reassigned.

immutable:

Object state cannot change.


Example:

final class Employee {

    private final int id;
    private final String name;

    Employee(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


ONE-LINE INTERVIEW ANSWER:

"An immutable class is a class whose state cannot be modified after object creation; typically we achieve this using a final class, private final fields, constructor initialization, no setters, and defensive copies for mutable fields."