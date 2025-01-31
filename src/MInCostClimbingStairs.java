public class MInCostClimbingStairs {
    private int[] array;
    public int minCostClimbingStairs(int[] cost) {
        array = new int[cost.length + 1];
        dp(cost, 0);
        dp(cost, 1);
        return Math.min(array[0] , array[1]);
    }
    private int dp(int cost[], int i)
    {
        if(i >= cost.length)
        {
            return 0;
        }
        // lookup
        if(array[i] != 0)
            return array[i];

        return array[i] = cost[i] + Math.min(dp(cost, i + 1), dp(cost, i + 2));
    }
}
