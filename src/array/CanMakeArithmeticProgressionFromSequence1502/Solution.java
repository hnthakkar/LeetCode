package array.CanMakeArithmeticProgressionFromSequence1502;

import java.util.Arrays;

public class Solution {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        int len = arr.length;

        for (int i = 2; i < len; i++) {
            if ((arr[i - 1] - arr[i - 2]) != (arr[i] - arr[i - 1])) {
                return false;
            }
        }

        return true;
    }

}
