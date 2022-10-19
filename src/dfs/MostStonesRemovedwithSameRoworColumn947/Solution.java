package dfs.MostStonesRemovedwithSameRoworColumn947;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}});

        sol.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 1}, {2, 2}, {3, 2}, {3, 3}, {3, 4}, {4, 3}, {4, 4}});
        // [[0,0],[0,1],[1,0],[1,1],[2,1],[2,2],[3,2],[3,3],[3,4],[4,3],[4,4]]
    }

    public int removeStones(int[][] stones) {
        int len = stones.length;

        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int curR = stones[i][0];
            int curC = stones[i][1];

            List<Integer> colList;
            if (!rowMap.containsKey(curR)) {
                colList = new ArrayList<>();
                rowMap.put(curR, colList);
            } else {
                colList = rowMap.get(curR);
            }

            colList.add(curC);

            List<Integer> rowList;
            if (!colMap.containsKey(curC)) {
                rowList = new ArrayList<>();
                colMap.put(curC, rowList);
            } else {
                rowList = colMap.get(curC);
            }

            rowList.add(curR);
        }

        Set<String> visited = new HashSet<>();

        int islands = 0;

        for (int i = 0; i < len; i++) {
            if (!visited.contains(arrayToString(stones[i]))) {
                islands++;
                helper(rowMap, colMap, stones[i], visited);
            }
        }

        return len - islands;
    }

    private void helper(Map<Integer, List<Integer>> rowMap, Map<Integer, List<Integer>> colMap, int[] cur, Set<String> visited) {
        String curString = arrayToString(cur);
        if (visited.contains(curString)) {
            return;
        }

        visited.add(curString);

        List<Integer> colList = rowMap.getOrDefault(cur[0], Collections.emptyList());
        List<Integer> rowList = colMap.getOrDefault(cur[1], Collections.emptyList());

        for (int col : colList) {
            helper(rowMap, colMap, new int[]{cur[0], col}, visited);
        }

        for (int row : rowList) {
            helper(rowMap, colMap, new int[]{row, cur[1]}, visited);
        }
    }

    private String arrayToString(int[] input) {
        return input[0] + "-" + input[1];
    }


    /*public int removeStones(int[][] stones) {
        int len = stones.length;

        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            List<Integer> colList;
            if (!rowMap.containsKey(stones[i][0])) {
                colList = new ArrayList<>();
                rowMap.put(stones[i][0], colList);
            } else {
                colList = rowMap.get(stones[i][0]);
            }

            colList.add(stones[i][1]);

            List<Integer> rowList;
            if (!colMap.containsKey(stones[i][1])) {
                rowList = new ArrayList<>();
                colMap.put(stones[i][1], rowList);
            } else {
                rowList = colMap.get(stones[i][1]);
            }

            rowList.add(stones[i][0]);
        }

        int result = 0;

        for (int i = 0; i < len; i++) {
            if (helper(rowMap, colMap, stones[i][0], stones[i][1])) {
                result++;
            }
        }

        return len - result;
    }

    private boolean helper(Map<Integer, List<Integer>> rowMap, Map<Integer, List<Integer>> colMap, int curR, int curC) {
        List<Integer> colList = rowMap.getOrDefault(curR, Collections.emptyList());
        List<Integer> rowList = rowMap.getOrDefault(curC, Collections.emptyList());

        if (colList.size() == 0 && rowList.size() == 0) {
            return false;
        }

        for (int col: colList) {

        }


    }*/

}
