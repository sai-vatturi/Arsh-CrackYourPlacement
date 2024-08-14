import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 3};
        int[] res = nextSmallerElement(arr);
        System.out.println(Arrays.toString(res));
    }

    /*
        Brute Force Approach: (Double FOR Loops):
        ========================================
        1. Traverse through every element in the array in the outer for loop
        2. Use another inner for loop to find the next smaller element, if j reached end, and element not found, make it -1
        3. return res array

        Optimal Approach (Stack):
        ========================


     */

    // Optimal mehthod:
    public static int[] nextSmallerElement(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return res;
        
    }

     // Brute force method
    // public static int[] nextSmallerElement(int[] arr) {
    //     int[] res = new int[arr.length];
        
    //     for (int i = 0; i < arr.length; i++) {
    //         int j;
    //         for (j = i + 1; j < arr.length; j++) {
    //             if (arr[j] < arr[i]) {
    //                 res[i] = arr[j];
    //                 break;
    //             }
    //         }
    //         if (j == arr.length) {
    //             res[i] = -1;
    //         }
    //     }
        
    //     return res;
    // }
}
