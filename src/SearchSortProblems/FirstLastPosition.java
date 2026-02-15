package SearchSortProblems;

import java.util.Arrays;

/**
 * Question 4: Find First and Last Position of an Element in a Sorted Array
 * Example: Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
 */
public class FirstLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int start = findIndex(nums, target, true);
        int end = findIndex(nums, target, false);
        return new int[] { start, end };
    }

    private static int findIndex(int[] nums, int target, boolean first) {
        int res = -1, l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                res = m;
                if (first)
                    r = m - 1;
                else
                    l = m + 1;
            } else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        System.out.println("Range for 8: " + Arrays.toString(searchRange(nums, 8)));
    }
}
