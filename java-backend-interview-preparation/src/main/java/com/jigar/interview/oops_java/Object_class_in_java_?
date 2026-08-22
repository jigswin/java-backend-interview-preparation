# Q16 — Object Class in Java

## 1. Object class kya hoti hai?

Java me `Object` sabhi classes ki root/base class hai.

Simple language:

> Java ki har class directly ya indirectly `Object` class se inherit hoti hai.

Example:

class Employee {
}

Ye internally conceptually:

class Employee extends Object {
}

ke equivalent inheritance relationship rakhti hai.


# 2. Object class kyu important hai?

`Object` class kuch common methods provide karti hai jo Java ke objects ke saath use kiye ja sakte hain.

Most important methods:

1. toString()
2. equals()
3. hashCode()
4. getClass()
5. clone()
6. wait()
7. notify()
8. notifyAll()


Interview ke liye sabse important:

`toString()`
`equals()`
`hashCode()`


# 3. toString()

`toString()` object ka string representation return karta hai.

Example:

class Employee {

    int id;
    String name;
}

Employee employee = new Employee();

employee.id = 101;
employee.name = "Jigar";

System.out.println(employee);

By default output meaningful nahi hota.

Isliye hum `toString()` override kar sakte hain.


# 4. toString() Override

Example:

class Employee {

    int id;
    String name;

    @Override
    public String toString() {

        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

Main:

Employee employee = new Employee();

employee.id = 101;
employee.name = "Jigar";

System.out.println(employee);

Output:

Employee{id=101, name='Jigar'}


# 5. Why toString() is useful?

Debugging aur logging ke time object ki meaningful information dekhne ke liye.

Example:

System.out.println(employee);

Java internally effectively:

System.out.println(employee.toString());

call karta hai.


# 6. equals()

`equals()` ka use objects ko logically compare karne ke liye hota hai.

Example:

String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1.equals(s2));

Output:

true


Because String ne `equals()` override karke content comparison implement kiya hai.


# 7. == vs equals()

Ye bahut important interview question hai.

`==`

→ Primitive values compare karta hai.

Objects ke case me:

→ References compare karta hai.


`equals()`

→ Logical/content equality compare karne ke liye use hota hai, depending on the class's implementation.


Example:

String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);

Output:

false

Because dono different objects hain.


System.out.println(s1.equals(s2));

Output:

true

Because String content same hai.


# 8. Custom Class me equals()

Agar hum apni class banate hain aur logical equality chahte hain, to generally `equals()` override karte hain.

Example:

class Employee {

    int id;
    String name;

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Employee employee = (Employee) obj;

        return id == employee.id &&
               java.util.Objects.equals(name, employee.name);
    }
}

Ab logically same data wale Employee objects ko equal treat kar sakte hain.


# 9. hashCode()

`hashCode()` object ka hash value return karta hai.

Hash-based collections me ye important hai.

Main examples:

HashMap
HashSet
Hashtable


Example:

Employee employee = new Employee();

System.out.println(employee.hashCode());


# 10. equals() aur hashCode() ka relationship

Ye interview ka VERY IMPORTANT question hai.

Rule:

> Agar two objects `equals()` ke according equal hain, to unka `hashCode()` same hona MUST hai.

Example:

Employee e1 = new Employee(101, "Jigar");
Employee e2 = new Employee(101, "Jigar");

Agar:

e1.equals(e2)

true hai,

to:

e1.hashCode() == e2.hashCode()

bhi true hona chahiye.


# 11. Reverse Rule

Agar two objects ka hashCode same hai:

e1.hashCode() == e2.hashCode()

to ye zaroori nahi hai ki:

e1.equals(e2)

true ho.

Because hash collision possible hai.


Important:

equals true
→ hashCode MUST be same

hashCode same
→ equals MAY be false


# 12. Why override equals() and hashCode() together?

Agar `equals()` override karte ho aur `hashCode()` properly override nahi karte, to hash-based collections unexpected behavior de sakti hain.

Example:

HashSet<Employee>

HashSet duplicate objects ko detect karne ke liye equality/hash semantics use karta hai.

Isliye:

equals()
+
hashCode()

consistent hone chahiye.


# 13. Real-World Example

class Employee {

    private int id;
    private String name;

    public Employee(int id, String name) {
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

        return id == employee.id &&
               java.util.Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {

        return java.util.Objects.hash(id, name);
    }

    @Override
    public String toString() {

        return "Employee{id=" + id +
               ", name='" + name + "'}";
    }
}


# 14. getClass()

`getClass()` object ki runtime class information return karta hai.

Example:

Employee employee = new Employee();

System.out.println(employee.getClass());

Output conceptually:

class Employee


Commonly reflection/type checks me useful hota hai.


# 15. clone()

`clone()` historically object ki copy create karne ke liye use hota hai.

Object class me:

protected Object clone()

method available hai.

A class ko cloning properly support karne ke liye usually `Cloneable` implement karna padta hai.

Example:

class Employee implements Cloneable {

    int id;

    @Override
    public Employee clone() throws CloneNotSupportedException {

        return (Employee) super.clone();
    }
}


Important:

Modern Java code me cloning ko blindly use karne ke bajay copy constructor ya factory approach often clearer hoti hai, especially for complex objects.


# 16. wait()

`wait()` thread ko wait state me jaane ke liye use hota hai.

Ye thread synchronization / inter-thread communication ka part hai.

Example concept:

synchronized (object) {

    object.wait();
}


Important:

`wait()` Object class ka method hai.


# 17. notify()

`notify()` waiting threads me se ek ko notify karta hai.

Example concept:

synchronized (object) {

    object.notify();
}


# 18. notifyAll()

`notifyAll()` currently waiting threads ko notify karta hai.

Example concept:

synchronized (object) {

    object.notifyAll();
}


# 19. wait(), notify(), notifyAll() kahan defined hain?

Ye methods:

`Object` class me defined hain.

Reason:

Every Java object can participate in monitor-based synchronization.


# 20. Object Class ke Important Methods

Object class me commonly discussed methods:

toString()
→ String representation

equals()
→ Logical equality

hashCode()
→ Hash value

getClass()
→ Runtime class information

clone()
→ Object cloning support

wait()
→ Current thread ko wait karata hai

notify()
→ One waiting thread ko notify karta hai

notifyAll()
→ Waiting threads ko notify karta hai


# 21. Important Interview Question

Q: What is Object class?

A:

"Object is the root class of the Java class hierarchy. Every class directly or indirectly inherits from Object and therefore gets common methods such as equals(), hashCode(), toString(), getClass(), wait(), notify() and notifyAll()."


Q: Difference between == and equals()?

A:

"For primitives, == compares values. For objects, == compares references, while equals() is used for logical equality according to the class implementation."


Q: Why override equals() and hashCode() together?

A:

"Because the equals-hashCode contract requires equal objects to have the same hash code, which is important for hash-based collections such as HashMap and HashSet."


Q: If two objects have same hashCode, are they equal?

A:

"No. Same hash code does not guarantee equality because hash collisions can occur."


Q: If two objects are equal, should their hashCode be same?

A:

"Yes. If equals() returns true, their hash codes must be the same."


Q: What does toString() do?

A:

"It returns a string representation of the object and is commonly used for logging and debugging."


# 22. Real Interview Example — HashSet

Suppose:

Employee e1 = new Employee(101, "Jigar");
Employee e2 = new Employee(101, "Jigar");

Set<Employee> employees = new HashSet<>();

employees.add(e1);
employees.add(e2);

If equals() and hashCode() are properly implemented:

employees.size()

will be:

1

because e1 and e2 are logically equal.


Without proper equality/hash implementation:

The HashSet may treat them as different objects.


# 23. Easy Memory Trick

Object class:

toString()
→ Object ko String me represent karo

equals()
→ Objects logically equal hain?

hashCode()
→ Hash-based collections ke liye hash

getClass()
→ Object ki class kya hai?

wait()
→ Wait

notify()
→ One waiting thread ko notify

notifyAll()
→ All waiting threads ko notify


# 24. Most Important Interview Points

1. Object is the root class of Java's class hierarchy.
2. Every class directly or indirectly inherits from Object.
3. toString() gives string representation.
4. equals() is used for logical equality.
5. == compares references for objects.
6. hashCode() is important for HashMap and HashSet.
7. Equal objects must have the same hash code.
8. Same hash code does not guarantee equality.
9. equals() and hashCode() should be consistent.
10. getClass() returns runtime class information.
11. wait(), notify() and notifyAll() are Object methods used in synchronization.
12. clone() provides cloning support, though alternatives are often preferred in modern code.


# QUICK REVISION

Object
= Root class of Java


Important methods:

toString()
= String representation

equals()
= Logical equality

hashCode()
= Hash-based collections

getClass()
= Runtime class

wait()
= Wait

notify()
= Notify one waiting thread

notifyAll()
= Notify waiting threads


MOST IMPORTANT:

==
→ Object reference comparison

equals()
→ Logical equality


equals() == true
→ hashCode() MUST be same

hashCode() same
→ equals() MAY be false


ONE-LINE INTERVIEW ANSWER:

"Object is the root class of Java, and it provides common methods such as toString(), equals(), hashCode(), getClass(), wait(), notify() and notifyAll() that are available to Java objects."