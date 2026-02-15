package MapProblems;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Question 2: Check if Array contains Duplicates
 */
public class CheckDuplicates {
    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x))
                return true;
        }
        return false;
    }

    /**
     * Java 8+ Approach
     */
    public static boolean hasDuplicateStream(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println("Java 7: " + hasDuplicate(nums));
        System.out.println("Java 8: " + hasDuplicateStream(nums));
    }
}
