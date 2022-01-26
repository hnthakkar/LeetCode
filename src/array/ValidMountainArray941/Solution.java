package array.ValidMountainArray941;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.validMountainArray(new int[]{2, 1});
        sol.validMountainArray(new int[]{3, 5, 5});
        sol.validMountainArray(new int[]{0, 3, 2, 1});
        sol.validMountainArray(new int[]{0, 1, 2, 1, 2});
        sol.validMountainArray(new int[]{2, 0, 2});
        sol.validMountainArray(new int[]{1, 2, 3});
        sol.validMountainArray(new int[]{3, 2, 1});
        sol.validMountainArray(new int[]{1, 3, 2});
    }

    public boolean validMountainArray(int[] arr) {
        int len = arr.length;

        if (len < 3) {
            return false;
        }

        int index = 1;

        boolean firstInc = false;

        while (index < len && arr[index - 1] < arr[index]) {
            firstInc = true;
            index++;
        }

        if (!firstInc) {
            return false;
        }

        boolean dec = false;
        while (index < len && arr[index - 1] > arr[index]) {
            dec = true;
            index++;
        }

        if (!dec || index != len) {
            return false;
        }

        return true;
    }

}
