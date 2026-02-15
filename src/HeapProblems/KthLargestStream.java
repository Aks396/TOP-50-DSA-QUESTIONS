package HeapProblems;

import java.util.PriorityQueue;

/**
 * Question 8: Kth Largest Element in a Stream
 */
public class KthLargestStream {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargestStream(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<Integer>();
        for (int n : nums)
            add(n);
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k)
            pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestStream kls = new KthLargestStream(3, new int[] { 4, 5, 8, 2 });
        System.out.println("Add 3: " + kls.add(3)); // 4
        System.out.println("Add 5: " + kls.add(5)); // 5
    }
}
