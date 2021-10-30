package DP.maxSubArrayPositiveProduct1567;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        // sol.getMaxLen(new int[]{-16,0,-5,2,2,-13,11,8});
        sol.getMaxLen(new int[]{-1, 2});
    }

    public int getMaxLen(int[] nums) {
        int len = nums.length;

        int globalMax = 0;

        int positiveCount = 0;
        int negativeCount = 0;


        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                positiveCount = 0;
                negativeCount = 0;
                continue;
            }

            if (nums[i] > 0) {
                positiveCount++;
                if (negativeCount > 0) {
                    negativeCount++;
                }
            } else {
                // negative
                int tmp = positiveCount + 1;
                positiveCount = negativeCount == 0 ? negativeCount : negativeCount + 1;
                negativeCount = tmp;
            }

            globalMax = Math.max(globalMax, positiveCount);
        }

        return globalMax;
    }
}
