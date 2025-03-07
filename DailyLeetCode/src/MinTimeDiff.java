import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinTimeDiff {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> mins = new ArrayList<>();

        for (var time : timePoints) {
            var t = LocalTime.parse(time);
            mins.add((t.getHour() * 60) + t.getMinute());
        }

        Collections.sort(mins);  // Sort the minutes
        int ans = Integer.MAX_VALUE;

        // Compare first and last time difference considering circular nature
        int first = mins.get(0);
        int last = mins.get(mins.size() - 1);
        ans = Math.min(ans, Math.min(last - first, 1440 - (last - first))); // Circular comparison

        // Compare consecutive time points
        for (int i = 1; i < mins.size(); i++) {
            int diff = mins.get(i) - mins.get(i - 1);
            ans = Math.min(ans, diff);
        }

        return ans;
    }
}
