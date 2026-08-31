# Q5 — String vs StringBuilder vs StringBuffer

## 1. What is String?

String Java me immutable hoti hai.

Immutable ka matlab:
Ek baar String object create hone ke baad uske existing content ko change nahi kar sakte.

Example:

String name = "Jigar";

name = name + " Nagar";

System.out.println(name);

Output:
Jigar Nagar

Important:
Yahan original "Jigar" String modify nahi hui. Ek new String object create hua.

Conceptually:

"Jigar" → "Jigar Nagar"
          ↑
       New object


## 2. String immutable kyu hai?

String ko immutable rakhne ke important reasons:

1. Security
2. String Pool optimization
3. Thread safety
4. Hashing
5. Performance/caching benefits

Example:
String username = "jigar";

Agar String mutable hoti, to same String object ko refer karne wale multiple references ka value unexpectedly change ho sakta tha.


## 3. String Concatenation Problem

Agar hum repeatedly String modify karte hain:

String result = "";

for (int i = 0; i < 5; i++) {
    result = result + i;
}

System.out.println(result);

Output:
01234

Har concatenation ke time new String objects create ho sakte hain.

Agar large loop ho, to unnecessary objects create hone ki wajah se performance impact ho sakta hai.

Aise cases me StringBuilder better option hota hai.


## 4. What is StringBuilder?

StringBuilder ek mutable sequence of characters hai.

Mutable ka matlab:
Same object ke content ko modify kar sakte hain.

Example:

StringBuilder sb = new StringBuilder("Hello");

sb.append(" Jigar");

System.out.println(sb);

Output:
Hello Jigar

StringBuilder existing object ko modify karta hai.


## 5. StringBuilder kab use karte hain?

StringBuilder use karo jab:

1. String ko repeatedly modify karna ho.
2. Loop me concatenation karna ho.
3. Performance important ho.
4. Multiple threads se same object access karne ki requirement na ho.

Example:

StringBuilder result = new StringBuilder();

for (int i = 1; i <= 5; i++) {
    result.append(i);
}

System.out.println(result);

Output:
12345


## 6. What is StringBuffer?

StringBuffer bhi mutable hota hai.

Example:

StringBuffer sb = new StringBuffer("Hello");

sb.append(" Jigar");

System.out.println(sb);

Output:
Hello Jigar

StringBuffer ka main difference hai:

StringBuffer methods are synchronized.

Isliye synchronized mutable string operations ke liye useful hai.


## 7. StringBuilder vs StringBuffer

StringBuilder:
- Mutable
- Not synchronized
- Generally faster
- Single-threaded context me commonly use hota hai

StringBuffer:
- Mutable
- Synchronized
- Generally slower than StringBuilder
- Jab synchronized mutable string operations required ho tab useful


## 8. String vs StringBuilder vs StringBuffer

String:
- Immutable
- Modification ke time new String object create ho sakta hai
- Fixed/unchanging text ke liye useful

StringBuilder:
- Mutable
- Not synchronized
- Generally faster
- Frequent string modification ke liye useful

StringBuffer:
- Mutable
- Synchronized
- Generally slower than StringBuilder
- Synchronized mutable operations ke liye useful


## 9. String Pool

String literals generally String Pool me maintain/reuse hote hain.

Example:

String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);

Output:
true

Reason:
Dono references same pooled String object ko point kar sakte hain.

Conceptually:

s1 ─────┐
        ↓
      "Java"
        ↑
s2 ─────┘


## 10. new String() ke saath kya hota hai?

String s1 = "Java";
String s2 = new String("Java");

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));

Output:
false
true

Reason:

==        → Reference compare karta hai
.equals() → Content compare karta hai


## 11. String Immutable hone ka example

String s = "Hello";

s.concat(" World");

System.out.println(s);

Output:
Hello

Reason:
concat() original String ko modify nahi karta.
It returns a new String.

Correct approach:

String s = "Hello";

s = s.concat(" World");

System.out.println(s);

Output:
Hello World


## 12. Important StringBuilder Methods

### append()

StringBuilder sb = new StringBuilder("Hello");

sb.append(" World");

System.out.println(sb);

Output:
Hello World


### insert()

StringBuilder sb = new StringBuilder("Hello");

sb.insert(5, " Java");

System.out.println(sb);

Output:
Hello Java


### delete()

StringBuilder sb = new StringBuilder("Hello World");

sb.delete(5, 11);

System.out.println(sb);

Output:
Hello


### reverse()

StringBuilder sb = new StringBuilder("Java");

sb.reverse();

System.out.println(sb);

Output:
avaJ


## 13. Interview Question — Which one is faster?

StringBuilder generally StringBuffer se faster hota hai.

Reason:

StringBuilder → Not synchronized
StringBuffer  → Synchronized

Synchronization ke additional overhead ki wajah se StringBuffer generally slower hota hai.


## 14. Interview Question — StringBuilder kab use karoge?

Answer:

Agar mujhe frequently String modify karni ho aur synchronization ki requirement nahi hai, to main StringBuilder use karunga because it is mutable and generally faster.


## 15. Interview Question — StringBuffer kab use karoge?

Answer:

Agar mujhe mutable String object par synchronized operations chahiye, especially shared multi-threaded context me, to StringBuffer consider karunga.


## 16. Interview Question — String thread-safe hai?

String immutable hai.

Because String ka state creation ke baad change nahi hota, same String object ko multiple threads safely share kiya ja sakta hai without modifying its state.


## 17. Interview-Ready Answer

Question:
"What is the difference between String, StringBuilder and StringBuffer?"

Answer:

"String is immutable, so once a String object is created, its content cannot be changed. If we perform modifications, a new String may be created.

StringBuilder and StringBuffer are mutable, so they can modify the same object.

StringBuilder is generally faster because it is not synchronized, while StringBuffer is synchronized.

For frequent String modifications in a normal single-threaded context, I would generally prefer StringBuilder."


## 18. Easy Memory Trick

String
→ Immutable

StringBuilder
→ Mutable + Fast + Not synchronized

StringBuffer
→ Mutable + Synchronized


## 19. Most Important Interview Points

1. String is immutable.
2. StringBuilder is mutable.
3. StringBuffer is mutable.
4. StringBuilder is not synchronized.
5. StringBuffer is synchronized.
6. StringBuilder is generally faster than StringBuffer.
7. Use StringBuilder for frequent modifications when synchronization is not required.
8. Use StringBuffer when synchronized mutable operations are required.
9. String literals are generally stored/reused through the String Pool.
10. == compares references for objects.
11. equals() compares logical/content equality when properly implemented.
12. String methods like concat() return a new String instead of modifying the existing String.
13. StringBuilder and StringBuffer provide methods like append(), insert(), delete(), and reverse().


## 20. Quick Interview Revision

Q: String immutable kyu hai?
A: Security, String Pool, thread-safety and hashing-related benefits.

Q: StringBuilder mutable hai?
A: Yes.

Q: StringBuffer mutable hai?
A: Yes.

Q: StringBuilder vs StringBuffer?
A: StringBuilder is not synchronized and generally faster; StringBuffer is synchronized.

Q: StringBuilder kab use karoge?
A: Frequent String modifications, especially when synchronization is not required.

Q: StringBuffer kab use karoge?
A: Frequent String modifications where synchronized access to the buffer is required.


### MEMORY TRICK

String = Immutable

StringBuilder = Mutable + Fast

StringBuffer = Mutable + Synchronized