import java.util.*;

public class SubsetsWithDups {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return new ArrayList<>(res);
    }
    private void dfs(int[] nums, int i, List<Integer> subset, Set<List<Integer>> res)
    {
        if(i >= nums.length)
        {
            // subset is complete add it
            res.add(new ArrayList<>(subset));
            return;
        }

        // to include i
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res);

        // to exclude i
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, res);
    }
}
