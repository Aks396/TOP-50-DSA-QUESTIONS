package ArrayProblems;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Question 7: Subarray with Given Sum
 * Example: Input: arr = [1,2,3,7,5], sum = 12
 * Output: [2, 4] (Indices 2 to 4, 1-based usually, but we'll use 0-based result
 * [1, 3] or values)
 * The PDF says Output: [2,4] which corresponds to 1-based indices for [2,3,7].
 */
public class SubarrayWithGivenSum {

    /**
     * Java 7 Approach: Sliding Window
     */
    public static void findSubarray(int[] arr, int target) {
        int start = 0, currSum = 0;
        for (int end = 0; end < arr.length; end++) {
            currSum += arr[end];
            while (currSum > target && start < end) {
                currSum -= arr[start];
                start++;
            }
            if (currSum == target) {
                System.out.println("Java 7 - Subarray found between indices: " + (start + 1) + " and " + (end + 1));
                return;
            }
        }
        System.out.println("Java 7 - No subarray found");
    }

    /**
     * Java 8+ Approach: Using Streams (Sliding window is harder in streams, but
     * possible with reduction)
     */
    public static void findSubarrayStream(int[] arr, int target) {
        // We'll use a simple iterative search since sliding window logic is not
        // functional-friendly
        // but we can wrap it in an IntStream to find the first match.
        boolean found = IntStream.range(0, arr.length)
                .filter(i -> {
                    int sum = 0;
                    for (int j = i; j < arr.length; j++) {
                        sum += arr[j];
                        if (sum == target) {
                            System.out.println(
                                    "Java 8+ - Subarray found between indices: " + (i + 1) + " and " + (j + 1));
                            return true;
                        }
                        if (sum > target)
                            break;
                    }
                    return false;
                }).findFirst().isPresent();

        if (!found)
            System.out.println("Java 8+ - No subarray found");
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 7, 5 };
        int sum = 12;
        System.out.println("Input: [1, 2, 3, 7, 5], sum=12");
        findSubarray(arr, sum);
        findSubarrayStream(arr, sum);
    }
}
