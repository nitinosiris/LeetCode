import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nextWord {
    /*
    You are given a collection of sentences represented as a list of word sequences.
    Each sentence is a list of strings, where each string denotes a word in the sentence. 4
    From this dataset, construct a language model that captures word-to-word transitions based on frequency.
    Design a function that, given an input word, returns the most probable word that follows it across all sentences.
    If multiple words follow with the same highest frequency, return any one of them.
    Input:
        A list of sentences sentences, where each sentence is a list of strings.
        A single string word.
    Output:
        A string representing the most probable word that directly follows the given input word in the dataset.
    Constraints:
        All words are case-sensitive.
        The input word will appear at least once in the dataset, and it will not be the last word in every occurrence.
    Objective:
        Return the word that most frequently appears immediately after the input word across all sentences.
     */
    public String NextWord(List<List<String>> sentences, String currWord)
    {
        HashMap<String, List<String>> map = new HashMap<>();

        for(var sentence : sentences)
        {
            for(int i = 0; i < sentence.size() - 1; i++)
            {
                var curr = sentence.get(i);
                var next = sentence.get(i + 1);
                map.computeIfAbsent(curr, a -> new ArrayList<>()).add(next);
            }
        }

        var list = map.get(currWord);
        return mostFrequentWord(list);

    }

    public String mostFrequentWord(List<String> words) {
        if (words == null || words.isEmpty()) {
            return null;
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        String mostFrequent = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequent = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequent;
    }
}
