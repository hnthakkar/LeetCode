package DP.LongestPalindromicSubsequence516;

public class Solution {

    public int longestPalindromeSubseq(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        return helper(sArray, 0, len - 1, new Integer[len][len]);
    }

    private int helper(char[] sArray, int startIndex, int endIndex, Integer[][] dp) {
        if (dp[startIndex][endIndex] != null) {
            return dp[startIndex][endIndex];
        }

        if (startIndex > endIndex) {
            return 0;
        }

        if (startIndex == endIndex) {
            return 1;
        }

        if (sArray[startIndex] == sArray[endIndex]) {
            dp[startIndex][endIndex] = 2 + helper(sArray, startIndex + 1, endIndex - 1, dp);
        } else {
            int leftPlus = helper(sArray, startIndex + 1, endIndex, dp);
            int rightMinus = helper(sArray, startIndex, endIndex - 1, dp);
            dp[startIndex][endIndex] = Math.max(leftPlus, rightMinus);
        }

        return dp[startIndex][endIndex];
    }

}
