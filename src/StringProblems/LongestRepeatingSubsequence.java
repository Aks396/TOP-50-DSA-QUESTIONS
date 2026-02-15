package StringProblems;

/**
 * Question 18: Longest Repeating Subsequence
 * Example: Input: "AABEBCDD" Output: "ABD" (Length 3)
 */
public class LongestRepeatingSubsequence {

    /**
     * Java 7 Approach: Dynamic Programming
     */
    public static int findLRS(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    /**
     * Java 8+ Approach: Logic remains DP, but we can wrap it.
     */
    public static int findLRSStream(String s) {
        // DP is inherently iterative, but we'll use a functional-style setup
        final int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        java.util.stream.IntStream.rangeClosed(1, n)
                .forEach(i -> java.util.stream.IntStream.rangeClosed(1, n).forEach(j -> {
                    if (s.charAt(i - 1) == s.charAt(j - 1) && i != j)
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }));
        return dp[n][n];
    }

    public static void main(String[] args) {
        String input = "AABEBCDD";
        System.out.println("Input: " + input);
        System.out.println("Java 7 LRS Length: " + findLRS(input));
        System.out.println("Java 8+ LRS Length: " + findLRSStream(input));
    }
}
