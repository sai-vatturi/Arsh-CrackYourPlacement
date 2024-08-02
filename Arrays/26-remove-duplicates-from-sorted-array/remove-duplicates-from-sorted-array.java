class Solution {
    public int removeDuplicates(int[] nums) {
        // Use Two Pointer Method
        // 1. Set i at first index, j at second index
        // 2. if i and j are both same, while j != i, increment j
        // 3. if they became different, increment i, swap with j
        //4. loop unitl j reaches end
        int i = 0;
        int j = 1;
        int count = 1;

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } 
            else {
                nums[++i] = nums[j];
                count++;
            }
        }

        return count;
    }
}