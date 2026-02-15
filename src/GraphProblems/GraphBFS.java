package GraphProblems;

import java.util.*;

/**
 * Question: Breadth-First Search (BFS)
 */
public class GraphBFS {
    public static void bfs(int start, Map<Integer, List<Integer>> adj) {
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(start);
        visited.add(start);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : adj.getOrDefault(node, new ArrayList<Integer>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        adj.put(0, Arrays.asList(1, 2));
        adj.put(1, Arrays.asList(2));
        adj.put(2, Arrays.asList(0, 3));
        adj.put(3, Arrays.asList(3));
        bfs(2, adj);
    }
}
