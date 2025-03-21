public class InsertionPhrase {
    //    Given two strings s1 and s2, find out if they only differ by the insertion of a phrase.
    //    Example:
    //    The boy goes to the hospital
    //    The cute little boy goes to the hospital
    //    'cute litte' is the added phrase everything else is the same so return True

    public static boolean check(String s1, String s2) {
        if (s2.length() < s1.length()) {
            var s = s2;
            s2 = s1;
            s1 = s;
        }

        String[] s1Array = s1.split(" ");
        String[] s2Array = s2.split(" ");

        int i = 0;
        int j = 0;

        while (i < s1Array.length && j < s2Array.length) {
            if (s1Array[i].equals(s2Array[j])) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if (i == s1Array.length)
            return true;

        return false;
    }
}
