import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DAG_MaxPath {
    /*
    given a DAG , find the maximum path distance it can go upto any node
    It means from any node to any other node, what is the max distance
    */
    public int maxDistDAG(int n, int[][] edges)
    {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(var edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            inDegree[v]++;

            adj.get(u).add(v);
        }

        // node, dist
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++)
            if(inDegree[i] == 0)
                q.add(new int[] {i, 0});


        int ans = 0;

        while(!q.isEmpty())
        {
            var curr = q.poll();

            int node = curr[0];
            int dist = curr[1];

            ans = Math.max(ans, dist);

            for(var neighbor : adj.get(node))
                q.add(new int[] {neighbor, 1 + dist});
        }

        return ans;
    }
}
