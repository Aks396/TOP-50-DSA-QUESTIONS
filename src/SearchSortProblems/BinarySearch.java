package SearchSortProblems;

import java.util.Arrays;

/**
 * Question 1: Binary Search
 * Example: Input: arr = [1, 3, 5, 7, 9], target = 5 Output: 2
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    /**
     * Java 8+ Approach: Using Arrays.binarySearch (or logic)
     */
    public static int searchStream(int[] nums, int target) {
        return Arrays.binarySearch(nums, target);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 7, 9 };
        System.out.println("Java 7 Index: " + search(nums, 5));
        System.out.println("Java 8+ Index: " + searchStream(nums, 5));
    }
}
