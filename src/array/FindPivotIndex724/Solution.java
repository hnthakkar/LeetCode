package array.FindPivotIndex724;

public class Solution {

    public int pivotIndex(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            nums[i] += nums[i -1];
        }

        for (int i = 0; i < len; i++) {
            int leftSum = i == 0? 0: nums[i - 1];
            int rightSum = nums[len - 1] - nums[i];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

}
