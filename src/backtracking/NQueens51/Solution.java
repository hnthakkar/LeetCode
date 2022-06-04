package backtracking.NQueens51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        Set<Integer> cols = new HashSet<>();
        Set<Integer> positiveDia = new HashSet<>(); // r - c
        Set<Integer> negativeDia = new HashSet<>(); // r = c

        String[][] matrix = new String[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = ".";
            }
        }

        helper(n, 0, cols, positiveDia, negativeDia, matrix, cur, result);

        return result;
    }

    private void helper(int n, int curR, Set<Integer> cols, Set<Integer> positiveDia, Set<Integer> negativeDia, String[][] matrix, List<String> cur, List<List<String>> result) {
        if (cur.size() == n) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int curC = 0; curC < n; curC++) {
            if (!cols.contains(curC) && !positiveDia.contains(curR - curC) && !negativeDia.contains(curR + curC)) {
                matrix[curR][curC] = "Q";
                cols.add(curC);
                positiveDia.add(curR - curC);
                negativeDia.add(curR + curC);
                cur.add(rowToString(matrix, curR, n));

                helper(n, curR + 1, cols, positiveDia, negativeDia, matrix, cur, result);

                cur.remove(cur.size() - 1);
                negativeDia.remove(curR + curC);
                positiveDia.remove(curR - curC);
                cols.remove(curC);
                matrix[curR][curC] = ".";
            }
        }
    }

    private String rowToString(String[][] mat, int row, int n) {
        StringBuilder sb = new StringBuilder();

        for (int c = 0; c < n; c++) {
            sb.append(mat[row][c]);
        }

        return sb.toString();
    }

}
