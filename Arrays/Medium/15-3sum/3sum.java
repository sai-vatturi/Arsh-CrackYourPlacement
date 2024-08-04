class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Brute Force / Recursion:
        // Triple for loop

        // Optimal:
        // *** ALWAYS REMEMBER FOR 3SUM WE WONT USE HASHMAP LIKE 2SUM
        // *** INSTEAD WE SORT THE ARRAY AND LEFT RIGHT POINTERS

        // 1. Sort the array
        // 2. Run a FOR loop from start to end and loop Write inside for loopp skip duplicate numbers
        // 3. If not a duplicate then create a window for J and N variables and write conditions so that sum of these 3 will be 0

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
                else if (sum < 0) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }

        return res;
    }
}