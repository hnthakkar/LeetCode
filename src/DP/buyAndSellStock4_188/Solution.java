package DP.buyAndSellStock4_188;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
    }

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k == 0 || len == 0) {
            return 0;
        }

        int[][] dp = new int[k + 1][len];

        for (int t = 1; t <= k; t++) {
            for (int day = 1; day < len; day++) {
                dp[t][day] = dp[t][day - 1];

                for (int i = 0; i <= day; i++) {
                    dp[t][day] = Math.max(dp[t][day], prices[day] - prices[i] + dp[t - 1][i]);
                }
            }
        }

        return dp[k][len - 1];
    }
}
