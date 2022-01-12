package virtualContest.weeklyContest275.CheckifEveryRowandColumnContainsAllNumbers2133;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean checkValid(int[][] matrix) {
        int rows = matrix.length;

        Set<Integer> s = new HashSet<>();

        for (int r = 0; r < rows; r++) {
            s.clear();
            for (int c = 0; c < rows; c++) {
                if (matrix[r][c] <= rows) {
                    s.add(matrix[r][c]);
                } else {
                    return false;
                }
            }

            if (s.size() < rows) {
                return false;
            }
        }

        for (int c = 0; c < rows; c++) {
            s.clear();
            for (int r = 0; r < rows; r++) {
                if (matrix[r][c] <= rows) {
                    s.add(matrix[r][c]);
                } else {
                    return false;
                }
            }

            if (s.size() < rows) {
                return false;
            }
        }

        return true;
    }
}
