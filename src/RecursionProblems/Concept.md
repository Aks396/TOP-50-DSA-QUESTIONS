# Concept: Recursion

Recursion is a technique where a function calls itself to solve smaller instances of the same problem.

## 🧠 Key Components

1. **Base Case**: The condition where the function stops calling itself to avoid infinite loops.
2. **Recursive Case**: The logic where the function calls itself with a reduced input.
3. **Stack Space**: Each recursive call uses a new stack frame. Deep recursion can lead to `StackOverflowError`.

## 🛠️ Common Patterns

- **Divide and Conquer**: Splitting the problem into two or more subproblems (e.g., Merge Sort, Binary Search).
- **Backtracking**: Exploring all possible paths (e.g., Permutations, N-Queens).
- **Tail Recursion**: A form of recursion where the recursive call is the last action. Java (JVM) generally does not optimize tail recursion.

## 🏁 Classic Problems

- Factorial, Fibonacci.
- Tower of Hanoi.
- Subset Generation.
- Memoization (Top-down DP).

## 📊 Complexity Analysis

- **Time**: Often **O(2^N)** for branching or **O(N)** for linear.
- **Space**: **O(H)** where H is the maximum depth of the recursion tree.
