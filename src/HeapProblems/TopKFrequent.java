package HeapProblems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Question 2: Top K Frequent Elements
 */
public class TopKFrequent {
    public static int[] solve(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));
        for (int n : map.keySet()) {
            pq.add(n);
            if (pq.size() > k)
                pq.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = pq.poll();
        return res;
    }

    /**
     * Java 8+ Approach
     */
    public static List<Integer> solveStream(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(java.util.function.Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .map(java.util.Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        System.out.println("Java 7 Top 2: " + Arrays.toString(solve(nums, 2)));
        System.out.println("Java 8 Top 2: " + solveStream(nums, 2));
    }
}
