package ConcurrencyProblems;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Question 2: Asynchronous Programming with CompletableFuture
 */
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting asynchronous pipeline...");

        CompletableFuture<String> pipeline = CompletableFuture.supplyAsync(() -> {
            simulateWork(1000);
            return "Data from Source";
        }).thenApply(data -> {
            System.out.println("Transforming: " + data);
            return data + " transformed";
        }).thenCompose(transformed -> CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching details for: " + transformed);
            simulateWork(500);
            return transformed + " with Details";
        }));

        // Callback for completion
        pipeline.thenAccept(result -> {
            System.out.println("Pipeline Result: " + result);
        });

        // Block main thread to allow async threads to finish (demo only)
        System.out.println("Main thread continues doing other things...");
        System.out.println("Final Result (blocking wait): " + pipeline.get());
    }

    private static void simulateWork(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
