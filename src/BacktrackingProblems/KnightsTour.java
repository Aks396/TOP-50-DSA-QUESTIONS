package BacktrackingProblems;

/**
 * Question 9: Knight's Tour Problem
 */
public class KnightsTour {
    public static void solve(int n) {
        int[][] sol = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sol[i][j] = -1;
        int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };
        sol[0][0] = 0;
        if (backtrack(0, 0, 1, sol, xMove, yMove, n))
            print(sol, n);
        else
            System.out.println("No solution");
    }

    private static boolean backtrack(int x, int y, int movei, int[][] sol, int[] xMove, int[] yMove, int n) {
        if (movei == n * n)
            return true;
        for (int k = 0; k < 8; k++) {
            int next_x = x + xMove[k];
            int next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol, n)) {
                sol[next_x][next_y] = movei;
                if (backtrack(next_x, next_y, movei + 1, sol, xMove, yMove, n))
                    return true;
                else
                    sol[next_x][next_y] = -1;
            }
        }
        return false;
    }

    private static boolean isSafe(int x, int y, int[][] sol, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n && sol[x][y] == -1);
    }

    private static void print(int[][] sol, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(sol[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve(8); // This might take time for 8x8, usually tested with 5x5 or 6x6
    }
}
