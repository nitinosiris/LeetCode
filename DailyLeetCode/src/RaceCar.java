import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RaceCar {
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new int[] {0, 1, 0});
        visited.add("0,1");

        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int pos = next[0], speed = next[1], steps = next[2];

            if (pos == target)
                return steps;

            // Accelerate (A)
            int newPos = pos + speed;
            int newSpeed = speed * 2;
            String accState = newPos + "," + newSpeed;

            if (!visited.contains(accState) && Math.abs(newPos) <= 2 * target) {
                queue.add(new int[] {newPos, newSpeed, steps + 1});
                visited.add(accState);
            }

            // Reverse (R)
            int revSpeed = speed > 0 ? -1 : 1;
            String revState = pos + "," + revSpeed;

            if (!visited.contains(revState)) {
                queue.add(new int[] {pos, revSpeed, steps + 1});
                visited.add(revState);
            }
        }
        return -1;
    }
}
