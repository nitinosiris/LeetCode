import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthNearestPoint {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Map.Entry<Double, Map.Entry<Integer, Integer>>> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(a.getKey(), b.getKey()) // Min-heap based on the distance (key of Map.Entry)
        );

        for(int i = 0; i < points.length; i++)
        {
            double distance = calculateDistance(points[i][0], points[i][1], 0, 0);
            System.out.println(distance);
            pq.add(new AbstractMap.SimpleEntry<>(distance, new AbstractMap.SimpleEntry<>(points[i][0], points[i][1])));
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++)
        {
            var temp = pq.poll();
            result[i][0] = temp.getValue().getKey();
            result[i][1] = temp.getValue().getValue();
        }

        return result;
    }

    public double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
