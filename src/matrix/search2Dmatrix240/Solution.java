package matrix.search2Dmatrix240;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.searchMatrix(new int[][]{{-1,3}}, 3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][cols - 1]) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[0][j] <= target && target <= matrix[rows - 1][j]) {
                        if (matrix[i][j] == target) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
