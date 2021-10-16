package DP.buyandsellstock123simpleway;

public class Solution1 {

    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 1) {
            return 0;
        }

        int t1_profit_after_buy = -prices[0];
        int t1_profit_after_sell = 0;
        int t2_profit_after_buy = Integer.MIN_VALUE;
        int t2_profit_after_sell = 0;

        for (int i = 1; i < len; i++) {
            // Always maximize profit

            // profit after buy in T1
            t1_profit_after_buy = Math.max(t1_profit_after_buy, -prices[i]);

            // profit after sell in T1
            t1_profit_after_sell = Math.max(t1_profit_after_sell, prices[i] + t1_profit_after_buy);

            // profit after buy in T2
            t2_profit_after_buy = Math.max(t2_profit_after_buy, t1_profit_after_sell - prices[i]);

            // profit after sell in T2
            t2_profit_after_sell = Math.max(t2_profit_after_sell, prices[i] + t2_profit_after_buy);
        }

        return t2_profit_after_sell;
    }

}
