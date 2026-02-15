package StackQueueProblems;

import java.util.Stack;

/**
 * Question 40: Largest Rectangle in Histogram
 * Example: Input: [2,1,5,6,2,3] Output: 10
 */
public class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0, i = 0;
        int[] h = new int[heights.length + 1];
        System.arraycopy(heights, 0, h, 0, heights.length);

        while (i < h.length) {
            if (s.isEmpty() || h[s.peek()] <= h[i])
                s.push(i++);
            else {
                int top = s.pop();
                maxArea = Math.max(maxArea, h[top] * (s.isEmpty() ? i : i - s.peek() - 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Max Area: " + largestRectangleArea(heights));
    }
}
