package array.longestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        sol.lis(list);
    }

    public int lis(final List<Integer> A) {

        int len = A.size();

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int max = 1;

        for (int i = 0; i < len; i++) {
            int localMax = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (A.get(j) < A.get(i) && (dp[j] + 1) > localMax) {
                    localMax = dp[j] + 1;
                }
            }
            dp[i] = localMax;
            max = Math.max(max, localMax);
        }

        return max;
    }
}
