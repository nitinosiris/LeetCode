import java.util.Arrays;

public class MaxDistanceShip {
    //    you are given maximum initial energy k (k<1000) and array A of length n denoting wind speed on n days.
//    he is stuck on a boat and each day he can either choose to move or stay put.. each day he decides to
//    travel he will move ahead A[i] Dist and his energy decreases by 1 and if he decides to stay put his energy increases by 1.
//    What is the maximum distance he can travel without dropping his energy to negative after n days.
//    Clarification questions i asked- what if energy is k and he decides to rest only- would energy go beyond maximum?
//    answer=No, it will remain k
//    can the wind speed be negative as well, denoting wind flowing in other direction? answer= No (initially)
    int k;
    int[][] dp;
    public int MaxDistance(int k, int[] arr)
    {
        this.k = k;
        int n = arr.length;
        dp = new int[n][k + 1];
        Arrays.fill(dp, -1);
        // if move
        // dist += A[i] and k -= 1
        // if no move
        // k += 1 and max k = 1000

        // intuition
        // two choices either go ahead or stay put
        // std recursion
        return rec(0, arr, k);
    }

    private int rec(int index, int[] arr, int currEnergy) {
        if (index == arr.length)
        {
            return 0;
        }

        if(dp[index][currEnergy] != -1)
            return dp[index][currEnergy];

        int moveDist = 0, restDist = 0;

        // Option 1: Move ahead if energy > 0
        if (currEnergy > 0) {
            moveDist = arr[index] + rec(index + 1, arr, currEnergy - 1);
        }

        // Option 2: Stay put and gain energy (max energy stays at k)
        restDist = rec(index + 1, arr, Math.min(k, currEnergy + 1));

        return dp[index][currEnergy] = Math.max(moveDist, restDist);
    }
}
