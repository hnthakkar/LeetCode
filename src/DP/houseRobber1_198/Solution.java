package DP.houseRobber1_198;

public class Solution {

    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (len == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }

        nums[2] += nums[0];

        for (int i = 3; i < len; i++) {
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }

        return Math.max(nums[len - 1], nums[len - 2]);
    }

    /*
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        if (len == 1) {
            return dp[0];
        }

        dp[1] = Math.max(nums[0], nums[1]);

        if (len == 2) {
            return dp[1];
        }

        dp[2] = Math.max(nums[0] + nums[2], nums[1]);

        int max = dp[2];
        for (int i = 3; i < len; i++) {
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

     */
}
