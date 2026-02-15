package StackQueueProblems;

/**
 * Question 37: Circular Queue Implementation
 */
public class CircularQueue {
    private int[] data;
    private int head, tail, size;

    public CircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        if (isEmpty())
            head = 0;
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else
            head = (head + 1) % size;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);
        cq.enQueue(1);
        cq.enQueue(2);
        cq.enQueue(3);
        System.out.println("Full: " + cq.isFull());
        cq.deQueue();
        cq.enQueue(4);
        System.out.println("Rear: " + cq.Rear()); // 4
    }
}
