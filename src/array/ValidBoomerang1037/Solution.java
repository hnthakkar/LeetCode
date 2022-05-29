package array.ValidBoomerang1037;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        //sol.isBoomerang(new int[][]{{73, 31}, {73, 19}, {73, 45}});
        sol.isBoomerang(new int[][]{{0, 1}, {2, 1}, {0, 0}});
    }

    public boolean isBoomerang(int[][] points) {
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];

        if (checkIfSamePoints(p1, p2) || checkIfSamePoints(p1, p3) || checkIfSamePoints(p2, p3)) {
            return false;
        }

        /*
        double slope_2_1 = p2[0] - p1[0] == 0? Double.MAX_VALUE: (p2[1] - p1[1]) / (p2[0] - p1[0]);
        double slope_3_2 = p3[0] - p2[0] == 0? Double.MAX_VALUE: (p3[1] - p2[1]) / (p3[0] - p2[0]);

        return slope_2_1 != slope_3_2;
        */

        return (p2[1] - p1[1]) * (p3[0] - p2[0]) != (p2[0] - p1[0]) * (p3[1] - p2[1]);
    }

    private boolean checkIfSamePoints(int[] p1, int[] p2) {
        if (p1[0] == p2[0] && p1[1] == p2[1]) {
            return true;
        }

        return false;
    }

}
