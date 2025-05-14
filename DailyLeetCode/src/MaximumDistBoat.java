public class MaximumDistBoat {
    //    You are stranded on a boat in the middle of the sea with a maximum initial energy of k units (k < 1000).
//    You are given an array A of length n, where A[i] denotes the wind speed on the i-th day.
//    The wind speed determines how far you can travel on that day if you choose to move.
//    Each day, you can make one of two choices:
//    Travel: You move forward by A[i] distance units. This action costs 1 unit of energy.
//    Rest: You remain stationary and regain 1 unit of energy.
//    Your energy level can never drop below 0 at any point in time.
//    Given these constraints, determine the maximum total distance you can travel over the span of n days without ever allowing your energy to become negative.
    public int MaximumDistance(int k, int[] array)
    {
        int n = array.length;
        int maxEnergy = k + n;
        int[][] dp = new int[n + 1][maxEnergy + 1];

        for (int day = n - 1; day >= 0; day--)
        {
            for (int energy = 0; energy <= maxEnergy; energy++)
            {
                int rest = 0, travel = 0;

                if (energy + 1 <= maxEnergy)
                    rest = dp[day + 1][energy + 1];

                if (energy > 0)
                    travel = array[day] + dp[day + 1][energy - 1];

                dp[day][energy] = Math.max(rest, travel);
            }
        }

        return dp[0][k];
    }

    private int rec(int day,int k, int[] array)
    {
        if(day == array.length)
            return 0;

        int include = 0, exclude = 0;
        if(k > 0)
            include = array[day] + rec(day + 1, k - 1, array);

        exclude = rec(day + 1, k + 1, array);

        return Math.max(include, exclude);
    }
}
