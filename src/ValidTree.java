import java.util.ArrayList;
import java.util.List;

public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        // A tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        // Create adjacency list for the undirected graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Track visited nodes
        boolean[] visited = new boolean[n];

        // Perform DFS to check for cycles and connectivity
        if (isCyclic(adj, 0, -1, visited)) {
            return false; // Cycle detected
        }

        // Ensure all nodes are visited (graph is connected)
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true; // No cycles and fully connected → valid tree
    }

    private boolean isCyclic(List<List<Integer>> adj, int node, int parent, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclic(adj, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Cycle detected in an undirected graph
            }
        }

        return false;
    }
}
