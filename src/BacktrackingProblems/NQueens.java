package BacktrackingProblems;

import java.util.*;

/**
 * Question 1: N-Queens Problem
 */
public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
        backtrack(res, board, 0);
        return res;
    }

    private static void backtrack(List<List<String>> res, char[][] board, int col) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 'Q';
                backtrack(res, board, col + 1);
                board[i][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 'Q')
                return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--)
            if (board[i][j] == 'Q')
                return false;
        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++)
            res.add(new String(board[i]));
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Solutions for 4x4: " + solveNQueens(4).size());
    }
}
