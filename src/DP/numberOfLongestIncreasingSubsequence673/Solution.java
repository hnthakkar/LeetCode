package DP.numberOfLongestIncreasingSubsequence673;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        // sol.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        // sol.findNumberOfLIS(new int[]{2, 2, 2, 2, 2});
        // sol.findNumberOfLIS(new int[]{3, 1, 2});
        sol.findNumberOfLIS(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3});
    }

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        int[] ways = new int[len];

        int max = 1;

        for (int i = len - 1; i >= 0; i--) {
            dp[i] = 1;
            ways[i] = 1;

            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        ways[i] = ways[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        ways[i] += ways[j];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                result += ways[i];
            }
        }

        return result;
    }

}
