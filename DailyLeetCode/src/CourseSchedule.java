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
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCyclic(adj, i, visited, recStack)) {
                return false; // Cycle detected → not possible to finish all courses
            }
        }
        return true;
    }

    private boolean isCyclic(List<List<Integer>> adj, int node, boolean[] visited, boolean[] recStack)
    {
        // cycle
        if (recStack[node])
            return true;

        // already processed, no cycle
        if (visited[node])
            return false;

        // Mark as visited and add to recursion stack
        visited[node] = true;
        recStack[node] = true;

        for(int neighbor : adj.get(node))
        {
            if(isCyclic(adj, neighbor, visited, recStack))
                return true;
        }

        recStack[node] = false;
        return false;
    }
}
