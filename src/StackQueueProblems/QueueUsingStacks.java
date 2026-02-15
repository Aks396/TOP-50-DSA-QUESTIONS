package StackQueueProblems;

import java.util.Stack;

/**
 * Question 32: Implement Queue Using Stacks
 * Example: Operations: Enqueue, Dequeue Output: Mimic Queue behavior
 */
public class QueueUsingStacks {
    private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> s2 = new Stack<Integer>();

    public void enqueue(int x) {
        s1.push(x);
    }

    public int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(1);
        q.enqueue(2);
        System.out.println("Dequeue: " + q.dequeue()); // 1
    }
}
