package HeapProblems;

import java.util.PriorityQueue;

/**
 * Question 4: Find Median from Data Stream
 */
public class MedianFinder {
    private PriorityQueue<Integer> small = new PriorityQueue<Integer>(java.util.Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<Integer>();

    public void addNum(int num) {
        small.add(num);
        large.add(small.poll());
        if (large.size() > small.size())
            small.add(large.poll());
    }

    public double findMedian() {
        if (small.size() > large.size())
            return small.peek();
        return (small.peek() + large.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median (1,2): " + mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println("Median (1,2,3): " + mf.findMedian()); // 2.0
    }
}
