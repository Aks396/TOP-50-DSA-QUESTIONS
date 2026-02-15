package ArrayProblems;

import java.util.Arrays;

/**
 * Question 5: Maximum Product Subarray
 * Example: Input: [2,3,-2,4] Output: 6
 */
public class MaximumProductSubarray {

    /**
     * Java 7 Approach: Iterative tracking min and max products
     */
    public static int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));

            maxSoFar = tempMax;
            result = Math.max(maxSoFar, result);
        }

        return result;
    }

    /**
     * Java 8+ Approach: Using Stream API reduction
     */
    public static int maxProductStream(int[] nums) {
        class State {
            int maxSoFar = nums[0];
            int minSoFar = nums[0];
            int result = nums[0];

            State accept(int i, int val) {
                if (i == 0)
                    return this;
                int tempMax = Math.max(val, Math.max(maxSoFar * val, minSoFar * val));
                minSoFar = Math.min(val, Math.min(maxSoFar * val, minSoFar * val));
                maxSoFar = tempMax;
                result = Math.max(result, maxSoFar);
                return this;
            }

            State combine(State other) {
                return this;
            }
        }

        State state = new State();
        for (int i = 0; i < nums.length; i++)
            state.accept(i, nums[i]);
        return state.result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        System.out.println("Input: [2, 3, -2, 4]");
        System.out.println("Java 7 Max Product: " + maxProduct(nums));
        System.out.println("Java 8+ Max Product: " + maxProductStream(nums));
    }
}
