public class SumOfPrefix {
    public class Node
    {
        Node[] children = new Node[26];
        int prefixCount = 0;
    }

    private void Insert(Node root, String key)
    {
        Node curr = root;
        for (char c : key.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new Node();

            curr.children[c - 'a'].prefixCount++;
            curr = curr.children[c - 'a'];

        }
    }

    private int PrefixCount(Node root, String key)
    {
        Node curr = root;
        int ans = 0;
        for (char c : key.toCharArray())
        {
            ans += curr.children[c - 'a'].prefixCount;
            curr = curr.children[c - 'a'];
        }
        return ans;
    }

    private Node root;
    public int[] sumPrefixScores(String[] words) {
        root = new Node();

        for (String word : words)
            Insert(root, word);

        // HashMap<String, Integer> map = new HashMap<>();
        int[] sum = new int[words.length];

        for (int i = 0; i < words.length; i++)
        {
            sum[i] = PrefixCount(root, words[i]);
        }
        return sum;
    }
}
