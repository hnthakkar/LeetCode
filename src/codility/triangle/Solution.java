package codility.triangle;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        Arrays.sort(A);
        int len = A.length;

        for (int i = 0; i < len - 2; i++) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }

        return 0;
    }

}
