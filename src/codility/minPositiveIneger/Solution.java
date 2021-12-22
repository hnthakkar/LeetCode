package codility.minPositiveIneger;

public class Solution {

    public int solution(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 1;
        }

        int min = A[0];
        int max = A[0];

        for (int i = 1; i < len; i++) {
            if (A[i] < 1) {
                continue;
            }

            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        if (min > 1 || max < 1) {
            return 1;
        }

        int[] ref = new int[max];

        for (int i = 0; i < len; i++) {
            if ((A[i] - 1) < 0) {
                continue;
            }
            ref[A[i] - 1] = 1;
        }

        int i = 0;
        for (; i < max; i++) {
            if (ref[i] == 0) {
                break;
            }
        }

        return i + 1;
    }
}
