package ArrayQuestion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * Question: Find only duplicate elements from array
 * Example: [1,2,3,4,5,6,7,8,9,4,5,6]
 * Output: 4 5 6
 */
public class FindDuplicateElements {

    /**
     * Java 7 Approach: Using HashMap to count frequencies
     * Complexity: O(n) Time, O(n) Space
     */
    public static void duplicateElement(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int num : arr) {
            Integer count = countMap.get(num);
            if (count == null) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, count + 1);
            }
        }
        System.out.println("Java 7 - Duplicate elements are:");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }


    /**
     * Java 8+ Approach: Using Stream API
     * Complexity: O(n) Time, O(n) Space
     */
    public static void duplicateElementStream(int[] arr) {
        System.out.println("Java 8+ - Duplicate elements are:");
        // 1. Convert the int array to a stream of boxed Integers
        // 2. Group the elements and count their occurrences
        Map<Integer, Long> countMap = stream(arr).boxed()
                .collect(Collectors.groupingBy(
                        n -> n,                   // Key: The number itself
                        Collectors.counting()     // Value: The frequency of the number
                ));

        // 3. Stream the map entries, filter those with a count > 1, and print the key
        List<Integer> duplicates = countMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Filter entries where count > 1
                .map(Map.Entry::getKey)                // Map to get only the element (Key)
                .collect(Collectors.toList());         // Collect the duplicates into a List

        // Print the result
        duplicates.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 5, 6};

        duplicateElement(data);
        duplicateElementStream(data);
    }
}
