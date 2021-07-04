package DP.coinchange;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        cc.coinChange(new int[]{384,324,196,481},285);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int n = coins.length;

        if (n == 1) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return -1;
            }
        }

        int[][] dp = new int[n][amount + 1];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c<= amount; c++) {
                dp[r][c] = Integer.MAX_VALUE;
            }
        }

        // first column all zero's
        for (int r = 0; r < n; r++) {
            dp[r][0] = 0;
        }

        for (int c = 1; c <= amount; c++) {
            if (c % coins[0] == 0) {
                dp[0][c] = c / coins[0];
            }
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c <= amount; c++) {
                int includeCurrent = Integer.MAX_VALUE;
                if (c - coins[r] >= 0 && dp[r][c - coins[r]] != Integer.MAX_VALUE) {
                    includeCurrent = 1 + dp[r][c - coins[r]];
                }
                dp[r][c] = Math.min(dp[r-1][c], includeCurrent);
            }
        }

        return dp[n -1][amount] == Integer.MAX_VALUE ? -1 : dp[n -1][amount];
    }

}
