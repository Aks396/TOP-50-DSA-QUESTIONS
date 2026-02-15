package StringProblems;

/**
 * Question 11: Longest Palindromic Substring
 * Example: Input: "babad" Output: "bab" or "aba"
 */
public class LongestPalindromicSubstring {

    /**
     * Java 7 Approach: Expand around center
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * Java 8+ Approach: Using Stream API (wrapping logic)
     */
    public static String longestPalindromeStream(String s) {
        if (s == null || s.length() < 1)
            return "";
        // Functional logic is tricky for "expand around center",
        // but we can use IntStream to find the best indices.
        return java.util.stream.IntStream.range(0, s.length())
                .boxed()
                .flatMap(i -> java.util.stream.Stream.of(
                        new int[] { i, i },
                        new int[] { i, i + 1 }))
                .map(range -> {
                    int l = range[0], r = range[1];
                    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                        l--;
                        r++;
                    }
                    return s.substring(l + 1, r);
                })
                .max(java.util.Comparator.comparingInt(String::length))
                .orElse("");
    }

    public static void main(String[] args) {
        String input = "babad";
        System.out.println("Input: " + input);
        System.out.println("Java 7 Output: " + longestPalindrome(input));
        System.out.println("Java 8+ Output: " + longestPalindromeStream(input));
    }
}
