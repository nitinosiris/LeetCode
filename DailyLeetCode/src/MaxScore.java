import java.util.ArrayList;
import java.util.List;

public class MaxScore {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for (List<Integer> neighbors : adj) {
            neighbors.sort((x, y) -> Integer.compare(scores[y], scores[x]));
            while (neighbors.size() > 3) {
                neighbors.remove(neighbors.size() - 1);
            }
        }

        int maxScore = -1;

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];

            for (int c : adj.get(a)) {
                if (c == b) continue; // Avoid cycles

                for (int d : adj.get(b)) {
                    if (d == a || d == c) continue;

                    int score = scores[a] + scores[b] + scores[c] + scores[d];
                    maxScore = Math.max(maxScore, score);
                }
            }
        }

        return maxScore;
    }
}
