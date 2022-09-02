package matrix.NumberofSubmatricesThatSumtoTarget1074;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                int[] sumCols = sumColumns(matrix, i, j, cols);
                result += subarraySum(sumCols, target);
            }
        }

        return result;
    }

    private int[] sumColumns(int[][] mat, int startRow, int endRow, int noOfCols) {
        int[] sumCols = new int[noOfCols];

        for (int c = 0; c < noOfCols; c++) {
            for (int r = startRow; r <= endRow; r++) {
                sumCols[c] += mat[r][c];
            }
        }

        return sumCols;
    }

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;

        int result = 0;

        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }

            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

}
