package microsoft.demo.q2;

public class Solution {


}


/*
package com.codility;

// you can also use imports, for example:
// import java.util.*;

public class Solution {

    private char[][] board;
    private Player p1; // red
    private Player p2; // yellow
    private int turn;
    private int rows;
    private int cols;

    public static void main(String [] args) {
        Player p1 = new Player("1");
        Player p2 = new Player("2");

        Solution sol = new Solution(6, 7, p1, p2);
        String winner = sol.startTheGame(new int[]{1,2,3,4});
        System.out.println("Winner is :" + winner);
    }

    public Solution(int pRows, int pCols, Player pP1, Player pP2) {
        board = new char[rows][cols];
        rows = pRows;
        cols = pCols;

        p1 = pP1;
        p2 = pP2;
        turn = 1;
    }

    public String startTheGame(int[] moves) {
        int len = moves.length;
        String winner = null;

        char newChar = turn == 1? 'R': 'Y';

        for (int i = 0; i < len; i++) {
            int[] location = dropCoin(moves[i], newChar);

            if (location[0] != -1) {
                if (isWinningMove(location)) {
                    winner = turn == 1? p1.name: p2.name;
                    break;
                }
            }
        }

        return winner;
    }

    private boolean isWinningMove(int[] location) {
        // check in all 8 directions
        if (horizontalCheck(location)) {
            return true;
        }

        if (verticalCheck(location)) {
            return true;
        }

        if (forwardDiagonalCheck(location)) {
            return true;
        }

        if (backwardDiagonalCheck(location)) {
            return true;
        }

        return false;
    }

    private boolean horizontalCheck(int[] location) {
        int row = location[0];
        int col = location[1];

        // Expand in both direction and inc with same char
        int counter = 1;
        char ch = board[row][col];
        while (col < (cols - 1) && board[row][++col] == ch) {
            // move to right
            counter++;
        }

        col = location[1];

        while (col > 0 && board[row][--col] == ch) {
            // move to right
            counter++;
        }


        return counter >= 4;
    }

    private boolean verticalCheck(int[] location) {
        int row = location[0];
        int col = location[1];

        // Expand in both direction and inc with same char
        int counter = 1;
        char ch = board[row][col];
        while (row > 0 && board[--row][col] == ch) {
            // move up
            counter++;
        }

        row = location[0];

        while (row < (rows - 1) && board[++row][col] == ch) {
            // move down
            counter++;
        }

        return counter >= 4;
    }

    private boolean forwardDiagonalCheck(int[] location) {
        int row = location[0];
        int col = location[1];

        // Expand in both direction and inc with same char
        int counter = 1;
        char ch = board[row][col];
        while (row > 0 && col < (cols - 1) && board[--row][++col] == ch) {
            // move diagonally up forward
            counter++;
        }

        row = location[0];
        col = location[1];

        while (row < (rows - 1) && col > 0 && board[++row][--col] == ch) {
            // move diagonally down backwards
            counter++;
        }

        return counter >= 4;
    }

    private boolean backwardDiagonalCheck(int[] location) {
        int row = location[0];
        int col = location[1];

        // Expand in both direction and inc with same char
        int counter = 1;
        char ch = board[row][col];
        while (row > 0 && col > 0 && board[--row][--col] == ch) {
            // move diagonally up backwards
            counter++;
        }

        row = location[0];
        col = location[1];

        while (row < (rows - 1) && col < (cols - 1) && board[++row][++col] == ch) {
            // move diagonally down forward
            counter++;
        }

        return counter >= 4;
    }

    private int[] dropCoin(int col, char newvalue) {
        int [] location = new int[] {-1, -1};
        int r = rows - 1;
        for (; r >= 0; r--) {
            if (board[r][col] == '\u0000') {
                board[r][col] = newvalue;
                location[0] = r;
                location[1] = col;
            }
        }

        return location;
    }

}

class Player {
    String name;

    public Player(String pName) {
        name = pName;
    }
}


/*

moves = 1,2,1,1
        R Y R Y

0 0 0 0 0
0 R 0 0 0
0 R Y 0 0
*/


