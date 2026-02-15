package ConcurrencyProblems;

/**
 * Question 8: Race Condition and Thread Safety Demonstration
 */
public class ThreadSafetyDemo {
    private int unsafeCount = 0;
    private int safeCount = 0;

    public void incrementUnsafe() {
        unsafeCount++; // Read-Modify-Write (Not atomic)
    }

    public synchronized void incrementSafe() {
        safeCount++;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafetyDemo demo = new ThreadSafetyDemo();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                demo.incrementUnsafe();
                demo.incrementSafe();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Unsafe Count (Expected 20000, but usually less): " + demo.unsafeCount);
        System.out.println("Final Safe Count (Expected 20000): " + demo.safeCount);
    }
}
