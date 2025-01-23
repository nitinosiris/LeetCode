import java.util.Map;

public class JumpGame2 {
    public int jump(int[] nums) {
//        Map<Integer, Integer> memo = new HashMap<>();
//        return dfs(nums, 0, memo);
        return greedy(nums);
    }

    private Integer greedy(int[] nums)
    {
        int l = 0, r = 0, res = 0;

        while(r < nums.length - 1)
        {
            int farthest = 0;
            for(int i = l; i <= r; i++)
            {
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }

    private Integer dfs(int[] nums, int i, Map<Integer, Integer> memo) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        if (i == nums.length - 1) {
            return 0;
        }

        if(nums[i] == 0)
        {
            return 1000000;
        }

        int res = 1000000;
        int end = Math.min(nums.length, i + nums[i] + 1);
        for (int j = i + 1; j < end; j++) {
            res = Math.min(1 + dfs(nums, j, memo), res);
        }
        memo.put(i, res);
        return res;
    }
}
