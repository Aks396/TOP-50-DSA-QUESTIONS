package GreedyProblems;

import java.util.*;

/**
 * Question 9: Dijkstra’s Shortest Path (Greedy Strategy)
 * Already implemented in GraphProblems, but re-added here as requested by PDF
 * structure.
 */
public class DijkstraGreedy {
    public static void solve(int[][] graph, int src, int n) {
        int[] dist = new int[n];
        boolean[] spt = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, spt, n);
            spt[u] = true;
            for (int v = 0; v < n; v++) {
                if (!spt[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < n; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    private static int minDistance(int[] dist, boolean[] spt, int n) {
        int min = Integer.MAX_VALUE, minIdx = -1;
        for (int v = 0; v < n; v++)
            if (!spt[v] && dist[v] <= min) {
                min = dist[v];
                minIdx = v;
            }
        return minIdx;
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 } };
        solve(graph, 0, 3); // Test with 3 nodes subset
    }
}
