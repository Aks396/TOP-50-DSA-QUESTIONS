package GraphProblems;

import java.util.*;

/**
 * Question: Depth-First Search (DFS)
 */
public class GraphDFS {
    public static void dfs(int start, Map<Integer, List<Integer>> adj) {
        Set<Integer> visited = new HashSet<Integer>();
        System.out.print("DFS: ");
        dfsRecursive(start, adj, visited);
        System.out.println();
    }

    private static void dfsRecursive(int node, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");
        for (int neighbor : adj.getOrDefault(node, new ArrayList<Integer>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        adj.put(0, Arrays.asList(1, 2));
        adj.put(1, Arrays.asList(2));
        adj.put(2, Arrays.asList(0, 3));
        adj.put(3, Arrays.asList(3));
        dfs(2, adj);
    }
}
