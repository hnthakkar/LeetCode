package matrix.rottingOranges994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                    continue;
                }

                if (grid[i][j] == 1) {
                    freshCount++;
                    if (notReachableCheck(i, j, rows, cols, grid)) {
                        return -1;
                    }
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int counter = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];

                if (curX > 0 && grid[curX - 1][curY] == 1) {
                    freshCount--;
                    q.add(new int[]{curX - 1, curY});
                    grid[curX - 1][curY] = 0;
                }

                if (curX + 1 < rows && grid[curX + 1][curY] == 1) {
                    freshCount--;
                    q.add(new int[]{curX + 1, curY});
                    grid[curX + 1][curY] = 0;
                }

                if (curY > 0 && grid[curX][curY - 1] == 1) {
                    freshCount--;
                    q.add(new int[]{curX, curY - 1});
                    grid[curX][curY - 1] = 0;
                }

                if (curY + 1 < cols && grid[curX][curY + 1] == 1) {
                    freshCount--;
                    q.add(new int[]{curX, curY + 1});
                    grid[curX][curY + 1] = 0;
                }
                size--;
            }
            counter++;
        }

        return freshCount == 0 ? counter - 1: -1;
    }

    private boolean notReachableCheck(int i, int j, int rows, int cols, int[][] grid) {
        if (i > 0 && grid[i-1][j] != 0) {
            return false;
        }

        if (i + 1 < rows && grid[i+1][j] != 0) {
            return false;
        }

        if (j > 0 && grid[i][j - 1] != 0) {
            return false;
        }

        if (j + 1 < cols && grid[i][j + 1] != 0) {
            return false;
        }

        return true;
    }


}
