package DP.InterleavingString97;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.isInterleave("aabcc", "dbbca", "aadbbbaccc"); // a = 8,
    }

    /*
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] s1Array = s1.toCharArray();
        int len1 = s1Array.length;

        char[] s2Array = s2.toCharArray();
        int len2 = s2Array.length;

        char[] s3Array = s3.toCharArray();
        int len3 = s3Array.length;

        if (len1 + len2 != len3) {
            return false;
        }

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[len1][len2] = true;

        for (int i = len1; i >= 0; i--) {
            for (int j = len2; j >= 0; j--) {
                if (i < len1 && s1Array[i - 1] == s3Array[i + j - 1] && dp[i + 1][j]) {
                    dp[i][j] = true;
                }

                if (j < len2 && s2Array[i - 1] == s3Array[i + j - 1] && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[0][0];
    }

     */

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] s1Array = s1.toCharArray();
        int len1 = s1Array.length;

        char[] s2Array = s2.toCharArray();
        int len2 = s2Array.length;

        char[] s3Array = s3.toCharArray();
        int len3 = s3Array.length;

        if (len1 + len2 != len3) {
            return false;
        }

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        return helper(s1Array, len1, 0, s2Array, len2, 0, s3Array, len3, 0, dp);
    }

    private boolean helper(char[] s1Array, int len1, int s1Index, char[] s2Array, int len2, int s2Index, char[] s3Array, int len3, int s3Index, boolean[][] dp) {
        if (s1Index == len1 && s2Index == len2 && s3Index == len3) {
            return true;
        }

        if (dp[s1Index][s2Index]) {
            return false;
        }

        if (s1Index < len1 && s1Array[s1Index] == s3Array[s3Index] && helper(s1Array, len1, s1Index + 1, s2Array, len2, s2Index, s3Array, len3, s3Index + 1, dp)) {
            return true;
        }

        if (s2Index < len2 && s2Array[s2Index] == s3Array[s3Index] && helper(s1Array, len1, s1Index, s2Array, len2, s2Index + 1, s3Array, len3, s3Index + 1, dp)) {
            return true;
        }

        dp[s1Index][s2Index] = true;

        return false;
    }

}
