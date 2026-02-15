# Concept: Backtracking

Backtracking is an algorithmic technique that considers searching every possible combination to solve a computational problem.

## 🧠 Key Traits

1. **Incremental Building**: Build the solution piece by piece.
2. **Pruning**: Remove branches that fail to satisfy constraints early (Dead ends).
3. **State Restoration**: Undo the choice before moving to the next possibility.

## 🏁 Classic Problems

- **N-Queens**: Placing queens on a board.
- **Sudoku Solver**: Filling a grid following rules.
- **Permutations & Subsets**: Generating all combinations of elements.
- **Rat in a Maze**: Finding a path through obstacles.

## 📊 Complexity Analysis

- Usually Exponential: **O(K^N)** where K is the number of choices and N is the number of steps.
