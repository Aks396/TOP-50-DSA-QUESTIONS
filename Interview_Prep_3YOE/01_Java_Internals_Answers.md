# Senior Interview Answers: Java Internals & Multithreading

### 1. Explain the working of ConcurrentHashMap. How does it differ from a synchronized HashMap?
- **Working**: In Java 8+, `ConcurrentHashMap` uses a combination of **CAS (Compare-And-Swap)** and **synchronized** blocks on a per-bucket basis (node-level locking). It no longer uses the `Segment` (Segmented locking) array from Java 7.
- **Differences**: 
  - `synchronized HashMap` or `Hashtable` locks the entire map for every operation, leading to contention.
  - `ConcurrentHashMap` allows multiple threads to read concurrently without locking and perform writes on different buckets simultaneously.
  - It does not allow `null` keys or values.

### 2. What is the Java Memory Model (JMM)?
- JMM defines how the JVM memory is divided into **Thread Stacks** and **Heap Memory**.
- It specifies the interaction between threads and the main memory to ensure **Visibility** (changes made by one thread are visible to others) and **Ordering** (preventing illegal instruction reordering by the compiler).

### 3. Difference between `synchronized` block and `ReentrantLock`.
- **synchronized**: Implicitly managed by JVM, simpler to use, automatically releases lock even if an exception occurs.
- **ReentrantLock**: Explicit management (`lock()`, `unlock()`). Offers advanced features:
  - `tryLock()`: Non-blocking attempt to acquire lock.
  - `lockInterruptibly()`: Can respond to interrupts.
  - **Fairness**: Can be configured to give the lock to the longest-waiting thread.
  - **Multiple Conditions**: Support for multiple `Condition` objects (`await/signal`).

### 4. How does Garbage Collection work in Java? G1 vs ZGC.
- **G1 (Garbage First)**: Default in Java 9+. Divides heap into regions. It prioritizes cleaning regions with the most garbage first to minimize pause times. Good for large heaps with soft real-time constraints.
- **ZGC (Z Garbage Collector)**: A low-latency collector (pauses < 1ms) that performs most of its work concurrently with application threads. It uses **Colored Pointers** and **Load Barriers**.

### 5. What are the different thread states?
- **NEW**: Thread created but not started.
- **RUNNABLE**: Executing in the JVM or waiting for CPU.
- **BLOCKED**: Waiting for a monitor lock (synchronized).
- **WAITING**: Waiting indefinitely for another thread (wait, join, park).
- **TIMED_WAITING**: Waiting for a specific time (sleep, timed wait).
- **TERMINATED**: Finished execution.

### 6. Explain the Fork/Join framework.
- Designed for task-parallelism (divide and conquer). It uses a **Work-Stealing Algorithm** where idle threads can 'steal' tasks from the back of the deques of busy threads.
- **Fork**: Splitting a task into smaller sub-tasks.
- **Join**: Waiting for the sub-tasks to finish and combining results.

### 7. What is a Deadlock? Detection and Prevention.
- **Deadlock**: Situation where two or more threads are stuck waiting for each other to release locks.
- **Prevention**: 
  - **Lock Ordering**: Always acquire locks in the same global order.
  - **Lock Timeout**: Use `ReentrantLock.tryLock()` with a timeout.
- **Detection**: Use `ThreadMXBean.findDeadlockedThreads()` or external tools like `jconsole`/`jstack`.

### 8. What is AtomicInteger and how does it work?
- It provides thread-safe operations on an `int` without using `synchronized`.
- It uses **CAS (Compare-And-Swap)** instructions provided by the CPU (via `Unsafe` class) to update values atomically.

### 9. Explain the usage of `volatile` keyword.
- **Visibility**: Ensures that any thread reading the field sees the most recently written value from the main memory, not from its local cache.
- **Atomicity**: It does NOT provide atomicity (e.g., `volatileCount++` is still unsafe).
- **Ordering**: Prevents instruction reordering around the volatile variable.

### 10. Difference between `wait/notify` and `await/signal`?
- `wait/notify` are methods of `Object` and work with `synchronized`.
- `await/signal` are methods of `Condition` interface and work with `ReentrantLock`. They allow for multiple wait-sets per lock (e.g., separate conditions for 'Buffer Full' and 'Buffer Empty').

### 11-15 Quick Hits:
11. **Custom Thread Pool**: Use `ThreadPoolExecutor` class to define core/max threads, queue types, and rejection policies.
12. **ThreadLocal**: Provides thread-level isolation for data (e.g., storing a user context or JDBC connection per thread).
13. **submit() vs execute()**: `execute()` returns void and is for 'fire and forget'. `submit()` returns a `Future` and allows result handling/exception catching.
14. **Race Condition**: When two threads access shared data and try to change it simultaneously. Fix with `synchronized`, `Locks`, or `Atomics`.
15. **String Interning**: Storing only one copy of each distinct String value in the **String Constant Pool** (Heap) to save memory.
