class Solution {
    public boolean isValid(String s) {
        Stack<Character> list = new Stack<>();   
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' ||  ch == '{' || ch == '[') {
                list.push(ch);
            } else {
                if(!(list.isEmpty()) && ch == ')' && list.peek() == '('){
                    list.pop();
                }
                else if(!(list.isEmpty()) && ch == ']' && list.peek() == '[') {
                    list.pop();
                }
                else if(!(list.isEmpty()) && ch == '}' && list.peek() == '{'){
                    list.pop();
                }
                else{
                    list.push(ch);
                }
            }
        }
        return list.isEmpty();
    }
}