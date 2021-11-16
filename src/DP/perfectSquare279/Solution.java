package DP.perfectSquare279;

import java.util.Arrays;

public class Solution {

    public int numSquares(int n) {
        if (n < 3) {
            return n;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        return helper(n, dp);
    }

    private int helper(int target, int[] dp) {
        if (dp[target] != 10001) {
            return dp[target];
        }

        int maxSquare = 2;

        while (maxSquare * maxSquare <= target) {
            maxSquare++;
        }

        dp[target] = 10001;
        for (int i = maxSquare - 1; i >= 1; i--) {
            dp[target] = Math.min(dp[target], 1 + helper(target - (i*i), dp));
        }


        return dp[target];

    }

}
