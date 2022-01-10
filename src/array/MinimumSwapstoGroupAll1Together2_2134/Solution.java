package array.MinimumSwapstoGroupAll1Together2_2134;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minSwaps(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0});
    }

    public int minSwaps(int[] nums) {
        int len = nums.length;

        int numOfOnes = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                numOfOnes++;
            }
        }

        if (numOfOnes <= 1) {
            return 0;
        }

        int localMin = 0;
        for (int i = 0; i < numOfOnes; i++) {
            if (nums[i] == 0) {
                localMin++;
            }
        }

        int globalMin = localMin;

        for (int i = 1; i < len; i++) {
            localMin += (nums[i - 1] == 0 ? -1 : 0) + (nums[(i + numOfOnes - 1) % len] == 0 ? 1 : 0);
            globalMin = Math.min(globalMin, localMin);
        }

        return globalMin;
    }
}
