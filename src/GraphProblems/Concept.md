# Concept: Graphs

A Graph consists of a set of Vertices (Nodes) and Edges connecting them.

## 🧠 Key Concepts

1. **Representation**:
   - **Adjacency Matrix**: 2D array, O(1) edge check, O(V²) space.
   - **Adjacency List**: Array of lists, O(V+E) space.
2. **Directed vs Undirected**: Does an edge have a direction?
3. **Cyclic vs Acyclic**: Are there loops? (DAG = Directed Acyclic Graph).

## 🛠️ Common Techniques

- **BFS**: Finds shortest path in unweighted graphs.
- **DFS**: Traverses deep before wide; used in cycle detection and topological sort.
- **Dijkstra’s Algorithm**: Shortest path in weighted graphs (Greedy).
- **Disjoint Set Union (DSU)**: Efficiently tracking connected components.

## 📊 Complexity Analysis

- **BFS/DFS**: O(V + E)
- **Dijkstra**: O(E log V)
