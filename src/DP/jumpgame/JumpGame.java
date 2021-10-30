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

/*

public boolean canJump(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return true;
        }

        if (nums[0] == 0) {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 0; i < n - 1; i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= (i + nums[i]) && j < n; j++) {
                    dp[j] = true;
                }
            }
        }

        return dp[n-1];
    }

 */

/*
public boolean canJump(int[] A) {
    int max = 0;
    for(int i=0;i<A.length;i++){
        if(i>max) {return false;}
        max = Math.max(A[i]+i,max);
    }
    return true;
}
 */
