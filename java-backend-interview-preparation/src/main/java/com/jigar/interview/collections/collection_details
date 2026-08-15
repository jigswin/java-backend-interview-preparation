JAVA COLLECTIONS — COMPLETE INTERVIEW NOTES
PHP Developer → Java Developer Reference

1. BIG PICTURE
Java Collections Framework helps store and manipulate groups of objects.

Main hierarchy:
Collection
├── List → ArrayList, LinkedList
├── Set → HashSet, LinkedHashSet, TreeSet
└── Queue → LinkedList, PriorityQueue, Deque/ArrayDeque

Map is separate from Collection:
Map → HashMap, LinkedHashMap, TreeMap

PHP mental mapping:
Indexed PHP array → ArrayList
Associative PHP array → HashMap
Unique values → HashSet
Nested arrays → List<Map>, Map<List>, List<List>, etc.

2. ARRAY VS COLLECTION
Array:
int[] numbers = {10,20,30};
Fixed size.

Collection:
List<Integer> numbers = new ArrayList<>();
Dynamic size.

Use arrays for fixed/simple indexed data; collections when you need dynamic
size, searching, adding/removing, uniqueness, mapping, sorting, queues, etc.

3. LIST
List is ordered, allows duplicates, and supports index access.

Example:
List<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Apple");

Important methods:
add(), get(), set(), remove(), contains(), indexOf(), size(),
isEmpty(), clear()

PHP analogy: indexed array.

4. ARRAYLIST
ArrayList is a resizable-array implementation of List.

Strength:
- Fast random/index access: get(index) typically O(1)
- Good default choice for normal lists

Weakness:
- Middle insert/remove can require shifting elements

Use for normal dynamic lists and read-heavy operations.

5. LINKEDLIST
LinkedList stores linked nodes conceptually:
Node <-> Node <-> Node

Good for operations at ends and also implements Queue/Deque.
Random index access is slower than ArrayList.

Rule:
Normal List → usually ArrayList
Queue/deque/end operations → consider ArrayDeque or LinkedList

6. ARRAYLIST VS LINKEDLIST
ArrayList:
Resizable array, fast get(index), middle insert/remove costly.

LinkedList:
Linked nodes, slower random access, useful for queue/deque behavior.

7. ARRAYS.ASLIST()
Arrays.asList("A","B","C") returns a fixed-size list backed by an array.

set() is allowed:
list.set(0,"X");

add()/remove() are not allowed and can throw
UnsupportedOperationException.

For a dynamic copy:
new ArrayList<>(Arrays.asList("A","B","C"));

8. SET
Set stores unique elements and has no index-based get().

Example:
Set<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Apple");
fruits.add("Banana");

Only one Apple remains.

PHP analogy: think array_unique() conceptually, but Set is designed for uniqueness.

9. HASHSET
HashSet:
- Unique values
- No guaranteed insertion order
- Average O(1) add/contains/remove
- Allows one null element

Common methods:
add(), remove(), contains(), size(), isEmpty(), clear()

Interview uses:
remove duplicates, detect duplicates, membership checks.

10. LINKEDHASHSET
Unique values + insertion order.

Example:
LinkedHashSet<Integer> set = new LinkedHashSet<>();
set.add(5); set.add(2); set.add(5); set.add(1);

Iteration: 5, 2, 1

Use when removing duplicates while preserving original order.

11. TREESET
TreeSet:
- Unique values
- Sorted order
- Basic operations typically O(log n)

Example:
TreeSet<Integer> set = new TreeSet<>();
set.add(50); set.add(10); set.add(30); set.add(10);

Result: 10, 30, 50

Use for unique + sorted values.

12. HASHSET VS LINKEDHASHSET VS TREESET
HashSet → unique, no guaranteed insertion order
LinkedHashSet → unique + insertion order
TreeSet → unique + sorted

13. MAP
Map stores KEY → VALUE pairs.
Map is separate from the Collection hierarchy.

Example:
Map<Integer,String> employees = new HashMap<>();
employees.put(101,"Jigar");
employees.put(102,"Rahul");

PHP analogy: associative array.

Rules:
- Keys are unique
- Values may duplicate
- One key has one current value

14. HASHMAP
HashMap is the most important Map for interviews.

Example:
Map<String,Integer> frequency = new HashMap<>();
frequency.put("Apple",3);
frequency.put("Banana",2);

Duplicate key replaces the old value:
frequency.put("Apple",5); // Apple -> 5

Important:
- No guaranteed insertion order
- One null key
- Multiple null values
- Average O(1) get/put/remove under normal conditions
- Not synchronized

15. HASHMAP METHODS
put(key,value) → add/update
get(key) → return value or null
getOrDefault(key,default) → existing value or default
containsKey(key) → key exists?
containsValue(value) → value exists?
remove(key) → remove entry
size() → number of entries
isEmpty() → empty?
clear() → remove all
putIfAbsent(key,value) → add only if absent
replace(key,value) → replace existing value
keySet() → all keys
values() → all values
entrySet() → key-value entries

16. HASHMAP ITERATION
Keys:
for (String key : map.keySet()) { }

Values:
for (Integer value : map.values()) { }

Key + value:
for (Map.Entry<String,Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey()+" -> "+entry.getValue());
}

Use entrySet() when both key and value are required.

17. FREQUENCY PATTERN
For:
[Apple, Banana, Apple, Mango, Banana, Apple]

Use:
Map<String,Integer> frequency = new HashMap<>();

for (String fruit : fruits) {
    frequency.put(fruit, frequency.getOrDefault(fruit,0) + 1);
}

Result:
Apple -> 3
Banana -> 2
Mango -> 1

Mental model:
Existing key → old count + 1
New key → 0 + 1

18. HASHMAP INTERNAL WORKING
Conceptually:
put("Jigar",100)
"Jigar" → hashCode() → hash/bucket → store key/value

get("Jigar")
"Jigar" → hashCode() → find bucket → equals() → return value

Important terms:
hashing, bucket, collision, hashCode(), equals()

19. HASH COLLISION
Collision means different keys map to the same bucket.
HashMap handles collisions internally. Modern Java can use tree-based
handling for heavily collided buckets under certain conditions.

20. EQUALS AND HASHCODE
Contract:
If a.equals(b) is true, a.hashCode() must equal b.hashCode().

For custom objects used as HashMap keys or HashSet elements, equals()
and hashCode() must be consistent.

Why?
hashCode() helps locate a bucket; equals() verifies actual equality.

21. LINKEDHASHMAP
Map + insertion order.

Example:
Map<String,Integer> map = new LinkedHashMap<>();
map.put("Apple",3);
map.put("Banana",2);
map.put("Mango",1);

Iteration follows insertion order.

22. TREEMAP
Map + sorted keys.

Example:
Map<String,Integer> map = new TreeMap<>();
map.put("Mango",1);
map.put("Apple",3);
map.put("Banana",2);

Iteration:
Apple -> 3
Banana -> 2
Mango -> 1

Basic operations typically O(log n).

23. HASHMAP VS LINKEDHASHMAP VS TREEMAP
HashMap → key/value, no guaranteed insertion order, average O(1)
LinkedHashMap → key/value + insertion order, average O(1)
TreeMap → key/value + sorted keys, O(log n)

24. QUEUE
Queue = FIFO (First In, First Out).

Queue<String> queue = new LinkedList<>();
queue.offer("Jigar");
queue.offer("Rahul");
queue.offer("Amit");

queue.poll(); // Jigar
queue.peek(); // Rahul

Important:
offer() → add
poll() → remove and return front
peek() → inspect front

25. QUEUE METHOD PAIRS
add() vs offer()
remove() vs poll()
element() vs peek()

The latter methods generally return a special value such as null/false
instead of throwing when the operation cannot be performed.

26. DEQUE
Deque = Double Ended Queue.
Add/remove from both ends.

Deque<String> deque = new ArrayDeque<>();
addFirst(), addLast()
removeFirst(), removeLast()
peekFirst(), peekLast()

27. STACK
Stack = LIFO (Last In, First Out).

Modern Java approach: use Deque/ArrayDeque for stack behavior.

Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.push(20);
stack.push(30);

stack.pop();  // 30
stack.peek(); // 20

PHP analogy: array_push()/array_pop() mental model.

28. PRIORITYQUEUE
PriorityQueue removes elements according to priority.

By default:
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(30); pq.offer(10); pq.offer(20);
pq.poll(); // 10

Useful for top-K, scheduling, smallest/largest element problems.

For max-heap behavior:
new PriorityQueue<>(Collections.reverseOrder());

29. COLLECTIONS UTILITY CLASS
java.util.Collections provides utilities:
Collections.sort(list)
Collections.reverse(list)
Collections.shuffle(list)
Collections.max(list)
Collections.min(list)
Collections.frequency(list,value)
Collections.binarySearch(sortedList,value)

30. COMPARABLE VS COMPARATOR
Comparable → natural/default ordering inside the class.
Comparator → custom ordering outside the class.

Memory:
Comparable = default comparison
Comparator = custom comparison

31. ITERATION
Enhanced for:
for (String x : list) { }

Iterator:
Iterator<String> it = list.iterator();
while (it.hasNext()) { }

ListIterator supports forward/backward traversal for Lists.

Maps are commonly traversed using keySet(), values(), entrySet().

32. FAIL-FAST / CONCURRENTMODIFICATIONEXCEPTION
Do not structurally modify a collection during enhanced iteration.

Bad:
for (String x : list) {
    if (...) list.remove(x);
}

May cause ConcurrentModificationException.

Use Iterator.remove() where appropriate or collect items for later removal.

33. COLLECTION CHOICE CHEAT SHEET
Indexed ordered data → ArrayList
Unique values → HashSet
Unique + insertion order → LinkedHashSet
Unique + sorted → TreeSet
Key → value → HashMap
Key/value + insertion order → LinkedHashMap
Key/value + sorted keys → TreeMap
FIFO → Queue
Both ends → Deque
LIFO → Deque as stack
Priority → PriorityQueue

34. COMPLEXITY CHEAT SHEET
ArrayList:
get(index) O(1)
add(end) O(1) amortized
search O(n)
middle remove O(n)

HashSet:
add/contains/remove O(1) average

HashMap:
put/get/containsKey/remove O(1) average

TreeSet:
add/contains/remove O(log n)

TreeMap:
put/get/remove O(log n)

These are typical/average complexity statements, not absolute guarantees
for every pathological case.

35. COMMON INTERVIEW QUESTIONS
1. What is Java Collection Framework?
2. Collection vs Collections?
3. List vs Set vs Map?
4. ArrayList vs LinkedList?
5. ArrayList vs array?
6. HashSet vs LinkedHashSet?
7. HashSet vs TreeSet?
8. HashMap vs Hashtable?
9. HashMap vs LinkedHashMap?
10. HashMap vs TreeMap?
11. How does HashMap work internally?
12. What is hashing?
13. What is collision?
14. Why equals() and hashCode()?
15. Can HashMap have null?
16. Can HashSet have null?
17. Can HashMap have duplicate keys?
18. How do you iterate a HashMap?
19. What is getOrDefault()?
20. What is entrySet()?
21. What is LinkedHashMap used for?
22. What is TreeMap used for?
23. Queue vs Stack?
24. What is FIFO?
25. What is LIFO?
26. What is Deque?
27. ArrayDeque vs LinkedList?
28. What is PriorityQueue?
29. Comparable vs Comparator?
30. Iterator vs ListIterator?
31. What is ConcurrentModificationException?
32. What is fail-fast behavior?

36. MUST-KNOW CODING PATTERNS
Frequency:
map.put(key, map.getOrDefault(key,0) + 1);

Duplicate detection:
Set<T> seen = new HashSet<>();
if (!seen.add(item)) {
    // duplicate
}

Unique + preserve order:
Set<T> unique = new LinkedHashSet<>(list);

Sorted unique:
Set<T> sorted = new TreeSet<>(list);

Two Sum:
Use HashMap to store previously seen number -> index.

Grouping:
Map<Key,List<Value>> groups = new HashMap<>();

37. PHP → JAVA QUICK MAP
PHP indexed array → ArrayList
PHP associative array → HashMap
Unique-value requirement → HashSet
Nested associative/indexed arrays → List<Map>, Map<List>, List<List>

38. INTERVIEW DECISION TREE
Need index access? → ArrayList
Need duplicates? → List
Need unique? → HashSet
Need unique + insertion order? → LinkedHashSet
Need unique + sorted? → TreeSet
Need key/value? → HashMap
Need key/value + insertion order? → LinkedHashMap
Need key/value + sorted keys? → TreeMap
Need FIFO? → Queue
Need both ends? → Deque
Need LIFO? → Deque as Stack
Need priority? → PriorityQueue

39. PRACTICE ORDER
1. ArrayList basics
2. Remove duplicates
3. Find duplicates
4. Fruit frequency
5. Character frequency
6. Word frequency
7. First non-repeating character
8. First repeating character
9. Most frequent element
10. LinkedHashSet duplicate removal preserving order
11. TreeSet sorting
12. HashMap iteration
13. LinkedHashMap ordering
14. TreeMap sorting
15. Common elements
16. Union/intersection
17. Two Sum
18. Anagram
19. Group Anagrams
20. Queue
21. Deque
22. Stack
23. Valid Parentheses
24. PriorityQueue
25. Top-K problems

40. GOLDEN MEMORY RULE
ArrayList: list + index
HashSet: unique values
LinkedHashSet: unique + insertion order
TreeSet: unique + sorted
HashMap: key → value
LinkedHashMap: key/value + insertion order
TreeMap: key/value + sorted keys
Queue: first in, first out
Deque: both ends
Stack: last in, first out
PriorityQueue: priority-based removal