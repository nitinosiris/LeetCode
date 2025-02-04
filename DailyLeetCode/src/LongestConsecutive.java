import java.util.HashSet;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) { // Start of a sequence
                int currNum = num;
                int count = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    count++;
                }

                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }
}
