package DP.houseRobber2_213;

public class Solution {

    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int firstIncluded = helper(nums, 0, len - 2);
        int firstExcluded = helper(nums, 1, len - 1);

        return Math.max(firstIncluded, firstExcluded);
    }

    public int helper(int[] nums, int startIndex, int endIndex) {
        int len = endIndex - startIndex + 1;

        int[] dp = new int[len];
        dp[0] = nums[startIndex];

        if (len == 1) {
            return dp[0];
        }

        dp[1] = Math.max(nums[startIndex], nums[startIndex + 1]);

        if (len == 2) {
            return dp[1];
        }

        dp[2] = Math.max(nums[startIndex] + nums[startIndex + 2], nums[startIndex + 1]);

        int max = dp[2];
        for (int i = 3; i < len; i++) {
            dp[i] = nums[startIndex + i] + Math.max(dp[i-2], dp[i-3]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }
}
