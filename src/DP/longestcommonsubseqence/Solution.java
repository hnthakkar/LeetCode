package DP.longestcommonsubseqence;

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1Array = text1.toCharArray();
        char[] s2Array = text2.toCharArray();

        int len1 = s1Array.length;
        int len2 = s2Array.length;

        int[][] dp = new int[len1][len2];

        boolean alreadyMatched = false;
        for (int i = 0; i < len1; i++) {
            alreadyMatched = false;
            for (int j = 0; j < len2; j++) {
                if (!alreadyMatched && s1Array[i] == s2Array[j]) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    int top = j > 0 ? dp[i][j-1]: 0;
                    int left = i > 0 ? dp[i-1][j]: 0;
                    dp[i][j] = Math.max(top, left);
                }
            }
        }

        return dp[len1-1][len2-1];
    }

}
