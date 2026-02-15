package GreedyProblems;

import java.util.*;

/**
 * Question 5: Kruskal’s Algorithm for MST
 */
public class KruskalAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void kruskalMST(int v, List<Edge> edges) {
        Collections.sort(edges);
        int[] parent = new int[v];
        for (int i = 0; i < v; i++)
            parent[i] = i;
        List<Edge> mst = new ArrayList<Edge>();
        for (Edge e : edges) {
            int x = find(parent, e.src);
            int y = find(parent, e.dest);
            if (x != y) {
                mst.add(e);
                union(parent, x, y);
            }
        }
        for (Edge e : mst)
            System.out.println(e.src + " - " + e.dest + ": " + e.weight);
    }

    private static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }

    private static void union(int[] parent, int x, int y) {
        parent[x] = y;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<Edge>();
        // Add edges... for brevity using 4 nodes example
        System.out.println("Kruskal MST:");
        // Placeholder test
    }
}
