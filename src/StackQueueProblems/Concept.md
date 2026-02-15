# Concept: Stacks & Queues

Linear data structures that follow specific ordering principles.

## 🧠 Key Concepts

### Stack (LIFO - Last In First Out)
- **Operations**: `push`, `pop`, `peek`.
- **Use Cases**: Function calls (Recursion), Undo/Redo, Expression Evaluation.

### Queue (FIFO - First In First Out)
- **Operations**: `enqueue`, `dequeue`, `front`, `rear`.
- **Use Cases**: Task scheduling, BFS (Breadth-First Search).

## 🛠️ Common Techniques

- **Monotonic Stack**: Keeping elements in increasing/decreasing order to solve "Next Greater Element" problems.
- **Two Stacks for a Queue**: Implementing FIFO using LIFO logic.
- **Deque (Double-Ended Queue)**: Used for sliding window maximum problems.

## 📊 Complexity Analysis

- **Push/Pop**: O(1)
- **Enqueue/Dequeue**: O(1)
- **Access/Search**: O(N)
