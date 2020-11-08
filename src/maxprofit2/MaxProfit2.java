package maxprofit2;

public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int totalProfit = 0;
        int minIndex = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] < prices[i-1]) {
                minIndex = i;
                continue;
            }

            totalProfit += prices[i] - prices[i-1];
        }

        return totalProfit;
    }
}
