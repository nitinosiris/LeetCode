import java.util.*;

public class TopFreqKWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (map.get(a) != map.get(b)) {
                return map.get(a) - map.get(b);
            }
            return b.compareTo(a);
        });

        for (String word : map.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll());
        }

        Collections.reverse(ans);
        return ans;
    }
}
