import java.util.*;

public class ClosestFavCity {
    //    Given are N cities and M roads that travel between the given pair of cities and
//    time it takes to travel that road. Also we are given a list of favourite cities L
//    and a source city S . we have to tell the favourite city which can be reached from
//    source city the fastest(in minimum time)
    private static final int INF = 0x3f3f3f3f;
    public int FavCity(int n, List<int[]> roads, List<Integer> l, int src)
    {
        // make fav city hashset for O(1) lookups
        Set<Integer> set = new HashSet<>(l);

        // graph
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.size(); i++)
        {
            var road = roads.get(i);
            addEdge(adj, road[0], road[1], road[2]);
        }

        int ans = -1;
        int minDist = INF;
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getFirst));

        List<Integer> dist
                = new ArrayList<>(Collections.nCopies(n, INF));

        queue.add(new Pair<>(0, src));
        dist.set(src, 0);

        while(!queue.isEmpty())
        {
            var curr = queue.poll();
            int u = curr.getSecond();
            int tempDis = curr.getFirst();
            if(set.contains(u))
            {
                if(tempDis < minDist)
                {
                    minDist = tempDis;
                    ans = u;
                }
            }

            for (Pair<Integer, Integer> x : adj.get(u))
            {
                int v = x.getFirst();
                int weight = x.getSecond();

                if (dist.get(v) > dist.get(u) + weight) {
                    // Updating distance of v
                    dist.set(v, dist.get(u) + weight);
                    queue.add(new Pair<>(dist.get(v), v));
                }
            }
        }
        return ans;
    }



    private void addEdge(List<List<Pair<Integer, Integer>>> adj, int src, int des, int wt)
    {
        adj.get(src).add(new Pair<>(des, wt));
        adj.get(des).add(new Pair<>(src, wt));
    }

    class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second)
        {
            this.first = first;
            this.second = second;
        }

        public T getFirst() { return first; }

        public U getSecond() { return second; }
    }
}
