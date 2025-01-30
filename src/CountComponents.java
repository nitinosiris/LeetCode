import java.util.HashMap;
import java.util.List;

public class CountComponents {
    // union find algo
    private int[] parent;

    // Find the representative (root) of the
    // set that includes element i
    public int find(int i) {

        // if i itself is root or representative
        if (parent[i] == i) {
            return i;
        }

        // Else recursively find the representative
        // of the parent
        return find(parent[i]);
    }

    public void union(int i, int j)
    {
        int parent_i = find(i);
        int parent_j = find(j);

        parent[parent_i] = parent_j;
    }


    public int countComponents(int n, int[][] edges) {
        // if all are disconnected
        if(edges.length == 0)
            return n;

        parent = new int[n];
        // Initialize the parent array with each
        // element as its own representative
        for(int i = 0; i < n; i++)
        {
            parent[i] = i;
        }

        // add edges
        for(int[] edge : edges)
        {
            union(edge[0], edge[1]);
        }

        // count how many roots are there
        int count = 0;

        for(int i = 0; i < n; i++)
            if(parent[i] == i)
                count++;

        return count;


//        // Create adjacency list for the undirected graph
//        List<List<Integer>> adj = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            adj.add(new ArrayList<>());
//        }
//
//        // populate the graph
//        for(int[] edge : edges)
//        {
//            adj.get(edge[0]).add(edge[1]);
//            adj.get(edge[1]).add(edge[0]);
//        }
//
//        // visited array to track
//        HashMap<Integer, Integer> visited = new HashMap<>();
//
//        int i = 0;
//        int count = 0;
//        while(visited.size() != n)
//        {
//            while(visited.containsKey(i))
//                i++;
//            dfs(adj, i, visited);
//            count++;
//        }
//        return count;
    }

    private void dfs(List<List<Integer>> adj, int v, HashMap<Integer, Integer> visited)
    {
        visited.put(v, v);

        for(int neighbor : adj.get(v))
        {
            if(!visited.containsKey(neighbor))
                dfs(adj, neighbor, visited);
        }
    }
}
