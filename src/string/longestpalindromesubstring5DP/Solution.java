package string.longestpalindromesubstring5DP;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestPalindrome("cbbd");
    }

    public String longestPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int max = 1;
        int globalStart = 0;
        int globalEnd = 0;

        int[][] dp = new int[len][len];

        for (int i = 0; i < len - 1; i++) {
            dp[i][i] = 1;
            if (sArray[i] == sArray[i + 1]) {
                dp[i][i + 1] = 1;
                max = 2;
            } else {
                dp[i][i + 1] = 0;
            }
        }


        int diagonal = 2;

        while (diagonal < len) {
            int i = 0;
            while ((i + diagonal) < len) {
                int start = i;
                int end = i + diagonal;

                if (dp[start + 1][end - 1] == 1 && sArray[start] == sArray[end]) {
                    dp[start][end] = 1;
                    if ((end - start + 1) > max) {
                        max = end - start + 1;
                        globalStart = start;
                        globalEnd = end;
                    }
                } else {
                    dp[start][end] = 0;
                }
                i++;
            }
            diagonal++;
        }

        return s.substring(globalStart, globalEnd + 1);
    }

}
