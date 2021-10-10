package array.movezero283;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.moveZeroes(new int[]{4,2,4,0,0,3,0,5,1,0});
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return;
        }

        int nonZeroNumberCount = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                if (nonZeroNumberCount != i) {
                    nums[nonZeroNumberCount] = nums[i];
                    nums[i] = 0;
                }
                nonZeroNumberCount++;
            }
        }
    }
}
