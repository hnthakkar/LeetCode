package virtualContest.weeklyContest268.TwoFurthestHouseWithDiffColor;

import java.util.Arrays;

public class Solution {

    public int maxDistance(int[] colors) {
        int len = colors.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, len - 1, colors, dp);
    }

    private int helper(int left, int right, int[] colors, int[][] dp) {
        if (left >= right) {
            return 0;
        }

        if (colors[left] != colors[right]) {
            return right - left;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        dp[left + 1][right] = dp[left + 1][right] != -1 ? dp[left + 1][right]: helper(left + 1, right, colors, dp);
        dp[left][right - 1] = dp[left][right - 1] != -1 ? dp[left][right - 1]: helper(left, right - 1, colors, dp);

        dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);

        return dp[left][right];
    }
}
