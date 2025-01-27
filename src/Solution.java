class Solution {
    private boolean result = false;
    private int rows;
    private int cols;
    public boolean exist(char[][] board, String word) {

        rows = board.length;
        cols = board[0].length;

        // Visited array to keep track of visited cells
        boolean[][] visited = new boolean[rows][cols];

        // Perform DFS starting from (0, 0)
        return check(board, word, 0, 0, 0, visited);
    }

    private boolean check(char[][] board, String word, int wordIndex, int row, int col, boolean[][] visited)
    {
        if(wordIndex == word.length())
            return true;

        // Mark the current cell as visited
        visited[row][col] = true;
        if(board[row][col] == word.charAt(wordIndex))
        {
            wordIndex++;
            System.out.println("WordCount");
        }


        // Define the 4 possible directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // Check if the new cell is valid, unvisited, and contains 1
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                    board[newRow][newCol] == word.charAt(wordIndex) && !visited[newRow][newCol])
            {
                System.out.println("newRow, newCol : " + newRow + ", " + newCol);
                // Recursively visit the next cell
                if (check(board, word, newRow, newCol, wordIndex, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
