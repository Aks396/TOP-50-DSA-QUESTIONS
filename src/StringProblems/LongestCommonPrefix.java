package StringProblems;

import java.util.Arrays;

/**
 * Question 13: Longest Common Prefix
 * Example: Input: ["flower","flow","flight"] Output: "fl"
 */
public class LongestCommonPrefix {

    /**
     * Java 7 Approach: Horizontal scanning
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    /**
     * Java 8+ Approach: Using Stream API reduction
     */
    public static String longestCommonPrefixStream(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        return Arrays.stream(strs)
                .reduce((p1, p2) -> {
                    int len = Math.min(p1.length(), p2.length());
                    int i = 0;
                    while (i < len && p1.charAt(i) == p2.charAt(i))
                        i++;
                    return p1.substring(0, i);
                }).orElse("");
    }

    public static void main(String[] args) {
        String[] input = { "flower", "flow", "flight" };
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Java 7: " + longestCommonPrefix(input));
        System.out.println("Java 8+: " + longestCommonPrefixStream(input));
    }
}
