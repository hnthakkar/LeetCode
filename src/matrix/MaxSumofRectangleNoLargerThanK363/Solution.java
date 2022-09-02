package matrix.MaxSumofRectangleNoLargerThanK363;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxSumSubmatrix(new int[][] {{2, 4, -2}}, 3);
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                int[] sumCols = sumColumns(matrix, i, j, cols);

                int check = subarraySum(sumCols, k);

                if (k == check) {
                    return k;
                }

                if (k - check < result) {
                    result = check;
                }
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

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            int sum = 0;

            for (int j = i; j < len; j++) {
                sum += nums[j];

                if (sum > k) {
                    continue;
                }

                if (sum == k) {
                    return k;
                }

                if (diff > Math.abs(k - sum)) {
                    diff = Math.abs(k - sum);
                }
            }
        }

        return k - diff;
    }
}
