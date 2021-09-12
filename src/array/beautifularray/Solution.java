package array.beautifularray;

public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.beautifulArray(5);
    }

    public int[] beautifulArray(int n) {
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }

        int inputSize = n;
        int stepSize = n;
        while (stepSize >= 2) {
            int startIndex = 0;
            int endIndex = startIndex + stepSize - 1;
            while (endIndex < inputSize) {
                partitionIntoOddEven(startIndex, endIndex, input);
                startIndex = endIndex + 1;
                endIndex = startIndex + stepSize - 1;
            }

            stepSize /= 2;
        }

        return input;
    }

    private void partitionIntoOddEven(int startIndex, int endIndex, int[] input) {
        int size = endIndex - startIndex + 1;
        int[] tmp = new int[size];
        int tmpIndex = 0;
        for (int i = startIndex; i < startIndex + size; i = i+2) {
            tmp[tmpIndex++] = input[i];
        }

        for (int i = startIndex + 1; i < startIndex + size; i = i+2) {
            tmp[tmpIndex++] = input[i];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            input[i] = tmp[i - startIndex];
        }
    }
}
