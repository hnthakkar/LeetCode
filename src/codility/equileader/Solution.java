package codility.equileader;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[]{1,1,2,1,1});
    }

    public int solution(int[] A) {
        int len = A.length;

        Map<Integer, Integer> freq = new HashMap<>();

        int max = (int) Math.ceil((double)(len + 1)/2);
        int dominatorIndex = -1;

        for (int i = 0; i < len; i++) {
            if (freq.containsKey(A[i])) {
                freq.put(A[i], freq.get(A[i]) + 1);
            } else {
                freq.put(A[i], 1);
            }

            if (freq.get(A[i]) >= max) {
                dominatorIndex = i;
            }
        }

        int result = 0;

        if (dominatorIndex > -1) {
            int dominatorCount = freq.get(A[dominatorIndex]);

            int countTillNow = 0;

            for (int i = 0; i < len - 1; i++) {
                if (A[i] == A[dominatorIndex]) {
                    countTillNow++;
                }

                int firstMax = (int) Math.ceil((double)(i + 2)/2);
                int secondMax = (int) Math.ceil((double)(len - 1 - i + 1)/2);

                if (countTillNow >= firstMax && (dominatorCount - countTillNow) >= secondMax) {
                    result++;
                }
            }
        }

        return result;
    }

}
