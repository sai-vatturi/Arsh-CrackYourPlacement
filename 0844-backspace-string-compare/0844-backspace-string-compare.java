class Solution {
    /*
        Method - 1: Using Stacks Time: O(s + t) Space: O(s + t)
        ========================
        1. Use two stacks and push characters into the stacks
        2. if # occurs, pop the top most element
        3. In the end, compare both the stack and return if both are equal

        Method - 2: Using pointers
        ===========================
        1. Traverse from the back of the both the string with two different pointers
        2. Write a function to get the index of next valid character from both the strings
        3. if both characters are same, then contiue, else return false;
    */
        public boolean backspaceCompare(String s, String t) {
            int i = s.length() - 1;
            int j = t.length() - 1;

            while (i >= 0 || j >= 0) {
                i = getNextValidCharIndex(s, i);
                j = getNextValidCharIndex(t, j);

                if (i < 0 && j < 0) {
                    return true; 
                }

                if (i < 0 || j < 0 || s.charAt(i) != t.charAt(j)) {
                    return false;
                }

                i--;
                j--;
            }

            return true; 
        }

        private int getNextValidCharIndex(String str, int index) {
            int skip = 0;

            while (index >= 0) {
                if (str.charAt(index) == '#') {
                    skip++;
                    index--;
                } else if (skip > 0) {
                    skip--;
                    index--;
                } else {
                    break;
                }
            }

            return index;
        }
    /*
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '#' && !s1.isEmpty()) {
                s1.pop();
            } else {
                s1.push(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#' && !s2.isEmpty()) {
                s2.pop();
            } else {
                s2.push(ch);
            }
        }

        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }
        return s1.isEmpty() && s2.isEmpty();
    }
    */
}