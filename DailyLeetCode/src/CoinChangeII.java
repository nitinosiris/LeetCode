import java.util.Arrays;

public class CoinChangeII {
    int[][] memo;
    public int change(int amount, int[] coins) {
        memo = new int[coins.length + 1][amount + 1];

        for(var row : memo)
            Arrays.fill(row, -1);

        return Check(coins, 0, amount);
    }

    private int Check(int[] coins, int index, int target)
    {
        if(index >= coins.length)
            return 0;

        if(target == 0)
            return 1;

        if(memo[index][target] != -1)
            return memo[index][target];

        int take = 0;
        if(coins[index] <= target)
            take = Check(coins, index, target - coins[index]);
        int donotTake = Check(coins, index + 1, target);

        return memo[index][target] = take + donotTake;
    }
}
