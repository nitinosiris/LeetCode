import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class DailyTempreature {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;

        int[] res = new int[size];
        res[size - 1] = 0;
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(temperatures[size - 1], size - 1));
        int i = size - 2;

        while(i >= 0)
        {
            if(temperatures[i] < stack.peek().getKey())
                res[i] = stack.peek().getValue() - i;
            else {
                while(!stack.isEmpty() && temperatures[i] > stack.peek().getKey())
                    stack.pop();

                if(stack.isEmpty())
                    res[i] = 0;
                else
                    res[i] = stack.peek().getValue() - i;
            }
            stack.push(new AbstractMap.SimpleEntry<>(temperatures[i], i));
            i--;
        }
        return res;
    }
}
