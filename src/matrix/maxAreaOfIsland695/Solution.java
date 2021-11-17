package matrix.maxAreaOfIsland695;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int max = 0;

        int[][] visited = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && visited[r][c] == 0) {
                    max = Math.max(max, getAreaOfIsland(grid, r, c, visited, rows, cols));
                }
            }
        }

        return max;
    }

    private int getAreaOfIsland(int[][] grid, int r, int c, int[][] visited, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = 1;

        int area = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            // up
            if (curX > 0 && grid[curX - 1][curY] == 1 && visited[curX - 1][curY] == 0) {
                visited[curX - 1][curY] = 1;
                q.add(new int[]{curX - 1, curY});
                area++;
            }

            // left
            if (curY > 0 && grid[curX][curY - 1] == 1 && visited[curX][curY - 1] == 0) {
                visited[curX][curY - 1] = 1;
                q.add(new int[]{curX, curY - 1});
                area++;
            }

            // down
            if (curX < (rows - 1) && grid[curX + 1][curY] == 1 && visited[curX + 1][curY] == 0) {
                visited[curX + 1][curY] = 1;
                q.add(new int[]{curX + 1, curY});
                area++;
            }

            // right
            if (curY < (cols - 1) && grid[curX][curY + 1] == 1 && visited[curX][curY + 1] == 0) {
                visited[curX][curY + 1] = 1;
                q.add(new int[]{curX, curY + 1});
                area++;
            }
        }

        return area;
    }

}
