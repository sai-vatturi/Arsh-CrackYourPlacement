class Solution {
    public int maxProfit(int[] prices) {
        // 1. Dont over think it 
        // 2. Have two variables lowest_price_so_far and max_profit_so_far
        // 3. Simply iterate over the loop and update lowest_price_so_far if the current element is smaller than it.
        // 4. similarly, in every iteration update max profit with the current difference between lowest_so_far and max_profit_so_far
        // 5. return lowest so far
        
        int lowest_so_far = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowest_so_far) {
                lowest_so_far = prices[i];
            }
            max_profit = Math.max(max_profit, prices[i] - lowest_so_far);
        }

        return max_profit;
    }
}