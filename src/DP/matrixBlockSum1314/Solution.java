package DP.matrixBlockSum1314;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.matrixBlockSum(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, 1);
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        int startX = -k;
        int startY = -k;
        int endX = k;
        int endY = k;

        int[][] result = new int[rows][cols];

        int sum = 0;

        for (int r = 0; r < rows; r++) {
            sum = 0;
            for (int c = 0; c < cols; c++) {
                if (sum == 0) {
                    startX = r - k;
                    startY = c - k;
                    endX = r + k;
                    endY = c + k;

                    sum = sumHelper(startX, startY, endX, endY, mat, rows, cols);
                    result[r][c] = sum;
                    continue;
                }

                // remove col
                sum = removeCol(sum, startX, endX, startY++, rows, cols, mat);

                // add col
                sum = addCol(sum, startX, endX, ++endY, rows, cols, mat);

                result[r][c] = sum;
            }

        }

        return result;
    }

    private int removeCol(int result, int startX, int endX, int startY, int rows, int cols, int[][] mat) {
        if (startY < 0) {
            return result;
        }

        startX = startX >= 0? startX: 0;
        endX = endX < rows? endX: rows - 1;

        for (int r = startX; r <= endX; r++) {
            result -= mat[r][startY];
        }

        return result;
    }

    private int addCol(int result, int startX, int endX, int endY, int rows, int cols, int[][] mat) {
        if (endY >= cols) {
            return result;
        }

        startX = startX >= 0? startX: 0;
        endX = endX < rows? endX: rows - 1;

        for (int r = startX; r <= endX; r++) {
            result += mat[r][endY];
        }

        return result;
    }

    private int sumHelper(int startX, int startY, int endX, int endY, int[][] mat, int rows, int cols) {
        int result = 0;

        startX = startX >= 0? startX: 0;
        startY = startY >= 0? startY: 0;

        endX = endX < rows? endX: rows - 1;
        endY = endY < cols? endY: cols - 1;

        for (int r = startX; r <= endX; r++) {
            for (int c = startY; c <= endY; c++) {
                result += mat[r][c];
            }
        }

        return result;
    }
}
