# Java — Q1: What is File Handling?

## File Handling kya hai?

File Handling ka matlab hai Java application se files ke andar
data ko:

→ Create
→ Read
→ Write
→ Update
→ Delete

karna.

## Real-World Example

Maan le hamari Spring Boot application me
daily application logs save karne hain:

application.log

2026-08-24 INFO Order Created
2026-08-24 INFO Payment Successful
2026-08-24 ERROR Payment Failed


Java application:

Application
     ↓
File Handling
     ↓
application.log


## Common File Operations

### Create

File create karna.

### Write

File ke andar data save karna.

### Read

File se data read karna.

### Delete

File remove karna.


## Java me important classes

### File

File/directory ke basic operations aur metadata ke liye.

File file = new File("data.txt");


### FileReader

Text file ko character-by-character read karne ke liye.

### FileWriter

Text file me characters write karne ke liye.

### BufferedReader

Efficiently text read karne ke liye.

### BufferedWriter

Efficiently text write karne ke liye.

### Files

Modern Java NIO API ka part.

Files.readString(...)
Files.writeString(...)


## Real Example

Suppose:

users.txt

Jigar
Rahul
Amit


Java:

→ File open
→ Data read
→ Process
→ Close


## Important Point

File resources ko properly close karna important hai.

Modern Java me:

try-with-resources

use karna preferred hai.

Example:

try (BufferedReader reader =
        new BufferedReader(
            new FileReader("users.txt"))) {

    String line;

    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}


Reader automatically close ho jayega.


## Interview Answer

"File handling in Java is used to create, read, write and manage files. Java provides traditional IO classes such as FileReader and FileWriter, and modern NIO APIs such as Files and Path."


## Easy Memory

File
→ File information


Reader
→ Read


Writer
→ Write


BufferedReader
→ Efficient reading


Files / Path
→ Modern NIO