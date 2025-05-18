import java.util.ArrayList;
import java.util.List;

public class PIQues {
    public List<Integer> check(String pi) {
        List<Integer> ans = new ArrayList<>();

        int n = pi.length();
        for (int i = 1; i <= n; i++) {
            String numStr = String.valueOf(i);
            int len = numStr.length();

            if (i < len || i > n)
                continue;

            int startIdx = i - len;
            String piSub = pi.substring(startIdx, i);

            if (piSub.equals(numStr)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
