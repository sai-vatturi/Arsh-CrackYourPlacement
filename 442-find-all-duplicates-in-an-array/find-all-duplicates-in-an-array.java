class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Use Array Marking technique
        // 1. Iterate through the array and mark the element index position as -
        // 2. while adding if the element is already negative, that means it is already marked and appearing again so add that element
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            }
            else {
                res.add(num);
            }
        }
        return res;
    }
}