package ArrayProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Question 4: Find the Duplicate Number
 * Example: Input: [1,3,4,2,2] Output: 2
 */
public class FindDuplicateNumber {

    /**
     * Java 7 Approach: Using HashSet
     */
    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }

    /**
     * Java 8+ Approach: Using Stream API with a temporary set
     */
    public static int findDuplicateStream(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(nums)
                .filter(n -> !seen.add(n))
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println("Input: [1, 3, 4, 2, 2]");
        System.out.println("Java 7 Duplicate: " + findDuplicate(nums));
        System.out.println("Java 8+ Duplicate: " + findDuplicateStream(nums));
    }
}
