package array.mergeintervals56;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.merge(new int[][] {{5,5},{1,3},{3,5},{4,6},{1,1},{3,3},{5,6},{3,3},{2,4},{0,0}});
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;

        if (len <= 1) {
            return intervals;
        }

        List<int[]> intervalList = Arrays.stream(intervals).collect(Collectors.toList());
        Collections.sort(intervalList, new IntervalComparator());

        List<int[]> result = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 1;
        while (leftIndex < len) {
            if (rightIndex < len && intervalList.get(leftIndex)[1] >= intervalList.get(rightIndex)[0]) {
                int start = intervalList.get(leftIndex)[0];
                int end = Math.max(intervalList.get(rightIndex)[1], intervalList.get(leftIndex)[1]);

                while (rightIndex < len && end >= intervalList.get(rightIndex)[0]) {
                    end = end = Math.max(intervalList.get(rightIndex)[1], end);
                    rightIndex++;
                }

                result.add(new int[] {start, end});
                leftIndex = rightIndex;
            } else {
                result.add(intervalList.get(leftIndex));
                leftIndex++;
            }
            rightIndex = leftIndex + 1;
        }

        int[][] resultArray = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}

class IntervalComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] interval1, int[] interval2) {
        Integer interval1StartTime = interval1[0];
        Integer interval2StartTime = interval2[0];
        return interval1StartTime.compareTo(interval2StartTime);
    }
}
