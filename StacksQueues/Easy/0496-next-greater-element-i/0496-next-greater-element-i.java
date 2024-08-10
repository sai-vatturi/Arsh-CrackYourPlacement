import java.util.HashMap;
import java.util.Stack;

class Solution {
        /*
        Stack and HashMap Solution:
        ================
        1. Traverse through the second loop and use stack and use hashmap to insert next greater elements to the hashmap
            Second HashMap Insertion Logic:
            1. Check top of the stack and keep removing until top of the stack is greater
            2. if stack is empty, add element, -1 to the hashmap
            3. else, add element, top of the stack.
            4. add the element to the stack.
        2. Create a new array for result
        3. Now traverse through the first array and get elements of hashmap
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = n2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        int[] res = new int[n1];
        for (int i = 0; i < n1; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}