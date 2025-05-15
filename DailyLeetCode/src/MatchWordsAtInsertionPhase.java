public class MatchWordsAtInsertionPhase {
    /*
        Given two strings, s1 and s2, determine whether they differ only by the insertion of a contiguous phrase in one of the strings,
        such that the remaining parts of the strings appear in the same order and are otherwise identical.
        The inserted phrase can consist of one or more words, and must be contiguous (i.e., not interleaved with the original text).
        The insertion must not modify, delete, or rearrange the original words in s1.
        Return true if s2 can be formed by inserting such a phrase into s1; otherwise, return false.
     */

    public boolean check(String a, String b)
    {
        var aWords = a.split(" ");
        var bWords = b.split(" ");

        if (aWords.length == bWords.length)
            return false;

        if (aWords.length > bWords.length) {
            var temp = aWords;
            aWords = bWords;
            bWords = temp;
        }

        int aptr = 0;
        int bptr = 0;

        while (aptr < aWords.length && bptr < bWords.length && aWords[aptr].equals(bWords[bptr])) {
            aptr++;
            bptr++;
        }

        while (bptr < bWords.length && (aptr >= aWords.length || !bWords[bptr].equals(aWords[aptr]))) {
            bptr++;
        }

        while (aptr < aWords.length && bptr < bWords.length && aWords[aptr].equals(bWords[bptr])) {
            aptr++;
            bptr++;
        }

        return aptr == aWords.length && bptr == bWords.length;
    }
}
