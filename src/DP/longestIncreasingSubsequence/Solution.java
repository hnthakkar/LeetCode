package DP.longestIncreasingSubsequence;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;

        int result = 1;

        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], (dp[j] == 0? 1: dp[j]) + 1);
                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
