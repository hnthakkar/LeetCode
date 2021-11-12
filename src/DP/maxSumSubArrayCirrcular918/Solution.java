package DP.maxSumSubArrayCirrcular918;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.maxSubarraySumCircular(new int[] {88,-35,50,-38,-60,-31,-2,-8,-8,91,-14,50,-25,-26,1,71,-91,-64,-40,46,30,-97,9,-55,-36,-75,71,99,90,-53,-68,-20,-73,89,-14,74,-8,72,82,48,45,2,-42,12,77,22,87,56,73,-21,78,15,-6,-75,24,46,-11,-70,-90,-77,57,43,-66,10,-30,-47,91,-37,-4,-67,-88,19,66,29,86,97,-4,67,54,-92,-54,71,-42,-17,57,-91,-9,-15,-26,56,-57,-58,-72,91,-55,35,-20,29,51,70});
        sol.maxSubarraySumCircular(new int[] {1,-2,3,-2});
    }

    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;

        int sum = nums[0];
        int globalMax = nums[0];
        int localMax = nums[0];

        int globalMin = nums[0];
        int localMin = nums[0];

        for (int i = 1; i < len; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            globalMax = Math.max(globalMax, localMax);

            sum += nums[i];

            localMin = Math.min(nums[i], localMin + nums[i]);
            globalMin = Math.min(globalMin, localMin);
        }

        if (sum == globalMin) {
            return globalMax;
        } else {
            return Math.max(sum - globalMin, globalMax);
        }
    }

    /*
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;

        int globalMax = -300000;
        int localMax = -300000;

        int globalMinIndex = 0;

        int globalMinStraight = 0;
        int localMinStraight = 0;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (nums[i] > 0) {
                localMinStraight = 0;
                continue;
            }

            while (i < len && nums[i] <= 0) {
                localMinStraight += nums[i];
                i++;
            }
            i--;
            globalMinStraight = Math.min(globalMinStraight, localMinStraight);
        }

        for (int i = 0; i < len; i++) {
            localMax = Math.max(localMax + nums[(globalMinIndex + 1 + i) % len], nums[(globalMinIndex + 1 + i) % len]);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }

     */
}
