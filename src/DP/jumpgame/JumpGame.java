package DP.jumpgame;

public class JumpGame {

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        jg.canJump(new int[]{0,2,3});
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return true;
        }

        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= (i + nums[i]) && j < n; j++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[n-1] < Integer.MAX_VALUE;
    }
}
