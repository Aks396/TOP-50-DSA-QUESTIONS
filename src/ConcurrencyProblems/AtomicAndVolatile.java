package ConcurrencyProblems;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Question 5: Atomic Classes and Volatile Visibility
 */
public class AtomicAndVolatile {
    private static volatile boolean running = true;
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // Volatile demo: Thread 1 reads 'running', Thread 2 updates it
        Thread reader = new Thread(() -> {
            System.out.println("Reader started...");
            while (running) {
                // Without volatile, a thread might cache the 'running' value infinitely
            }
            System.out.println("Reader stopped because 'running' became false.");
        });

        Thread atomicWorker = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                atomicCount.incrementAndGet();
        });

        reader.start();
        atomicWorker.start();

        Thread.sleep(500);
        System.out.println("Main: Stopping reader by setting volatile flag...");
        running = false;

        atomicWorker.join();
        reader.join();
        System.out.println("Final Atomic Count: " + atomicCount.get());
    }
}
