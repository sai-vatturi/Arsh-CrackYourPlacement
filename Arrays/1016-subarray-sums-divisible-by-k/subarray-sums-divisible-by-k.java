class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        /*
        brute force:
        1. generate all subarrays with sum divided by 5
        2. return count of those subarrays

        optimal:
        1. The idea is to keep adding all the elements of array with current sum  and modulus k while iterating
        2. we will add the curr_sum remainder values to a hashmap and how many times it has occured
        3. if the same remainder occured again, then its means that there was a sum in between that's divisible by k
        Note: add 0, 1 to the hashmap, make sure the sums are always positive
        */
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int count = 0;
        map.put(0, 1);

        for (int i : nums) {
            currSum = (currSum + i) % k;
            currSum = (currSum + k) % k;

            if (map.containsKey(currSum)) {
                count += map.get(currSum);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}