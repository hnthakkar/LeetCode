package slidingwindow.minsizesubarraysum;

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;

        int[] preSumArray = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            preSumArray[i] = preSumArray[i-1] + nums[i-1];
        }

        int leftIndex = 0;
        int rightIndex = 1;

        int diff = 0;
        int globalMin = Integer.MAX_VALUE;
        int localMin = Integer.MAX_VALUE;

        while (rightIndex < len + 1) {
            diff = preSumArray[rightIndex] - preSumArray[leftIndex];
            if (diff >= target) {
                localMin = rightIndex - leftIndex;
                if (localMin < globalMin) {
                    globalMin = localMin;
                }
                leftIndex++;
            } else {
                rightIndex++;
            }
        }

        return globalMin == Integer.MAX_VALUE ? 0 : globalMin;
    }

}
