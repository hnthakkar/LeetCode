package runningsum;

public class Solution {

    public int[] runningSum(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            nums[i] = sum;
        }

        return nums;
    }
}
