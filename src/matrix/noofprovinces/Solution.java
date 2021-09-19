package matrix.noofprovinces;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

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

}
