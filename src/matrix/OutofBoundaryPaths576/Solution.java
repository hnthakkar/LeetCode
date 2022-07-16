package matrix.OutofBoundaryPaths576;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findPaths(2, 2, 2, 0 ,0);
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] ref = new int[m][n][maxMove + 1];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                for (int mv = 0; mv <= maxMove; mv++) {
                    ref[r][c][mv] = -1;
                }
            }
        }

        return helper(m, n, 0, startRow, startColumn, 0, maxMove, ref);
    }

    private int helper(int m, int n, int move, int row, int col, int result, int maxMove, int[][][] ref) {
        if (move > maxMove) {
            return 0;
        }

        if (row < 0 || col < 0 || row >= m || col >= n) {
            // System.out.println("CurX:" + row + "#CurY:" + col);
            return 1;
        }

        if (ref[row][col][move] != -1) {
            return ref[row][col][move];
        }


        int cur = 0;
        // top
        cur = (cur + helper(m, n, move + 1, row - 1, col, result, maxMove, ref)) % 1000000007;

        // down
        cur = (cur + helper(m, n, move + 1, row + 1, col, result, maxMove, ref)) % 1000000007;

        // right
        cur = (cur + helper(m, n, move + 1, row, col + 1, result, maxMove, ref)) % 1000000007;

        // left
        cur = (cur + helper(m, n, move + 1, row, col - 1, result, maxMove, ref)) % 1000000007;

        ref[row][col][move] = cur;

        return (result + cur) % 1000000007;
    }

}
