package array.FindNearestPointThatHastheSameXorYCoordinate1779;

public class Solution {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int len = points.length;

        double minDist = Integer.MAX_VALUE;
        int resultIndex = -1;

        for (int i = 0; i < len; i++) {
            int[] cur = points[i];

            if (cur[0] == x || cur[1] == y) {
                double dist = Math.sqrt(Math.pow(x - cur[0], 2) + Math.pow(y - cur[1], 2));

                if (dist < minDist) {
                    minDist = dist;
                    resultIndex = i;
                }
            }
        }

        return resultIndex;
    }

}
