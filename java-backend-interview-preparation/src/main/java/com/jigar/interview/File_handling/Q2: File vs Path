# File vs Path

## 1. File kya hai?

`java.io.File` purana (legacy) API hai jo file/directory ke
saath basic operations aur metadata handle karta hai.

Example:

File file = new File("users.txt");

System.out.println(file.exists());
System.out.println(file.length());


Isse hum check kar sakte hain:

→ File exist karti hai ya nahi
→ File ka size
→ File/directory ka naam
→ Directory hai ya nahi


## 2. Path kya hai?

`java.nio.file.Path` modern Java NIO API ka part hai.

Example:

Path path = Path.of("users.txt");


Path mainly file/directory ka **location/path represent** karta hai.


## Real-World Example

Maan le application me:

/logs/application.log


### Old approach

File file =
    new File("/logs/application.log");


### Modern approach

Path path =
    Path.of("/logs/application.log");


Aur modern file operations ke liye:

Files.exists(path);
Files.readString(path);
Files.writeString(path, "Hello");


## Main Difference

File
→ Legacy API
→ Basic file/directory operations


Path
→ Modern NIO API
→ File system path ko represent karta hai


Files
→ Path ke saath actual operations perform karta hai


## Real Project Example

Spring Boot application me log file read karni hai:

Path path = Path.of("logs/app.log");

String content = Files.readString(path);


Yahan:

Path
→ "File kaha hai?"


Files
→ "File ke saath kya karna hai?"


## Interview Answer

"`File` is the older Java I/O API used for basic file and directory operations. `Path` is part of the modern NIO API and represents a file-system path, while the `Files` class provides modern operations such as reading, writing, copying and deleting files."


## Easy Memory

File
→ Old / Legacy


Path
→ Modern path representation


Files
→ Modern operations


Path + Files
→ Preferred modern approach