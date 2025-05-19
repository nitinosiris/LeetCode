import java.util.HashSet;
import java.util.Set;

public class UniqPaths {
    int[][] directions = new int[][] {{0, 1}, {-1, 1}, {1, 1}};
    int rows, cols;
    int ans = 0;
    public int uniquePaths(int n, int m)
    {
        rows = n; cols = m;
        backtrack(n - 1, 0, new HashSet<>(), new HashSet<>());
        return ans;
    }

    public void backtrack(int x, int y, HashSet<String> visited, Set<String> checkpoints)
    {
        String pos = x + "," + y;
        visited.add(pos);

        if (x == rows - 1 && y == cols - 1)
        {
            if (visited.containsAll(checkpoints))
            {
                ans++;
            }
        }
        else
        {
            for (var dir : directions)
            {
                int nx = x + dir[0], ny = y + dir[1];
                String nextPos = nx + "," + ny;

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited.contains(nextPos)) {
                    backtrack(nx, ny, visited, checkpoints);
                }
            }
        }

        visited.remove(pos);  // backtrack cleanup
    }
}
