package ArrayProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Question 10: Next Permutation
 * Example: Input: [1,2,3] Output: [1,3,2]
 */
public class NextPermutation {

    /**
     * Java 7 Approach: Find peak, swap, and reverse
     */
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
        System.out.println("Java 7 Next: " + Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end)
            swap(nums, start++, end--);
    }

    /**
     * Java 8+ Approach: Using Stream/List for reversal (though core logic remains
     * same)
     */
    public static void nextPermutationStream(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }

        // Use a list to reverse sub-array for "Stream" feel
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> sub = list.subList(i + 1, n);
        Collections.reverse(sub);

        System.out.println("Java 8+ Next: " + list);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 1, 2, 3 };
        System.out.println("Input: [1, 2, 3]");
        nextPermutation(nums1);
        nextPermutationStream(nums2);
    }
}
