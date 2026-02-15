package MapProblems;

import java.util.*;

/**
 * Question 5: Largest Subarray with 0 Sum
 */
public class SubarraySumZero {
    public static int find(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxLen = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0)
                maxLen = i + 1;
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println("Max Length: " + find(arr)); // 5 ([-2, 2, -8, 1, 7])
    }
}
