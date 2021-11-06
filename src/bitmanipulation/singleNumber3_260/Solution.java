package bitmanipulation.singleNumber3_260;

import java.util.Arrays;

public class Solution {

    public int[] singleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int[] result = new int[2];
        int resultIndex = 0;

        int i = 0;

        for (; i < len;) {
            if (i - 1 > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            if (i + 1 < len && nums[i] == nums[i + 1]) {
                i += 2;
                continue;
            }

            if (resultIndex == 0) {
                result[resultIndex++] = nums[i++];
            } else {
                result[resultIndex] = nums[i];
                break;
            }
        }

        return result;
    }
}
