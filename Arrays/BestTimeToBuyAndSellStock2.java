public class BestTimeToBuyAndSellStock2 {

    /**
     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length-1;
        int i=0;
        while(i<len) {
            while(i<len-1 && prices[i]>= prices[i+1])
                i++;
            int buy= prices[i];
            while(i<len && prices[i]<=prices[i+1])
                i++;
            profit+= prices[i] - buy;
            i++;
        }
        return profit;
    }
}
