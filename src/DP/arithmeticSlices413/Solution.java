package DP.arithmeticSlices413;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.numberOfArithmeticSlices(new int[] {1,2,3,4,5,6,7,8});
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;

        int[]  dp = new int[len];

        for (int i = 2; i < len; i++) {
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int result = 0;

        for (int i = 0; i < len; i++) {
            result += dp[i];
        }

        return result;
    }

    /*
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;

        if (len < 3) {
            return 0;
        }

        int[] dp = new int[len + 1];
        dp[3] = 1;
        dp[4] = 3;

        int lastDp = 4;

        int result = 0;

        int curDiff = nums[1] - nums[0];
        int counter = 2;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == curDiff) {
                counter++;
                continue;
            }

            if (counter > 2) {
                result += lastDp >= counter ? dp[counter] : getCount(counter, dp, lastDp);
                if (counter > lastDp) {
                    lastDp = counter;
                }
            }


            if (i + 1 == len) {
                break;
            }

            i++;
            curDiff = nums[i] - nums[i--];
            counter = 2;
        }

        if (counter > 2) {
            result += lastDp >= counter ? dp[counter] : getCount(counter, dp, lastDp);
        }

        return result;

    }

    private int getCount(int counter, int[] dp, int lastDp) {
        int diff = dp[lastDp] - dp[lastDp - 1];

        for (int i = lastDp + 1; i <= counter; i++) {
            diff += 1;
            dp[i] = dp[i - 1] + diff;
        }

        return dp[counter];
    }

     */
}
