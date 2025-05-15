import java.util.HashMap;
import java.util.List;

public class Evaluate_the_Bracket_Pairs1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        for(var know : knowledge)
            map.put(know.get(0), know.get(1));

        int len = s.length();

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < len; i++)
        {
            if(s.charAt(i) != '(')
            {
                str.append(s.charAt(i));
                continue;
            }

            // we are at (
            int j = i + 1;
            while(j < len && s.charAt(j) != ')')
                j++;

            // i -> ( and j -> )
            var substr = s.substring(i + 1, j);

            if(map.containsKey(substr))
                str.append(map.get(substr));
            else
                str.append("?");
            i = j;
        }

        return str.toString();
    }
}
