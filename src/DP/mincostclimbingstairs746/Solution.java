package DP.mincostclimbingstairs746;

public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int noOfStairs = cost.length;

        int[] dp = new int[noOfStairs + 1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        int curCost = 0;
        for (int i = 2; i < noOfStairs + 1; i++) {
            curCost = i == noOfStairs ? 0: cost[i];
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + curCost;
        }

        return dp[noOfStairs];
    }

}
