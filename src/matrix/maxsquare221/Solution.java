package matrix.maxsquare221;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();

        /*
        char[][] input = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'0','0','1','1','1'}
        };

         */
        char[][] input = new char[][] {
                {'0','1'},
                {'1','0'}
        };
        sol.maximalSquare(input);
    }

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxSquare = 0;
        int localMax = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] - '0' == 1) {
                    localMax = '1';
                    if (r > 0 && c > 0 && matrix[r-1][c] - '0' > 0 && matrix[r][c-1] - '0' > 0) {
                        localMax = Math.min((int)matrix[r - 1][c], (int)matrix[r][c - 1]);
                        localMax = Math.min(localMax, (int)matrix[r - 1][c - 1]) + 1;
                        matrix[r][c] = (char) (localMax);
                    }
                    maxSquare = Math.max(maxSquare, localMax - '0');
                }
            }
        }

        return maxSquare * maxSquare;
    }
}


