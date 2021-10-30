package DP.maxSubArrayPositiveProduct1567;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getMaxLen(new int[]{-1,2});
    }

    public int getMaxLen(int[] nums) {
        int len = nums.length;

        int globalMax = 0;
        int localMax = 0;

        int negCount = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }

            localMax = 0;
            negCount = 0;
            int j = i;
            int firstNegative = -1;
            int lastNegative = -1;

            for (; j < len; j++) {
                if (nums[j] == 0) {
                    break;
                }

                if (nums[j] < 0) {
                    negCount += 1;
                    if (firstNegative == -1) {
                        firstNegative = j;
                    }
                    lastNegative = j;
                }
            }

            if (negCount % 2 == 0) {
                // no negative or even negatives
                localMax = (j - 1) - i + 1;
            } else {
                // odd number of negative
                localMax = Math.max(j - 1 - firstNegative, lastNegative - i);
            }

            globalMax = Math.max(globalMax, localMax);

            i = j;
        }

        return globalMax;
    }
}
