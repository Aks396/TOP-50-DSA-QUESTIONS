package SearchSortProblems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Question 5: Kth Smallest Element
 * Example: Input: arr = [7, 10, 4, 3, 20, 15], k = 3 Output: 7
 */
public class KthSmallestElement {
    public static int findKthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(java.util.Collections.reverseOrder());
        for (int x : arr) {
            pq.add(x);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        System.out.println("3rd Smallest: " + findKthSmallest(arr, 3)); // 7
    }
}
