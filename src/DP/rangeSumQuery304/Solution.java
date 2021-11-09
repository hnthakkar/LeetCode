package DP.rangeSumQuery304;

public class Solution {

    int[][] mat;

    public static void main(String[] str) {
        Solution sol = new Solution(new int[][]{{-1}});
        sol.sumRegion(0,0,0,0);
    }

    public Solution(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowSum = 0;
        for (int r = 0; r < rows; r++) {
            rowSum = 0;
            for (int c = 0; c < cols; c++) {
                rowSum += matrix[r][c];
                matrix[r][c] = rowSum;
            }
        }

        mat = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int r = row1; r <= row2; r++) {
            if (col1 > 0) {
                sum += (mat[r][col1] - mat[r][col1 - 1]);
            } else {
                sum += mat[r][col1];
            }

            sum += (mat[r][col2] - mat[r][col1]);
        }

        return sum;
    }
}
