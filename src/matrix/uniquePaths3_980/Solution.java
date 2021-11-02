package matrix.uniquePaths3_980;

public class Solution {

    public static final int[] invalidPath = new int[] {0, 0};

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}});
        sol.uniquePathsIII(new int[][]{{0, 1},{2,0}});
    }

    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int start_x = 0;
        int start_y = 0;

        int cellsToCover = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] < 0) {
                    continue;
                }

                cellsToCover++;

                if (grid[i][j] == 1) {
                    start_x = i;
                    start_y = j;
                }
            }
        }

        int[] result = helper(grid, rows, cols, 0, cellsToCover, start_x, start_y);
        return result[1];
    }

    private int[] helper(int[][] grid, int rows, int cols, int noOfCellsCovered, int cellsToCover, int startX, int startY) {
        if (startX < 0 || startY < 0 || startX >= rows || startY >= cols || grid[startX][startY] == 3 || grid[startX][startY] == -1) {
            return invalidPath;
        }

        noOfCellsCovered++;
        if (grid[startX][startY] == 2 && noOfCellsCovered != cellsToCover) {
            return invalidPath;
        }

        grid[startX][startY] = 3; // visited


        if (noOfCellsCovered == cellsToCover) {
            grid[startX][startY] = 0;
            return new int[]{1, 1};
        }

        int pathCountFromHere = 0;

        // top
        int[] topResponse = helper(grid, rows, cols, noOfCellsCovered, cellsToCover, startX - 1, startY);
        if (topResponse[0] == 1) {
            pathCountFromHere += topResponse[1];
        }

        // down
        int[] downResponse = helper(grid, rows, cols, noOfCellsCovered, cellsToCover, startX + 1, startY);
        if (downResponse[0] == 1) {
            pathCountFromHere += downResponse[1];
        }

        // right
        int[] rightResponse = helper(grid, rows, cols, noOfCellsCovered, cellsToCover, startX, startY + 1);
        if (rightResponse[0] == 1) {
            pathCountFromHere += rightResponse[1];
        }

        // left
        int[] leftResponse = helper(grid, rows, cols, noOfCellsCovered, cellsToCover, startX, startY - 1);
        if (leftResponse[0] == 1) {
            pathCountFromHere += leftResponse[1];
        }

        grid[startX][startY] = 0;

        return new int[] {(pathCountFromHere > 0 ? 1: 0), pathCountFromHere};
    }
}
