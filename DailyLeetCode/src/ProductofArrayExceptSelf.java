public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] left = new int[size];
        int[] right = new int[size];

        left[0] = 1;
        for(int i = 1; i < size; i++)
        {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[size - 1] = 1;
        for(int i = size - 2; i >=0; i++)
        {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] res = new int[size];

        for(int i = 0; i < size; i++)
        {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
