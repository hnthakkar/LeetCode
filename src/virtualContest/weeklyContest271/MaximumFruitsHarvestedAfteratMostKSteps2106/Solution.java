package virtualContest.weeklyContest271.MaximumFruitsHarvestedAfteratMostKSteps2106;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maxTotalFruits(new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}}, 5, 4);
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        Map<Integer, Integer> positionAmt = new HashMap<>();
        for (int[] info: fruits) {
            positionAmt.put(info[0], info[1]);
        }

        int resul = helper(positionAmt, startPos, k, 0);
        return resul;
    }

    private int helper(Map<Integer, Integer> positionAmt, int startPos, int k, int harvested) {
        if (k < 0) {
            return harvested;
        }

        int tmp = 0;
        if (positionAmt.containsKey(startPos)) {
            tmp = positionAmt.get(startPos);
            harvested += tmp;
            positionAmt.put(startPos, 0);
        }



        int left = helper(positionAmt, startPos - 1, k - 1, harvested);
        int right = helper(positionAmt, startPos + 1, k - 1, harvested);

        if (positionAmt.containsKey(startPos)) {
            positionAmt.put(startPos, tmp);
        }

        return Math.max(left, right);
    }
}
