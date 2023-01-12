package greedy.MinimumNumberofArrowstoBurstBalloons452;

import java.util.Arrays;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.findMinArrowShots(new int[][]{{-2147483646,-2147483645}, {2147483646,2147483647}});
    }

    public int findMinArrowShots(int[][] points) {
        int noOfBallons = points.length;

        if (noOfBallons == 1) {
            return 1;
        }

        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));

        int arrowNeeded = 1;
        int currentBallon = 1;
        int lastArrowPosition = points[0][1];

        while (currentBallon < noOfBallons) {
            int[] curBallon = points[currentBallon];

            if (curBallon[0] > lastArrowPosition) {
                lastArrowPosition = curBallon[1];
                arrowNeeded++;
            }

            currentBallon++;
        }

        return arrowNeeded;
    }

    /*
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

     */
}
