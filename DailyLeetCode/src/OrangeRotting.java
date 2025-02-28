import java.util.LinkedList;
import java.util.Queue;

public class OrangeRotting {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // Edge case: If no fresh oranges, return 0
        if (freshOranges == 0) return 0;

        // Step 2: BFS traversal
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Rotten now
                        queue.add(new int[]{newRow, newCol});
                        freshOranges--;
                        rotted = true;
                    }
                }
            }

            if (rotted) minutes++; // Increase time only if new oranges rotted
        }

        // If there are fresh oranges left, return -1
        return freshOranges == 0 ? minutes : -1;
    }
}
