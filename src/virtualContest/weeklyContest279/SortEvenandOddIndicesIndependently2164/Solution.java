package virtualContest.weeklyContest279.SortEvenandOddIndicesIndependently2164;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.sortEvenOdd(new int[]{4, 1, 2, 3});
        sol.sortEvenOdd(new int[]{2, 1});
        sol.sortEvenOdd(new int[]{4, 7, 8, 2, 4, 9, 1, 4, 5, 6, 3});

        // 4, 8, 4, 1, 5, 3 ==> 1, 3, 4, 4, 5, 8
        // 7, 2, 9, 4, 6 ==> 9, 7, 6, 4, 2
    }

    public int[] sortEvenOdd(int[] nums) {
        int len = nums.length;

        int[] tmp = new int[len / 2 + 1];

        Arrays.fill(tmp, Integer.MAX_VALUE);

        int tmpIndex = 0;
        for (int i = 0; i < len; i = i + 2) {
            tmp[tmpIndex++] = nums[i];
        }

        Arrays.sort(tmp);

        for (int i = 0, j = 0; j < tmpIndex; i = i + 2) {
            nums[i] = tmp[j++];
        }

        Arrays.fill(tmp, Integer.MIN_VALUE);

        tmpIndex = 0;
        for (int i = 1; i < len; i = i + 2) {
            tmp[tmpIndex++] = nums[i];
        }

        tmp = Arrays.stream(tmp).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        for (int i = 1, j = 0; j < tmpIndex; i = i + 2) {
            nums[i] = tmp[j++];
        }

        return nums;

    }
}
