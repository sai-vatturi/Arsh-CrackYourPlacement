class Solution {
    /*
        1. Insert two pointers at front and end
        2. Check if it is palindrome, if not add the last character to result Stringbuilder
        3. continue until end comes to start
        4. Add result + orignal String and return the answer
    */
    public String shortestPalindrome(String s) {
        int j = s.length() - 1;
        StringBuilder res =  new StringBuilder();
        
        while (j > 0) {
            if (isPalindrome(s, 0, j)) {
                break;
            } 
            res.append(s.charAt(j));
            j--;
        }

        res.append(s);
        return res.toString();
    }

    public boolean isPalindrome(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}