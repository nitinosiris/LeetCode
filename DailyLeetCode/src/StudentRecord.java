import java.util.HashMap;

public class StudentRecord {
    int count = 0;
    char[] attendence = new char[] {'A', 'L', 'P'};
    static final int MOD = 1000000007;

    HashMap<String, Integer> set;

    public int checkRecord(int n) {
        set = new HashMap<>();
        return Check(n, 0, 0);
    }

    private int countRecords(int n, int aCount, int lCount)
    {
        if(n == 0)
            return 1;

        int total = 0;

        String str = n + "," + aCount + "," + lCount;

        if(set.containsKey(str))
            return set.get(str);

        // Add 'P'
        total = (total + countRecords(n - 1, aCount, 0)) % MOD;

        // Add 'A' if not already present
        if (aCount == 0) {
            total = (total + countRecords(n - 1, aCount + 1, 0)) % MOD;
        }

        // Add 'L' if last two were not 'LL'
        if (lCount < 2) {
            total = (total + countRecords(n - 1, aCount, lCount + 1)) % MOD;
        }
        set.put(str, total);
        System.out.println(str + " " + total);
        return total;
    }


    private int Check(int n, int aCount, int lCount)
    {
        // dp[i][j][k] -> Number of valid sequences of length i
        // j = number of 'A's used (0 or 1)
        // k = consecutive 'L's at the end (0, 1, or 2)

        int[][][] dp = new int[n + 1][2][3];

        // base case
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++)
        {
            for (int a = 0; a <= 1; a++)
            {
                // 'A' can be 0 or 1 times
                for (int l = 0; l <= 2; l++)
                {
                    // Add 'P' (resets L count)
                    dp[i][a][0] = (dp[i][a][0] + dp[i - 1][a][l]) % MOD;

                    // Add 'A' if not already present
                    if (a == 0) {
                        dp[i][a + 1][0] = (dp[i][a + 1][0] + dp[i - 1][a][l]) % MOD;
                    }

                    // Add 'L' if last two were not 'LL'
                    if (l < 2) {
                        dp[i][a][l + 1] = (dp[i][a][l + 1] + dp[i - 1][a][l]) % MOD;
                    }
                }
            }
        }
        // Sum all valid states for length 'n'
        int total = 0;
        for (int a = 0; a <= 1; a++) {
            for (int l = 0; l <= 2; l++) {
                total = (total + dp[n][a][l]) % MOD;
            }
        }
        return total;
    }

    private void BackTrack(String str, int n, boolean aPresent)
    {
        if(str.length() == n)
        {
            count = (count + 1) % MOD;  // Apply modulo here
        }
        else
        {
            for(int i = 0; i < attendence.length; i++)
            {
                // check for AA
                if(aPresent)
                {
                    if(attendence[i] == 'A')
                        continue;
                    else
                    {
                        if(str.length() >= 2 && str.substring(str.length() - 2).equals("LL") && attendence[i] == 'L')
                            continue;

                        str += attendence[i];
                        BackTrack(str, n, true);
                        str = str.substring(0, str.length() - 1);
                    }
                }
                else
                {
                    if(str.length() >= 2 && str.substring(str.length() - 2).equals("LL") && attendence[i] == 'L') {
                        continue;
                    }
                    str += attendence[i];
                    if(attendence[i] == 'A')
                        BackTrack(str, n, true);
                    else
                        BackTrack(str, n, false);
                    str = str.substring(0, str.length() - 1);
                }
            }

        }
    }
}
