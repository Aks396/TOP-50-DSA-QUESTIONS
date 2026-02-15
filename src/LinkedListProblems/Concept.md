# Concept: Linked Lists

A Linked List is a linear data structure where elements are not stored in contiguous locations; instead, they are linked using pointers.

## 🧠 Key Concepts

1. **Nodes**: Each element consists of data and a reference (`next`) to the next node.
2. **Types**:
   - **Singly Linked**: Directional (forward only).
   - **Doubly Linked**: Bi-directional (next and prev).
   - **Circular**: Last node points back to the head.

## 🛠️ Common Techniques

- **Fast & Slow Pointers (Floyd's Cycle)**: Used to detect loops or find the middle of the list.
- **Recursion**: Very effective for reversing or traversing lists.
- **Dummy Head**: Using a placeholder node to simplify edge cases (e.g., merging lists).

## 📊 Complexity Analysis

- **Access**: O(N)
- **Search**: O(N)
- **Insertion/Deletion**: O(1) (if position is known)
