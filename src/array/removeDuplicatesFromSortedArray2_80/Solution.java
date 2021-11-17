package array.removeDuplicatesFromSortedArray2_80;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] == nums[i + 2]) {
                nums[i] = Integer.MAX_VALUE;
            }
        }

        int nextToFill = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                nums[nextToFill++] = nums[i];
            }
        }

        return nextToFill;
    }

}
