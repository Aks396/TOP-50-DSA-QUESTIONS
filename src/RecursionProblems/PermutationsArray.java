package RecursionProblems;

import java.util.*;

/**
 * Question 6: Permutations of an Array
 */
public class PermutationsArray {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, boolean[] used) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(res, curr, nums, used);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println("Permutations: " + permute(nums));
    }
}
