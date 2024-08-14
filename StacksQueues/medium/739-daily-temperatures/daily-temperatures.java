class Solution {
    /*
        Brute Force: (Double FOR Loop)
        ============
        1. For every element find the next greatest element
        2. find the difference between i and j
        3. add it to the result array for every element and return

        Optimized Approach (Stack Approach) 
        ====================================
        1. Traverse through the end of the array
        2. while the top of the stack is not empty and less than current index element, pop the elements from the stack.
        3. if stack is empty, then 0 else, difference between the indexes and after all elements, return res array
    */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = st.peek() - i;
            }
            st.push(i);
        }

        return res;
    }
}