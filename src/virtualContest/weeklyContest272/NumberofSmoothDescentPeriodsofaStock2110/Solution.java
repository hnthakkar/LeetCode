package virtualContest.weeklyContest272.NumberofSmoothDescentPeriodsofaStock2110;

public class Solution {

    public long getDescentPeriods(int[] prices) {
        int len = prices.length;

        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        long result = 0;

        for (int d: dp) {
            result += d;
        }

        return result;
    }

}
