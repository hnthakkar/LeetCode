package DP.uniquePathSum62;

public class Solution {

    public int uniquePaths(int rows, int cols) {
        int[][] mat = new int[rows][cols];
        mat[rows - 1][cols - 1] = 1;

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (r == rows - 1 && c == cols - 1) {
                    continue;
                }

                mat[r][c] = r < rows - 1 ? mat[r + 1][c] : 0;
                mat[r][c] += c < cols - 1 ? mat[r][c + 1] : 0;
            }
        }

        return mat[0][0];
    }
}
