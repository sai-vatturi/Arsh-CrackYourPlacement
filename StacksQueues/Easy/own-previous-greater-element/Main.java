
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 20, 40, 12, 30}; // Expected output: -1, 10, 4, -1, -1, 40, 40
        int[] res = previousGreaterElement(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] previousGreaterElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
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
