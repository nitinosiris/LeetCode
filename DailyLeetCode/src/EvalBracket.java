import java.util.HashMap;
import java.util.List;

public class EvalBracket {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        for (var know : knowledge)
            map.put(know.get(0), know.get(1));

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int start = i + 1;
                int end = start;

                while (end < s.length() && s.charAt(end) != ')') {
                    end++;
                }

                String key = s.substring(start, end);

                if (map.containsKey(key)) {
                    result.append(map.get(key));
                } else {
                    result.append("?");
                }

                i = end + 1;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}
