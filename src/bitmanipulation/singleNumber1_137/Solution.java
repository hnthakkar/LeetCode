package bitmanipulation.singleNumber1_137;

import java.util.Arrays;

public class Solution {

    public int singleNumber(int[] nums) {
        int len  = nums.length;
        Arrays.sort(nums);

        int i = 1;
        for (; i < len; i += 3) {
            if (nums[i] == nums[i-1]) {
                continue;
            }

            break;
        }

        return nums[i - 1];
    }
}
