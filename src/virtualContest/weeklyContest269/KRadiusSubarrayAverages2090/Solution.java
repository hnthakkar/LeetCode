package virtualContest.weeklyContest269.KRadiusSubarrayAverages2090;

import java.util.Arrays;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.getAverages(new int[]{2,2,1}, 1);
        // sol.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3);
        // sol.getAverages(new int[]{8}, 100000);
    }

    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;

        if (k == 0) {
            return nums;
        }

        int[] result = new int[len];
        Arrays.fill(result, -1);

        long sum = 0;

        for (int i = 0; i < (2*k + 1) && (2*k + 1) <= len; i++) {
            sum += nums[i];
        }

        if ((2*k + 1) <= len) {
            result[k] = (int) Math.floor(sum/(2*k + 1));
            int i = k + 1;
            for (; i + k + 1 <= len; i++) {
                // System.out.println("Sum : " + sum);
                sum += nums[i + k] - nums[i - k - 1];
                result[i] = (int) Math.floor(sum/(2*k + 1));
            }
        }

        return result;
    }

}
