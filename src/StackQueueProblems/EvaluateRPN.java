package StackQueueProblems;

import java.util.Stack;

/**
 * Question 36: Evaluate Reverse Polish Notation
 * Example: Input: ["2","1","+","3","*"] Output: 9
 */
public class EvaluateRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : tokens) {
            if ("+".equals(s))
                stack.push(stack.pop() + stack.pop());
            else if ("-".equals(s)) {
                int b = stack.pop();
                stack.push(stack.pop() - b);
            } else if ("*".equals(s))
                stack.push(stack.pop() * stack.pop());
            else if ("/".equals(s)) {
                int b = stack.pop();
                stack.push(stack.pop() / b);
            } else
                stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println("Output: " + evalRPN(tokens));
    }
}
