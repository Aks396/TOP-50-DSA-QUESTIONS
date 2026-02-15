# Concept: Java Fundamentals

Core internal workings of the Java programming language and Virtual Machine.

## 🧠 JVM Architecture
The Java Virtual Machine (JVM) is the engine that provides the runtime environment to drive the Java Code.
1. **Class Loader**: Loads `.class` files into memory.
2. **JVM Memory Areas**:
   - **Method Area**: Stores class structures, static fields.
   - **Heap**: Stores all objects. Managed by Garbage Collector.
   - **Stack**: Stores local variables and partial results for each thread.
   - **PC Register**: Stores the address of the current instruction.
3. **Execution Engine**: JIT (Just-In-Time) compiler and Interpreter.

## 🛠️ Key Java Features

- **Garbage Collection (GC)**: Automatic memory management. Major algorithms include G1, ZGC, and CMS.
- **Exceptions**:
  - **Checked**: Must be handled at compile-time (e.g., `IOException`).
  - **Unchecked**: Run-time errors (e.g., `NullPointerException`).
- **Generics**: Provides compile-time type safety for collections.
- **Reflection**: Ability to inspect or modify the behavior of applications at runtime.

## 📊 Performance & Memory
- **String Constant Pool**: Memory optimization for Strings.
- **Wrapper Classes & Autoboxing**: Converting primitives to Objects (e.g., `int` to `Integer`).
- **Serialization**: Converting an object into a byte stream for persistence or transmission.
