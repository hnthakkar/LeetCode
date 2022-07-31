package greedy.AssignCookies455;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
    }

    public int findContentChildren(int[] g, int[] s) {
        int gLen = g.length;
        int sLen = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = 0;
        int sIndex = 0;

        int result = 0;

        while (gIndex < gLen && sIndex < sLen) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
                sIndex++;
                result++;
                continue;
            } else {
                sIndex++;
            }
        }

        return result;
    }

}
