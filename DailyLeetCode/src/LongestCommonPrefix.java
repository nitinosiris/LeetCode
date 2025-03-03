public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // find smallest
        StringBuilder builder = new StringBuilder();
        int smallLen = strs[0].length();
        for(var str : strs)
            smallLen = Math.min(smallLen, str.length());

        if(smallLen == 0)
            return builder.toString();

        for(int i = 0; i < smallLen; i++)
        {
            char temp = strs[0].charAt(i);

            for(int j = 1; j < strs.length; j++)
            {
                if(temp == strs[j].charAt(i))
                    continue;
                else
                    return builder.toString();
            }

            builder.append(temp);
        }
        return builder.toString();
    }
}
