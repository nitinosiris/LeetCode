import java.util.*;

class NetworkDelays {
    public int networkDelayTime(int[][] times, int n, int k) {
        Graph graph = new Graph(n);
        for(int i = 0; i < times.length; i++)
        {
            graph.addEdge(times[i][0] - 1, times[i][1] - 1, times[i][2]);
        }

        return shortedPath(k - 1, graph);
    }

    private int shortedPath(int src, Graph graph)
    {
        PriorityQueue<iPair> pq = new PriorityQueue<>();
        int[] dist = new int[graph.getVertices()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new iPair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().first;

            for (iPair v : graph.adj.get(u)) {
                int newDist = dist[u] + v.second;
                if (newDist < dist[v.first]) {
                    dist[v.first] = newDist;
                    pq.add(new iPair(v.first, newDist));
                }
            }
        }
        int maxTime = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) return -1; // If a node is unreachable
            maxTime = Math.max(maxTime, d);
        }
        return maxTime;
    }
}
class Graph{
    private int V;
    public List<List<iPair>> adj;


    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public int getVertices()
    {
        return V;
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(v, w));
    }
}
class iPair implements Comparable<iPair> {
    int first, second;
    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public int compareTo(iPair other) {
        return Integer.compare(this.second, other.second);
    }
}

