public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.child[c - 'a'] == null)
            {
                TrieNode node = new TrieNode();
                curr.child[c - 'a'] = node;
            }
            curr = curr.child[c - 'a'];
        }
        curr.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.child[c - 'a'] == null)
                return false;
            else
                curr = curr.child[c - 'a'];
        }
        return curr.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray())
        {
            if(curr.child[c - 'a'] == null)
                return false;
            else
                curr = curr.child[c - 'a'];
        }
        return true;
    }
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean wordEnd;
    }

}

