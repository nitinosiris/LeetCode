import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        generatePartitions(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void generatePartitions(String s, int index, List<String> currentPartition, List<List<String>> result)
    {
        if(index == s.length())
        {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // Extract substring from index to i
            String substring = s.substring(index, i + 1);

            // check if it is palindrome
            if(isPalindrome(substring)) {
                // Choose this substring as a partition
                currentPartition.add(substring);

                // Recur for the remaining part of the string
                generatePartitions(s, i + 1, currentPartition, result);
                // Backtrack: Remove the last added partition to try a new possibility
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
