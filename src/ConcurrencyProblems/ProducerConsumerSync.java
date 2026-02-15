package ConcurrencyProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Question 6: Producer-Consumer using Wait and Notify
 */
public class ProducerConsumerSync {
    private static final int CAPACITY = 5;
    private final Queue<Integer> queue = new LinkedList<Integer>();

    public void produce() throws InterruptedException {
        int val = 0;
        while (true) {
            synchronized (this) {
                while (queue.size() == CAPACITY)
                    wait();
                System.out.println("Produced: " + val);
                queue.add(val++);
                notifyAll();
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == 0)
                    wait();
                int val = queue.poll();
                System.out.println("Consumed: " + val);
                notifyAll();
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerSync pc = new ProducerConsumerSync();
        new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
            }
        }).start();

        new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
            }
        }).start();
    }
}
