class Solution {
    // Two methods
    // Method 1: Generate all permutations using swapping technique and use a hashset to exlude duplicates

    // Method 2: Generate all permutatoins using boolean array technique and use a hashset to exclude duplicates

    // Method 3: Generate all permutations and avoid duplicates by (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])



    // Method 1
    /*
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        getPermutations1(nums, set, 0);
        return new ArrayList<>(set);

    }

    public static void getPermutations1(int[] nums, HashSet<List<Integer>> set, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) list.add(i);
            set.add(list);
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            getPermutations1(nums, set, index + 1);
            swap(nums, i, index);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    */


    // Method 2
    /*
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        printPermutations2(nums, new boolean[nums.length], new ArrayList<>(), set);
        return new ArrayList<>(set);

    }
    public static void printPermutations2(int[] nums, boolean[] used, List<Integer> list, HashSet<List<Integer>> set) {
        if (list.size() == nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            else {
                used[i] = true;
                list.add(nums[i]);
                printPermutations2(nums, used, list, set);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
    */

    // Method 3
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        printPermutations3(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;

    }
    public static void printPermutations3(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            else {
                used[i] = true;
                list.add(nums[i]);
                printPermutations3(nums, used, list, res);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}