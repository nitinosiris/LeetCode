public class MaxSubarrayGreedy {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int max_ending = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            max_ending = Math.max(nums[i], max_ending + nums[i]);
            res = Math.max(max_ending, res);
        }
        return res;
    }
}
