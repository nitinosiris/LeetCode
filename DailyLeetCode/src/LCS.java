import java.util.Arrays;

public class LCS {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        // memo dp
        dp = new int[text1.length() + 1][text2.length() + 1];

        // fill the dp
        for(var row : dp)
            Arrays.fill(row, -1);

        return LCS(text1, text2, text1.length(), text2.length());
    }

    public int LCS(String a, String b, int m, int n)
    {
        if(m == 0 || n == 0)
            return 0;

        if(dp[m][n] != -1)
            return dp[m][n];

        if(a.charAt(m-1) == b.charAt(n-1))
            return dp[m][n] = 1 + LCS(a, b, m - 1, n - 1);
        else
            return dp[m][n] = Math.max(LCS(a, b, m - 1, n), LCS(a, b, m, n - 1));
    }
}
