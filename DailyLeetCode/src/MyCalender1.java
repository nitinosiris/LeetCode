import java.util.LinkedList;
import java.util.List;

public class MyCalender1 {
    List<int[]> sortedList;

    public MyCalendar() {
        sortedList = new LinkedList<>();
    }

    public boolean book(int startTime, int endTime) {
        // Binary search for the position to insert the new booking
        int lo = 0, hi = sortedList.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sortedList.get(mid)[0] < startTime) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        if (lo > 0 && sortedList.get(lo - 1)[1] > startTime) {
            return false;
        }
        if (lo < sortedList.size() && sortedList.get(lo)[0] < endTime) {
            return false;
        }

        // Insert the new booking in sorted order
        sortedList.add(lo, new int[] {startTime, endTime});
        return true;
    }
}
