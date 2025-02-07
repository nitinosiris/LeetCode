import java.util.*;

public class AlienDictionary {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Set<Character> allChars = new HashSet<>();

        // Initialize all unique characters in the dictionary
        for (String word : words) {
            for (char c : word.toCharArray()) {
                allChars.add(c);
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            char[] edge = findEdge(words[i], words[i + 1]);
            if (edge == null) return ""; // Invalid case (prefix issue)
            if (edge.length == 2 && edge[0] != edge[1]) {  // Add check for empty array
                adj.get(edge[0]).add(edge[1]);
            }
        }

        // Perform topological sorting
        boolean[] visited = new boolean[26];
        boolean[] onStack = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (char node : allChars) {
            if (!visited[node - 'a']) {
                if (TopoLogicalSortUtil(node, adj, visited, onStack, stack)) {
                    return ""; // Cycle detected
                }
            }
        }

        // Build the result
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private boolean TopoLogicalSortUtil(char src, Map<Character, List<Character>> adj,
                                        boolean[] visited, boolean[] onStack, Stack<Character> stack) {
        visited[src - 'a'] = true;
        onStack[src - 'a'] = true;

        for (char neighbor : adj.getOrDefault(src, new ArrayList<>())) {
            if (!visited[neighbor - 'a']) {
                if (TopoLogicalSortUtil(neighbor, adj, visited, onStack, stack))
                    return true; // Cycle detected
            } else if (onStack[neighbor - 'a']) {
                return true; // Cycle detected
            }
        }

        onStack[src - 'a'] = false;
        stack.push(src);
        return false;
    }

    public char[] findEdge(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j)) {
            i++;
            j++;
        }

        // If b is a prefix of a, return invalid case
        if (i < a.length() && j == b.length()) return null;

        return i < a.length() && j < b.length() ? new char[]{a.charAt(i), b.charAt(j)} : new char[]{};
    }
}
