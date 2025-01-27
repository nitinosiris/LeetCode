import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, target, subset, res);
        return res;
    }
    private void dfs(int[] nums, int start, int target, List<Integer> combination, List<List<Integer>> res)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(combination));
        }

        if (target < 0) {
            return; // Stop exploring this path
        }

        for (int i = start; i < nums.length; i++) {
            // Add the current number to the combination
            combination.add(nums[i]);
            // Recur with the same number (i), and the reduced target (target - nums[i])
            dfs(nums, i, target - nums[i], combination, res);
            // Backtrack: remove the last added number and try the next number
            combination.remove(combination.size() - 1);
        }
    }
}
