package BacktrackingProblems;

import java.util.*;

/**
 * Question 5: Subsets
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, int start) {
        res.add(new ArrayList<Integer>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println("Subsets of [1,2,3]: " + subsets(nums));
    }
}
