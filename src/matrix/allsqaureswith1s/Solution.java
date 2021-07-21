package matrix.allsqaureswith1s;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countSquares(new int[][] {{0,0,0},{0,1,0},{0,1,0},{1,1,1},{1,1,0}});
    }

    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        String str = "test";
        str.toCharArray();

        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 || c == 0) {
                    if (matrix[r][c] == 1) {
                        count++;
                    }
                    continue;
                }

                if (matrix[r][c] == 1) {
                    if (matrix[r-1][c] >= 1 && matrix[r][c-1] >= 1 && matrix[r-1][c-1] >= 1) {
                        matrix[r][c] = Math.min(Math.min(matrix[r-1][c], matrix[r-1][c]), matrix[r-1][c-1]) + 1;
                        count += matrix[r][c];
                    } else {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
