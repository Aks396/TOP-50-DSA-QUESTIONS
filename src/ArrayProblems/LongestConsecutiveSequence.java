package ArrayProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Question 8: Longest Consecutive Sequence
 * Example: Input: [100,4,200,1,3,2] Output: 4
 */
public class LongestConsecutiveSequence {

    /**
     * Java 7 Approach: Using HashSet for O(n) search
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums)
            set.add(n);

        int maxLen = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int curr = n;
                int currLen = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    currLen++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }

    /**
     * Java 8+ Approach: Using Stream API to build set
     */
    public static int longestConsecutiveStream(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        return set.stream()
                .filter(n -> !set.contains(n - 1))
                .mapToInt(n -> {
                    int curr = n;
                    int count = 1;
                    while (set.contains(++curr))
                        count++;
                    return count;
                })
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Input: [100, 4, 200, 1, 3, 2]");
        System.out.println("Java 7 Longest: " + longestConsecutive(nums));
        System.out.println("Java 8+ Longest: " + longestConsecutiveStream(nums));
    }
}
