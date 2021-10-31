package DP.maxSumSubArrayCirrcular918;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maxSubarraySumCircular(new int[] {5,-3,5});
    }

    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;

        int globalMax = 0;
        int localMax = 0;

        for (int i = 0; i < 2 * len - 1; i++) {
            localMax = Math.max(localMax + nums[i % len], nums[i % len]);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }
}
