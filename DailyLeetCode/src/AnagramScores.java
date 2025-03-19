import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class AnagramScores {

//    we have a dictionary of words and a function which gives hash of these words
//    and another function which gives score=sum of diff of adjacent characters in a
//    string and implement another function which gives the anagram of the given word with highest score.
//    Hash of all anagrams is same.

    public static int hashFunction(String word) {
        // Implement hash logic
        return 0;  // Replace with actual logic
    }

    public static int scoreFunction(String word) {
        // Implement score calculation logic
        return 0;  // Replace with actual logic
    }

    public static String highestScoringAnagram(String word, List<String> wordDict) {

        int maxScore = Integer.MIN_VALUE;
        int wordHash = hashFunction(word);
        String best = "";
        for(var curr : wordDict)
        {
            if(hashFunction(curr) == wordHash)
            {
                var score = scoreFunction(curr);
                if(score > maxScore)
                {
                    maxScore = score;
                    best = curr;
                }
            }
        }

        return best;
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("listen", "silent", "enlist", "google", "loogle");
        String word = "tinsel";
        System.out.println(highestScoringAnagram(word, wordDict));  // Output: "silent"
    }
}
