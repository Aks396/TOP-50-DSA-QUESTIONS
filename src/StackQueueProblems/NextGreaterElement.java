package StackQueueProblems;

import java.util.Arrays;
import java.util.Stack;

/**
 * Question 33: Next Greater Element
 * Example: Input: [4,5,2,25] Output: [5,25,25,-1]
 */
public class NextGreaterElement {

    public static int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = { 4, 5, 2, 25 };
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + Arrays.toString(nextGreater(input)));
    }
}
