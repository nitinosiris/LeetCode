public class FirstPositiveMissing {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < 0)
                nums[i] = 0;
        }

        // positive
        for(int i = 0; i < nums.length; i++)
        {
            var temp = Math.abs(nums[i]);
            if(temp > 0 && temp <= nums.length) {
                if(nums[temp - 1] == 0)
                {
                    nums[temp - 1] = -temp;
                }
                else if (nums[temp - 1] > 0)
                {
                    nums[temp - 1] = -1 * nums[temp - 1];
                }
            }
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] >= 0)
                return i + 1;
        }
        return nums.length + 1;
    }
}
