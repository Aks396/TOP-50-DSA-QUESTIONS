package StackQueueProblems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Question 38: Sliding Window Maximum
 * Example: Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7]
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peek() < i - k + 1)
                dq.poll();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            dq.offer(i);
            if (i >= k - 1)
                res[i - k + 1] = nums[dq.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
