package array.maxsubarray;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int startIndex = 0;
        int endIndex = 0;
        int s = 0;

        int maxSumHere = 0;
        int maxSoFar = 0;

        for (int i = 0; i < nums.length; i++) {
            maxSumHere += nums[i];
            if (maxSoFar < maxSumHere) {
                maxSoFar = maxSumHere;
                startIndex = s;
                endIndex = i;
            }

            if (maxSumHere < 0) {
                maxSumHere = 0;
                s = i + 1;
            }
        }

        return maxSoFar;
    }
}
