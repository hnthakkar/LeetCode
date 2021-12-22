package codility.binaryGap;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(529);
    }

    public int solution(int N) {
        int globalMax = 0;
        int localMax = 0;

        while (N > 0) {
            if ((N & 1) == 1) {
                localMax = 0;
                N >>= 1;
                while (N > 0 && (N & 1) == 0) {
                    localMax++;
                    N >>= 1;
                }

                if (N != 0) {
                    globalMax = Math.max(globalMax, localMax);
                }
            } else {
                N >>= 1;
            }
        }

        return globalMax;

    }

}
