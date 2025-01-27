import java.util.HashMap;
import java.util.TreeMap;

public class HandQuestion {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // If the total number of cards is not divisible by groupSize, it's impossible
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Count the frequency of each card
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Use a TreeMap to automatically sort the keys in ascending order
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(map);

        // Iterate over the sorted keys and form groups
        for (int card : sortedMap.keySet()) {
            int count = sortedMap.get(card);

            if (count > 0) {
                // Try to form a group starting with this card
                for (int i = 0; i < groupSize; i++) {
                    int nextCard = card + i;

                    // If the next card is not available or its count is insufficient
                    if (sortedMap.getOrDefault(nextCard, 0) < count) {
                        return false;
                    }

                    // Deduct the count for the next card
                    sortedMap.put(nextCard, sortedMap.get(nextCard) - count);
                }
            }
        }

        return true;
    }
}
