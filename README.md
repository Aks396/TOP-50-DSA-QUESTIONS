# Java Interview Master Kit (Junior to Senior+)

The ultimate repository for Java developers preparing for technical interviews. This kit covers everything from fundamental DSA to senior-level System Design and Concurrency.

## 🚀 Overview

The repository features **150+ high-quality materials**:
- **120+ DSA Problems** (Dual Java 7 & 8+ approaches)
- **10+ Advanced Concurrency Utilities**
- **4+ System Design Deep Dives**
- **10+ OOPS & Java Fundamentals Demos**
- **60+ Question Senior Prep Guide (3+ YOE)**

## 📂 Project Structure

### 💻 Data Structures & Algorithms
- `Array`, `String`, `LinkedList`, `StackQueue`, `Map`, `Heap`, `TreeBST`, `Graph`, `DP`, `SearchSort`, `Backtracking`, `Greedy`, `Recursion`.
- *Every package contains a detailed `Concept.md`.*

### 🎨 OOPS & Java Fundamentals
- `OOPS_Concepts`: Inheritance, Polymorphism, Abstraction, Encapsulation, SOLID principles.
- `Java_Fundamentals`: JVM Architecture, Exceptions, Generics, Collections Internals, Advanced Streams, Reflection.

### 🧵 Advanced Concurrency
- `ConcurrencyProblems`: ExecutorService, CompletableFuture, ReentrantLock, Sync Utilities, Thread Safety.

### 🏛️ System Design & Senior Prep
- `SystemDesign/`: Load Balancing, Caching, Database Sharding.
- `Interview_Prep_3YOE/`: 60+ most asked questions **with detailed answers** for senior profiles.
  - [Java Internals & Multithreading Answers](file:///d:/Antigravity-IDE/DSA-Question/Interview_Prep_3YOE/01_Java_Internals_Answers.md)
  - [Design Patterns & SOLID Answers](file:///d:/Antigravity-IDE/DSA-Question/Interview_Prep_3YOE/02_Design_Patterns_Answers.md)
  - [Microservices & Spring Boot Answers](file:///d:/Antigravity-IDE/DSA-Question/Interview_Prep_3YOE/03_Microservices_Spring_Answers.md)
  - [DB & System Design Answers](file:///d:/Antigravity-IDE/DSA-Question/Interview_Prep_3YOE/04_Database_System_Design_Answers.md)

## 🏗️ How to Use
1. **Clone**: `git clone https://github.com/Aks396/TOP-DSA-QUESTIONS.git`
2. **Compile All**:
   ```bash
   $javaFiles = Get-ChildItem -Path src -Filter *.java -Recurse | Select-Object -ExpandProperty FullName; javac -d bin $javaFiles
   ```
3. **Run a Sample (e.g., OOPS)**:
   ```bash
   java -cp bin OOPS_Concepts.PolymorphismDemo
   ```

---
*Elevating Java interviews to the next level.* 🚀
