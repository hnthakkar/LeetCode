package virtualContest.weeklyContest278.AllDivisionsWiththeHighestScoreofaBinaryArray2155;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maxScoreIndices(new int[]{0, 0, 1, 0});
    }

    public List<Integer> maxScoreIndices(int[] nums) {
        int len = nums.length;

        int[] zeroToLeft = new int[len + 1];
        int noOfZero = 0;

        for (int i = 0; i < len; i++) {
            zeroToLeft[i] = noOfZero;
            if (nums[i] == 0) {
                noOfZero++;
            }
        }

        zeroToLeft[len] = noOfZero;

        int[] onesToRight = new int[len + 1];
        int noOfOnes = 0;

        for (int i = len; i > 0; i--) {
            onesToRight[i] = noOfOnes;
            if (nums[i - 1] == 1) {
                noOfOnes++;
            }
        }

        onesToRight[0] = noOfOnes;

        int max = Integer.MIN_VALUE;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= len; i++) {
            if ((zeroToLeft[i] + onesToRight[i]) > max) {
                max = zeroToLeft[i] + onesToRight[i];
                result.clear();
                result.add(i);
            } else if ((zeroToLeft[i] + onesToRight[i]) == max) {
                result.add(i);
            }
        }

        return result;
    }

}
