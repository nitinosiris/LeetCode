import java.util.*;

public class Iternary {
    public List<String> findItinerary(List<List<String>> tickets) {

        // adj list for graph
        Map<String, List<String>> adj = new HashMap<>();

        // add the edges in adj
        for(var ticket : tickets)
        {
            if(!adj.containsKey(ticket.get(0)))
                adj.put(ticket.get(0), new ArrayList<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        // Sorting each list lexicographically
        for (Map.Entry<String, List<String>> entry : adj.entrySet()) {
            Collections.sort(entry.getValue());  // Sort before traversal
        }

        Set<String> visited = new HashSet<>();
        return dfs("JFK", adj, visited);
    }
    private List<String> dfs(String src, Map<String, List<String>> adj, Set<String> visited)
    {
        List<String> res = new ArrayList<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(src);

        while(!priorityQueue.isEmpty())
        {
            String node = priorityQueue.poll();
            res.add(node);

            // traverse all the neighbors
            List<String> neighbors = adj.get(node);
            System.out.println(node);

            if(neighbors != null)
            {
                for(var neighbor : neighbors)
                {
                    System.out.println("neighbor : " + neighbor);
                    if(!visited.contains(neighbor) || neighbor.equals(src))
                    {
                        if(neighbor != src) {
                            visited.add(neighbor);
                            System.out.println("visited : " + neighbor);
                        }
                        priorityQueue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}
