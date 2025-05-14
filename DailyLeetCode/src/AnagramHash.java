import java.util.Arrays;
import java.util.List;

public class AnagramHash {
    /*
    You are given:
    A dictionary of words.
    A function hash(word) that returns a hash value such that all anagrams of a word produce the same hash.
    A function score(word) that computes the score of a word as the sum of absolute differences of adjacent characters in the word.
    For example:
        score("abc") = |'a'-'b'| + |'b'-'c'| = |97-98| + |98-99| = 1 + 1 = 2
     */

    public String highest_scoring_anagram(String word, List<String> dictionary)
    {
        String ans = word;
        String wordHash = hash(word);
        int wordScore = score(word);

        for(var x : dictionary)
        {
            if(wordHash.equals(hash(x)))
            {
                int xScore = score(x);
                if(wordScore < xScore)
                {
                    ans = x;
                    wordScore = xScore;
                }
            }
        }
        return ans;
    }

    private String hash(String a)
    {
        var chArray = a.toCharArray();
        Arrays.sort(chArray);
        return new String(chArray);
    }

    private int score(String a)
    {
        int ans = 0;

        for(int i = 0; i < a.length() - 1; i++)
            ans += Math.abs(a.charAt(i) - a.charAt(i + 1));

        return ans;
    }
}
