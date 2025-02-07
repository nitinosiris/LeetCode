import java.util.Comparator;
import java.util.PriorityQueue;

public class CellElevation {
    class Solution {
        private static final int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        public int swimInWater(int[][] grid) {
            int n = grid.length;

            // Min-Heap based on the highest elevation encountered so far
            PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.elevation));
            pq.offer(new Cell(grid[0][0], 0, 0));

            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;

            int maxElevation = grid[0][0];

            while (!pq.isEmpty()) {
                Cell cell = pq.poll();
                maxElevation = Math.max(maxElevation, cell.elevation);

                // If we reach the bottom-right cell, return the answer
                if (cell.row == n - 1 && cell.col == n - 1)
                    return maxElevation;

                // Explore all 4 directions
                for (int[] dir : directions) {
                    int newRow = cell.row + dir[0], newCol = cell.col + dir[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                        pq.offer(new Cell(grid[newRow][newCol], newRow, newCol));
                        visited[newRow][newCol] = true;
                    }
                }
            }

            return -1; // This should never be reached
        }
    }

    class Cell {
        int elevation, row, col;

        Cell(int elevation, int row, int col) {
            this.elevation = elevation;
            this.row = row;
            this.col = col;
        }
    }

}
