import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res);
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res) {
        // If we reached the end of the array, add the current permutation
        if (index == nums.length) {
            res.add(convertArrayToList(nums));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // Swap to fix the current element at the index
            swap(nums, index, i);

            // Recursively generate permutations for the rest of the array
            dfs(nums, index + 1, res);

            // Backtrack to restore the original array
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

    private List<Integer> convertArrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}
