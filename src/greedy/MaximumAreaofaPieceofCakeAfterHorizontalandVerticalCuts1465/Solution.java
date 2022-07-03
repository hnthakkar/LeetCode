package greedy.MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts1465;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2});
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);

        int last = 0;
        int maxW = 0;

        for (int cur : horizontalCuts) {
            maxW = Math.max(maxW, cur - last);
            last = cur;
        }

        maxW = Math.max(maxW, h - last);

        Arrays.sort(verticalCuts);

        last = 0;
        int maxH = 0;

        for (int cur : verticalCuts) {
            maxH = Math.max(maxH, cur - last);
            last = cur;
        }

        maxH = Math.max(maxH, w - last);

        long result = 1L * maxW * maxH;

        return (int)(result % 1000000007);
    }

}
