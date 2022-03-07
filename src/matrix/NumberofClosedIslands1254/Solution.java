package matrix.NumberofClosedIslands1254;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        /*sol.closedIsland(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        });*/

        sol.closedIsland(new int[][]{
                {0,0,1,1,0,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,0,1,1,0},
                {0,1,1,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,1,1,1,0},
                {0,1,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,1,0,0,0,1},
                {1,1,1,1,1,1,0,0,0,0},
                {1,1,1,0,0,1,0,1,0,1},
                {1,1,1,0,1,1,0,1,1,0}
        });
    }

    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0 && helper(grid, r, c, rows, cols)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean helper(int[][] image, int sr, int sc, int rows, int cols) {
        if ((sr < 0 || sc < 0 || sr > (rows - 1) || sc > (cols - 1) || image[sr][sc] == 1)) {
            return true;
        }

        boolean result = true;

        image[sr][sc] = 1;

        if ((sr == 0 || sc == 0 || sr == (rows - 1) || sc == (cols - 1))) {
            result = false;
        }


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
