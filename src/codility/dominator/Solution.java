package codility.dominator;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[]{1,2,1});
    }

    public int solution(int[] A) {
        int len = A.length;

        Map<Integer, Integer> freq = new HashMap<>();

        int max = (int) Math.ceil((double)(len + 1)/2);
        int index = -1;

        for (int i = 0; i < len; i++) {
            if (freq.containsKey(A[i])) {
                freq.put(A[i], freq.get(A[i]) + 1);
            } else {
                freq.put(A[i], 1);
            }

            if (freq.get(A[i]) >= max) {
                index = i;
            }
        }

        return index;
    }
}
