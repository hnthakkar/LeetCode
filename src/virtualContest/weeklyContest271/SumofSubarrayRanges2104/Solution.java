package virtualContest.weeklyContest271.SumofSubarrayRanges2104;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.subArrayRanges(new int[] {4,-2,-3,4,1});
    }

    public long subArrayRanges(int[] nums) {
        int len = nums.length;

        long result = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }

                if (nums[j] < min) {
                    min = nums[j];
                }

                result += (max - min);
            }
        }

        return result;
    }


}
