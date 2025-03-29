import java.util.HashSet;

public class WordCount {
    public static int wordCount(String[] startWords, String[] targetWords) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for (String word : startWords) {
            int bitmask = 0;
            for (char c : word.toCharArray()) {
                bitmask |= (1 << (c - 'a'));
            }
            set.add(bitmask);
        }

        for (String word : targetWords) {

            int bitmask = 0;
            for (char c : word.toCharArray()) {
                bitmask |= (1 << (c - 'a'));
            }

            for (int i = 0; i < word.length(); i++) {
                int newBitMask = bitmask - (1 << (word.charAt(i) - 'a'));
                if(set.contains(newBitMask))
                {
                    ans++;
                    break;
                }

            }
        }

        return ans;
    }
}
