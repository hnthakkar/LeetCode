package array.intervalListIntersections986;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}}, new int[][]{{1,5},{8,12},{15,24},{25,26}});
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        int fLen = firstList.length;
        int sLen = secondList.length;

        int fIndex = 0;
        int sIndex = 0;

        while (fIndex < fLen && sIndex < sLen) {
            int[] fInterval = firstList[fIndex];
            int[] sInterval = secondList[sIndex];

            int[] intersection = checkIfOverlapping(fInterval, sInterval);

            if (intersection[0] != -1) {
                int[] prev = null;
                if (result.size() > 0) {
                    prev = result.get(result.size() - 1);
                }

                if (prev != null && prev[1] == intersection[0]) {
                    prev[1] = intersection[1];
                    result.remove(result.size() - 1);
                    result.add(prev);
                } else {
                    result.add(intersection);
                }
            }

            if (fInterval[1] > sInterval[1]) {
                sIndex++;
            } else {
                fIndex++;
            }
        }

        int[][] ret = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }

        return ret;
    }

    private int[] checkIfOverlapping(int[] fInterval, int[] sInterval) {
        if ((fInterval[1] >= sInterval[0] && fInterval[1] <= sInterval[1]) || (sInterval[1] >= fInterval[0] && sInterval[1] <= fInterval[1])) {
            return new int[] {Math.max(fInterval[0], sInterval[0]), Math.min(fInterval[1], sInterval[1])};
        }

        return new int[] {-1, -1};
    }

}
