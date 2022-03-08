package matrix.AsFarfromLandasPossible1162;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maxDistance(new int[][]{
                {0, 0, 1, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1}
        });
    }

    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        boolean atleastOneLand = false;
        boolean atleastOneWater = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 1) {
                    atleastOneWater = true;

                    dp[i][j] = 101;

                    // above
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }

                    // left
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                } else {
                    atleastOneLand = true;
                }
            }
        }

        if (!atleastOneLand || !atleastOneWater) {
            return -1;
        }

        int maxDistance = -1;

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (grid[i][j] != 1) {

                    // up
                    if (i < (rows - 1)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }

                    // right
                    if (j < (cols - 1)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }

                    maxDistance = Math.max(maxDistance, dp[i][j]);
                }
            }
        }

        return maxDistance;
    }

}
