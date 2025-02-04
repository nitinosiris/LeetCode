import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tripplets {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int first;
        for(first = 0; first < nums.length; first++)
        {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            var pairs = TwoSumList(nums, first + 1, nums.length - 1, 0 - nums[first]);
            for (var pair : pairs) {
                List<Integer> tripplet = new ArrayList<>();
                tripplet.add(nums[first]);
                tripplet.addAll(pair);
                result.add(tripplet);
            }

        }
        return result;
    }
    private List<List<Integer>> TwoSumList(int[] nums, int start, int end, int target)
    {
        List<List<Integer>> pairs = new ArrayList<>();
        int i = start; int j = end;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--; // Move the right pointer leftward to reduce the sum
            } else if (sum < target) {
                i++; // Move the left pointer rightward to increase the sum
            } else {
                // Found a valid pair
                pairs.add(Arrays.asList(nums[i], nums[j]));

                // Skip duplicates for both pointers to avoid duplicate pairs
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;

                // Move both pointers inward
                i++;
                j--;
            }
        }
        return pairs;
    }
}
