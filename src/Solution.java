import java.util.*;

class Solution {
    public int countComponents(int n, int[][] edges) {
        // if all are disconnected
        if(edges.length == 0)
            return n;

        parent = new int[n];
        for(int i = 0; i < n; i++)
        {
            parent[i] = i;
        }




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

    // union find algo
    private int[] parent;




}
