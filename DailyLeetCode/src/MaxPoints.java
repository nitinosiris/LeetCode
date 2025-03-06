public class MaxPoints {
    public long maxPoints(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;
        long[][] dp = new long[rows][cols];
        long ans = 0;
        for(int i = 0; i < cols; i++)
        {
            dp[0][i] = points[0][i];
            ans = Math.max(dp[0][i], ans);
        }

        for(int i = 1; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                long temp = Integer.MIN_VALUE;
                for(int k = 0; k < cols; k++)
                {
                    temp = Math.max(temp, points[i][j] + dp[i - 1][k] - Math.abs(k - j));
                }
                dp[i][j] = temp;
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }
}
