package ArrayQuestion;

import java.util.Arrays;

/**
 * Question: Find the Largest Sum Contiguous Subarray (Kadane’s Algorithm)
 * Example: Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4] 
 * Output: 6 (Subarray: [4, -1, 2, 1])
 */
public class KadaneAlgorithm {

    /**
     * Java 7 Approach: Iterative Kadane's Algorithm
     */
    public static int findMaxSubarraySum(int[] arr) {
        int maxSoFar = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    /**
     * Java 8+ Approach: Using Stream API (though Kadane is inherently iterative)
     * We can use reduce to maintain state.
     */
    public static int findMaxSubarraySumStream(int[] arr) {
        // State to keep track of max so far and current max
        class State {
            int maxSoFar = Integer.MIN_VALUE;
            int currentMax = 0;
            
            State accept(int val) {
                currentMax = Math.max(val, currentMax + val);
                maxSoFar = Math.max(maxSoFar, currentMax);
                return this;
            }
            
            State combine(State other) {
                // Not strictly needed for sequential stream, but required for combine
                return this;
            }
        }
        
        return Arrays.stream(arr)
                .boxed()
                .reduce(new State(), State::accept, State::combine)
                .maxSoFar;
    }

    public static void main(String[] args) {
        int[] data = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Java 7 Max Sum: " + findMaxSubarraySum(data));
        System.out.println("Java 8+ Max Sum: " + findMaxSubarraySumStream(data));
    }
}
