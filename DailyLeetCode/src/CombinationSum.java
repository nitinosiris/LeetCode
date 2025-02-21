import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(candidates, 0, target, subset, res);
        return res;
    }

    private void dfs(int[] cadidates, int index, int target, List<Integer> subset, List<List<Integer>> res)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(subset));
        }

        if(target < 0)
            return;

        for(int i = index; i < cadidates.length; i++)
        {
            // Add the current number to the combination
            subset.add(cadidates[i]);

            // Recur with the same number (i), and the reduced target (target - nums[i])
            dfs(cadidates, i, target - cadidates[i], subset, res);

            // Backtrack: remove the last added number and try the next number
            subset.remove(subset.size() - 1);
        }
    }
}
