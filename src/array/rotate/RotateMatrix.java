package array.rotate;

class RotateMatrix {
    public void rotate(int[][] matrix) {
        int firstColumn  = 0;
        int lastColumn = matrix[0].length - 1;
        int firstRow = 0;

        while (firstColumn < lastColumn) {
            rotateSquareLoop(firstColumn, lastColumn, firstRow, matrix);
            firstColumn++;
            lastColumn--;
            firstRow++;
        }
    }

    private void rotateSquareLoop(int hStart, int hEnd, int vStart, int[][] matrix) {
        int squareSize = hEnd - hStart + 1;
        int vEnd = vStart + squareSize - 1;
        int[] tmp = new int[hEnd - hStart + 1];

        for (int i = 0; i < squareSize; i++) {
            tmp[i] = matrix[vStart][hStart + i];
        }
        tmp = copyToRightVertical(tmp, vStart, vEnd, hEnd, matrix);
        tmp = copyToLowerHorizontal(tmp, hEnd, hStart, vEnd, matrix);
        tmp = copyToLeftVertical(tmp, vEnd, vStart, hStart, matrix);
        copyToUpperHorizontal(tmp, hStart, hEnd, vStart, matrix);
    }

    private int[] copyToRightVertical(int[] fromArray, int vStart, int vEnd, int constantCol, int[][] matrix) {
        int squareSize = vEnd - vStart + 1;
        int[] returnArray = new int[squareSize];
        for (int i = 0; i < squareSize; i++) {
            returnArray[i] = matrix[vStart + i][constantCol];
            matrix[vStart + i][constantCol] = fromArray[i];
        }

        printArray(returnArray);
        printMatrix(matrix);

        return returnArray;
    }

    private int[] copyToLowerHorizontal(int[] fromArray, int hStart, int hEnd, int constantRow, int[][] matrix) {
        int squareSize = hStart - hEnd + 1;
        int[] returnArray = new int[squareSize];
        for (int i = 0; i < squareSize; i++) {
            returnArray[i] = matrix[constantRow][hStart - i];
            if (i > 0) {
                matrix[constantRow][hStart - i] = fromArray[i];
            }
        }

        printArray(returnArray);
        printMatrix(matrix);

        return returnArray;
    }

    private int[] copyToLeftVertical(int[] fromArray, int vStart, int vEnd, int constantCol, int[][] matrix) {
        int squareSize = vStart - vEnd + 1;
        int[] returnArray = new int[squareSize];
        for (int i = 0; i < squareSize; i++) {
            returnArray[i] = matrix[vStart - i][constantCol];
            if (i > 0) {
                matrix[vStart - i][constantCol] = fromArray[i];
            }
        }

        printArray(returnArray);
        printMatrix(matrix);

        return returnArray;
    }

    private int[] copyToUpperHorizontal(int[] fromArray, int hStart, int hEnd, int constantRow, int[][] matrix) {
        int squareSize = hEnd - hStart + 1;
        int[] returnArray = new int[squareSize];
        for (int i = 0; i < squareSize; i++) {
            returnArray[i] = matrix[constantRow][hStart + i];
            if (i > 0) {
                matrix[constantRow][hStart + i] = fromArray[i];
            }
        }

        printArray(returnArray);
        printMatrix(matrix);

        return returnArray;
    }

    private static void printArray(int[] ret) {
        System.out.println(" ret array: ");
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + "\t");
        }
    }

    private static void printMatrix(int[][] matrix) {
        int rows = matrix[0].length;
        System.out.println();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < rows; c++) {
                System.out.print(matrix[r][c] + "\t");
            }
            System.out.println();
        }
    }

}
