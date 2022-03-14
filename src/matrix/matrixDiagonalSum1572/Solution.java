package matrix.matrixDiagonalSum1572;

public class Solution {

    public int diagonalSum(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int result = 0;

        for (int r = 0; r < rows; r++) {
            // back tilt diagonal
            result += mat[r][r];

            // forward tilt diagonal
            if (r != (cols - 1 - r)) {
                result += mat[r][cols - 1 - r];
            }
        }

        return result;
    }

}
