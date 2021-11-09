package DP.minimumPathSum64;

public class Solution {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int noToRight;
        int noDown;
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (r == rows - 1 && c == cols - 1) {
                    continue;
                }

                noToRight = r < rows - 1 ? grid[r + 1][c] : Integer.MAX_VALUE;
                noDown = c < cols - 1 ? grid[r][c + 1] : Integer.MAX_VALUE;

                grid[r][c] += Math.min(noToRight, noDown);
            }
        }

        return grid[0][0];
    }
}
