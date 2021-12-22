package codility.maxCounters;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(5, new int[]{3,4,4,6,1,4,4});
    }

    public int[] solution(int N, int[] A) {
        int len = A.length;
        int[] result = new int[N];

        int curMax = 0;
        int minValue = 0;

        for (int i = 0; i < len; i++) {
            if (A[i] - 1 < N) {
                result[A[i] - 1] = result[A[i] - 1] > minValue ? result[A[i] - 1] + 1: minValue + 1;
                curMax = Math.max(curMax, result[A[i] - 1]);
            } else {
                minValue = curMax;
            }
        }

        for (int i = 0; i < N; i++) {
            if (result[i] < minValue) {
                result[i] = minValue;
            }
        }

        return result;
    }

}
