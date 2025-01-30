public class RedundentConnection {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;

        // every element is disjoint
        // everyone is root themselves
        parent = new int[n];
        for(int i = 0; i < n; i++)
        {
            parent[i] = i;
        }
        int[] res = new int[2];
        for(int[] edge : edges)
        {
            // if root of the elements
            // is diff, then do union or add the edge
            if(find(edge[0]) == find(edge[1]))
                res = edge;
            else
                union(edge[0], edge[1]);
        }
        return res;
    }

    // find the root of the given element
    public int find(int i)
    {
        if(parent[i] == i)
            return i;

        return find(parent[i]);
    }


    // union algo
    public void union(int i, int j)
    {
        int pi = find(i);
        int pj = find(j);

        parent[pi] = pj;
    }
}
