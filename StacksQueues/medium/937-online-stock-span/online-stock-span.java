import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {
    /*
        This question is similar to stock span but the difference is, in stock span we need to return res array for all prices, but here we have to return the current elements span

        1. Create an array list and stack
        2. Add any incoming price to the list
        3. now perform typical stock span procedure
            --- While stack not empty and top <= price, pop elements
            --- if empty, then the leneth of the stack, else, difference in indexes
            --- push current index and return ans
    */

    ArrayList<Integer> list;
    Stack<Integer> stack;

    public StockSpanner() {
        list = new ArrayList<>();
        stack = new Stack<>();
    }
    
    public int next(int price) {
        list.add(price);

        while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
            stack.pop();
        }

        int ans = 0;
        if (stack.isEmpty()) {
            ans = list.size();
        } else {
            ans = list.size() - stack.peek() - 1;
        }
        stack.push(list.size() - 1);

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */