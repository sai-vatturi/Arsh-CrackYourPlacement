class Solution {
    public void moveZeroes(int[] nums) {
        // two pointer method
        // j will be updated as every non zero element
        // i will be looping through the array

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
