package microsoft.demo.d2;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[]{1, 3, 6, 4, 1, 2});
    }

    public int solution(int[] A) {
        int len = A.length;

        if (len == 0) {
            return 1;
        }

        int min = A[0];
        int max = A[0];

        int[] dp = new int[len + 1];

        for (int i = 0; i < len; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);

            if (A[i] < 1 || A[i] > len) {
                continue;
            }

            dp[A[i]] = 1;
        }

        if (max < 1 || min > 1) {
            return 1;
        }

        for (int i = 1; i <= len; i++) {
            if (dp[i] != 1) {
                return i;
            }
        }

        return len + 1;
    }
}
