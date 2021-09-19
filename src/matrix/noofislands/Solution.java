package matrix.noofislands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        });
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int noOfIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    noOfIslands += 1;
                    markAllElemsInIsland(grid, i, j, rows, cols);
                }
            }
        }

        return noOfIslands;
    }

    private void markAllElemsInIsland(char[][] grid, int x, int y, int rows, int cols) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            // top
            if (p.x > 0 && grid[p.x - 1][p.y] == '1') {
                grid[p.x - 1][p.y] = 'm';
                q.add(new Pair(p.x - 1, p.y));
            }

            // down
            if (p.x + 1 < rows && grid[p.x + 1][p.y] == '1') {
                grid[p.x + 1][p.y] = 'm';
                q.add(new Pair(p.x + 1, p.y));
            }

            // left
            if (p.y > 0 && grid[p.x][p.y - 1] == '1') {
                grid[p.x][p.y - 1] = 'm';
                q.add(new Pair(p.x, p.y - 1));
            }

            // right
            if (p.y + 1 < cols && grid[p.x][p.y + 1] == '1') {
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

 /*
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ("1".equals(grid[i][j])) {
                    if (i == 0 && j == 0) {
                        continue;
                    } else if (i == 0) {
                        grid[i][j] = (Integer.parseInt(grid[i][j] + "") + Integer.parseInt(grid[i][j - 1] + "")) > 1 ? 'm' : grid[i][j];
                    } else if (j == 0) {
                        grid[i][j] = (Integer.parseInt(grid[i][j] + "") + Integer.parseInt(grid[i - 1][j] + "")) > 1 ? 'm' : grid[i][j];
                    } else {
                        grid[i][j] = (Integer.parseInt(grid[i][j] + "") + Integer.parseInt(grid[i - 1][j] + "") + Integer.parseInt(grid[i][j - 1] + "")) > 1 ? 'm' : grid[i][j];
                    }
                }
            }
        }

        int noOfIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ("1".equals(grid[i][j])) {
                    noOfIslands += 1;
                }
            }
        }

        return noOfIslands;
    }

     */

