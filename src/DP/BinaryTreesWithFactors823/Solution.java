package DP.BinaryTreesWithFactors823;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numFactoredBinaryTrees(new int[]{2, 4});
        sol.numFactoredBinaryTrees(new int[]{2, 4, 5, 10});
        sol.numFactoredBinaryTrees(new int[]{2, 3, 5, 6, 30});
    }

    public int numFactoredBinaryTrees(int[] arr) {
        int len = arr.length;

        Arrays.sort(arr);
        Map<Integer, Integer> ref = new HashMap<>();

        for (int i = 0; i < len; i++) {
            ref.put(arr[i], i);
        }

        long[] dp = new long[len];
        dp[0] = 1L;


        for (int i = 1; i < len; i++) {
            dp[i] = 1L;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && ref.containsKey(arr[i]/arr[j])) {
                    // int resultIndex = ref.get(arr[i] * arr[j]);
                    // dp[resultIndex] = (dp[resultIndex] + ((dp[i] * dp[j]) * ((arr[i] == arr[j] && (dp[i] == 1 && dp[j] == 1)) ? 1 : 2))) % 1000000007;
                    //dp[i] += (dp[i] * dp[j]) % 1000000007;
                    dp[i] += (dp[j] * dp[ref.get(arr[i]/arr[j])]);
                }
            }
        }

        long result = 0L;

        for (long d : dp) {
            result += d;
        }

        return (int) (result % 1000000007);
    }
}
