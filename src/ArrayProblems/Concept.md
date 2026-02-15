# Concept: Arrays

An Array is a collection of items stored at contiguous memory locations. It is one of the most fundamental data structures in computer science.

## 🧠 Key Concepts

1. **Memory Layout**: Contiguous memory allows for **O(1) random access** using an index.
2. **Fixed Size**: In standard Java arrays (`int[]`), the size is fixed at creation time. `ArrayList` provides dynamic resizing.
3. **Index**: Always starts from `0`.

## 🛠️ Common Techniques

- **Two Pointers**: Used for sorted arrays or searching for pairs (e.g., Target Sum). One pointer at start, one at end.
- **Sliding Window**: Efficiently processing subarrays or subsegments of the array (e.g., Maximum Sum Subarray of size K).
- **Kadane's Algorithm**: Dynamic Programming approach to find the maximum subarray sum in O(N).
- **Dutch National Flag Algorithm**: Sorting arrays with limited unique values (e.g., 0s, 1s, and 2s).

## 📊 Complexity Analysis

- **Access**: O(1)
- **Search**: O(N) (Linear) / O(log N) (Binary Search on sorted)
- **Insertion/Deletion**: O(N) (due to shifting elements)
