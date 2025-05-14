import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FavCity {
    /*
    You are given:
    An integer N representing the number of cities, numbered from 1 to N.
    An integer M representing the number of bidirectional roads.
    Each road is described by a tuple (u, v, w), denoting a road between city u and city v that takes w units of time to travel.
    A list L of favourite cities, where each city in the list is an integer between 1 and N.
    An integer S, representing the source city.
    Objective:
    Determine the city from the list L that can be reached from the source city S in the minimum amount of time.
    If multiple favourite cities can be reached in the same minimum time, return the one with the smallest city number.
     */

    private int FavCity(int n, int s, int[][] roads, int[] favcity)
    {
        // create a weighted graph
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(var road : roads)
        {
            // undirected
            int src = road[0] - 1, dest = road[1] - 1, time = road[2];
            adj.get(src).add(new int[] {dest, time});
            adj.get(dest).add(new int[] {src, time});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[s] = 0;

        // time, city
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, s - 1});

        while(!pq.isEmpty())
        {
            var curr = pq.poll();
            int u = curr[1];

            for(var neighbor : adj.get(curr[1]))
            {
                int v = neighbor[0];
                int time = neighbor[1];

                if(dist[u] + time < dist[v])
                {
                    dist[v] = dist[u] + time;
                    pq.add(new int[] {dist[v], v});
                }
            }
        }

        int fcity = favcity[0] - 1;
        int d = dist[fcity];
        for(var city : favcity)
        {
            if(d > dist[city - 1])
            {
                fcity = city - 1;
                d = dist[city - 1];
            }
        }
        return fcity + 1;
    }
}
