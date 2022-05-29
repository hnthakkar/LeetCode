package DP.RussianDollEnvelopes354;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxEnvelopes(new int[][]{{10, 17}, {10, 19}, {16, 2}, {19, 18}, {5, 6}});
    }

    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;

        Arrays.sort(envelopes, new EnvelopeComparator());


        for (int i = 0; i < len; i++) {
            int[] cur = envelopes[i];
            System.out.println(i + "->" + cur[0] + ":" + cur[1]);
        }

        int[] dp = new int[len];
        int max = 1;

        for (int i = 0; i < len; i++) {
            dp[i] = 1;

            for (int j = i -1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && dp[i] < (dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

class EnvelopeComparator implements Comparator<int[]> {

    public int compare (int[] e1, int[] e2) {
        return e1[0] == e2[0]? e1[1] - e2[1]: e1[0] - e2[0];
    }
}