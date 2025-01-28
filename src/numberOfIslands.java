import java.util.LinkedList;
import java.util.Queue;

public class numberOfIslands {
    private int rows;
    private int cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int result = 0;
        boolean[][] visited = new boolean[rows][cols];

        for(int i =  0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(visited[i][j] == false && grid[i][j] == '1')
                {
                    result++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int i, int j, boolean[][] visited)
    {
        // queue for storing
        Queue<int[]> queue = new LinkedList<>();

        // mark the source as visited
        visited[i][j] = true;
        queue.add(new int[]{i, j});

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty())
        {
            // pop the front
            var indexes = queue.poll();

            for (int[] dir : directions) {
                int newRow = indexes[0] + dir[0];
                int newCol = indexes[1] + dir[1];

                if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols)
                    continue;
                else {
                    if(!visited[newRow][newCol] && grid[newRow][newCol] == '1')
                    {
                        visited[newRow][newCol] = true;
                        queue.add(new int[] {newRow, newCol});
                    }
                }
            }
        }
    }
}
