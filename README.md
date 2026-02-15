# Java DSA & Advanced Interview Prep (Master Kit)

This repository is a comprehensive resource for technical interview preparation, covering fundamental Data Structures, Algorithms, Advanced Java Concurrency, and System Design concepts.

## 🚀 Overview

The project includes **130+ implementation-focused solutions and documents**, demonstrating mastery in:
- **Java 7 & Java 8+ patterns**: Comparative implementations for all DSA problems.
- **Concurrency Utilities**: Professional-grade multithreading examples.
- **System Design**: High-level architectural foundations.

## 📂 Project Structure

### 💻 Data Structures & Algorithms
Organized into topical packages with detailed `Concept.md` files:
- `ArrayProblems`: Kadane's Algorithm, Rotate Array, Trapping Rain Water, etc.
- `StringProblems`: KMP Algorithm, Longest Palindromic Substring, etc.
- `LinkedListProblems`: Reverse List, Loop Detection, Merging, etc.
- `StackQueueProblems`: LRU Cache, Min Stack, Sliding Window Max, etc.
- `MapProblems`: HashMap/HashSet logic, Two-Sum, Group Anagrams, etc.
- `HeapProblems`: PriorityQueue, Median Finder, Kth Largest, etc.
- `TreeBSTProblems`: Traversals, LCA, Validate BST, Max Path Sum, etc.
- `GraphProblems`: BFS/DFS, Dijkstra, Cycle Detection.
- `DPProblems`: 0/1 Knapsack, LIS, LCS, Edit Distance.
- `SearchSortProblems`: Quick Sort, Merge Sort, Binary Search, Radix Sort.
- `BacktrackingProblems`: N-Queens, Sudoku Solver, Word Search.
- `GreedyProblems`: Huffman Encoding, Activity Selection, Prim's/Kruskal's.
- `RecursionProblems`: Permutations, Subset Sum, Phone Mnemonics.

### 🧵 Advanced Java Concurrency
Located in `ConcurrencyProblems`:
- **ExecutorService**: Professional thread pool management.
- **CompletableFuture**: Asynchronous non-blocking pipelines.
- **Locking**: `ReentrantLock` and `ReadWriteLock`.
- **Sync Utilities**: `Semaphore`, `CountDownLatch`, `CyclicBarrier`.
- **Thread Safety**: Atomic variables, Volatile, and Deadlock detection.

### 🏛️ System Design Basics
Found in the `SystemDesign/` folder:
- **Core Principles**: Scalability, Availability, Reliability.
- **Load Balancing**: L4/L7 types and algorithms.
- **Caching**: Eviction policies and strategies.
- **Database Sharding**: Partitioning and scalability trade-offs.

## 🏗️ How to Run
1. **Clone the repository**:
   ```bash
   git clone https://github.com/Aks396/TOP-DSA-QUESTIONS.git
   ```
2. **Compile the project**:
   ```bash
   # Windows PowerShell
   $javaFiles = Get-ChildItem -Path src -Filter *.java -Recurse | Select-Object -ExpandProperty FullName; javac -d bin $javaFiles
   ```
3. **Run a specific class**:
   ```bash
   java -cp bin ConcurrencyProblems.ExecutorServiceExample
   ```

---
*Built for excellence in engineering.* 🚀
