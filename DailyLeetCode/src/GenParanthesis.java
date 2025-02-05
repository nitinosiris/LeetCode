import java.util.ArrayList;
import java.util.List;

public class GenParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        FindAllCombinations(res, "", 0, 0, n);
        return res;
    }
    public void FindAllCombinations(List<String> result, String seq, int open, int close, int len)
    {

        if (seq.length() == 2 * len)
        {
            result.add(seq);
            return;
        }

        if (open < len)
        {
            FindAllCombinations(result, seq + "(", open + 1, close, len);
        }

        if (close < open)
        {
            FindAllCombinations(result, seq + ")", open, close + 1, len);
        }
    }
}
