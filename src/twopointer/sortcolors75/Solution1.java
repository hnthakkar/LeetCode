package twopointer.sortcolors75;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        sol.sortColors(new int[] {1,2,0});
    }

    public void sortColors(int[] nums) {
        int len = nums.length;

        int nextNonZeroIndex = 0;
        int prevNonTwoIndex = len - 1;

        int tmp;
        boolean wasSwapped = false;
        for (int i = 0; i < len; i++) {
            wasSwapped = false;
            if (i >= nextNonZeroIndex && nums[i] == 0) {
                nums[i] = nums[nextNonZeroIndex];
                nums[nextNonZeroIndex++] = 0;
                wasSwapped = true;
            }

            if (i <= prevNonTwoIndex && nums[i] == 2) {
                nums[i] = nums[prevNonTwoIndex];
                nums[prevNonTwoIndex--] = 2;
                wasSwapped = true;
            }

            if (wasSwapped) {
                i--;
            }
        }
    }
}
