import java.util.*;

public class LuggageReachable {
    public static class city {
        String name;
        int arrival;
        int depart;

        public city(String n, int d, int a) {
            name = n;
            depart = d;
            arrival = a;
        }
    }

    public static class pair {
        String name;
        int time;

        public pair(String inp, int t) {
            name = inp;
            time = t;
        }
    }

    public boolean isPossible(List<List<String>> flights, int[][] times, String src, String dest) {
        HashMap<String, List<city>> graph = new HashMap<>();
        for (int i = 0; i < flights.size(); i++) {
            var s = flights.get(i).get(0);
            var d = flights.get(i).get(1);

            graph.putIfAbsent(s, new ArrayList<>());
            graph.get(s).add(new city(d, times[i][0], times[i][1]));
        }

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(src, 0));

        while (!q.isEmpty()) {
            var currCity = q.poll();
            if (currCity.name.equals(dest))
                return true;

            if (!graph.containsKey(currCity.name))
                continue;

            for (var flight : graph.get(currCity.name)) {
                if (currCity.time <= flight.depart) {
                    q.add(new pair(flight.name, flight.arrival));
                }
            }
        }
        return false;
    }
}
