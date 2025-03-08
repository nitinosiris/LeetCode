public class StudentRecord {
    int count = 0;
    char[] attendence = new char[] {'A', 'L', 'P'};
    static final int MOD = 1000000007;

    public int checkRecord(int n) {
        BackTrack("", n, false);
        return count;
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
