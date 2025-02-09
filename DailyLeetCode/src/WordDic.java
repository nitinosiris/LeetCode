class WordDic {
    private Trie root;
    public WordDic() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.child[c - 'a'] == null)
            {
                curr.child[c - 'a'] = new Trie();
            }
            curr = curr.child[c - 'a'];
        }
        curr.wordEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, Trie node)
    {
        Trie curr = node;
        for(int i = j; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(c == '.')
            {
                for(var children : curr.child)
                {
                    if(children != null && dfs(word, i + 1, children))
                        return true;
                }
                return false;
            }
            else
            {
                if(curr.child[c - 'a'] == null)
                    return false;
                curr = curr.child[c - 'a'];
            }
        }
        return curr.wordEnd;
    }

    class Trie{
        Trie[] child = new Trie[26];
        boolean wordEnd;
    }
}
