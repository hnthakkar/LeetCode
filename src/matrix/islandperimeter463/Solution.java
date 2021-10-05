package matrix.islandperimeter463;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.islandPerimeter(new int[][]{{0},{1}});
    }

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols];

        int boundaryCount = 0;

        Queue<Pair> q = new LinkedList<>();
        int i = 0, j = 0;

        boolean found = false;
        for (; i < rows; i++) {
            j = 0;
            for (; j < cols; j++) {
                if (grid[i][j] == 1) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }

        }

        q.add(new Pair(i, j));
        visited[i][j] = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            // top
            if (cur.x == 0 || grid[cur.x - 1][cur.y] == 0) {
                boundaryCount += 1;
            } else if (visited[cur.x - 1][cur.y] == 0){
                q.add(new Pair(cur.x - 1, cur.y));
                visited[cur.x - 1][cur.y] = 1;
            }

            // down
            if (cur.x == rows -1 || grid[cur.x + 1][cur.y] == 0) {
                boundaryCount += 1;
            } else if (visited[cur.x + 1][cur.y] == 0){
                q.add(new Pair(cur.x + 1, cur.y));
                visited[cur.x + 1][cur.y] = 1;
            }

            // left
            if (cur.y == 0 || grid[cur.x][cur.y - 1] == 0) {
                boundaryCount += 1;
            } else if (visited[cur.x][cur.y - 1] == 0){
                q.add(new Pair(cur.x, cur.y - 1));
                visited[cur.x][cur.y - 1] = 1;
            }

            // right
            if (cur.y == cols - 1 || grid[cur.x][cur.y + 1] == 0) {
                boundaryCount += 1;
            } else if (visited[cur.x][cur.y + 1] == 0){
                q.add(new Pair(cur.x, cur.y + 1));
                visited[cur.x][cur.y + 1] = 1;
            }

        }

        return boundaryCount;
    }

}

class Pair {
    int x, y;

    public Pair(int pX, int pY) {
        x = pX;
        y = pY;
    }
}