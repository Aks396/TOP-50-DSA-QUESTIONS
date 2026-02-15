package RecursionProblems;

import java.util.*;

/**
 * Question 10: Letter Combinations of a Phone Number
 */
public class LetterCombinations {
    private static final String[] MAPPING = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> solve(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.isEmpty())
            return res;
        backtrack(res, "", digits, 0);
        return res;
    }

    private static void backtrack(List<String> res, String curr, String digits, int idx) {
        if (idx == digits.length()) {
            res.add(curr);
            return;
        }
        String letters = MAPPING[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            backtrack(res, curr + c, digits, idx + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Combinations 23: " + solve("23"));
    }
}
