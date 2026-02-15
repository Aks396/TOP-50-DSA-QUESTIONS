# Concept: Strings

In Java, a `String` is an object that represents a sequence of characters.

## 🧠 Key Concepts

1. **Immutability**: `String` objects are immutable. Any modification creates a new String.
2. **String Pool**: A special memory area where Strings are stored to save space.
3. **StringBuilder / StringBuffer**: Used for efficient character manipulations (mutable strings).

## 🛠️ Common Techniques

- **KMP Algorithm**: Efficient pattern matching in O(N+M) time.
- **Rabin-Karp**: String searching using hashing.
- **Anagram Checks**: Sorting or character counting (Frequency Map).
- **Longest Palindromic String**: Expand around center or Manacher's Algorithm.

## 📊 Complexity Analysis

- **Concatenation**: O(N+M)
- **Substring**: O(M)
- **Comparison**: O(min(N, M))
