package DP.largestsubmatrixwith1;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] input = {{'1','1'},{'1','1'}};
        sol.maximalSquare(input);
    }

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int max = 0;

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == '1') {
                    if (matrix[r-1][c] >= '1' && matrix[r][c-1] >= '1' && matrix[r-1][c-1] >= '1') {
                        matrix[r][c] = (char) ((int) Math.min(Math.min(matrix[r-1][c], matrix[r][c-1]), matrix[r-1][c-1]) + 1);

                        if (matrix[r][c] > max) {
                            max = (int) matrix[r][c];
                        }
                    }
                }
            }
        }

        if (max == 0) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (matrix[r][c] == '1') {
                        return 1;
                    }
                }
            }

            return 0;
        }

        max = max - '0';
        return max * max;
    }
}
