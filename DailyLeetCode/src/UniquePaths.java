import java.util.Arrays;

public class UniquePaths {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];

        // fill the dp with -1
        for(var row : dp)
            Arrays.fill(row, -1);

        return BackTrack(0,0, m, n);
    }

    private int BackTrack(int i, int j, int m, int n)
    {
        // if you reach destination
        if(i == m - 1 && j == n - 1)
            return 1;
        // if its out of bounds
        if(i >= m || j >= n)
            return 0;

        // if found in dp
        if(dp[i][j] != -1)
            return dp[i][j];
        // if in bounds
        return dp[i][j] = BackTrack(i + 1, j, m, n) + BackTrack(i, j + 1, m, n);
    }
}
