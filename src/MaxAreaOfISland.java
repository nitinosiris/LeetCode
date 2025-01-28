import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfISland {
    private int rows, cols;
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int result = 0;

        for(int i =  0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 1)
                {
                    result = Math.max(bfs(grid, i, j), result);
                }
            }
        }
        return result;
    }
    private int bfs(int[][] grid, int i, int j)
    {
        // result
        int count = 0;

        // queue for storing
        Queue<int[]> queue = new LinkedList<>();

        // mark the source as visited
        grid[i][j] = 0;
        queue.add(new int[]{i, j});

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            // pop the front
            var indexes = queue.poll();
            count++;

            for (int[] dir : directions) {
                int newRow = indexes[0] + dir[0];
                int newCol = indexes[1] + dir[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols)
                    continue;
                else {
                    if (grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 0;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return count;
    }
}
