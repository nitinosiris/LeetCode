import java.util.HashSet;

public class Ishappy {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1)
        {
            // cal digits
            int ans = 0;
            while(n > 0)
            {
                int rem = n % 10;
                ans += rem * rem;
                n = n / 10;
            }
            n = ans;
            if(set.contains(ans))
                break;
            else
                set.add(ans);
        }
        if(n == 1)
            return true;
        return false;
    }
}
