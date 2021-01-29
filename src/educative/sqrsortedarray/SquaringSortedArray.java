package educative.sqrsortedarray;

public class SquaringSortedArray {

    public static void main(String[] args) {
        SquaringSortedArray.makeSquares(new int[]{-3, -1, 0, 1, 2});
    }

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int toLeftIndex = 0;
        int squaresIndex = 0;

        while (arr[toLeftIndex] < 0) {
            toLeftIndex++;
        }

        int toRightIndex = toLeftIndex < arr.length - 1 ? toLeftIndex + 1 : toLeftIndex;

        while (squaresIndex < arr.length) {
            if (toLeftIndex < 0) {
                squares[squaresIndex++] = arr[toRightIndex] * arr[toRightIndex];
                toRightIndex++;
                continue;
            }

            if (toRightIndex > arr.length - 1) {
                squares[squaresIndex++] = arr[toLeftIndex] * arr[toLeftIndex];
                toLeftIndex--;
                continue;
            }

            if (arr[toLeftIndex] * arr[toLeftIndex] <= arr[toRightIndex] * arr[toRightIndex]) {
                squares[squaresIndex++] = arr[toLeftIndex] * arr[toLeftIndex];
                toLeftIndex--;
            } else {
                squares[squaresIndex++] = arr[toRightIndex] * arr[toRightIndex];
                toRightIndex++;
            }
        }

        return squares;
    }
}
