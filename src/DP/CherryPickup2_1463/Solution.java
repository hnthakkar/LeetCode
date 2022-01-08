package DP.CherryPickup2_1463;

public class Solution {

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        return helper(grid, new int[rows][cols][rows][cols], 0, 0, 0, cols - 1, rows, cols);
    }

    private int helper(int[][] grid, int[][][][] dp, int x1, int y1, int x2, int y2, int rows, int cols) {
        if (y1 < 0 || y2 < 0 || y1 >= cols || y2 >= cols || x1 >= rows || x2 >= rows) {
            return Integer.MIN_VALUE;
        }

        if (dp[x1][y1][x2][y2] != 0) {
            return dp[x1][y1][x2][y2];
        }

        int sum = 0;

        if (y1 == y2) {
            sum = grid[x1][y1];
        } else {
            sum += grid[x1][y1] + grid[x2][y2];
        }

        if (x1 == rows - 1) {
            return sum;
        }

        int[] possibleComb = new int[9];

        possibleComb[0] = helper(grid, dp, x1 + 1, y1 - 1, x2 + 1, y2 - 1, rows, cols);
        possibleComb[1] = helper(grid, dp, x1 + 1, y1 - 1, x2 + 1, y2, rows, cols);
        possibleComb[2] = helper(grid, dp, x1 + 1, y1 - 1, x2 + 1, y2 + 1, rows, cols);
        possibleComb[3] = helper(grid, dp, x1 + 1, y1, x2 + 1, y2 - 1, rows, cols);
        possibleComb[4] = helper(grid, dp, x1 + 1, y1, x2 + 1, y2, rows, cols);
        possibleComb[5] = helper(grid, dp, x1 + 1, y1, x2 + 1, y2 + 1, rows, cols);
        possibleComb[6] = helper(grid, dp, x1 + 1, y1 + 1, x2 + 1, y2 - 1, rows, cols);
        possibleComb[7] = helper(grid, dp, x1 + 1, y1 + 1, x2 + 1, y2, rows, cols);
        possibleComb[8] = helper(grid, dp, x1 + 1, y1 + 1, x2 + 1, y2 + 1, rows, cols);

        sum += getMax(possibleComb);

        dp[x1][y1][x2][y2] = sum;

        return sum;
    }

    private int getMax(int[] A) {
        int result = 0;

        for (int a: A) {
            result = Math.max(result, a);
        }

        return result;
    }
}
