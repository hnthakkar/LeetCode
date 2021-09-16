package matrix.spiraltraverse;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        int topEdge = 0;
        int bottomEdge = rows - 1;
        int leftEdge = 0;
        int rightEdge = cols - 1;

        while (leftEdge <= rightEdge && topEdge <= bottomEdge) {
            if (topEdge <= bottomEdge) {
                // traverse right
                for (int i = leftEdge; i <= rightEdge; i++) {
                    result.add(matrix[topEdge][i]);
                }
            }
            topEdge++;

            if(leftEdge <= rightEdge) {
                // traverse down
                for (int i = topEdge; i <= bottomEdge; i++) {
                    result.add(matrix[i][rightEdge]);
                }
            }
            rightEdge--;

            if (topEdge <= bottomEdge) {
                // traverse left
                for (int i = rightEdge; i >= leftEdge; i--) {
                    result.add(matrix[bottomEdge][i]);
                }
            }
            bottomEdge--;

            if (leftEdge <= rightEdge) {
                // traverse up
                for (int i = bottomEdge; i >= topEdge; i--) {
                    result.add(matrix[i][leftEdge]);
                }
            }
            leftEdge++;
        }

        return result;
    }
}
