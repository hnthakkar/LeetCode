package array.ValidMountainArray941;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        /*sol.validMountainArray(new int[]{2, 1});
        sol.validMountainArray(new int[]{3, 5, 5});
        sol.validMountainArray(new int[]{0, 3, 2, 1});

         */
        sol.validMountainArray(new int[]{0, 1, 2, 1, 2});
    }

    public boolean validMountainArray(int[] arr) {
        int len = arr.length;

        if (len < 3) {
            return false;
        }

        int curDiff = 0;

        boolean peakReached = false;

        for (int i = 2; i < len; i++) {
            curDiff = arr[i] - arr[i -1];

            if (curDiff < 0) {
                peakReached = true;
                continue;
            }

            if (curDiff == 0) {
                return false;
            }

            if (peakReached && curDiff > 0) {
                return false;
            }
        }

        return true;
    }

}
