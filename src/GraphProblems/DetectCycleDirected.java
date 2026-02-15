package GraphProblems;

import java.util.*;

/**
 * Question: Detect Cycle in a Directed Graph
 */
public class DetectCycleDirected {
    public static boolean hasCycle(int n, Map<Integer, List<Integer>> adj) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> recStack = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (isCyclic(i, adj, visited, recStack))
                return true;
        }
        return false;
    }

    private static boolean isCyclic(int i, Map<Integer, List<Integer>> adj, Set<Integer> visited,
            Set<Integer> recStack) {
        if (recStack.contains(i))
            return true;
        if (visited.contains(i))
            return false;

        visited.add(i);
        recStack.add(i);
        for (int neighbor : adj.getOrDefault(i, new ArrayList<Integer>())) {
            if (isCyclic(neighbor, adj, visited, recStack))
                return true;
        }
        recStack.remove(i);
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        adj.put(0, Arrays.asList(1));
        adj.put(1, Arrays.asList(2));
        adj.put(2, Arrays.asList(0));
        System.out.println("Has Cycle: " + hasCycle(3, adj)); // true
    }
}
