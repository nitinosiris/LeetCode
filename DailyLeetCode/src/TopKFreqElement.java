import java.util.*;

public class TopKFreqElement {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Convert the map entries to a list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list by value (frequency count) in descending order
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Prepare the result list and collect the top k frequent elements
        List<Integer> result = new ArrayList<>();
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            result.add(entry.getKey());
            i++;
            if (i == k)
                break;
        }

        // Convert the result list to an int array and return
        int[] resultArray = new int[result.size()];
        for (i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
