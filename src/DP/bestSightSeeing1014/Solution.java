package DP.bestSightSeeing1014;

public class Solution {

    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;

        int localMax = 0;
        int globalMax = 0;

        int curIndex = 0;

        for (int i = 1; i < len; i++) {
            localMax = Math.max(localMax, values[i] + values[curIndex] + curIndex - i);
            globalMax = Math.max(globalMax, localMax);
            curIndex = values[curIndex] + curIndex - i > values[i] ? curIndex: i;
        }


        return globalMax;
    }
}
