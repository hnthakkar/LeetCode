package maxsubarray;

public class MaxSubArrayNegative {

    public int maxSubArray(int[] nums) {
        int maxSumHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSumHere = Math.max(maxSumHere + nums[i], nums[i]) ;
            if (maxSoFar < maxSumHere) {
                maxSoFar = maxSumHere;
            }
        }

        return maxSoFar;
    }
}
