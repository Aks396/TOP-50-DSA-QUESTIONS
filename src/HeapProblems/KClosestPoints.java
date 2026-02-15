package HeapProblems;

import java.util.*;

/**
 * Question 6: K Closest Points to Origin
 */
public class KClosestPoints {
    public static int[][] solve(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > k)
                pq.poll();
        }
        int[][] res = new int[k][2];
        while (k > 0)
            res[--k] = pq.poll();
        return res;
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 3 }, { -2, 2 } };
        int[][] res = solve(points, 1);
        System.out.println("Closest Point: [" + res[0][0] + ", " + res[0][1] + "]"); // [-2, 2]
    }
}
