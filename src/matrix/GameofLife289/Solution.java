package matrix.GameofLife289;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] result = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                getNextState(board, r, c, rows - 1, cols - 1, result);
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = result[r][c];
            }
        }
    }

    private void getNextState(int[][] board, int curR, int curC, int rows, int cols, int[][] result) {
        int counter = 0;

        // top left
        if (curR > 0 && curC > 0 && board[curR - 1][curC - 1] == 1) {
            counter++;
        }

        // top
        if (curR > 0 && board[curR - 1][curC] == 1) {
            counter++;
        }

        // top right
        if (curR > 0 && curC < cols && board[curR - 1][curC + 1] == 1) {
            counter++;
        }

        // left
        if (curC > 0 && board[curR][curC - 1] == 1) {
            counter++;
        }

        // right
        if (curC < cols && board[curR][curC + 1] == 1) {
            counter++;
        }

        // bottom left
        if (curR < rows && curC > 0 && board[curR + 1][curC - 1] == 1) {
            counter++;
        }

        // bottom
        if (curR < rows && board[curR + 1][curC] == 1) {
            counter++;
        }

        // bottom right
        if (curR < rows && curC < cols && board[curR + 1][curC + 1] == 1) {
            counter++;
        }

        if (board[curR][curC] == 1) {
            if (counter < 2 || counter > 3) {
                result[curR][curC] = 0;
            } else {
                result[curR][curC] = 1;
            }
        } else {
            if (counter == 3) {
                result[curR][curC] = 1;
            }
        }
    }
}
