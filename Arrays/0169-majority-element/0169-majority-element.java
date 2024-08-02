class Solution {
    public int majorityElement(int[] nums) {
        // Optimal Solution
        // Keep track of count and variable that has occured max times
        int max = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                max = num;
                count++;
            }
            else if (max == num) {
                count++;
            }
            else {
                count--;
            }
        }

        return max;
    }
}