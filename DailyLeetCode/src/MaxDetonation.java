import java.util.ArrayList;
import java.util.List;

public class MaxDetonation {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(i, new ArrayList<>());

        for(int i = 0; i < n - 1; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(isCenterInside(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1], bombs[i][2]))
                    adj.get(i).add(j);
                if(isCenterInside(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1], bombs[j][2]))
                    adj.get(j).add(i);
            }
        }

        // run dfs on each vertex to check how
        // many vertex it can visit
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            ans = Math.max(ans, dfs(adj, i, new boolean[n]));
        }
        return ans;
    }

    private int dfs(List<List<Integer>> adj, int src, boolean[] visited)
    {
        // mark src as visited;
        visited[src] = true;
        int maxDepth = 1;

        for(var neighbor : adj.get(src))
        {
            if(!visited[neighbor])
            {
                maxDepth += dfs(adj, neighbor, visited);
            }
        }
        return maxDepth;
    }

    public boolean isCenterInside(int x1, int y1, int x2, int y2, int r) {
        // Calculate the distance between the centers
        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Check if the center of the first circle is inside the second circle
        return d <= r;
    }
}
