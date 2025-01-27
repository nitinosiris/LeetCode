import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }
    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res)
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
