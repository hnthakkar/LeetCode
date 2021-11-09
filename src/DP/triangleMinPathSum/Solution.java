package DP.triangleMinPathSum;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();

        int cur = 0;
        for (int r = rows - 2; r >= 0; r--) {
            List<Integer> row = triangle.get(r);
            List<Integer> belowRow = triangle.get(r + 1);
            int col = row.size();
            for (int c = 0; c < col; c++) {
                cur = row.get(c);
                row.set(c, cur + Math.min(belowRow.get(c), belowRow.get(c + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}
