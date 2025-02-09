import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        for(int i = 0; i < intervals.size() - 1; i++)
        {
            if(intervals.get(i).end <= intervals.get(i + 1).start)
                continue;
            else
                return false;
        }
        return true;
    }

    class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
