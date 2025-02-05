import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++)
        {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.push(Integer.parseInt(tokens[i]));
            }
            else
            {
                int right = stack.pop();
                int left = stack.pop();
                int ans = 0;
                switch (tokens[i])
                {
                    case "+":
                        ans = left + right;
                        break;
                    case "-":
                        ans = left - right;
                        break;
                    case "*":
                        ans = left * right;
                        break;
                    case "/":
                        ans = left / right;
                        break;
                }
                stack.push(ans);
            }
        }
        return stack.peek();
    }
}
