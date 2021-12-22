package codility.missingNumber;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[]{2, 3, 1, 5});
    }

    public int solution(int[] A) {
        int len = A.length;
        int[] ref = new int[len + 1];

        for (int i = 0; i < len; i++) {
            ref[A[i] - 1] = 1;
        }

        int i = 0;
        for (; i < len; i++) {
            if (ref[i] == 0) {
                break;
            }
        }

        return i + 1;
    }
}
