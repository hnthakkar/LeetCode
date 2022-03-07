package array.NumberofEnclaves1020;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.numEnclaves(new int[][]{
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}
                /*
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}

                 */
        });
    }

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int count = helper(grid, r, c, rows, cols);
                    result += count == -1 ? 0 : count;
                }
            }
        }

        return result;
    }

    private int helper(int[][] image, int sr, int sc, int rows, int cols) {
        if ((sr < 0 || sc < 0 || sr > (rows - 1) || sc > (cols - 1) || image[sr][sc] == 0)) {
            return 0;
        }

        int result = 1;

        image[sr][sc] = 0;

        if ((sr == 0 || sc == 0 || sr == (rows - 1) || sc == (cols - 1))) {
            result = -1;
        }

        // left
        int left = helper(image, sr, sc - 1, rows, cols);
        result = (left == -1 || result == -1) ? -1 : result + left;

        // right
        int right = helper(image, sr, sc + 1, rows, cols);
        result = (right == -1 || result == -1) ? -1 : result + right;

        // up
        int up = helper(image, sr - 1, sc, rows, cols);
        result = (up == -1 || result == -1) ? -1 : result + up;

        // down
        int down = helper(image, sr + 1, sc, rows, cols);
        result = (down == -1 || result == -1) ? -1 : result + down;

        return result;
    }

}
