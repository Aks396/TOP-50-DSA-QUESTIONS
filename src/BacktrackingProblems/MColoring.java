package BacktrackingProblems;

/**
 * Question 10: Solve the M-Coloring Problem
 */
public class MColoring {
    public static boolean solve(int[][] graph, int m, int n) {
        int[] color = new int[n];
        return backtrack(graph, m, color, 0, n);
    }

    private static boolean backtrack(int[][] graph, int m, int[] color, int v, int n) {
        if (v == n)
            return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c, n)) {
                color[v] = c;
                if (backtrack(graph, m, color, v + 1, n))
                    return true;
                color[v] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int v, int[][] graph, int[] color, int c, int n) {
        for (int i = 0; i < n; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 } };
        System.out.println("Can color with 3: " + solve(graph, 3, 4)); // true
    }
}
