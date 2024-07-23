class Solution {
    public int maxProfit(int[] prices) {
        // similar to bttbass 1, dont overthink

        // 1. buy when increasing and add it to the profit
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}