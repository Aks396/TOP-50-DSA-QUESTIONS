# Concept: Maps & Sets

Hashing-based data structures for key-value storage and uniqueness.

## 🧠 Key Concepts

### HashMap
- Stores data as **(Key, Value)** pairs.
- Uses **Hashing** for O(1) average time complexity for `get` and `put`.
- Handles collisions using Chaining or Open Addressing.

### HashSet
- Stores unique elements only.
- Internally uses a `HashMap` where the value is a placeholder.

### LinkedHashMap & TreeMap
- **LinkedHashMap**: Maintains insertion order.
- **TreeMap**: Maintains natural ordering of keys (Red-Black Tree).

## 🛠️ Common Techniques

- **Frequency Counting**: Using Map to count occurrences of elements.
- **Two-Sum Problem**: Using HashSet to find complement in O(N).
- **Memoization**: Storing results of recursive calls in a Map.

## 📊 Complexity Analysis

- **Insert/Search/Delete**: 
  - **HashMap/HashSet**: O(1) average, O(N) worst case.
  - **TreeMap**: O(log N).
