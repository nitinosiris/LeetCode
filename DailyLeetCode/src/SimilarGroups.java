public class SimilarGroups {
    int[] parent;
    
    public static boolean isSimilar(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i) && ++count > 2){
                return false;
            }
        }
        
        return true;
    }
    
    private int find(int x) {
        if(x == parent[x])
            return x;
        
        return parent[x] = find(parent[x]);
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int group = strs.length;

        for (int i = 0; i < strs.length - 1; i++)
        {
            for (int j = i + 1; j < strs.length; j++) 
            {
                if (isSimilar(strs[i], strs[j])) 
                {
                    int p1 = find(i);
                    int p2 = find(j);

                    if(p1 != p2)
                    {
                        parent[p2] = p1;
                        group--;
                    }
                }
            }
        }       
        return group;
    }    
}
