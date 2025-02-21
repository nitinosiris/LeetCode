class Solution {
    public int hammingWeight(int n) {
        int res = 0;

        while(n > 0)
        {
            res += 1;
            n = n & (n - 1);
        }
        return res;
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 0; i <= n; i++)
            res[i] = hammingWeight(i);

        return res;
    }
}
