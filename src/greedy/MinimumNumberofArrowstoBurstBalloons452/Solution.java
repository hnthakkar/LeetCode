package greedy.MinimumNumberofArrowstoBurstBalloons452;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
    }

    public int findMinArrowShots(int[][] points) {
        int len = points.length;

        if (len == 1) {
            return 1;
        }

        List<int[]> pointsList = new ArrayList<>();
        for (int[] point : points) {
            pointsList.add(point);
        }

        Collections.sort(pointsList, (p1, p2) -> ((Integer) p1[1]).compareTo((Integer) p2[1]));

        int lastArrowX = -1;

        int result = 0;

        for (int i = 0; i < len; i++) {
            int[] curPoint = pointsList.get(i);

            if (curPoint[0] <= lastArrowX && curPoint[1] >= lastArrowX) {
                continue;
            }

            result++;
            lastArrowX = curPoint[1];
        }

        return result;
    }
}
