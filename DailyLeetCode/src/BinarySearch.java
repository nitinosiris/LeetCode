public class BinarySearch {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid = 0;
        while(i < j)
        {
            mid = i + (j - i) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return -1;
    }
}
