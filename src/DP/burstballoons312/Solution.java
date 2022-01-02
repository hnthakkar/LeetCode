package DP.burstballoons312;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maxCoins(new int[]{1, 2, 3, 4});
    }

    public int maxCoins(int[] n) {
        int[] nums = new int[n.length + 2];
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) {
                nums[i] = 1;
                continue;
            }

            nums[i] = n[i - 1];
        }

        int[][] dp = new int[len][len];

        int diagonal = 0;

        while (diagonal < len - 1) {
            int i = 1;
            while ((i + diagonal) < len - 1) {
                int start = i;
                int end = i + diagonal;

                if (diagonal == 0) {
                    dp[start][end] = nums[start - 1] * nums[start] * nums[start + 1];
                } else {
                    int max = Integer.MIN_VALUE;
                    for (int x = start; x <= end; x++) {
                        int xTmp = helper(start, end, x, dp, nums);
                        max = Math.max(max, xTmp);
                    }

                    dp[start][end] = max;
                }

                i++;
            }
            diagonal++;
        }

        return dp[1][len - 2];
    }

    private int helper(int left, int right, int cur, int[][] dp, int[] nums) {
        // left
        int leftSum = 0;
        if (cur != left) {
            leftSum = dp[left][cur - 1];
        }

        int curSum = nums[cur] * nums[left - 1] * nums[right + 1];

        // right
        int rightSum = 0;
        if (cur != right) {
            rightSum = dp[cur + 1][right];
        }

        return leftSum + curSum + rightSum;
    }
}
