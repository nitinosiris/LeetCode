public class ClimbingStairs {
    int[] array;

    public int climbStairs(int n) {
        if (n == 1) return 1; // Edge case for n = 1
        array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        return dp(n);
    }

    private int dp(int n) {
        if (array[n] != 0) return array[n]; // Memoization check
        array[n] = dp(n - 1) + dp(n - 2); // Recursive calculation
        return array[n];
    }
}
