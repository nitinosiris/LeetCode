public class HouseRobber2 {
    public int rob(int[] nums)
    {
        int sz = nums.length;
        if (sz == 1) return nums[0];

        return Math.max(robRange(nums, 0, sz - 2), robRange(nums, 1, sz - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0; // prev1 = dp[i-1], prev2 = dp[i-2]

        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + nums[i]);
            prev2 = temp;
        }

        return prev1;
    }
}
