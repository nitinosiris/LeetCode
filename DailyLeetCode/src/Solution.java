import java.util.HashMap;

class Solution {
    private HashMap<String, Integer> memo;
    public int lengthOfLIS(int[] nums) {
        memo = new HashMap<>();
        return Rec(nums, 0, Integer.MIN_VALUE);
    }

    private int Rec(int[] nums, int index, int prev)
    {
        if (index >= nums.length)
            return 0;
        String key = index + "," + prev;
        if (!memo.containsKey(key))
        {
            int include = 0;
            int exclude = 0;
            if(nums[index] > prev)
                include = 1 + Rec(nums, index + 1, nums[index]);
            exclude = Rec(nums, index + 1, prev);
            memo.put(key, Math.max(include, exclude));
        }
        return memo.get(key);
    }
}
