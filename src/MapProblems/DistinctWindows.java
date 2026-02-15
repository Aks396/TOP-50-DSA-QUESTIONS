package MapProblems;

import java.util.*;

/**
 * Question 10: Count Distinct Elements in every window of size K
 */
public class DistinctWindows {
    public static List<Integer> count(int[] arr, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (i >= k - 1) {
                res.add(map.size());
                int left = arr[i - k + 1];
                if (map.get(left) == 1)
                    map.remove(left);
                else
                    map.put(left, map.get(left) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
        System.out.println("Count (k=4): " + count(arr, 4)); // [3, 4, 4, 3]
    }
}
