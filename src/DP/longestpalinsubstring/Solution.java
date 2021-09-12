package DP.longestpalinsubstring;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestPalindrome("aacabdkacaa");
    }

    public String longestPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        int startIndex = 0, endIndex = 0;
        int maxPalinLen = 1;
        int i = 0, j = 1, diagonal = 1;
        while (i < len && j < len) {
            if (sArray[i] == sArray[j]) {
                if (i+1 > j-1) {
                    dp[i][j] = 2;
                } else if (dp[i+1][j-1] > 0) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }

                if (dp[i][j] > maxPalinLen) {
                    maxPalinLen = dp[i][j];
                    startIndex = i;
                    endIndex = j;
                }
            }

            i++;
            j++;

            if (j >= len) {
                i = 0;
                j = ++diagonal;
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }
}
