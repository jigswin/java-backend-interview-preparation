========================================================
                HASHMAP - JAVA NOTES
========================================================


1. WHAT IS HASHMAP?
--------------------------------------------------------

HashMap is a Java Collection used to store data in
KEY-VALUE pairs.

Example:

Map<String, Integer> map = new HashMap<>();


Concept:

Key        Value
----------------
Apple   ->   3
Banana  ->   2
Mango   ->   1


PHP comparison:

PHP Associative Array
        ↓
Java HashMap


Example PHP:

$fruit = [
    "Apple" => 3,
    "Banana" => 2
];


Java:

Map<String, Integer> fruit = new HashMap<>();

fruit.put("Apple", 3);
fruit.put("Banana", 2);



2. HASHMAP DECLARATION
--------------------------------------------------------

Preferred:

Map<String, Integer> map = new HashMap<>();


Why Map instead of HashMap on left side?

Because Map is an interface and HashMap is an implementation.

Map
 |
 +-- HashMap
 +-- LinkedHashMap
 +-- TreeMap


This is called Programming to an Interface.



3. KEY AND VALUE
--------------------------------------------------------

HashMap<KeyType, ValueType>


Example:

HashMap<String, Integer>

String  = Key
Integer = Value


Example:

map.put("Apple", 10);


Apple = Key
10    = Value



4. IMPORTANT RULES
--------------------------------------------------------

KEY:

- Keys must be unique.
- Duplicate key is not stored separately.
- If same key is inserted again, old value is replaced.


Example:

map.put("Apple", 10);
map.put("Apple", 20);


Result:

Apple -> 20


VALUE:

- Values can be duplicated.


Example:

map.put("Apple", 10);
map.put("Banana", 10);
map.put("Mango", 10);


This is valid.



5. IMPORTANT HASHMAP METHODS
--------------------------------------------------------

put(key, value)

Adds or updates a key-value pair.

map.put("Apple", 10);


--------------------------------------------------------

get(key)

Returns value for the given key.

map.get("Apple");

Output:

10


If key does not exist:

map.get("Orange");

Output:

null


--------------------------------------------------------

getOrDefault(key, defaultValue)

Returns existing value if key exists,
otherwise returns default value.

map.getOrDefault("Apple", 0);


If Apple exists:

Apple -> 3

Result = 3


If Apple does not exist:

Result = 0


VERY IMPORTANT FOR FREQUENCY QUESTIONS.


--------------------------------------------------------

containsKey(key)

Checks whether a key exists.

map.containsKey("Apple");

true / false


--------------------------------------------------------

containsValue(value)

Checks whether a value exists.

map.containsValue(10);

true / false


--------------------------------------------------------

remove(key)

Removes key-value pair.

map.remove("Apple");


--------------------------------------------------------

size()

Returns number of key-value pairs.

map.size();


--------------------------------------------------------

isEmpty()

Checks whether HashMap is empty.

map.isEmpty();


--------------------------------------------------------

clear()

Removes all entries.

map.clear();


--------------------------------------------------------

putIfAbsent(key, value)

Adds value only if key does not already exist.

map.putIfAbsent("Apple", 10);


--------------------------------------------------------

replace(key, value)

Replaces existing value.

map.replace("Apple", 20);



6. ITERATING HASHMAP
--------------------------------------------------------

A) keySet()

Used when only keys are required.

for (String key : map.keySet()) {
    System.out.println(key);
}


--------------------------------------------------------

B) values()

Used when only values are required.

for (Integer value : map.values()) {
    System.out.println(value);
}


--------------------------------------------------------

C) entrySet()

Used when both key and value are required.

for (Map.Entry<String, Integer> entry : map.entrySet()) {

    System.out.println(
        entry.getKey() + " -> " + entry.getValue()
    );
}


This is the most common approach when printing
both key and value.



7. HASHMAP FREQUENCY PATTERN
--------------------------------------------------------

This is VERY IMPORTANT for interviews.

Example:

String:

"banana"


Logic:

Map<Character, Integer> frequency = new HashMap<>();

for (char ch : str.toCharArray()) {

    frequency.put(
        ch,
        frequency.getOrDefault(ch, 0) + 1
    );
}


Mental logic:

Character found
      ↓
Already exists?
      ↓
YES → old count + 1
NO  → 0 + 1
      ↓
Store in HashMap



8. FRUIT FREQUENCY EXAMPLE
--------------------------------------------------------

Input:

Apple
Banana
Apple
Mango
Banana
Apple


HashMap:

Apple  -> 3
Banana -> 2
Mango  -> 1


Code:

Map<String, Integer> frequency = new HashMap<>();

for (String fruit : fruits) {

    frequency.put(
        fruit,
        frequency.getOrDefault(fruit, 0) + 1
    );
}


This pattern should be remembered conceptually,
not by memorizing the code.



9. INTERNAL WORKING OF HASHMAP
--------------------------------------------------------

When we execute:

map.put("Jigar", 100);


Conceptually:

"Jigar"
   ↓
hashCode()
   ↓
hash calculation
   ↓
bucket/index
   ↓
store key + value


When we execute:

map.get("Jigar");


Conceptually:

"Jigar"
   ↓
hashCode()
   ↓
find bucket
   ↓
equals()
   ↓
find matching key
   ↓
return value



10. hashCode() AND equals()
--------------------------------------------------------

Very important interview topic.

HashMap uses:

hashCode()
    ↓
to locate bucket

equals()
    ↓
to check actual key equality


General rule:

If two objects are equal according to equals(),
they MUST have the same hashCode().


Important:

If we override equals(), we should generally
override hashCode() as well.



11. HASH COLLISION
--------------------------------------------------------

Collision occurs when different keys end up in
the same bucket.

Concept:

Key A ──┐
        ├──> Same Bucket
Key B ──┘


HashMap handles collisions internally.

For interview:

"Collision occurs when multiple keys map to
the same bucket."



12. NULL IN HASHMAP
--------------------------------------------------------

HashMap allows:

- One null key
- Multiple null values


Example:

map.put(null, 100);

map.put("Apple", null);
map.put("Banana", null);


Valid.



13. ORDERING
--------------------------------------------------------

HashMap does NOT guarantee insertion order.


Example:

map.put("Apple", 1);
map.put("Banana", 2);
map.put("Mango", 3);


Output order should NOT be assumed.


If insertion order is required:

LinkedHashMap


If sorted keys are required:

TreeMap



14. HASHMAP VS LINKEDHASHMAP VS TREEMAP
--------------------------------------------------------

HashMap:

- Fast lookup
- No guaranteed insertion order


LinkedHashMap:

- Maintains insertion order


TreeMap:

- Maintains sorted key order



15. HASHMAP VS HASHSET
--------------------------------------------------------

HashMap:

Key -> Value


HashSet:

Only unique elements


Example HashMap:

Apple  -> 3
Banana -> 2


Example HashSet:

Apple
Banana
Mango


PHP comparison:

Associative Array
      ↓
HashMap


Unique values
      ↓
HashSet



16. HASHMAP VS ARRAYLIST
--------------------------------------------------------

ArrayList:

Index based.

Example:

0 -> Apple
1 -> Banana
2 -> Mango


HashMap:

Key based.

Apple -> 3
Banana -> 2


PHP comparison:

PHP Indexed Array
      ↓
ArrayList


PHP Associative Array
      ↓
HashMap



17. TIME COMPLEXITY
--------------------------------------------------------

Average:

put()          -> O(1)
get()          -> O(1)
remove()       -> O(1)
containsKey()  -> O(1)


Frequency problem:

n elements
↓
O(n) time


Space:

O(n) in worst case because HashMap may store
n unique elements.



18. COMMON INTERVIEW QUESTIONS
--------------------------------------------------------

1. What is HashMap?

2. How does HashMap work internally?

3. What is hashing?

4. What is hash collision?

5. What is the relationship between equals()
   and hashCode()?

6. Can HashMap contain null?

7. Can HashMap contain duplicate keys?

8. Can HashMap contain duplicate values?

9. HashMap vs HashSet?

10. HashMap vs Hashtable?

11. HashMap vs LinkedHashMap?

12. HashMap vs TreeMap?

13. How do you iterate over HashMap?

14. What is getOrDefault()?

15. Why is HashMap generally O(1) for get()?

16. How to find frequency using HashMap?

17. How to find duplicate elements?

18. How to find first non-repeating element?

19. How to find most frequent element?

20. Why should equals() and hashCode() be
    overridden together?



19. COMMON HASHMAP CODING QUESTIONS
--------------------------------------------------------

1. Character frequency

2. Word frequency

3. Fruit frequency

4. Find duplicate elements

5. Find unique elements

6. First non-repeating character

7. First repeating character

8. Most frequent character

9. Two Sum

10. Anagram using HashMap

11. Group anagrams

12. Count occurrence of words

13. Find duplicate numbers

14. Find intersection of two arrays

15. Find common elements using HashMap



20. GOLDEN INTERVIEW PATTERN
--------------------------------------------------------

Whenever you see:

"Count frequency"
        ↓
Think HashMap


"Find duplicates"
        ↓
Think HashSet / HashMap


"Find unique"
        ↓
Think HashSet


"Key -> Value"
        ↓
Think HashMap


"Maintain insertion order"
        ↓
Think LinkedHashMap / LinkedHashSet


"Sorted data"
        ↓
Think TreeMap / TreeSet



21. MOST IMPORTANT CODE PATTERN
--------------------------------------------------------

Frequency:

map.put(
    key,
    map.getOrDefault(key, 0) + 1
);


Remember the CONCEPT:

Existing key
    ↓
old count + 1

New key
    ↓
0 + 1



========================================================
                    END OF NOTES
========================================================