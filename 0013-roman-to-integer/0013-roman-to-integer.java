class Solution {
    public int romanToInt(String s) {
        int[] sI = new int[s.length()];
        int res = 0;
        
        for(int i = 0; i<s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I' : 
                {
                    sI[i] = 1;
                    break;
                }
                case 'V' : 
                {
                    sI[i] = 5;
                    break;
                }
                case 'X' : 
                {
                    sI[i] = 10;
                    break;
                }
                case 'L' : 
                {
                    sI[i] = 50;
                    break;
                }
                case 'C' : 
                {
                    sI[i] = 100;
                    break;
                }
                case 'D' : 
                {
                    sI[i] = 500;
                    break;
                }
                case 'M' : 
                {
                    sI[i] = 1000;
                    break;
                }
            }
        }

        int i = 0;
        for(i = 0; i < s.length() - 1; i++) {
            if 
                (sI[i] < sI[i+1]) res-= sI[i];
            else 
                res += sI[i];
        }
        res += sI[i];
        return res;
    }
}