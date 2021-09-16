package twopointer.intervallistintersection;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstListLen = firstList.length;
        int secondListLen = secondList.length;

        if (firstListLen == 0 || secondListLen == 0) {
            return new int[][]{};
        }

        int firstListIndex = 0;
        int secondListIndex = 0;

        List<int[]> intervals = new ArrayList<>();

        while (firstListIndex < firstListLen && secondListIndex < secondListLen) {
            int maxOfStart = Math.max(firstList[firstListIndex][0], secondList[secondListIndex][0]);
            int minOfEnd = Math.min(firstList[firstListIndex][1], secondList[secondListIndex][1]);

            if (minOfEnd >= maxOfStart) {
                intervals.add(new int[]{maxOfStart, minOfEnd});
            }

            if (firstList[firstListIndex][1] == minOfEnd) {
                firstListIndex++;
            }

            if (secondList[secondListIndex][1] == minOfEnd) {
                secondListIndex++;
            }
        }

        int resultLen = intervals.size();
        int[][] result = new int[resultLen][2];

        for (int i = 0; i < resultLen; i++) {
            result[i] = intervals.get(i);
        }

        return result;
    }
}
