﻿public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = n;

        for(int i = 0; i < n; i++)
        {
            xor ^= i ^ nums[i];
        }
        return xor;
    }
}
