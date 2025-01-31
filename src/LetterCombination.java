import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    private char[][] array = {
            {}, {}, // index 0 and 1 are not used as per the problem description
            {}, {}, // index 1 is not used
            {'a', 'b', 'c'}, // 2
            {'d', 'e', 'f'}, // 3
            {'g', 'h', 'i'}, // 4
            {'j', 'k', 'l'}, // 5
            {'m', 'n', 'o'}, // 6
            {'p', 'q', 'r', 's'}, // 7
            {'t', 'u', 'v'}, // 8
            {'w', 'x', 'y', 'z'}  // 9
    };

    public List<String> letterCombinations(String digits) {
        // If the input is empty, return a list with one empty string
        if (digits.isEmpty()) {
            List<String> result = new ArrayList<>();
//            result.add("");
            return result;
        }

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: if the current string's length equals the digits' length
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the digit at the current position and convert it to integer
        int digit = digits.charAt(index) - '0';  // This gives us the numeric value of the character (2-9)

        // Loop through all possible characters for this digit
        for (char c : array[digit]) {
            current.append(c);            // Add the current character to the current string
            backtrack(digits, index + 1, current, result); // Move to the next digit
            current.deleteCharAt(current.length() - 1); // Backtrack by removing the last character
        }
    }
}
