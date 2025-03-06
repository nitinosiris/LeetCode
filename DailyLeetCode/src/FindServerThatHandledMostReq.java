import java.util.*;

public class FindServerThatHandledMostReq {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // TreeSet to track available servers (sorted order)
        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }

        // Request count for each server
        int[] requestCount = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            int currentTime = arrival[i];

            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                availableServers.add(busyServers.poll()[1]);
            }

            Integer serverToUse = availableServers.ceiling(i % k);
            if (serverToUse == null) {
                serverToUse = availableServers.ceiling(0);
            }

            if (serverToUse != null) {
                availableServers.remove(serverToUse);
                busyServers.add(new int[]{currentTime + load[i], serverToUse});
                requestCount[serverToUse]++;
            }
        }

        // Find the max requests handled
        int maxRequests = Arrays.stream(requestCount).max().orElse(0);

        // Collect all busiest servers
        List<Integer> busiestServers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                busiestServers.add(i);
            }
        }

        return busiestServers;
    }
}
