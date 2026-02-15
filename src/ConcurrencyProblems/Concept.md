# Concept: Java Concurrency & Multithreading

Concurrency is the ability to run multiple parts of a program or several programs in parallel. In Java, this is achieved through the Threading API.

## 🧠 Core Concepts

1. **Processes vs Threads**:
   - A **Process** is an instance of a program (isolated memory).
   - A **Thread** is the smallest unit of execution within a process (shared memory).
2. **Race Conditions**: Occur when multiple threads access and modify shared data simultaneously, leading to unpredictable results.
3. **Thread Safety**: Ensuring that data remains consistent when accessed by multiple threads.

## 🛠️ Java Concurrency Utilities (`java.util.concurrent`)

- **ExecutorService**: Decouples task submission from thread management.
- **Atomic Classes**: Lock-free thread-safe operations on single variables.
- **Locks**: More flexible synchronization than the `synchronized` keyword.
- **CompletableFuture**: Simplifies asynchronous, non-blocking code.
- **Synchronizers**: `CountDownLatch`, `CyclicBarrier`, `Semaphore`.

## 📊 Performance Trade-offs
- **Context Switching**: The overhead of saving and restoring the state of a thread. 
- **Deadlocks**: Threads waiting for each other in a circular dependency.
- **Starvation**: A thread being permanently denied access to resources.
