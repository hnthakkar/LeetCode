package slidingwindow.minsizesubarraysum;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minSubArrayLen(11, new int[]{1,2,3,4,5});
    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;

        int sum = 0;
        int[] preSumArray = new int[len + 1];
        preSumArray[0] = 0;
        for (int i = 1; i <= len; i++) {
            sum += nums[i - 1];
            preSumArray[i] = sum;
        }

        int leftIndex = 0;
        int rightIndex = 1;

        int diff = 0;
        int globalMin = Integer.MAX_VALUE;
        int localMin = Integer.MAX_VALUE;

        while (rightIndex <= len) {
            diff = preSumArray[rightIndex] - preSumArray[leftIndex];

            if (diff == target) {
                localMin = rightIndex - leftIndex;
                if (localMin < globalMin) {
                    globalMin = localMin;
                }

                leftIndex++;
                rightIndex++;
            } else if (diff > target) {
                leftIndex++;
            } else {
                rightIndex++;
            }
        }

        return globalMin == Integer.MAX_VALUE ? 0 : globalMin;
    }

    /*
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


     */
}
