import java.util.HashSet;
import java.util.List;

public class ConstructTheWord {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hash = new HashSet<>();

        // build the hash set
        // so that retrieval becomes O(1)
        for(var word : wordDict)
            if(!hash.contains(word))
                hash.add(word);

        Boolean[] memo = new Boolean[s.length()];
        return Rec(s, 0, 0, hash, memo);
    }
    private boolean Rec(String s, int start, int end, HashSet<String> set, Boolean[] memo) {
        if (start == s.length())
            return true; // Successfully segmented

        if (memo[start] != null)
            return memo[start]; // Return cached result

        if (end > s.length())
            return false; // Avoid out-of-bounds

        String sub = s.substring(start, end);
        if (set.contains(sub)) {
            if (Rec(s, end, end + 1, set, memo))
                return memo[start] = true;
        }

        return memo[start] = Rec(s, start, end + 1, set, memo);
    }
}
