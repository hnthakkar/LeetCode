package codility.DiscIntersection;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[]{1, 5, 2, 1, 4, 0});
    }

    public int solution(int[] A) {
        int len = A.length;
        long count = 0;

        for (int i = 0; i < len - 1; i++) {
            count += Math.min(A[i], len - 1 - i);
            for (int j = i + A[i] + 1; j < len; j++) {
                if (((long) A[i] + A[j]) >= j - i) {
                    count++;
                    if (count > 10000000) {
                        return -1;
                    }
                }
            }
        }

        return (int) count;
    }

}
