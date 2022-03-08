package matrix.CountSubIslands1905;

public class Solution {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;
        int cols = grid1[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid2[i][j] == 1) {
                    if (grid1[i][j] == 0) {
                        grid2[i][j] = 2;
                    }
                }
            }
        }

        int result = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid2[r][c] == 1 && helper(grid2, r, c, rows, cols)) {
                    result++;
                }
            }
        }

        return result;

    }

    private boolean helper(int[][] image, int sr, int sc, int rows, int cols) {
        if ((sr < 0 || sc < 0 || sr > (rows - 1) || sc > (cols - 1) || image[sr][sc] == 0)) {
            return true;
        }

        boolean result = true;

        if (image[sr][sc] == 2) {
            result = false;
        }

        image[sr][sc] = 0;

        // left
        result = helper(image, sr, sc - 1, rows, cols) && result;

        // right
        result = helper(image, sr, sc + 1, rows, cols) && result;

        // up
        result = helper(image, sr - 1, sc, rows, cols) && result;

        // down
        result = helper(image, sr + 1, sc, rows, cols) && result;

        return result;
    }

}
