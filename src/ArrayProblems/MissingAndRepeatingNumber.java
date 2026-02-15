package ArrayProblems;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Question 6: Find the Missing and Repeating Number
 * Example: Input: n = 5, arr[] = {1, 3, 3, 5, 4}
 * Output: Missing = 2, Repeating = 3
 */
public class MissingAndRepeatingNumber {

    /**
     * Java 7 Approach: Using frequency array
     */
    public static void findNumbers(int[] arr, int n) {
        int[] freq = new int[n + 1];
        for (int x : arr)
            freq[x]++;

        int missing = -1, repeating = -1;
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0)
                missing = i;
            if (freq[i] > 1)
                repeating = i;
        }
        System.out.println("Java 7 - Missing: " + missing + ", Repeating: " + repeating);
    }

    /**
     * Java 8+ Approach: Using Stream API
     */
    public static void findNumbersStream(int[] arr, int n) {
        Map<Integer, Long> freqMap = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        int repeating = freqMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);

        int missing = (int) LongStream.rangeClosed(1, n)
                .filter(i -> !freqMap.containsKey((int) i))
                .findFirst().orElse(-1);

        System.out.println("Java 8+ - Missing: " + missing + ", Repeating: " + repeating);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 3, 5, 4 };
        int n = 5;
        System.out.println("Input: {1, 3, 3, 5, 4}, n=5");
        findNumbers(arr, n);
        findNumbersStream(arr, n);
    }
}
