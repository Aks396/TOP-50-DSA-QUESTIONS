package MapProblems;

import java.util.*;

/**
 * Question 1: Two Sum
 * Example: nums = [2, 7, 11, 15], target = 9 Output: [0, 1]
 */
public class TwoSum {
    public static int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[] { map.get(complement), i };
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        System.out.println("Result: " + Arrays.toString(solve(nums, 9)));
    }
}
