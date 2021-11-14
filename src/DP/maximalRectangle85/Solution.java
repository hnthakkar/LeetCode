package DP.maximalRectangle85;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        });
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;

        if (rows == 0) {
            return 0;
        }

        int cols = matrix[0].length;

        if (cols == 0) {
            return 0;
        }

        int[][] colSum = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] - '0' == 1) {
                    if (r == 0) {
                        colSum[r][c] = 1;
                    } else {
                        colSum[r][c] = colSum[r - 1][c] + 1;
                    }
                }
            }
        }

        int globalMax = 0;
        int localMax = 0;

        int back, forward;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                localMax = colSum[r][c];

                back = c - 1;
                while (back >= 0 && colSum[r][back] >= colSum[r][c]) {
                    localMax += colSum[r][c];
                    back--;
                }

                forward = c + 1;
                while (forward < cols && colSum[r][forward] >= colSum[r][c]) {
                    localMax += colSum[r][c];
                    forward++;
                }

                globalMax = Math.max(globalMax, localMax);
            }
        }

        return globalMax;
    }
}
