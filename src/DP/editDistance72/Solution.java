package DP.editDistance72;

public class Solution {

    public int minDistance(String word1, String word2) {
        char[] w1Array = word1.toCharArray();
        int w1Len = w1Array.length;

        char[] w2Array = word2.toCharArray();
        int w2Len = w2Array.length;

        if (w1Len == 0) {
            return w2Len;
        }

        if (w2Len == 0) {
            return w1Len;
        }


        int[][] dp = new int[w1Len + 1][w2Len + 1];

        for (int i = 0; i <= w1Len; i++) {
            for (int j = 0; j <= w2Len; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                if (w1Array[i - 1] == w2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[w1Len][w2Len];
    }

}
