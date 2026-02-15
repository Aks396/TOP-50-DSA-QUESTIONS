package RecursionProblems;

import java.util.*;

/**
 * Question 9: Combination Sum II (Unique combinations)
 */
public class CombinationSum2 {
    public static List<List<Integer>> solve(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> curr, int[] candidates, int remain,
            int start) {
        if (remain == 0) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > remain)
                break;
            curr.add(candidates[i]);
            backtrack(res, curr, candidates, remain - candidates[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
        System.out.println("Combination Sum II (8): " + solve(nums, 8));
    }
}
