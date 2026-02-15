package ArrayQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Question: Rotate an Array by K Steps
 * Example: Input: nums = [1,2,3,4,5,6,7], k = 3 
 * Output: [5,6,7,1,2,3,4]
 */
public class RotateArray {

    /**
     * Java 7 Approach: Using reversal algorithm
     * 1. Reverse the first k elements (arr.length - k)
     * 2. Reverse the remaining k elements
     * 3. Reverse the entire array
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        System.out.println("Java 7 Rotated: " + Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Java 8+ Approach: Using Stream API
     */
    public static void rotateStream(int[] nums, int k) {
        int n = nums.length;
        int rotation = k % n;
        
        List<Integer> rotated = IntStream.concat(
                Arrays.stream(nums, n - rotation, n),
                Arrays.stream(nums, 0, n - rotation)
        ).boxed().collect(Collectors.toList());
        
        System.out.println("Java 8+ Rotated: " + rotated);
    }

    public static void main(String[] args) {
        int[] data1 = {1, 2, 3, 4, 5, 6, 7};
        int[] data2 = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(data1, k);
        rotateStream(data2, k);
    }
}
