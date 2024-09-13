class Pair {
    char ch;
    int i;

    public Pair(char ch, int i) {
        this.ch = ch;
        this.i = i;
    }
}

class Solution {
    /*
        Stack Approach:
        ===============
        1. Create a pair class of character and integer to store that character and no of times it appeared
        2. if the top of the stack is equal to k, remove it k times
        3. Repeat until the end of the string and return all the values in stack in a string
    */
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == ch) {
                stack.push(new Pair(ch, stack.peek().i + 1));
            } else {
                stack.push(new Pair(ch, 1));
            }
            if (stack.peek().i == k) {
                for (int i = 0; i < k; i++) {
                    stack.pop();
                }
            }
        }

       
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop().ch);
        }

        return sb.toString();
    }
}