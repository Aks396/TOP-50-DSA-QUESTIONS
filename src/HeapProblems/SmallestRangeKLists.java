package HeapProblems;

import java.util.*;

/**
 * Question 9: Smallest Range Covering Elements from K Lists
 */
public class SmallestRangeKLists {
    public static int[] find(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (a, b) -> nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[] { i, 0 });
            max = Math.max(max, nums.get(i).get(0));
        }
        int start = 0, end = Integer.MAX_VALUE;
        while (pq.size() == nums.size()) {
            int[] curr = pq.poll();
            int i = curr[0], j = curr[1];
            if (max - nums.get(i).get(j) < end - start) {
                start = nums.get(i).get(j);
                end = max;
            }
            if (j + 1 < nums.get(i).size()) {
                pq.add(new int[] { i, j + 1 });
                max = Math.max(max, nums.get(i).get(j + 1));
            }
        }
        return new int[] { start, end };
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        nums.add(Arrays.asList(4, 10, 15));
        nums.add(Arrays.asList(1, 10, 11));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.out.println("Range: " + Arrays.toString(find(nums))); // [10, 15]
    }
}
