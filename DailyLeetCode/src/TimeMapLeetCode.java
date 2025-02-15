import java.util.*;

public class TimeMapLeetCode {
    class TimeMap {
        private Map<String, List<Map.Entry<Integer, String>>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            Map.Entry<Integer, String> entry = new AbstractMap.SimpleEntry<>(timestamp, value);
            if (map.containsKey(key)) {
                map.get(key).add(entry);
            } else {
                List<Map.Entry<Integer, String>> list = new ArrayList<>();
                list.add(entry);
                map.put(key, list);
            }
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key))
                return "";
            var list = map.get(key);
            int low = 0;
            int high = list.size() - 1;

            while(low <= high)
            {
                int mid = (low + high) / 2;
                int element = list.get(mid).getKey();
                if(element == timestamp)
                    return list.get(mid).getValue();
                if(element < timestamp)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            if (high >= 0)
            {
                return list.get(high).getValue();
            }

            return ""; // No valid timestamp found
        }
    }
}
