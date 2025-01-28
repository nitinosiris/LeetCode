import java.util.LinkedList;
import java.util.Queue;

public class RottenFruits {
    private int rows, cols;

    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        // Check if there are no fresh fruits to rot
        boolean hasFresh = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    hasFresh = true;
                    break;
                }
            }
        }
        if (!hasFresh) return 0;  // No fresh fruits to rot, so return 0

        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all the rotten fruits
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // If there are no rotten fruits and the grid contains fresh fruits, return -1
        if (queue.isEmpty()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = -1;

        // BFS to rot the adjacent fresh fruits
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : directions) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];
                    if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || grid[newRow][newCol] != 1)
                        continue;

                    grid[newRow][newCol] = 2; // Rot the fresh fruit
                    queue.add(new int[]{newRow, newCol});
                }
            }
            minutes++;
        }

        // Check if there are still fresh fruits left
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1; // If any fresh fruit is left, return -1
                }
            }
        }

        return minutes;
    }
}
