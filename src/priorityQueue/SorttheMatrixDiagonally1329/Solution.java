package priorityQueue.SorttheMatrixDiagonally1329;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};

        Solution sol = new Solution();
        sol.diagonalSort(mat);
    }

    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                List<Integer> list = map.getOrDefault(r - c, new ArrayList<>());
                list.add(mat[r][c]);
                map.put(r - c, list);
            }
        }

        for (int key : map.keySet()) {
            List curList = map.get(key);
            Collections.sort(curList, Collections.reverseOrder());
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                List<Integer> curList = map.get(r - c);
                mat[r][c] = curList.get(curList.size() - 1);
                curList.remove(curList.size() - 1);
            }
        }

        return mat;
    }

}
