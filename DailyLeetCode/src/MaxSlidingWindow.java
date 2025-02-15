import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b.getKey(), a.getKey()));

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;

        while (end < nums.length) {
            pq.add(new AbstractMap.SimpleEntry<>(nums[end], end));

            if (end - start + 1 == k) {
                res.add(pq.peek().getKey());
                while(!pq.isEmpty() && pq.peek().getValue() < start)
                    pq.poll();
                start++;
            }
            end++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
