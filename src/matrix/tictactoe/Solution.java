package matrix.tictactoe;

public class Solution {

    public String tictactoe(int[][] moves) {
        int noOfMoves = moves.length;
        char[][] board = new char[3][3];
        populateBoardWithMoves(board, moves, noOfMoves);

        if (checkIfPlayerIsWinning(board, 'X')) {
            return "A";
        }

        if (checkIfPlayerIsWinning(board, 'O')) {
            return "B";
        }

        if (noOfMoves == 9) {
            return "Draw";
        }

        return "Pending";
    }

    private boolean checkIfPlayerIsWinning(char[][] board, char ch) {
        // Rows and Cols check
        for (int i = 0; i < 3; i++) {
            if (checkIfRowWins(board, ch, i) || (checkIfColWins(board, ch, i))) {
                return true;
            }
        }

        if (checkForwardDiagonal(board, ch)) {
            return true;
        }

        if (checkReverseDiagonal(board, ch)) {
            return true;
        }

        return false;
    }

    private boolean checkReverseDiagonal(char[][] board, char ch) {
        // Reverse diagonal
        for (int i = 2; i >= 0; i--) {
            if (board[i][Math.abs(i-2)] != ch) {
                return false;
            }
        }

        return true;
    }

    private boolean checkForwardDiagonal(char[][] board, char ch) {
        // forward diagonal
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != ch) {
                return false;
            }
        }

        return true;
    }

    private boolean checkIfRowWins(char[][] board, char ch, int row) {
        for (int i = 0; i < 3; i++) {
            if (board[row][i] != ch) {
                return false;
            }
        }

        return true;
    }

    private boolean checkIfColWins(char[][] board, char ch, int col) {
        for (int i = 0; i < 3; i++) {
            if (board[i][col] != ch) {
                return false;
            }
        }

        return true;
    }

    private void populateBoardWithMoves(char[][] board, int[][] moves, int noOfMoves) {
        char chance = 'X';

        for (int i = 0; i < noOfMoves; i++) {
            int[] move = moves[i];
            board[move[0]][move[1]] = chance;

            if (chance == 'X') {
                chance = 'O';
            } else {
                chance = 'X';
            }
        }
    }
}
