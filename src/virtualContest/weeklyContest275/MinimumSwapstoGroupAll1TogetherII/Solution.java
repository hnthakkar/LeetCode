package virtualContest.weeklyContest275.MinimumSwapstoGroupAll1TogetherII;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minSwaps(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0});
    }

    public int minSwaps(int[] nums) {
        int len = nums.length;
        int noOfOnes = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                noOfOnes++;
            }
        }

        int result = 0;
        for (int j = 0; j < noOfOnes; j++) {
            if (nums[j % len] == 0) {
                result++;
            }
        }

        int globalMin = result;
        int lastCount = result;

        for (int i = 1; i < len; i++) {
            if (nums[i - 1] == 0) {
                lastCount--;
            }

            if (nums[(i + noOfOnes - 1) % len] == 0) {
                lastCount++;
            }

            globalMin = Math.min(globalMin, lastCount);
        }

        return globalMin;
    }
}
