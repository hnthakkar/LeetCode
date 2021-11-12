package DP.buyAndSellStockWithCoolDown309;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.maxProfit(new int[] {1,2,3,0,2});
        sol.maxProfit(new int[] {1,2,3,0,2});
    }

    /*
    2D Matrix DP, time out
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxTransactions = len/2;

        int[][] dp = new int[maxTransactions + 1][len];

        for (int t = 1; t <= maxTransactions; t++) {
            for (int day = 1; day < len; day++) {
                int oneMoreTransaction = prices[day] - prices[0];
                for (int i = 0; i < day; i++) {
                    oneMoreTransaction = Math.max(oneMoreTransaction, prices[day] - prices[i] + ( i - 3 >= 0 ? dp[t - 1][i - 3 + 1] : 0));
                }

                dp[t][day] = Math.max(dp[t][day - 1], oneMoreTransaction);
            }
        }

        return dp[maxTransactions][len -1];
    }

     */

    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 1) {
            return 0;
        }

        int[] buy = new int[len];
        int[] sell = new int[len];

        buy[0] = - prices[0];

        for (int i = 1; i < len; i++) {
            buy[i] = Math.max(buy[i - 1], (i - 2 >= 0 ? sell[i - 2] : 0) - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[len - 1];
    }


}
