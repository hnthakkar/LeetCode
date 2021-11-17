package DP.matrixDistanceFromZero542;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.updateMatrix(new int[][]{
                {1,0,0,0},
                {1,1,1,1},
                {1,1,1,1}
        });
    }

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        int[][] leftUp = getCopyOfMat(mat, rows, cols);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (leftUp[r][c] == 1) {
                    left = c > 0? leftUp[r][c - 1] : Integer.MAX_VALUE;
                    up = r > 0? leftUp[r - 1][c] : Integer.MAX_VALUE;

                    if (left == Integer.MAX_VALUE && up == Integer.MAX_VALUE) {
                        leftUp[r][c] = Integer.MAX_VALUE;
                    } else {
                        leftUp[r][c] = Math.min(left, up) + 1;
                    }
                }
            }
        }

        int[][] rightDown = getCopyOfMat(mat, rows, cols);
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (rightDown[r][c] == 1) {
                    right = c < cols - 1? rightDown[r][c + 1] : Integer.MAX_VALUE;
                    down = r < rows - 1? rightDown[r + 1][c] : Integer.MAX_VALUE;

                    if (right == Integer.MAX_VALUE && down == Integer.MAX_VALUE) {
                        rightDown[r][c] = Integer.MAX_VALUE;
                    } else {
                        rightDown[r][c] = Math.min(right, down) + 1;
                    }
                }
            }
        }

        int[][] rightUp = getCopyOfMat(mat, rows, cols);
        for (int r = 0; r < rows; r++) {
            for (int c = cols - 1; c >= 0; c--) {
                if (rightUp[r][c] == 1) {
                    right = c < cols - 1? rightUp[r][c + 1] : Integer.MAX_VALUE;
                    up = r > 0? rightUp[r - 1][c] : Integer.MAX_VALUE;

                    if (right == Integer.MAX_VALUE && up == Integer.MAX_VALUE) {
                        rightUp[r][c] = Integer.MAX_VALUE;
                    } else {
                        rightUp[r][c] = Math.min(right, up) + 1;
                    }
                }
            }
        }

        int[][] leftDown = getCopyOfMat(mat, rows, cols);
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = 0; c < cols; c++) {
                if (leftDown[r][c] == 1) {
                    left = c > 0? leftDown[r][c - 1] : Integer.MAX_VALUE;
                    down = r < rows - 1? leftDown[r + 1][c] : Integer.MAX_VALUE;

                    if (left == Integer.MAX_VALUE && down == Integer.MAX_VALUE) {
                        leftDown[r][c] = Integer.MAX_VALUE;
                    } else {
                        leftDown[r][c] = Math.min(left, down) + 1;
                    }
                    // System.out.println("For r = " + r + " c = " + c + " Value = " + mat[r][c] + " Left = " + left + " right = " + right + " up = " + up + " down = " + down);
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                mat[r][c] = Math.min(Math.min(leftUp[r][c], rightDown[r][c]), Math.min(rightUp[r][c], leftDown[r][c]));
            }
        }

        return mat;
    }

    private int[][] getCopyOfMat(int[][] mat, int rows, int cols) {
        int[][] copy = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                copy[r][c] = mat[r][c];
            }
        }

        return copy;
    }
}
