package ArrayProblems;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Question 9: Trapping Rain Water
 * Example: Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 */
public class TrappingRainWater {

    /**
     * Java 7 Approach: Left and Right max arrays
     */
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }

    /**
     * Java 8+ Approach: Using Stream API
     */
    public static int trapStream(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        IntStream.range(0, n).forEach(i -> leftMax[i] = (i == 0) ? height[0] : Math.max(leftMax[i - 1], height[i]));
        for (int i = n - 1; i >= 0; i--)
            rightMax[i] = (i == n - 1) ? height[n - 1] : Math.max(rightMax[i + 1], height[i]);

        return IntStream.range(0, n)
                .map(i -> Math.min(leftMax[i], rightMax[i]) - height[i])
                .sum();
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Input: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]");
        System.out.println("Java 7 Trapped: " + trap(height));
        System.out.println("Java 8+ Trapped: " + trapStream(height));
    }
}
