package twopointer.NextPermutation31;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.nextPermutation(new int[]{4, 2, 0, 2, 3, 2, 0});
        // sol.nextPermutation(new int[]{1, 2, 3});
        sol.nextPermutation(new int[]{1, 3, 2});
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return;
        }

        int peak = getLowestPeakIndex(nums, len);

        if (peak == -1) {
            Arrays.sort(nums);
            return;
        }
        int swapWithIndex = peak - 1;

        int lowerPeak = -1;

        for (int i = peak + 1; i < len; i++) {
            if (nums[i] < nums[peak] && nums[i] > nums[peak - 1]) {
                lowerPeak = i;
            }
        }

        peak = lowerPeak == -1? peak: lowerPeak;

        int tmp = nums[peak];
        nums[peak] = nums[swapWithIndex];
        nums[swapWithIndex] = tmp;

        Arrays.sort(nums, swapWithIndex + 1, len);
    }

    private int getLowestPeakIndex(int[] nums, int len) {
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                return i;
            }
        }

        return -1;
    }

}
