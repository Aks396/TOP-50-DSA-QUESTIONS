package BacktrackingProblems;

/**
 * Question 3: Word Search
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, int r, int c, String word, int idx) {
        if (idx == word.length())
            return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(idx))
            return false;

        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = backtrack(board, r + 1, c, word, idx + 1) ||
                backtrack(board, r - 1, c, word, idx + 1) ||
                backtrack(board, r, c + 1, word, idx + 1) ||
                backtrack(board, r, c - 1, word, idx + 1);
        board[r][c] = temp;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println("Exists ABCCED: " + exist(board, "ABCCED")); // true
    }
}
