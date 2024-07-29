class Solution {
    public List<String> generateParenthesis(int n) {
        // Simple Recursion - Backtracking
        // No of outputs = refer to catalan number
        // Here, we make use of two variables opencount and close count to effectively count number of brackets we need to add
        // we always make sure that the paranthesis is valid by first generaing opening paranthesis followed by closing paranthesis
        // we will back track by removing the previously added character from the stringbuilder object
        List<String> res = new ArrayList<>();
        generateString(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    public void generateString(int n, int openCount, int closeCount, StringBuilder sb, List<String> res) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (openCount < n) {
            sb.append('(');
            generateString(n, openCount + 1, closeCount, sb, res);
            sb.deleteCharAt(sb.length() - 1);

        }
        if (closeCount < openCount) {
            sb.append(')');
            generateString(n, openCount, closeCount + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}