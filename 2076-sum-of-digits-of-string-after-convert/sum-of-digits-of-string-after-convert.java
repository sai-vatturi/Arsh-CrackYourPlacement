class Solution {
    /*
        1. First apply the convert function and form a new number from the string
        2. Next apply transform function k times and return the number
    */
    public int getLucky(String s, int k) {
        
        StringBuilder num = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int transformedNum = (int) (ch - 'a') + 1;
            num.append(String.valueOf(transformedNum));
        }

       
        for (int i = 0; i < k; i++) {
            String number = transform(num.toString());
            num = new StringBuilder(number);
        }

        return Integer.parseInt(num.toString());
    }

    public String transform(String num) {
        long val = 0;
        for (int i = 0; i < num.length(); i++) {
            val += (int) num.charAt(i) - '0';
        }
        return String.valueOf(val);
    }
}