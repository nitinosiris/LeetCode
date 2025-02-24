public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(Math.min(next2, next3), next5);
            dp[i] = nextUgly;

            if (nextUgly == next2) {
                next2 = dp[++i2] * 2;
            }
            if (nextUgly == next3) {
                next3 = dp[++i3] * 3;
            }
            if (nextUgly == next5) {
                next5 = dp[++i5] * 5;
            }
        }

        return dp[n - 1];
    }
}
