package array.LargestPerimeterTriangle976;

import java.util.Arrays;

public class Solution {

    public int largestPerimeter(int[] nums) {
        int len = nums.length;

        Arrays.sort(nums);

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if ((nums[j] + nums[k]) > nums[i]) {
                        return nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }

        return 0;
    }

}
