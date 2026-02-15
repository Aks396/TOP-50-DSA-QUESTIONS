package SearchSortProblems;

/**
 * Question 6: Search in Rotated Sorted Array
 * Example: Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 */
public class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target)
                return m;
            if (nums[l] <= nums[m]) {
                if (target >= nums[l] && target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else {
                if (target > nums[m] && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Index of 0: " + search(nums, 0)); // 4
    }
}
