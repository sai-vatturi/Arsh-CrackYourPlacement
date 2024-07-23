class Solution {
    public int subarraySum(int[] nums, int k) {
        
        /*
        Brute force solution: generate all subarrays with double for loop

        Optimal solution: Use prefixsum and hashmap pattern
        1. iterate through the array and keep on adding it to the curr_sum
        2. the idea is to add every curr_sum and how many times it has occured.
        3. and in every iteration we will check whether there is an element that's present in hashmap that gives sum of the subarray until that point as k. we will add it to the count if it present
        */


        HashMap<Integer, Integer> map = new HashMap<>();
        int curr_sum = 0;
        int count = 0;

        for (int i : nums) {
            curr_sum += i;

            if (curr_sum == k) count++;
            int value = curr_sum - k;

            if (map.containsKey(value)) {
                count += map.get(value);
            }
            map.put(curr_sum, map.getOrDefault(curr_sum, 0) + 1);
        }

        return count;
    }
}