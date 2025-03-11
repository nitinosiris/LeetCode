import java.util.Arrays;

public class BookShelf {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Iterate over each book
        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;

            // Try placing books on the current shelf (Look back at previous books)
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0];  // Add book width
                if (width > shelfWidth)
                    break; // Stop if width exceeds shelf limit

                height = Math.max(height, books[j - 1][1]); // Max height of current shelf

                // Update dp[i] -> Place books[j-1] to books[i-1] on the same shelf
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[n]; // Minimum height needed for all books
    }
}
