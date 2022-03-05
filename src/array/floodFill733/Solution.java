package array.floodFill733;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.floodFill(new int[][] {{0, 0, 0}, {0, 1, 1}}, 1, 1, 1);
        sol.floodFill(new int[][] {{1,1,1}, {1, 1, 0}, {1,0,1}}, 1, 1, 2);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return helper(image, sr, sc, newColor, image[sr][sc]);
    }

    private int[][] helper(int[][] image, int sr, int sc, int newColor, int oriColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == newColor || image[sr][sc] != oriColor) {
            return image;
        }

        image[sr][sc] = newColor;

        // left
        helper(image, sr, sc - 1, newColor, oriColor);

        // right
        helper(image, sr, sc + 1, newColor, oriColor);

        // up
        helper(image, sr - 1, sc, newColor, oriColor);

        // down
        helper(image, sr + 1, sc, newColor, oriColor);

        return image;
    }


    /*
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        int original = image[sr][sc];

        int[][] visited = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        visited[sr][sc] = 1;
        image[sr][sc] = newColor;
        q.add(new int[]{sr, sc});

        int[] cur;

        while (!q.isEmpty()) {
            cur = q.poll();

            int curX = cur[0];
            int curY = cur[1];

            // up
            if (curX > 0 && image[curX - 1][curY] == original && visited[curX - 1][curY] != 1) {
                image[curX - 1][curY] = newColor;
                q.add(new int[]{curX - 1, curY});
            }

            // left
            if (curY > 0 && image[curX][curY - 1] == original && visited[curX][curY - 1] != 1) {
                image[curX][curY - 1] = newColor;
                q.add(new int[]{curX, curY - 1});
            }

            // down
            if (curX < (rows - 1) && image[curX + 1][curY] == original && visited[curX + 1][curY] != 1) {
                image[curX + 1][curY] = newColor;
                q.add(new int[]{curX + 1, curY});
            }

            // right
            if (curY < (cols - 1) && image[curX][curY + 1] == original && visited[curX][curY + 1] != 1) {
                image[curX][curY + 1] = newColor;
                q.add(new int[]{curX, curY + 1});
            }
        }

        return image;
    }

     */

}
