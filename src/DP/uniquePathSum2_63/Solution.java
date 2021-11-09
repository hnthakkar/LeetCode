package DP.uniquePathSum2_63;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }

        int[][] mat = new int[rows][cols];
        mat[rows - 1][cols - 1] = 1;

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (r == rows - 1 && c == cols - 1) {
                    continue;
                }

                mat[r][c] = r < rows - 1 && obstacleGrid[r + 1][c] != 1 ? mat[r + 1][c] : 0;
                mat[r][c] += c < cols - 1 && obstacleGrid[r][c + 1] != 1? mat[r][c + 1] : 0;
            }
        }

        return mat[0][0];
    }
}
