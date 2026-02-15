package HeapProblems;

import java.util.PriorityQueue;

/**
 * Question 1: Kth Largest Element in an Array
 */
public class KthLargest {
    public static int find(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        System.out.println("4th Largest: " + find(nums, 4)); // 4
    }
}
