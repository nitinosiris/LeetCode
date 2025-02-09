import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();

        for(int[] interval : intervals)
        {
            if(stack.isEmpty())
                stack.push(new AbstractMap.SimpleEntry<>(interval[0], interval[1]));
            else {
                if(stack.peek().getValue() >= interval[0])
                {
                    // they overlap
                    var top = stack.pop();
                    stack.push(new AbstractMap.SimpleEntry<>(top.getKey(), Math.max(top.getValue(), interval[1])));
                }
                else
                {
                    stack.push(new AbstractMap.SimpleEntry<>(interval[0], interval[1]));
                }
            }
        }
        int[][] res = new int[stack.size()][2];
        int i = 0;
        while(!stack.isEmpty())
        {
            var top = stack.pop();
            res[i] = new int[] {top.getKey(), top.getValue()};
            i++;
        }
        return res;
    }
}
