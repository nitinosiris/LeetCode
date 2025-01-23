import java.util.Map;

public class JumpGame {
    public boolean canJump(int[] nums) {
//        Map<Integer, Boolean> memo = new HashMap<>();
//        return dfs(nums, 0, memo);
        return greedy(nums);
    }

    private boolean greedy(int[] nums)
    {
        int goal = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--)
        {
            if(i + nums[i] >= goal)
                goal = i;
        }
        return goal == 0 ? true : false;
    }

    private boolean dfs(int[] nums, int i, Map<Integer, Boolean> memo) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        if (i == nums.length - 1) {
            return true;
        }
        if (nums[i] == 0) {
            return false;
        }

        int end = Math.min(nums.length, i + nums[i] + 1);
        for (int j = i + 1; j < end; j++) {
            if (dfs(nums, j, memo)) {
                memo.put(i, true);
                return true;
            }
        }
        memo.put(i, false);
        return false;
    }
}
