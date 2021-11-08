package DP.uniqueBST_96;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.numTrees(7);
    }

    public int numTrees(int n) {
        int result = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) {
            dp[i] = helper(i, dp);
        }

        return dp[n];
    }

    private int helper(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (dp[i] * dp[n - i - 1]);
        }

        return result;
    }

}
