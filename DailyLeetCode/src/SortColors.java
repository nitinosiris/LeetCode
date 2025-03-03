public class SortColors {
    public void sortColors(int[] nums) {
        int one = 0;
        int two = 0;
        int zero = 0;

        for(var num : nums)
        {
            if(num == 0)
                zero++;
            else if(num == 1)
                one++;
            else
                two++;
        }

        int i = 0;
        while(zero > 0)
        {
            nums[i++] = 0;
            zero--;
        }

        while(one > 0)
        {
            nums[i++] = 1;
            one--;
        }

        while(two > 0)
        {
            nums[i++] = 2;
            two--;
        }
    }
}
