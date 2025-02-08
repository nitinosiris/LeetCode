import java.util.*;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {

        List<Map.Entry<Integer, Integer>> pairs = new ArrayList<>();

        for(int i = 0; i < position.length; i++)
        {
            pairs.add(new AbstractMap.SimpleEntry<>(position[i], speed[i]));
        }

        pairs.sort(Map.Entry.<Integer, Integer>comparingByKey().reversed());

        Stack<Double> stack = new Stack<>();

        for(var cars : pairs)
        {
            double time = (double) (target - cars.getKey()) / cars.getValue();

            if (stack.size() == 0 || time > stack.peek())
            {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
