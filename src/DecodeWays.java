import java.util.Arrays;

public class DecodeWays {
    int[] dp;
    public int numDecodings(String s) {
        int[] digits = s.chars().map(c -> c - '0').toArray();
        dp = new int[digits.length + 1];
        Arrays.fill(dp, -1);
        return rec(digits, 0);
    }

    private int rec(int[] digits, int index) {
        if (index >= digits.length) {
            return 1;
        } else if (digits[index] == 0) {
            return 0;
        } else if (index == digits.length - 1 && digits[index] >= 1 && digits[index] <= 9) {
            return 1;
        }
        else if(dp[index] != -1)
            return dp[index];
        else {

            int left = rec(digits, index + 1);
            int right = 0;
            int digit = 0;

            if (index + 1 < digits.length) {
                digit = (digits[index] * 10) + digits[index + 1];
                if (digit <= 26) {
                    right = rec(digits, index + 2);
                }
            }
            return dp[index] = left + right;
        }
    }
}
