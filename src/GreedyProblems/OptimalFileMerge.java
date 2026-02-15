package GreedyProblems;

import java.util.PriorityQueue;

/**
 * Question 8: Optimal File Merge Patterns
 */
public class OptimalFileMerge {
    public static int minCost(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int f : files)
            pq.add(f);
        int cost = 0;
        while (pq.size() > 1) {
            int merge = pq.poll() + pq.poll();
            cost += merge;
            pq.add(merge);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] files = { 2, 3, 4, 5, 6, 7 };
        System.out.println("Min Merge Cost: " + minCost(files));
    }
}
