public class BestTimeToSellStock {
    /**
     https://leetcode.com/problems/best-time-to-buy-and-sell-stock
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int i=1;
        int curr = prices[0];
        while(i<prices.length) {
            if(prices[i]< curr) {
                curr = prices[i];
            }
            else {
                int profit = prices[i] - curr;
                max = Math.max(profit, max);
            }
            i++;
        }
        return max;
    }
}
