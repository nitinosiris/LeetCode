import java.util.Arrays;

public class partitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(var num : nums)
            sum += num;

        if(sum % 2 != 0)
            return false;

        int[][] memo = new int[nums.length + 1][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return isSubsetSumRec(nums, nums.length, sum / 2, memo);
    }

    private boolean isSubsetSumRec(int[] arr, int n, int sum,
                                   int[][] memo) {

        // If the sum is zero, we found a subset
        if (sum == 0) {
            return true;
        }

        // If no elements are left
        if (n <= 0) {
            return false;
        }

        // If the value is already computed, return it
        if (memo[n][sum] != -1) {
            return memo[n][sum] == 1;
        }

        // If the last element is greater than the sum,
        // ignore it
        if (arr[n - 1] > sum) {
            memo[n][sum] = isSubsetSumRec(arr, n - 1, sum, memo)
                    ? 1 : 0;
        }
        else {

            // Include or exclude the last element directly
            memo[n][sum] = (isSubsetSumRec(arr, n - 1, sum, memo)
                    || isSubsetSumRec(arr, n - 1, sum - arr[n - 1], memo))
                    ? 1 : 0;
        }

        return memo[n][sum] == 1;
    }
}
