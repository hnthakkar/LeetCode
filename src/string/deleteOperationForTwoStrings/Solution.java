package string.deleteOperationForTwoStrings;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minDistance("sea", "ate");
    }

    public int minDistance(String word1, String word2) {
        char[] s1Array = word1.toCharArray();
        int len1 = s1Array.length;

        char[] s2Array = word2.toCharArray();
        int len2 = s2Array.length;

        int lcs = longestCommonSubsequence(s1Array, len1, s2Array, len2);

        return len1 + len2 - 2 * lcs;
    }

    private int longestCommonSubsequence(char[] s1Array, int len1, char[] s2Array, int len2) {
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }

                if (s1Array[i - 1] == s2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[len1][len2];
    }
}
