package matrix.rotateimage48;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.rotate(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        if (n == 1 ) {
            return;
        }

        for (int i = 0; i < n; i++) {
            reverseColumn(matrix, i, n);
        }

        swapNonDiagonalElements(matrix, n);
    }

    private void swapNonDiagonalElements(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i == j) {
                    continue;
                }

                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    private void reverseColumn(int[][] matrix, int c, int n) {
        int upperIndex = 0;
        int lowerIndex = n - 1;

        while (upperIndex < lowerIndex) {
            int tmp = matrix[upperIndex][c];
            matrix[upperIndex][c] = matrix[lowerIndex][c];
            matrix[lowerIndex][c] = tmp;
            upperIndex++;
            lowerIndex--;
        }
    }

}
