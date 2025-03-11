import java.util.Arrays;

public class WeakChac {
    public int numberOfWeakCharacters(int[][] properties) {
        // Sort by attack in descending order, and if attack is the same, sort by defense in ascending order
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int maxDefense = 0;
        int count = 0;

        for (int[] p : properties) {
            if (p[1] < maxDefense) {
                count++; // It's a weak character
            } else {
                maxDefense = p[1]; // Update maxDefense seen so far
            }
        }

        return count;
    }
}
