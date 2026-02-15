# Concept: Trees & BST

A Tree is a hierarchical data structure. A Binary Tree has at most two children per node.

## 🧠 Key Concepts

1. **Terminology**: Root, Leaf, Height, Depth, Ancestor, Descendant.
2. **Binary Search Tree (BST)**:
   - For every node, `Left < Node < Right`.
   - In-order traversal of BST gives sorted order.

## 🛠️ Common Techniques

- **Traversals**:
   - **DFS**: Pre-order, In-order, Post-order.
   - **BFS**: Level-order (using a Queue).
- **Recursion**: The primary tool for tree problems due to their inductive structure.
- **LCA (Lowest Common Ancestor)**: Finding the split point of two nodes.

## 📊 Complexity Analysis (Balanced)

- **Access/Search**: O(log N)
- **Insertion/Deletion**: O(log N)
- **Worst Case (Skewed)**: O(N)
