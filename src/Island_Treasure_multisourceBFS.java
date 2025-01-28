import java.util.LinkedList;
import java.util.Queue;

public class Island_Treasure_multisourceBFS {
    private int rows, cols;
    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        bfs(grid);
    }
    private int bfs(int[][] grid)
    {
        // result
        int count = 0;

        // queue for storing
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            // pop the front
            var indexes = queue.poll();
            count++;

            for (int[] dir : directions) {
                int newRow = indexes[0] + dir[0];
                int newCol = indexes[1] + dir[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || grid[newRow][newCol] == -1)
                    continue;
                else {
                    if (grid[newRow][newCol] == 2147483647) {
                        grid[newRow][newCol] = Math.min(grid[indexes[0]][indexes[1]] + 1, grid[newRow][newCol]);
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return count;
    }
}
