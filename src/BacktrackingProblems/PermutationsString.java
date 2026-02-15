package BacktrackingProblems;

import java.util.*;

/**
 * Question 4: Permutations of a String
 * Example: Input: "ABC" Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
 */
public class PermutationsString {
    public static List<String> permute(String s) {
        List<String> res = new ArrayList<String>();
        backtrack(s.toCharArray(), 0, res);
        return res;
    }

    private static void backtrack(char[] s, int start, List<String> res) {
        if (start == s.length) {
            res.add(new String(s));
            return;
        }
        for (int i = start; i < s.length; i++) {
            swap(s, start, i);
            backtrack(s, start + 1, res);
            swap(s, start, i);
        }
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("Permutations of ABC: " + permute("ABC"));
    }
}
