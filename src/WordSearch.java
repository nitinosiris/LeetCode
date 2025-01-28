public class WordSearch {
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        // Iterate through all cells to start DFS
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Start DFS if the current cell matches the first character
                if (board[row][col] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    if (check(board, word, 0, row, col, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int wordIndex, int row, int col, boolean[][] visited) {
        // Base case: if we've matched the entire word
        if (wordIndex == word.length()) {
            return true;
        }

        // Check bounds and validity
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || board[row][col] != word.charAt(wordIndex)) {
            return false;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        // Define the 4 possible directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Recursively visit neighbors
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (check(board, word, wordIndex + 1, newRow, newCol, visited)) {
                return true;
            }
        }

        // Backtrack: unmark the current cell
        visited[row][col] = false;

        return false;
    }
}
