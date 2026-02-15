# Concept: Heaps & Priority Queues

A Heap is a specialized Tree-based data structure that satisfies the heap property.

## 🧠 Key Concepts

1. **Min-Heap**: Root is the minimum element. Every parent is smaller than its children.
2. **Max-Heap**: Root is the maximum element. Every parent is larger than its children.
3. **Array Representation**:
   - Parent of node at `i` is at `(i-1)/2`.
   - Left child is at `2i + 1`, Right child at `2i + 2`.

## 🛠️ Common Techniques

- **PriorityQueue**: The built-in Java class for heaps.
- **Kth Element Problems**: Using a heap of size K to find min/max in O(N log K).
- **Merging K Sorted Lists**: Using a Min-Heap to keep track of the head of each list.
- **Median Finding**: Using two heaps (Min and Max) to find the median in O(log N).

## 📊 Complexity Analysis

- **Insert**: O(log N)
- **Extract Min/Max**: O(log N)
- **Peek**: O(1)
- **Heapify**: O(N)
