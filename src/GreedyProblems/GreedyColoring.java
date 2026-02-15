package GreedyProblems;

import java.util.*;

/**
 * Question 7: Graph Coloring (Greedy Implementation)
 */
public class GreedyColoring {
    public static void color(int v, Map<Integer, List<Integer>> adj) {
        int[] res = new int[v];
        Arrays.fill(res, -1);
        res[0] = 0;
        boolean[] available = new boolean[v];
        Arrays.fill(available, true);
        for (int u = 1; u < v; u++) {
            for (int i : adj.getOrDefault(u, new ArrayList<Integer>())) {
                if (res[i] != -1)
                    available[res[i]] = false;
            }
            int cr;
            for (cr = 0; cr < v; cr++)
                if (available[cr])
                    break;
            res[u] = cr;
            Arrays.fill(available, true);
        }
        for (int u = 0; u < v; u++)
            System.out.println("Vertex " + u + " -> Color " + res[u]);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        adj.put(0, Arrays.asList(1, 2));
        adj.put(1, Arrays.asList(0, 2, 3));
        adj.put(2, Arrays.asList(0, 1, 3));
        adj.put(3, Arrays.asList(1, 2));
        color(4, adj);
    }
}
