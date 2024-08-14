import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1, 6, 4, 10, 2, 5};
        int[] res = previousSmallerElement(arr, arr.length);
        System.out.println(Arrays.toString(res));
    }

    public static int[] previousSmallerElement(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

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
}
