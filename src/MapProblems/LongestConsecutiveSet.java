package MapProblems;

import java.util.*;

/**
 * Question 7: Longest Consecutive Sequence (HashSet implementation)
 */
public class LongestConsecutiveSet {
    public static int longest(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums)
            set.add(n);
        int max = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int curr = n, len = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Longest: " + longest(nums)); // 4
    }
}
