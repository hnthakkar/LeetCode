package virtualContest.weeklyContest276.SolvingQuestionsWithBrainpower2140;

import java.util.Arrays;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}});
    }

    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len];
        Arrays.fill(dp, Integer.MIN_VALUE);

        helper(questions, 0, 0, dp);

        return dp[0];
    }

    private long helper(int[][] questions, int pointTillNow, int nextIndex, long[] dp) {
        if (nextIndex >= questions.length) {
            return pointTillNow;
        }

        if (dp[nextIndex] != Integer.MIN_VALUE) {
            return dp[nextIndex];
        }

        // if solve current one
        long pointBySolvingCur = pointTillNow + questions[nextIndex][0] + helper(questions, pointTillNow, nextIndex + questions[nextIndex][1] + 1, dp);

        // don't solve current
        long pointBySkippingCur = pointTillNow + helper(questions, pointTillNow, nextIndex + 1, dp);

        dp[nextIndex] = Math.max(pointBySolvingCur, pointBySkippingCur);

        return dp[nextIndex];
    }

}
