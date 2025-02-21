public class SingleIntXOR {
    public int singleNumber(int[] nums) {
        int sz = nums.length;
        if(sz == 1)
            return nums[0];

        int ans = 0;
        for(var num : nums)
            ans ^= num;

        return ans;
    }
}
