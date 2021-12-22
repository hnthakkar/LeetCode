package DP.decodeways2_639;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.numDecodings("1*");
    }

    public int numDecodings(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int[] dp = new int[len];
        helper(sArray, 0, dp, len);

        return dp[0];
    }

    private int helper(char[] sArray, int index, int[] dp, int len) {
        if (index >= len) {
            return 1;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        if(sArray[index] == '0') {
            dp[index] = 0;
            return 0;
        }

        int result = 0;
        if(sArray[index] == '*') {
            result += 9;
            result = helper(sArray, index + 1, dp, len);
        }

        /*
        if (index + 1 < len) {
            if (sArray[index + 1] ) {

            } else if (Integer.parseInt("" + sArray[index] + sArray[index + 1]) < 27) {
                result += helper(sArray, index + 2, dp, len);
            }
        }
        */

        dp[index] = result;

        return result;
    }
}
