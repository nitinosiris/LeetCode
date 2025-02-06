import java.util.Arrays;

public class EditDistance {
    int[][] dp;
    private int editDistance(String word1, String word2, int m, int n) {
        // If one string is empty, return the number of insertions/deletions needed
        if (m == 0) return n;
        if (n == 0) return m;

        // Check memoization
        if (dp[m][n] != -1) return dp[m][n];

        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            // Characters match, move both pointers
            dp[m][n] = editDistance(word1, word2, m - 1, n - 1);
        } else {
            // Insert, Delete, Replace operations
            int insertOp = editDistance(word1, word2, m, n - 1);   // Insert
            int deleteOp = editDistance(word1, word2, m - 1, n);   // Delete
            int replaceOp = editDistance(word1, word2, m - 1, n - 1); // Replace

            dp[m][n] = 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
        }

        return dp[m][n];
    }


    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m + 1][n + 1];

        // Initialize DP table
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return editDistance(word1, word2, m, n);
    }
}
