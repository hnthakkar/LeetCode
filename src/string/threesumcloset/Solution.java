package string.threesumcloset;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums);

        int globalCloset = Integer.MAX_VALUE;
        int currentCloset = Integer.MAX_VALUE;
        int threeSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int leftIndex = 0;
            int rightIndex = len - 1;

            while (leftIndex < rightIndex) {
                if (leftIndex == i) {
                    leftIndex++;
                    continue;
                }

                if (rightIndex == i) {
                    rightIndex--;
                    continue;
                }

                currentCloset = Math.abs(target - (nums[i] + nums[leftIndex] + nums[rightIndex]));

                if (currentCloset == 0) {
                    return target;
                }

                if (currentCloset < globalCloset) {
                    globalCloset = currentCloset;
                    threeSum = (nums[i] + nums[leftIndex] + nums[rightIndex]);
                }

                if (nums[i] + nums[leftIndex] + nums[rightIndex] < target) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }

        return threeSum;
    }
}
