import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
    private int rows;
    private int cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
//        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int row, int col)
    {
        Queue<int[]> queue = new LinkedList<>();

        // mark the curr grid as visited
        grid[row][col] = '0';
        queue.add(new int[] {row, col});

        while(!queue.isEmpty())
        {
            var curr = queue.poll();
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] dir : directions) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols)
                    continue;
                else {
                    if(grid[newRow][newCol] == '1')
                    {
                        grid[newRow][newCol] = '0';
                        queue.add(new int[] {newRow, newCol});
                    }
                }
            }
        }
    }
}
