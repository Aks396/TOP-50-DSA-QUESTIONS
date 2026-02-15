package BacktrackingProblems;

/**
 * Question 7: Rat in a Maze
 */
public class RatInAMaze {
    public static void solve(int[][] maze, int n) {
        int[][] res = new int[n][n];
        if (backtrack(maze, 0, 0, res, n)) {
            print(res, n);
        } else
            System.out.println("No solution");
    }

    private static boolean backtrack(int[][] maze, int r, int c, int[][] res, int n) {
        if (r == n - 1 && c == n - 1) {
            res[r][c] = 1;
            return true;
        }
        if (r >= 0 && c >= 0 && r < n && c < n && maze[r][c] == 1) {
            res[r][c] = 1;
            if (backtrack(maze, r + 1, c, res, n))
                return true;
            if (backtrack(maze, r, c + 1, res, n))
                return true;
            res[r][c] = 0;
            return false;
        }
        return false;
    }

    private static void print(int[][] res, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(res[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
        solve(maze, 4);
    }
}
