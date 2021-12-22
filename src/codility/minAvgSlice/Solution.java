package codility.minAvgSlice;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[]{4, 2, 2, 5, 1, 5, 8});
    }

    public int solution(int[] A) {
        int len = A.length;

        int[] preSum = new int[len];
        for (int i = 0; i < len; i++) {
            preSum[i] = A[i];
        }

        for (int i = 1; i < len; i++) {
            preSum[i] += preSum[i - 1];
        }

        double globalMinAvg = Double.MAX_VALUE;
        int globalMinStart = 0;

        double curWindowsum = 0;
        double curWindowMinSum;
        double curWindowMinSumAvg;
        int curWindowMinSumStart = 0;

        for (int w = 2; w <= 3; w++) {
            curWindowsum = preSum[w - 1];
            curWindowMinSum = Double.MAX_VALUE;
            for (int j = 0; j + w < len; j++) {
                if (curWindowsum < curWindowMinSum) {
                    curWindowMinSum = curWindowsum;
                    curWindowMinSumStart = j;
                }

                curWindowsum += A[j + w] - A[j];
            }

            curWindowMinSumAvg = curWindowMinSum/w;

            if (curWindowMinSumAvg < globalMinAvg) {
                globalMinAvg = curWindowMinSumAvg;
                globalMinStart = curWindowMinSumStart;
            }
        }

        return globalMinStart;
    }
}

/*
public int solution(int[] A) {
        int len = A.length;

        for (int i = 1; i < len; i++) {
            A[i] += A[i - 1];
        }

        double minAvg = Double.MAX_VALUE;
        double sum;
        int noOfElems;
        int startIndexOfMin = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (i == 0) {
                    sum = A[j];
                    noOfElems = j + 1;
                } else {
                    sum = A[j] - A[i - 1];
                    noOfElems = j - i + 1;
                }

                double curAvg = sum / noOfElems;

                if (curAvg < minAvg) {
                    minAvg = curAvg;
                    startIndexOfMin = i;
                }
            }
        }

        return startIndexOfMin;
    }
 */
