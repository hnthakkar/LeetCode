package DP.integerBreak;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.integerBreak(10);
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max((i - j), dp[i - j]));
            }
        }

        return dp[n];
    }

    /*
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(i-j, dp[i - j]));
            }
        }
        return dp[n];
    }
     */

    /*
    public int integerBreak(int n) {
        if(n==2)    return 1;
        if(n==3)    return 2;
        if(n%3 == 0)    return (int)Math.pow(3,n/3);
        if(n%3 == 1)    return (int)Math.pow(3,(n-4)/3)*4;
        return (int)Math.pow(3,(n-2)/3)*2;
    }

     */

}
