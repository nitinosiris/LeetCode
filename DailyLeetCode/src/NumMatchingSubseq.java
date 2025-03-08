import java.util.HashMap;

public class NumMatchingSubseq {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<String, Boolean> dict = new HashMap<>();
        for(var word : words)
        {
            if(!dict.containsKey(word))
            {
                int i = 0, j = 0;

                while (i < word.length() && j < s.length()) {
                    if (word.charAt(i) == s.charAt(j)) {
                        i++;
                    }
                    j++;
                }

                if(i == word.length())
                {
                    dict.put(word, true);
                    count++;
                }
                else
                    dict.put(word, false);
            }
            else
            if(dict.get(word))
                count++;
        }
        return count;
    }
}
