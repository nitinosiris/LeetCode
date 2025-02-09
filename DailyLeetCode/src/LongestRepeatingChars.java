public class LongestRepeatingChars {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // Frequency array for characters A-Z
        int left = 0, maxFreq = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // If window is invalid, shrink it from the left
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--; // Reduce frequency of left character
                left++; // Move left pointer
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
