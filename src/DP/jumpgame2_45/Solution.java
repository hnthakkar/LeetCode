package DP.jumpgame2_45;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.jump(new int[]{2, 3, 1, 1, 4});
    }

    public int jump(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int[] dp = new int[n];
        int min = Integer.MAX_VALUE;

        for (int i = n - 2; i >= 0; i--) {
            min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= (i + nums[i]) && j < n; j++) {
                min = Math.min(min, dp[j]);
            }

            dp[i] = min == Integer.MAX_VALUE? Integer.MAX_VALUE : min + 1;
        }

        return dp[0];
    }
}
