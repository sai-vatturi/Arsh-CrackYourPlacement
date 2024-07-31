class Solution {
    public String reverseWords(String s) {
        String[] out = s.trim().split("\\s+");
        StringBuilder output = new StringBuilder();
        for (int i = out.length - 1; i > 0; i--) {
            output.append(out[i]);
            output.append(" ");
        }
        output.append(out[0]);
        return output.toString();
    }
}