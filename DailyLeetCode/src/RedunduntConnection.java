public class RedunduntConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int vertices = edges.length + 1;

        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        for(int i = 0; i < vertices; i++)
        {
            parent[i] = i;
        }

        int[] res = new int[] {0, 0};;
        for(var edge : edges)
        {
            if(find(edge[0], parent) == find(edge[1], parent))
                res = new int[] {edge[0], edge[1]};

            unionByRank(edge[0], edge[1], parent, rank);
        }
        return res;
    }

    private int find(int x, int[] parent)
    {
        int root = parent[x];

        if(parent[root] != root)
            return parent[x] = find(root, parent);

        return root;
    }

    private void unionByRank(int x, int y, int[] parent, int[] rank)
    {
        int xRoot = find(x, parent), yRoot = find(y, parent);

        if(xRoot == yRoot)
            return;

        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else
        {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
