package matrix.tictactoe348;

public class TicTacToe {

    private int[][] board;
    private int n;

    public static void main(String[] str) {
        TicTacToe sol = new TicTacToe(2);
        sol.move(0,0,2);
        sol.move(1,1,1);
        sol.move(0,1,2);
    }

    public TicTacToe(int size) {
        board = new int[size][size];
        n = size;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;

        if (checkRow(row, player) || checkCol(col, player) || checkBackDiagonal(player) || checkFrontDiagonal(player)) {
            return player;
        }

        return 0;
    }

    private boolean checkRow(int row, int player) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCol(int col, int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkBackDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkFrontDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][n - 1 - i] != player) {
                return false;
            }
        }

        return true;
    }
}
