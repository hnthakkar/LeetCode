package virtualContest.weeklyContest263.CountNumberofMaximumBitwiseORSubsets2044;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.countMaxOrSubsets(new int[] {3, 1});
        sol.countMaxOrSubsets(new int[]{2, 2, 2});
        sol.countMaxOrSubsets(new int[]{3, 2, 1, 5});
    }

    public int countMaxOrSubsets(int[] nums) {
        int len = nums.length;

        int combi = (int) Math.pow(2, len);

        int count = 0;
        int max = 0;

        for (int i = 0; i < combi; i++) {
            int cur = 0;
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) > 0) {
                    cur = cur == 0 ? nums[j] : cur | nums[j];
                }
            }

            if (cur > max) {
                count = 1;
                max = cur;
            } else if (cur == max) {
                count++;
            }
        }

        return count;
    }
}
