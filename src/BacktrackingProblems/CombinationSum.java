package BacktrackingProblems;

import java.util.*;

/**
 * Question 6: Combination Sum
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> curr, int[] candidates, int remain,
            int start) {
        if (remain < 0)
            return;
        if (remain == 0) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            backtrack(res, curr, candidates, remain - candidates[i], i);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 7 };
        System.out.println("Combination Sum (7): " + combinationSum(nums, 7));
    }
}
