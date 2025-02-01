public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length
            // res++;
            int l = i, r = i;
            while (l >= 0 && r < s.length() &&
                    s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }

            // even length
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() &&
                    s.charAt(l) == s.charAt(r)) {
                l--;
                res++;
                r++;
            }
        }
        return res;
    }
}
