public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        var res = Dp(coins, 0, amount);
        if(res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
    private int Dp(int[] coins, int n, int sum)
    {
        // base case
        if (sum == 0) return 0;
        if (sum < 0 || n == coins.length) return Integer.MAX_VALUE;

        int take = Integer.MAX_VALUE;

        // take a coin only if its value
        // is greater than 0.
        take = Dp(coins, n,sum - coins[n]);
        if (take != Integer.MAX_VALUE)
            take++;
        int noTake = Dp(coins, n + 1, sum);
        return Math.min(take, noTake);
    }
}
