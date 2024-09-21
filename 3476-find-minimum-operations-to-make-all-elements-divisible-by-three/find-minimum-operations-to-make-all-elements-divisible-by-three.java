class Solution {
    /*
        1. Check if the number is divisible by 3, if not add count by 1;
        2. Continue for the whole loop and return;
    */
    public int minimumOperations(int[] nums) {
        int count = 0;
        
        for (int num : nums) {
            if (num % 3 != 0) {
                count++;
            }
        }

        return count;
    }
}