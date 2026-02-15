package ConcurrencyProblems;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Question 4: CountDownLatch, CyclicBarrier, and Semaphore
 */
public class SyncUtilities {

    public static void main(String[] args) throws InterruptedException {
        // 1. Semaphore demo (limiting concurrent access)
        Semaphore semaphore = new Semaphore(2);
        Runnable semTask = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " acquired semaphore.");
                Thread.sleep(1000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " released semaphore.");
            } catch (InterruptedException e) {
            }
        };

        // 2. CountDownLatch demo (waiting for others to finish)
        CountDownLatch latch = new CountDownLatch(3);
        Runnable latchTask = () -> {
            System.out.println("Worker " + Thread.currentThread().getName() + " finished.");
            latch.countDown();
        };

        // Execution
        System.out.println("--- Starting Semaphore Demo ---");
        for (int i = 0; i < 4; i++)
            new Thread(semTask).start();
        Thread.sleep(2500);

        System.out.println("\n--- Starting CountDownLatch Demo ---");
        for (int i = 0; i < 3; i++)
            new Thread(latchTask).start();
        latch.await();
        System.out.println("Master thread: All workers completed.");
    }
}
