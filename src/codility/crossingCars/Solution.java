package codility.crossingCars;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[]{0,1,0,1,1});
    }

    public int solution(int[] A) {
        int len = A.length;

        int sum = 0;
        int[] ref = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (A[i] == 1) {
                ref[i] = ++sum;
            } else {
                ref[i] = sum;
            }
        }

        int result = 0;

        for (int i = 0; i < len; i++) {
            if (A[i] == 0) {
                if ((long)(result + ref[i]) > 1000000000) {
                    return -1;
                }
                result += ref[i];
            }
        }

        return result;
    }

    /*
    public int solution(int[] A) {
        int len = A.length;

        int oneSum = 0;
        int zeroSum = 0;

        int[] ref = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (A[i] == 1) {
                ref[i] = ++oneSum;
            } else {
                ref[i] = ++zeroSum;
            }
        }

        int result = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (A[j] != A[i]) {
                    result += ref[j];
                    break;
                }
            }
        }

        return result;
    }

     */
}
