package array.carPooling1094;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4);
        sol.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5);
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int noOfTrips = trips.length;

        int[] capCheck = new int[1001];

        for (int i = 0; i < noOfTrips; i++) {
            int[] trip = trips[i];

            if (trip[1] > trip[2]) {
                return false;
            }

            for (int j = trip[1]; j < trip[2]; j++) {
                if (capCheck[j] + trip[0] <= capacity) {
                    capCheck[j] += trip[0];
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
