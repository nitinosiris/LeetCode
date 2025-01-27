import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, target, subset, res);
        return res;
    }
    private void dfs(int[] nums, int start, int target, List<Integer> combination, List<List<Integer>> res)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(combination));
        }

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates in the same recursive level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target) {
                break; // No point in continuing if the current number exceeds the target
            }

            // Add the current number to the combination
            combination.add(nums[i]);
            // Recur with next number (i), and the reduced target (target - nums[i])
            dfs(nums, i+1, target - nums[i], combination, res);
            // Backtrack: remove the last added number and try the next number
            combination.remove(combination.size() - 1);
        }
    }
}
