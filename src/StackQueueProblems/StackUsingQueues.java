package StackQueueProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Question 31: Implement Stack Using Queues
 * Example: Operations: Push, Pop, Top Output: Mimic Stack behavior
 */
public class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty())
            q2.add(q1.remove());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.top()); // 2
        System.out.println("Pop: " + stack.pop()); // 2
    }
}
