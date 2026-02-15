package MapProblems;

import java.util.*;

/**
 * Question 8: Count Triplets with Given Sum (HashMap implementation)
 */
public class CountTripletsMap {
    public static int count(int[] arr, int target) {
        int count = 0, n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < n; j++) {
                int complement = target - (arr[i] + arr[j]);
                if (map.containsKey(complement))
                    count += map.get(complement);
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 2 };
        System.out.println("Triplets (6): " + count(arr, 6)); // 1 (1,3,2)
    }
}
