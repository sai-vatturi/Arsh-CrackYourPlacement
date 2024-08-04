class Solution {
    public void sortColors(int[] nums) {
        // Dutch National Flag Algorithm
        // 1. Here, we use the mid pointer as our main pivot
        // 2. if mid is 1, just move it further
        // 3. if it is 0, it should be swapped with low index and low mid incremented
        // 4. if it is 2, is should be swapped with high index and high decremented
        int start = 0;
        int mid = 0;
        int end = nums.length - 1;

        while (mid <= end) {
            if (nums[mid] == 0) {
                swap(nums, start, mid);
                start++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, end);
                end--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}