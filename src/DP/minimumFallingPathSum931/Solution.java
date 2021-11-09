package DP.minimumFallingPathSum931;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minFallingPathSum(new int[][]{{2,1,3}, {6,5,4}, {7,8,9}});
    }

    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = 0; c < cols; c++) {
                if (r == rows - 1) {
                    dp[r][c] = matrix[r][c];
                    continue;
                }

                dp[r][c] = dp[r + 1][c];

                if (c > 0) {
                    dp[r][c] = Math.min(dp[r][c], dp[r + 1][c - 1]);
                }

                if (c < cols - 1) {
                    dp[r][c] = Math.min(dp[r][c], dp[r + 1][c + 1]);
                }

                dp[r][c] += matrix[r][c];
            }
        }

        if (rows == 1) {
            return minPathSum(matrix, cols);
        } else {
            return minPathSum(dp, cols);
        }
    }

    private int minPathSum(int[][] matrix, int cols) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            if (result > matrix[0][i]) {
                result = matrix[0][i];
            }
        }

        return result;
    }

}
