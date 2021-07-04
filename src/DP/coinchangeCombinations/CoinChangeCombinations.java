package DP.coinchangeCombinations;

import DP.coinchange.CoinChange;

public class CoinChangeCombinations {

    public static void main(String[] args) {
        CoinChangeCombinations cc = new CoinChangeCombinations();
        cc.coinChange(new int[]{1,2,5},5);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 1;
        }

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        // first column all zero's
        for (int r = 0; r < n; r++) {
            dp[r][0] = 1;
        }

        for (int c = 1; c <= amount; c++) {
            if (c % coins[0] == 0) {
                dp[0][c] = 1;
            }
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c <= amount; c++) {
                dp[r][c] = dp[r-1][c];

                if (c - coins[r] >= 0) {
                    dp[r][c] += dp[r][c - coins[r]];
                }
            }
        }

        return dp[n -1][amount];
    }
}
