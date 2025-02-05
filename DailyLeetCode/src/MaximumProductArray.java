import java.util.HashMap;

public class MaximumProductArray {
    private HashMap<String, Integer> memo;

    public int maxProduct(int[] nums) {
        memo = new HashMap<>();
        return maxProductRecursive(nums, 0, nums.length - 1, 1);
    }

    private int maxProductRecursive(int[] nums, int start, int end, int product) {
        if (start > end) return Integer.MIN_VALUE;

        String key = start + "," + end + "," + product;
        if (memo.containsKey(key)) return memo.get(key);

        // Compute the max product by extending both boundaries
        int left = maxProductRecursive(nums, start + 1, end, 1);  // Move start forward
        int right = maxProductRecursive(nums, start, end - 1, 1); // Move end backward
        int extend = maxProductRecursive(nums, start + 1, end, product * nums[start]); // Extend product

        int result = Math.max(product * nums[start], Math.max(left, Math.max(right, extend)));
        memo.put(key, result);
        return result;
    }
}
