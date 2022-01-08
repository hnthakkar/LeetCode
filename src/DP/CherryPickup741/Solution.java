package DP.CherryPickup741;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.cherryPickup(new int[][] {{0,1,-1}, {1,0,-1}, {1,1,1}});
        // sol.cherryPickup(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}});
        // sol.cherryPickup(new int[][]{{1}});
    }

    public int cherryPickup(int[][] grid) {
        int len = grid.length;
        int result = helper(grid, new int[len][len][len][len], 0,0,0,0, len, len);
        return result;
    }

    private int helper(int[][] grid, int[][][][] dp, int r1, int c1, int r2, int c2, int rows, int cols) {
        if (r1 >= rows || r2 >= rows || c1 >= cols || c2 >= cols || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (dp[r1][c1][r2][c2] != 0) {
            return dp[r1][c1][r2][c2];
        }

        if (r1 == rows - 1 && c1 == cols - 1) {
            return grid[r1][c1];
        }

        int noOfCherryPickedUp = 0;

        if (r1 == r2 && c1 == c2) {
            noOfCherryPickedUp += grid[r1][c1];
        } else {
            noOfCherryPickedUp += grid[r1][c1] + grid[r2][c2];
        }

        // RR
        int rr = helper(grid, dp, r1, c1 + 1, r2, c2 + 1, rows, cols);

        //DR
        int dr = helper(grid, dp, r1 + 1, c1, r2, c2 + 1, rows, cols);

        // RD
        int rd = helper(grid, dp, r1, c1 + 1, r2 + 1, c2, rows, cols);

        //DD
        int dd = helper(grid, dp, r1 + 1, c1, r2 + 1, c2, rows, cols);

        noOfCherryPickedUp += Math.max(Math.max(rr, dr), Math.max(rd, dd));

        dp[r1][c1][r2][c2] = noOfCherryPickedUp;

        return noOfCherryPickedUp;
    }

    /*
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;

        int[][] dp = new int[rows][cols];
        int numberOfCherries = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == -1) {
                    dp[r][c] = Integer.MIN_VALUE;
                    continue;
                }

                if (grid[r][c] == 1) {
                    numberOfCherries++;
                }

                if (r == 0 && c == 0) {
                    dp[r][c] = grid[r][c];
                    continue;
                }

                if (r == 0) {
                    dp[r][c] = dp[r][c - 1] + grid[r][c];
                    continue;
                }

                if (c == 0) {
                    dp[r][c] = dp[r - 1][c] + grid[r][c];
                    continue;
                }

                if ((grid[r][c - 1] == -1 && grid[r - 1][c] == -1)
                        || (dp[r][c - 1] == Integer.MIN_VALUE && dp[r - 1][c] == Integer.MIN_VALUE)) {
                    dp[r][c] = Integer.MIN_VALUE;
                    continue;
                }

                dp[r][c] = Math.max(dp[r][c - 1], dp[r - 1][c]) + grid[r][c];
            }
        }

        if (dp[rows - 1][cols - 1] < 0 || (dp[rows - 1][cols - 1] == 0 && numberOfCherries > 0)) {
            return 0;
        }

        result = dp[rows - 1][cols - 1];

        markMaxPath(grid, dp, rows, cols);

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                dp[r][c] = 0;
                if (r == rows - 1 && c == cols - 1) {
                    continue;
                }

                if (r == rows - 1) {
                    dp[r][c] = dp[r][c + 1] + grid[r][c];
                    continue;
                }

                if (c == cols - 1) {
                    dp[r][c] = dp[r + 1][c] + grid[r][c];
                    continue;
                }

                dp[r][c] = Math.max(dp[r][c + 1], dp[r + 1][c]) + grid[r][c];
            }
        }

        result += dp[0][0];

        return result;
    }


    private void markMaxPath(int[][] grid, int[][] dp, int rows, int cols) {
        int curRow = rows - 1;
        int curCol = cols - 1;

        grid[curRow][curCol] = 0;

        while (curCol != 0 || curRow != 0) {
            if (curCol > 0 && dp[curRow][curCol] - 1 == dp[curRow][curCol - 1]) {
                grid[curRow][curCol - 1] = 0;
                curCol--;
            } else {
                grid[curRow - 1][curCol] = 0;
                curRow--;
            }
        }

        grid[0][0] = 0;
    }

     */
}
