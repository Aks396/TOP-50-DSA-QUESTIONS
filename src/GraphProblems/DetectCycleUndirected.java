package GraphProblems;

import java.util.*;

/**
 * Question: Detect Cycle in an Undirected Graph
 */
public class DetectCycleUndirected {
    public static boolean hasCycle(int n, Map<Integer, List<Integer>> adj) {
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                if (isCyclic(i, -1, adj, visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean isCyclic(int v, int parent, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        visited.add(v);
        for (int neighbor : adj.getOrDefault(v, new ArrayList<Integer>())) {
            if (!visited.contains(neighbor)) {
                if (isCyclic(neighbor, v, adj, visited))
                    return true;
            } else if (neighbor != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        adj.put(0, Arrays.asList(1));
        adj.put(1, Arrays.asList(0, 2));
        adj.put(2, Arrays.asList(1, 0)); // Cycle 0-1-2-0
        System.out.println("Has Cycle: " + hasCycle(3, adj)); // true
    }
}
