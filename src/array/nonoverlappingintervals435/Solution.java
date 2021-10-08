package array.nonoverlappingintervals435;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;

        if (len <= 1) {
            return 0;
        }

        List<int[]> intervalList = new ArrayList<>();
        for (int[] row: intervals) {
            intervalList.add(row);
        }

        Collections.sort(intervalList, (e1, e2) -> ((Integer)e1[1]).compareTo((Integer)e2[1]));

        int counter = 0;
        int curIndex = 1;

        int lastCloingValue = intervalList.get(0)[1];
        int[] cur;

        while (curIndex < len) {
            cur = intervalList.get(curIndex);
            if (cur[0] < lastCloingValue) {
                counter++;
            } else {
                lastCloingValue = cur[1];
            }

            curIndex++;
        }

        return counter;
    }
}
