package virtualContest.weeklyContest272.MinimumOperationstoMaketheArrayKIncreasing2111;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        /* sol.kIncreasing(new int[] {5,4,3,2,1}, 1);
        sol.kIncreasing(new int[] {4,1,5,2,6,2}, 2);
        sol.kIncreasing(new int[] {4,1,5,2,6,2}, 3);

         */
        sol.kIncreasing(new int[] {12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3}, 1);
    }

    public int kIncreasing(int[] arr, int k) {
        int len = arr.length;
        int result = 0;

        int[] greaterNumberToRight = new int[len];
        int[] lesserNumberToRight = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    greaterNumberToRight[i] += 1;
                } else {
                    lesserNumberToRight[i] += 1;
                }
            }
        }



        for (int i = 0; i < k && i < len; i++) {
            for (int j = i; j < len; j = j + k) {
                if ((j + k) < len && arr[j] > arr[j + k]) {
                    result++;
                }
            }
        }

        return result;
    }

}
