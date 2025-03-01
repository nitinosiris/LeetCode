import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adj = new ArrayList<>();
            int[] inDegree = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] course : prerequisites) {
                adj.get(course[1]).add(course[0]);
                inDegree[course[0]]++;
            }

//        // Queue for BFS (Start with courses having in-degree 0)
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (inDegree[i] == 0) {
//                queue.add(i);
//            }
//        }
//
//        // Topological Sorting
//        int[] result = new int[numCourses];
//        int index = 0;
//        while (!queue.isEmpty()) {
//            int course = queue.poll();
//            result[index++] = course;
//
//            // Reduce in-degree for dependent courses
//            for (int neighbor : adj.get(course)) {
//                inDegree[neighbor]--;
//                if (inDegree[neighbor] == 0) {
//                    queue.add(neighbor);
//                }
//            }
//        }


            boolean[] visited = new boolean[numCourses];
            boolean[] recStack = new boolean[numCourses];

            // detect cycles
            for(int i = 0; i < numCourses; i++) {
                if(isCyclic(adj, i, visited, recStack)) {
                    return new int[0];
                }
            }

            // topological sort
            Stack<Integer> st = new Stack<>();
            Arrays.fill(visited, false);

            for(int i = 0; i < numCourses; i++)
            {
                if(!visited[i])
                    topoLogicalSortUtil(adj, i, visited, st);
            }

            ArrayList<Integer> ans = new ArrayList<>();
            // Append contents of stack
            while (!st.isEmpty()) {
                ans.add(st.pop());
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        private void topoLogicalSortUtil(List<List<Integer>> adj, int node, boolean[] visited, Stack<Integer> stack)
        {
            visited[node] = true;

            for(var neighbor : adj.get(node))
                if(!visited[neighbor])
                    topoLogicalSortUtil(adj, neighbor, visited, stack);

            stack.push(node);
        }

        private boolean isCyclic(List<List<Integer>> adj, int node, boolean[] visited, boolean[] recStack)
        {
            if(recStack[node])
                return true;

            if(visited[node])
                return false;

            visited[node] = true;
            recStack[node] = true;

            for(var neighbor : adj.get(node))
                if(isCyclic(adj, neighbor, visited, recStack))
                    return true;

            recStack[node] = false;
            return false;
        }
    }

}
