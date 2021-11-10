package DP.uglyNumber2_264;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.nthUglyNumber(11);
    }

    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;

        int index_2 = 0, multiple_2 = 2;
        int index_3 = 0, multiple_3 = 3;
        int index_5 = 0, multiple_5 = 5;

        for (int i = 1; i < n; i++) {
            result[i] = Math.min(multiple_2, Math.min(multiple_3, multiple_5));

            if (result[i] == multiple_2) {
                multiple_2 = 2 * result[++index_2];
            }

            if (result[i] == multiple_3) {
                multiple_3 = 3 * result[++index_3];
            }

            if (result[i] == multiple_5) {
                multiple_5 = 5 * result[++index_5];
            }
        }

        return result[n - 1];
    }
}
