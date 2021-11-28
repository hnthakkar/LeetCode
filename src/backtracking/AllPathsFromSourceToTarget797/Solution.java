package backtracking.AllPathsFromSourceToTarget797;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.allPathsSourceTarget(new int[][]{{1,2}, {3}, {3},{}});
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int destNode = graph.length - 1;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        curPath.add(0);

        Set<Integer> alreadyAdded = new HashSet<>();
        alreadyAdded.add(0);

        helper(result, curPath, alreadyAdded, 0, destNode, graph);


        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> curPath, Set<Integer> alreadyAdded, int newNode, int n, int[][] graph) {
        if (newNode == n) {
            result.add(new ArrayList<>(curPath));
            return;
        }

        int[] neighbours = graph[newNode];

        for (int i = 0; i < neighbours.length; i++) {
            int next = neighbours[i];

            if (alreadyAdded.contains(next)) {
                continue;
            }

            alreadyAdded.add(next);
            curPath.add(next);

            helper(result, curPath, alreadyAdded, next, n, graph);

            alreadyAdded.remove(next);
            curPath.remove(curPath.size() - 1);
        }
    }

}
