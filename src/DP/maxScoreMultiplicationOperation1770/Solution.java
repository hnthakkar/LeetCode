package DP.maxScoreMultiplicationOperation1770;

import java.util.Arrays;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maximumScore(new int[]{1,2,3}, new int[]{3,2,1});
    }

    private int[] nums;
    private int[] multipliers;

    private int n;
    private int m;

    private int[][] dp;

    public int maximumScore(int[] pNums, int[] pMultipliers) {
        nums = pNums;
        multipliers = pMultipliers;

        n = nums.length;
        m = multipliers.length;

        dp = new int[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 0, 0);
    }

    private int helper(int nStart, int mIndex, int alreadyDone) {
        if (mIndex >= multipliers.length) {
            return 0;
        }

        if (dp[nStart][mIndex] != -1) {
            return dp[nStart][mIndex];
        }

        int ifLeft = multipliers[mIndex] * nums[nStart] + helper(nStart + 1, mIndex + 1, alreadyDone + 1);
        int ifRight = multipliers[mIndex] * nums[n - (alreadyDone - nStart) - 1] + helper(nStart, mIndex + 1, alreadyDone + 1);

        dp[nStart][mIndex] = Math.max(ifLeft, ifRight);

        return dp[nStart][mIndex];
    }
}
