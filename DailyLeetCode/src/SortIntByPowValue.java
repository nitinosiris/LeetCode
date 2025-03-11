import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortIntByPowValue {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int i = lo; i <= hi; i++) {
            queue.add(new int[]{calculate(i), i});
        }

        while (--k > 0) {
            queue.poll();
        }

        return queue.poll()[1];
    }

    private int calculate(int i) {
        if (i == 1) return 0;
        if (memo.containsKey(i)) return memo.get(i);

        int steps = (i % 2 == 0) ? 1 + calculate(i / 2) : 1 + calculate(3 * i + 1);
        memo.put(i, steps);
        return steps;
    }
}
