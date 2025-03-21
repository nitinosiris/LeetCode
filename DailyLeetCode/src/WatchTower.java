import java.util.Arrays;

public class WatchTower {
    // A town is building a watchtower.
    // The watchtower is located at (0, 0).
    // Each unit height of the watchtower has a cost H.
    // There are N houses located at (x, y) coordinates.
    // Each house will pay cost C if it comes under the surveillance of the watchtower.
    // The horizontal distance covered by the watchtower is the same as it's height.
    // Find out the max profit you can make

    public static double maxProfit(int N, int[][] houses, double H, double C) {

        double[] distances = new double[N];
        for (int i = 0; i < N; i++) {
            int x = houses[i][0];
            int y = houses[i][1];
            distances[i] = Math.sqrt(x * x + y * y);
        }

        Arrays.sort(distances);

        double maxProfit = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < N; i++)
        {
            double h = distances[i];

            double revenue = (i + 1) * C;
            double cost = h * H;

            double profit = revenue - cost;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
