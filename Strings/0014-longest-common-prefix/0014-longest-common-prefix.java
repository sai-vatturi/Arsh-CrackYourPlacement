class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String currentRes = "";
            int k = 0;
            int minLength = Math.min(res.length(), strs[i].length());
            while ((k < minLength) && (res.charAt(k) == strs[i].charAt(k))) {
                currentRes += res.charAt(k);
                k++;
            }
            res = currentRes;
        }
        return res;
    }
}