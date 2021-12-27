package matrix.noofprovinces;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }

    public int findCircleNum(int[][] isConnected) {
        int rows = isConnected.length;
        int cols = isConnected[0].length;

        int province = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isConnected[r][c] == 1) {
                    province++;
                    markRow(isConnected, r, rows, cols);
                }
            }
        }

        return province;
    }

    private void markRow(int[][] isConnected, int row, int rows, int cols) {
        for (int c = 0; c < cols; c++) {
            if (isConnected[row][c] == 1) {
                isConnected[row][c] = 0;
                if (row != c) {
                    markRow(isConnected, c, rows, cols);
                }
            }
        }
    }

    /*
    public int findCircleNum(int[][] isConnected) {
        int rows = isConnected.length;
        int cols = isConnected[0].length;

        int province = 0;
        int startRow = 0;

        while (startRow < rows) {
            Queue<Integer> q = new LinkedList<>();
            q.add(startRow);
            boolean connected = false;

            while (!q.isEmpty()) {
                int curRow = q.poll();

                for (int i = 0; i < cols; i++) {
                    if (isConnected[curRow][i] == 1) {
                        connected = true;
                        if (curRow != i) {
                            q.add(i);
                        }
                        isConnected[curRow][i] = 0;
                    }
                }
            }

            if (connected) {
                province++;
            }

            startRow++;
        }


        return province;
    }

     */

}
