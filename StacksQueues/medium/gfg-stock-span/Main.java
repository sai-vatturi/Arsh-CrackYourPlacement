import java.util.Stack;

class Solution {
    /*
        Stack Approach:
        ===============
        1. While not stack is Empty, and price of the top elements is lesser than current keep popping
        2. If stack is empty(), that means there is no element greater than it, so make it i + 1
        3. Else, difference between the top element and current index. and push element to the stack.
    */
    public static int[] calculateSpan(int price[], int n) {
        int[] res = new int[n];
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            while(!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = i + 1;
            } else {
                res[i] = i - st.peek();
            }
            st.push(i);
        }
        return res;
        
    }
}