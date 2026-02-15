package GreedyProblems;

import java.util.*;

/**
 * Question 4: Prim’s Algorithm for MST
 */
public class PrimAlgorithm {
    public static void primMST(int[][] graph, int n) {
        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] mstSet = new boolean[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < n - 1; count++) {
            int u = minKey(key, mstSet, n);
            mstSet[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph, n);
    }

    private static int minKey(int[] key, boolean[] mstSet, int n) {
        int min = Integer.MAX_VALUE, minIdx = -1;
        for (int v = 0; v < n; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIdx = v;
            }
        return minIdx;
    }

    private static void printMST(int[] parent, int[][] graph, int n) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < n; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        primMST(graph, 5);
    }
}
