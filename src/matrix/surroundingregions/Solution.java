package matrix.surroundingregions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // mark top row
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                markAllConnectedZeros(board, 0, i, rows, cols);
            }
        }

        // mark bottom row
        for (int i = 0; i < cols; i++) {
            if (board[rows - 1][i] == 'O') {
                markAllConnectedZeros(board, rows - 1, i, rows, cols);
            }
        }

        // mark left col
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                markAllConnectedZeros(board, i, 0, rows, cols);
            }
        }

        // mark right col
        for (int i = 0; i < rows; i++) {
            if (board[i][cols - 1] == 'O') {
                markAllConnectedZeros(board, i, cols - 1, rows, cols);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'm') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

            }
        }
    }

    private void markAllConnectedZeros(char[][] grid, int x, int y, int rows, int cols) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        grid[x][y] = 'm';

        while (!q.isEmpty()) {
            Pair p = q.poll();

            // top
            if (p.x > 0 && grid[p.x - 1][p.y] == 'O') {
                grid[p.x - 1][p.y] = 'm';
                q.add(new Pair(p.x - 1, p.y));
            }

            // down
            if (p.x + 1 < rows && grid[p.x + 1][p.y] == 'O') {
                grid[p.x + 1][p.y] = 'm';
                q.add(new Pair(p.x + 1, p.y));
            }

            // left
            if (p.y > 0 && grid[p.x][p.y - 1] == 'O') {
                grid[p.x][p.y - 1] = 'm';
                q.add(new Pair(p.x, p.y - 1));
            }

            // right
            if (p.y + 1 < cols && grid[p.x][p.y + 1] == 'O') {
                grid[p.x][p.y + 1] = 'm';
                q.add(new Pair(p.x, p.y + 1));
            }
        }
    }
}

class Pair {
    int x;
    int y;
    public Pair (int pX, int pY) {
        x = pX;
        y = pY;
    }
}
