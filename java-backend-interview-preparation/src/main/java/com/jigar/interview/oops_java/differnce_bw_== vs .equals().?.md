# Java — == vs equals()

## 1. What is the difference between == and equals()?

Java me `==` aur `.equals()` dono comparison ke liye use hote hain, but **objects ke case me dono ka purpose different hai.**

Simple language:

```text
==        → Reference same hai ya nahi?
.equals() → Content/value same hai ya nahi?
```

---

# 2. `==` Operator

Primitive data types ke saath `==` **values compare** karta hai.

Example:

```java
int a = 10;
int b = 10;

System.out.println(a == b);
```

Output:

```text
true
```

Because:

```text
10 == 10
```

---

## 3. Objects ke saath `==`

Objects ke case me `==` check karta hai ki **dono references same object ko point kar rahe hain ya nahi.**

Example:

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
```

Output:

```text
false
```

Kyun?

Dono objects ka content same hai:

```text
"Java"
"Java"
```

Lekin dono **different objects** hain.

Conceptually:

```text
s1 ─────→ [Java]

s2 ─────→ [Java]
```

References different hain.

Therefore:

```text
s1 == s2
false
```

---

# 4. `.equals()` Method

`.equals()` generally objects ke **logical/content equality** ko compare karne ke liye use hota hai.

Example:

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1.equals(s2));
```

Output:

```text
true
```

Because both Strings ka content `"Java"` same hai.

```text
s1.equals(s2)
       ↓
"Java" == "Java"
       ↓
true
```

---

# 5. Important — String Example

Ye interview ka common example hai:

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
```

Output:

```text
true
true
```

### Why is `==` true?

Because String literals Java ke **String Pool** me stored hote hain.

Same literal `"Java"` ke liye JVM existing pooled String ko reuse kar sakti hai.

Conceptually:

```text
s1 ─────┐
        ↓
      [Java]  ← String Pool
        ↑
s2 ─────┘
```

Both references same pooled object ko point kar rahe hain.

---

# 6. `new String()` Example

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
```

Output:

```text
false
true
```

Reason:

```text
==        → Different object references
equals()  → Same content
```

---

# 7. Most Important Rule

### Primitive:

```text
== → Value comparison
```

Example:

```java
int a = 10;
int b = 10;

a == b; // true
```

### Objects:

```text
== → Reference comparison
.equals() → Logical/content comparison
```

Example:

```java
String a = new String("Java");
String b = new String("Java");

a == b;        // false
a.equals(b);   // true
```

---

# 8. Why Does String `.equals()` Work?

`String` class overrides the `equals()` method from `Object`.

That's why:

```java
s1.equals(s2);
```

String ke actual content ko compare karta hai.

Conceptually:

```text
Object
   ↓
equals()
   ↓
String overrides equals()
   ↓
Content comparison
```

---

# 9. What Happens If We Don't Override equals()?

This is very important for custom classes.

Suppose:

```java
class Employee {

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

Create objects:

```java
Employee e1 = new Employee(1, "Jigar");
Employee e2 = new Employee(1, "Jigar");

System.out.println(e1.equals(e2));
```

Without overriding `equals()`, result will generally be:

```text
false
```

Why?

Because `Object.equals()` by default behaves like reference equality.

So if we want logical equality based on `id` and `name`, we should override `equals()`.

---

# 10. Overriding equals()

Example:

```java
class Employee {

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Employee employee = (Employee) obj;

        return id == employee.id
                && name.equals(employee.name);
    }
}
```

Now:

```java
Employee e1 = new Employee(1, "Jigar");
Employee e2 = new Employee(1, "Jigar");

System.out.println(e1.equals(e2));
```

Output:

```text
true
```

Because we defined what equality means for `Employee`.

---

# 11. `equals()` and `hashCode()` Relationship

This is a **very important interview follow-up**.

If we override `equals()`, we should generally override `hashCode()` consistently.

Rule:

> **If two objects are equal according to `equals()`, they must return the same `hashCode()`.**

Example:

```java
@Override
public int hashCode() {
    return Objects.hash(id, name);
}
```

This is especially important when objects are used in:

```text
HashMap
HashSet
HashTable
```

---

# 12. Why is this important in HashMap/HashSet?

Suppose:

```java
Set<Employee> employees = new HashSet<>();
```

If two Employee objects logically represent the same employee, `equals()` and `hashCode()` help the collection determine whether they should be treated as duplicates.

Therefore:

```text
equals() + hashCode()
        ↓
HashMap / HashSet
```

This is why interviewers often ask:

> **"What is the contract between equals() and hashCode()?"**

---

# 13. Interview Trap — Can we use `==` for String comparison?

Technically yes, Java allows it.

But **you should not use `==` to compare String content.**

❌:

```java
if (name == "Jigar") {
}
```

✅:

```java
if ("Jigar".equals(name)) {
}
```

Why is this safer?

If `name` is `null`:

```java
"Jigar".equals(name)
```

simply returns `false`.

But:

```java
name.equals("Jigar")
```

would throw `NullPointerException` if `name == null`.

---

# 14. Interview-Ready Answer

If interviewer asks:

### "What is the difference between == and equals()?"

Say:

> **“For primitive types, `==` compares values. For objects, `==` compares references, meaning whether both references point to the same object. The `equals()` method is used for logical equality and its behavior depends on how the class implements or overrides it. For example, String overrides equals() to compare content.”**

---

# 15. Quick Comparison Table

| Feature            | `==`                   | `.equals()`                                      |
| ------------------ | ---------------------- | ------------------------------------------------ |
| Type               | Operator               | Method                                           |
| Primitive          | Compares value         | Not applicable to primitives                     |
| Objects            | Compares references    | Compares logical/content equality if implemented |
| String             | Reference comparison   | Content comparison                               |
| Can be overridden? | No                     | Yes                                              |
| Defined by         | Java language/operator | `Object` class method                            |

---

# 16. Easy Memory Trick

```text
Primitive:
== → Value

Object:
== → Reference
equals() → Content/Logical equality
```

### One-line shortcut:

> **`==` asks: “Are you the same object?”**

> **`equals()` asks: “Do you represent the same value?”**

---

# 17. Most Important Interview Points

1. `==` is an operator.
2. `equals()` is a method defined in `Object`.
3. For primitives, `==` compares values.
4. For objects, `==` compares references.
5. `equals()` can be overridden.
6. String overrides `equals()` to compare content.
7. If you override `equals()`, maintain the `hashCode()` contract.
8. `HashMap` and `HashSet` depend on `equals()` and `hashCode()` for logical equality.
9. Don't use `==` for String content comparison.
10. `"Jigar".equals(name)` is safer when `name` can be null.
