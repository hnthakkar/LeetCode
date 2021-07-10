package DP.jumpgame4;

import DP.jumpgame.JumpGame;

public class JumpGame4 {

    public static void main(String[] args) {
        JumpGame4 jg = new JumpGame4();
        jg.canJump("01101110", 2, 3);
    }

    public boolean canJump(String s, int minJump, int maxJump) {
        char[] sArray = s.toCharArray();
        int n = sArray.length;

        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = minJump; i < n; i++) {
            if (sArray[i] == '1') {
                continue;
            }
            for (int j = i - minJump; j >= 0 && j >= i - maxJump; j--) {
                dp[i] = dp[i] || dp[j];
            }
        }

        return dp[n-1];
    }
}
