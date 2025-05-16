public class LexioSmallnext {
    public int maxLexSmall(String input) {
        int n = input.length();
        int[] leftmost = new int[26];
        int[] rightmost = new int[26];

        for (int i = 0; i < 26; i++) {
            leftmost[i] = n;
            rightmost[i] = -1;
        }


        for (int i = 0; i < n; i++) {
            int idx = input.charAt(i) - 'a';
            leftmost[idx] = Math.min(leftmost[idx], i);
            rightmost[idx] = Math.max(rightmost[idx], i);
        }

        int ans = 0;

        for (int c1 = 0; c1 < 25; c1++) {
            for (int c2 = c1 + 1; c2 < 26; c2++) {
                if (leftmost[c1] < n && rightmost[c2] != -1) {
                    int length = rightmost[c2] - leftmost[c1] + 1;
                    ans = Math.max(ans, length);
                }
            }
        }

        return ans;
    }
}
