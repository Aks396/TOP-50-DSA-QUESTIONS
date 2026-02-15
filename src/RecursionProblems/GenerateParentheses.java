package RecursionProblems;

import java.util.*;

/**
 * Question 7: Generate Parentheses
 */
public class GenerateParentheses {
    public static List<String> generate(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private static void backtrack(List<String> res, String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            res.add(curr);
            return;
        }
        if (open < max)
            backtrack(res, curr + "(", open + 1, close, max);
        if (close < open)
            backtrack(res, curr + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        System.out.println("Parentheses (3): " + generate(3));
    }
}
