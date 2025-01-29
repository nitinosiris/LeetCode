import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list for the directed graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]); // Directed edge: edge[1] → edge[0]
        }

        // Arrays to track visited nodes and recursion stack
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        // Check for cycles using DFS
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCyclic(adj, i, visited, recStack)) {
                return false; // Cycle detected → not possible to finish all courses
            }
        }
        return true;
    }

    private boolean isCyclic(List<List<Integer>> adj, int node, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return true; // Cycle detected

        if (visited[node]) return false; // Already processed, no cycle

        // Mark as visited and add to recursion stack
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (isCyclic(adj, neighbor, visited, recStack)) {
                return true;
            }
        }

        // Remove from recursion stack after processing
        recStack[node] = false;
        return false;
    }
}
