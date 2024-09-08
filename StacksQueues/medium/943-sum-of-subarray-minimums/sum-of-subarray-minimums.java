class Solution {
    /*
        Brute Force: O(n3) || Optimizing gets O(n2)
        ===========
        1. Generate all subarrays and keep track of the min value
        2. Add the minimum value to a sum and return it in the end

        Stack Approach: Time: O(5n) Space: O(5n)
        ==============
        Intuition:
         The number of subarrays that an element will occur is equal to 
            length of previous smaller element * length of next smaller element

        Approach:
        1. Have two arrays for previous smaller element and next smaller element and return indexes of previous smallest and next smallest elements.
        2. For every element do the calculattion pse * nse * curElement and add it to total
        3. In the end return the array

        Note:
        If the element doesn't have a pse or nse, then use 0 for pse and n for nse
    */

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        long sum = 0;

        int[] pse = previousSmallerElement(arr);
        int[] nse = nextSmallerElement(arr);

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int previous = pse[i];
            int next = nse[i];

            int leftCount = i - previous;
            int rightCount = next - i;
            sum = (sum + ((long) curr * leftCount * rightCount) % MOD) % MOD;
        }

        return (int) sum;
    }

    public static int[] previousSmallerElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        return res;
    }

    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        return res;
    }


    // Brute force approach:
    // public int sumSubarrayMins(int[] arr) {
    //     int MOD = 1000000007;
    //     int sum = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         int min = arr[i];
    //         for (int j = i; j < arr.length; j++) {
    //             min = Math.min(arr[j], min);
    //             sum = (sum + min) % MOD;
    //         }
    //     }
    //     return sum;
    // }
}