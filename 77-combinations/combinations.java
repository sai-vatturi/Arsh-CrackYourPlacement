class Solution {
    /*
        Backtracking Solution:
        ----------------------
        1. Use result 2d arraylist and temp 1d arraylist
        2. Iterate through the numbers and keep adding to an array
        3. if number of elements in the array == k, add it the result list
        4. while returning, backtrack by removing the last added element to the array.
        5. continue for all elements and return result list at the end

    */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    private void combinations(List<List<Integer>> result, List<Integer> temp, int start, int n, int k) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            temp.add(i); 
            combinations(result, temp, i + 1, n, k);
            temp.remove(temp.size() - 1); 
        }
    }
}