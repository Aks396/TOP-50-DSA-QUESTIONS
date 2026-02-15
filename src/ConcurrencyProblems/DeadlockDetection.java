package ConcurrencyProblems;

/**
 * Question 9: Deadlock Demonstration and Avoidance
 */
public class DeadlockDetection {
    private static final Object Resource1 = new Object();
    private static final Object Resource2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (Resource1) {
                System.out.println("Thread 1: Locked Resource 1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                System.out.println("Thread 1: Waiting for Resource 2...");
                synchronized (Resource2) {
                    System.out.println("Thread 1: Locked Resource 2");
                }
            }
        });

        // This pattern creates deadlock
        Thread t2 = new Thread(() -> {
            synchronized (Resource2) {
                System.out.println("Thread 2: Locked Resource 2");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                System.out.println("Thread 2: Waiting for Resource 1...");
                synchronized (Resource1) {
                    System.out.println("Thread 2: Locked Resource 1");
                }
            }
        });

        System.out.println("Starting deadlock demo (May hang indefinitely)...");
        // t1.start();
        // t2.start();

        System.out.println("NOTE: To avoid deadlock, always acquire resources in the SAME order across all threads.");
    }
}
