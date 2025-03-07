import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MeetingRoomIII {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Integer.compare((int) a[1], (int) b[1])
        );

        // Sorted available rooms
        TreeSet<Integer> availableRooms = new TreeSet<>();
        for (int i = 0; i < n; i++)
            availableRooms.add(i);

        // Count of meetings held in each room
        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Free up rooms that have completed meetings before this one starts
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.add((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                // Assign the lowest available room
                int room = availableRooms.pollFirst();
                busyRooms.add(new long[]{end, room});
                meetingCount[room]++;
            } else {
                // No room is free; delay the earliest finishing meeting
                long[] earliest = busyRooms.poll();
                int room = (int) earliest[1];
                long newEndTime = earliest[0] + (end - start);
                busyRooms.add(new long[]{newEndTime, room});
                meetingCount[room]++;
            }
        }

        // Find the room with max meetings (smallest index in case of a tie)
        int bestRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > meetingCount[bestRoom]) {
                bestRoom = i;
            }
        }
        return bestRoom;
    }
}
