class Solution {
    /*
        Reverse Polish Notation - Postfix expression
        ============================================
        1. Iterate over the tokens
        2. Use the stack to push incoming numbers into the stack
        3. For any operator stack, pop the element form the stack and calculate the operator with the incoming stack.
        4. The last element in the stack is the result
    */
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        
        while (i < n) {
            String ch = tokens[i];

            if (ch.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (ch.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (ch.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (ch.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }

        return stack.peek();
    }
}