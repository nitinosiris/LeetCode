public class LongestIncreasingPathInMatrix {
    private int rows, cols;
    private int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        rows = matrix.length;
        cols = matrix[0].length;
        dp = new int[rows][cols]; // DP array to store results of subproblems
        int result = 0;

        // Start DFS from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Calculate longest path starting from cell (i, j) if not already computed
                if (dp[i][j] == 0) {
                    result = Math.max(result, dfs(matrix, i, j));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j) {
        // If the result for this cell is already computed, return it
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        // Initialize the length of the longest path starting from (i, j)
        int maxLength = 1; // We count the current cell

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Explore all four directions
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            // Check if the new position is within bounds and has a larger value
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                    && grid[newRow][newCol] > grid[i][j]) {

                // Recursively find the longest path from the neighbor
                maxLength = Math.max(maxLength, 1 + dfs(grid, newRow, newCol));
            }
        }

        // Store the result in the DP array
        dp[i][j] = maxLength;
        return maxLength;
    }
}
