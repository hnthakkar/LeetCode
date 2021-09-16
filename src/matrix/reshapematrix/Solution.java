package matrix.reshapematrix;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = new int[][] {{1,2}, {3,4}};
        sol.matrixReshape(mat, 1, 4);
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int originalRows = mat.length;
        int originalCols = mat[0].length;

        if ((originalRows * originalCols) != (r * c)) {
            return mat;
        }

        int srcRowIndex = 0;
        int srcColIndex = 0;

        int trgRowIndex = 0;
        int trgColIndex = 0;

        int[][] newMat = new int[r][c];

        while (srcRowIndex < originalRows && srcColIndex < originalCols) {
            int elemToBeCopied = mat[srcRowIndex][srcColIndex];

            newMat[trgRowIndex][trgColIndex] = elemToBeCopied;

            // Update the Index for Src
            srcColIndex++;
            if (srcColIndex == originalCols) {
                srcRowIndex++;
                srcColIndex = 0;
            }

            // Update the Index for target
            trgColIndex++;
            if (trgColIndex == c) {
                trgRowIndex++;
                trgColIndex = 0;
            }
        }

        return newMat;
    }
}
