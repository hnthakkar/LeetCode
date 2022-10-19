package stack.InsertInterval57;

import java.util.Stack;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int notOfIntervals = intervals.length;
        Stack<int[]> stack = new Stack<>();

        int curIndex = notOfIntervals;
        boolean newIntervalAdded = false;

        while (curIndex >= 0) {
            if (intervals[curIndex][1] < newInterval[0]) {
                // new interval start is greater than the cur Interval end
                if (!newIntervalAdded) {
                    stack.push(newInterval);
                    newIntervalAdded = true;
                }

                stack.push(intervals[curIndex]);
            } else if (newInterval[1] < intervals[curIndex][0]) {
                // current interval start is greater than new interval end
                stack.push(intervals[curIndex]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[curIndex][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[curIndex][1]);
            }

            curIndex--;
        }

        if (!newIntervalAdded) {
            stack.push(newInterval);
        }

        int[][] result = new int[stack.size()][];

        int index = 0;

        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }

}
