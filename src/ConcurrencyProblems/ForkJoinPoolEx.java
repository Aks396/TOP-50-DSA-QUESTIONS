package ConcurrencyProblems;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Question 10: Fork/Join Framework for Parallel Processing
 */
public class ForkJoinPoolEx extends RecursiveTask<Long> {
    private final int[] arr;
    private final int start, end;
    private static final int THRESHOLD = 1000;

    public ForkJoinPoolEx(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++)
                sum += arr[i];
            return sum;
        }
        int mid = (start + end) / 2;
        ForkJoinPoolEx leftTask = new ForkJoinPoolEx(arr, start, mid);
        ForkJoinPoolEx rightTask = new ForkJoinPoolEx(arr, mid, end);
        leftTask.fork(); // Run asynchronously
        return rightTask.compute() + leftTask.join();
    }

    public static void main(String[] args) {
        int[] data = new int[10000];
        for (int i = 0; i < data.length; i++)
            data[i] = 1;

        ForkJoinPool pool = new ForkJoinPool();
        long result = pool.invoke(new ForkJoinPoolEx(data, 0, data.length));
        System.out.println("Total Parallel Sum: " + result);
    }
}
