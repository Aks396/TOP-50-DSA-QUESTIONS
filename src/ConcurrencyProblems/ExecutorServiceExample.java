package ConcurrencyProblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Question 1: Managing Thread Pools with ExecutorService
 */
public class ExecutorServiceExample {

    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Processing Task " + taskId + " on thread: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000); // Simulate work
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // Proper shutdown sequence
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("All tasks finished.");
    }
}
