package array.NUniqueIntegersSumToZero1304;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.sumZero(5);
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];

        if (n == 1) {
            result[0] = 0;
            return result;
        }

        /*
        if (n == 2) {
            result[0] = -1;
            result[1] = 1;
            return result;
        }

        if (n == 3) {
            result[0] = -2;
            result[1] = 1;
            result[2] = 2;
            return result;
        }
        */

        int resultIndex = 0;
        int counter = 1;

        while (n > 0) {
            if (n == 3) {
                result[resultIndex++] = counter;
                result[resultIndex++] = counter + 1;
                result[resultIndex++] = -(2 * counter + 1);
                break;
            }

            result[resultIndex++] = -counter;
            result[resultIndex++] = counter;
            counter++;
            n -= 2;
        }

        return result;
    }
}
