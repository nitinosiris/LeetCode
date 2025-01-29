public class surroundedRegions {
    private int rows, cols;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        rows = board.length;
        cols = board[0].length;

        // Step 1: Mark border-connected 'O's
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
        }

        // Step 2 & 3: Convert 'O' -> 'X', 'T' -> 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') return;

        board[row][col] = 'T';

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
