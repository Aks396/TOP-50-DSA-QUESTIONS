package BacktrackingProblems;

import java.util.*;

/**
 * Question 8: Palindrome Partitioning
 */
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        backtrack(res, new ArrayList<String>(), s, 0);
        return res;
    }

    private static void backtrack(List<List<String>> res, List<String> curr, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(curr));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                curr.add(s.substring(start, i + 1));
                backtrack(res, curr, s, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Partition aab: " + partition("aab"));
    }
}
