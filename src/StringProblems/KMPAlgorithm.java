package StringProblems;

import java.util.Arrays;

/**
 * Question 19: KMP Algorithm for Pattern Searching
 * Example: Text: "abxabcabcaby", Pattern: "abcaby" Output: 6 (Start index)
 */
public class KMPAlgorithm {

    /**
     * Java 7 Approach: KMP with LPS array
     */
    public static int search(String text, String pat) {
        int M = pat.length();
        int N = text.length();
        int[] lps = computeLPSArray(pat);

        int i = 0; // index for text
        int j = 0; // index for pat
        while (i < N) {
            if (pat.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                return i - j;
            } else if (i < N && pat.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return -1;
    }

    private static int[] computeLPSArray(String pat) {
        int M = pat.length();
        int[] lps = new int[M];
        int len = 0, i = 1;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * Java 8+ Approach: Java 8 doesn't change the algorithm,
     * but we can use IntStream for LPS computation if we want to be fancy.
     */
    public static int searchStream(String text, String pat) {
        // Core KMP is sequential, so standard implementation is best.
        return search(text, pat);
    }

    public static void main(String[] args) {
        String text = "abxabcabcaby";
        String pat = "abcaby";
        System.out.println("Text: " + text + ", Pattern: " + pat);
        System.out.println("Java 7 Index: " + search(text, pat));
        System.out.println("Java 8+ Index: " + searchStream(text, pat));
    }
}
