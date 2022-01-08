package DP.PartitionArrayForMaximumSum1043;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maxSumAfterPartitioning(new int[] {1,15,7,9,2,5,10}, 3);
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int globalMax = 0;
        int[] dp = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            int max = arr[i] + ((i + 1) >= len ? 0 : dp[i + 1]);

            for (int j = i + 1; j < len && j < (i + k); j++)  {
                max = Math.max(max, maxSumInRange(arr, i, j) + ((j + 1) >= len ? 0 : dp[j + 1]));
            }

            dp[i] = max;
            globalMax = Math.max(globalMax, max);
        }

        return globalMax;
    }


    private int maxSumInRange(int[] arr, int startAt, int endAt) {
        int max = arr[startAt];

        for (int i = startAt; i <= endAt; i++) {
            max = Math.max(max, arr[i]);
        }

        return max * (endAt - startAt + 1);
    }
}
