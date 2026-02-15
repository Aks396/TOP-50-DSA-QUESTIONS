package GraphProblems;

import java.util.*;

/**
 * Question: Dijkstra’s Shortest Path Algorithm
 */
public class DijkstraAlgorithm {
    static class Edge {
        int target, weight;

        Edge(int t, int w) {
            target = t;
            weight = w;
        }
    }

    public static int[] dijkstra(int n, Map<Integer, List<Edge>> adj, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        pq.add(new int[] { src, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            if (curr[1] > dist[u])
                continue;
            for (Edge e : adj.getOrDefault(u, new ArrayList<Edge>())) {
                if (dist[u] + e.weight < dist[e.target]) {
                    dist[e.target] = dist[u] + e.weight;
                    pq.add(new int[] { e.target, dist[e.target] });
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> adj = new HashMap<Integer, List<Edge>>();
        adj.put(0, Arrays.asList(new Edge(1, 4), new Edge(2, 1)));
        adj.put(2, Arrays.asList(new Edge(1, 2)));
        int[] dists = dijkstra(3, adj, 0);
        System.out.println("Distances from 0: " + Arrays.toString(dists)); // [0, 3, 1]
    }
}
