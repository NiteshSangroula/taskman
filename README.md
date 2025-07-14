# TaskMan 📝  
A Feature-Rich Command Line Task Manager built in Java.

---

## ✨ Features
- ✅ Add tasks with a name, due date, and priority (HIGH / MEDIUM / LOW)
- ✅ Mark tasks as done
- ✅ Delete tasks by ID
- ✅ List all tasks in a clean format
- ✅ Data persists between runs (using Java Serialization)
- ✅ Cross-platform storage support (Windows, macOS, Linux)
- ✅ Clean design using SOLID principles and common design patterns:
  - Command Pattern
  - Factory Pattern
  - Strategy Pattern
  - REPL (Read-Eval-Print-Loop) Structure

---

## 🛠️ How to Build and Run

### 🔹 Build with Maven:
```bash
mvn clean package
```
This creates a runnable JAR file in the target/ directory:

```bash
target/taskman-1.0-SNAPSHOT.jar
```

### 🔹 Run the JAR:
```bash
java -jar target/taskman-1.0-SNAPSHOT.jar
```

### 🔹 For Development (without packaging):
```bash
mvn compile
mvn exec:java
```

### 💻 Example Usage (Inside REPL)
```bash
> add -n "Buy Milk" -d 2025-07-15 -p high
Task added successfully!

> list
ID | Name     | Due Date   | Priority | Done
1  | Buy Milk | 2025-07-15 | HIGH     | false

> done -id 1
Task marked as done!

> delete -id 1
Task deleted successfully!
```

### 🗂️ Project Structure
```bash
src/
 └── main/
      └── java/
           └── com/
                └── nitesh/
                     └── taskman/
                          ├── command/      # Command Pattern Classes
                          ├── model/        # Task Model & Enums
                          ├── parser/       # Command Parser & Factory
                          ├── repl/         # REPL Logic
                          ├── storage/      # Serialization & Persistence
                          └── util/         # Utility Classes (Path Utils)
```

### 🌐 Cross-Platform Storage Location
OS	      Path Example
Windows	  %APPDATA%\taskman\tasks.ser
macOS	    ~/Library/Application Support/taskman/tasks.ser
Linux	    ~/.local/share/taskman/tasks.ser

### 🚀 Possible Future Enhancements

    JSON-based storage (Gson / Jackson)
    CLI argument auto-completion
    Task categories or tags
    Search and filter options
    REST API version with Spring Boot
    Undo/Redo functionality

### 🤝 Contributing

Pull requests are welcome!
If you have suggestions or improvements, feel free to open an issue.

### ⚖️ License

MIT License — Feel free to use, modify, and distribute.
