import java.util.Stack;


class Solution
{
    /*
        1. Traverse through the string and add numbers to the stack
        2. In case any expression occurs, pop the top two numbers, and do the expression operation and push them back to the stack
        3. In the end, return the top most element of the stack
    */
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> stack = new Stack<>();
        
        for (char ch : S.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push((int) ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                
                switch (ch) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        
        return stack.peek();
    }
}