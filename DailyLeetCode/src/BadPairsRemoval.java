import java.util.Stack;

public class BadPairsRemoval {
    public String BadPairs(String input)
    {
        if(input.length() == 0)
            return "";

        Stack<Character> stack = new Stack<>();

        for(var ch : input.toCharArray())
        {
            if(stack.isEmpty())
                stack.push(ch);
            else
            {
                // curr is upper caps and stack is lower or
                // curr is lower and stack is upper
                if(Character.isUpperCase(ch) && stack.peek() == Character.toLowerCase(ch) ||
                        Character.isLowerCase(ch) && stack.peek() == Character.toUpperCase(ch))
                    stack.pop();
                else
                    stack.push(ch);
            }
        }

        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty())
            str.append(stack.pop());

        str.reverse();
        return str.toString();
    }
}
