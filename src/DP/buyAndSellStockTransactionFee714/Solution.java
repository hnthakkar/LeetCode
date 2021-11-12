package DP.buyAndSellStockTransactionFee714;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maxProfit(new int[]{1,3,2,8,4,9}, 2);
    }

    /*
    Results in time out....2D Matrix

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int maxTransactions = len/2;

        int[][] dp = new int[maxTransactions + 1][len];

        for (int t = 1; t <= maxTransactions; t++) {
            for (int day = 1; day < len; day++) {
                int noTransaction = dp[t][day - 1];

                int oneMoreTransaction = prices[day] - prices[0] - 2;
                for (int i = 1; i <= day; i++) {
                    oneMoreTransaction = Math.max(oneMoreTransaction, prices[day] - prices[i] + dp[t - 1][i] - 2);
                }

                dp[t][day] = Math.max(noTransaction, oneMoreTransaction);
            }
        }

        return dp[maxTransactions][len -1];
    }

    */

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;

        if (len == 1) {
            return 0;
        }

        int buy = - prices[0];
        int sell = 0;

        int prevSell = 0;
        for (int i = 1; i < len; i++) {
            // profit after buy in T1
            buy = Math.max(buy, prevSell - prices[i]);

            // profit after sell in T1
            sell = Math.max(sell, prices[i] + buy - fee);
            prevSell = sell;
        }

        return Math.max(buy, sell);
    }

    /*

    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int days = prices.length, buy[] = new int[days], sell[] = new int[days];
        buy[0]=-prices[0];
        for (int i = 1; i<days; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]); // keep the same as day i-1, or buy from sell status at day i-1
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee); // keep the same as day i-1, or sell from buy status at day i-1
        }
        return sell[days - 1];
    }

     */

}
